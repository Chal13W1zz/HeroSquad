package dao;

import models.Hero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oHeroDaoTest {
    private Sql2oHeroDao heroDao;
    private Connection conn;

    @BeforeEach
    void setUp() {
        String connectionString = "jdbc:h2:mem:testing;INIT=RUNSCRIPT from 'classpath:db/create.sql'";
        Sql2o sql2o = new Sql2o(connectionString,"","");
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @Test
    public void addingHeroSetsId() throws Exception {
        Hero hero = new Hero("Ironman",30,"Genius","Swimming","https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg");
        int originalHeroId = hero.getId();
        heroDao.addHero(hero);
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void existingHeroCanBeFoundById() throws Exception {
        Hero hero = new Hero("Ironman",30,"Genius","Swimming","https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg");
        heroDao.addHero(hero);
        Hero foundHero = heroDao.findHeroById(hero.getId());
        assertEquals(hero, foundHero);
    }

    @Test
    public void deleteByIdDeletesCorrectHero() throws Exception {
        Hero hero = new Hero("Thor",35,"Lightning","Black Widow","https://wallsdesk.com/wp-content/uploads/2016/12/Thor-High-Quality-Wallpapers.jpg");
        heroDao.addHero(hero);
        heroDao.deleteHeroById(hero.getId());
        assertEquals(0,heroDao.getAllHeros().size());
    }

    @Test
    public void clearAllHerosClearsAll() throws Exception {
        Hero hero = new Hero("Ironman",30,"Genius","Swimming","https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg");
        Hero hero1 = new Hero("Thor",35,"Lightning","Black Widow","https://wallsdesk.com/wp-content/uploads/2016/12/Thor-High-Quality-Wallpapers.jpg");
        heroDao.addHero(hero);
        heroDao.addHero(hero1);
        int daoSize = heroDao.getAllHeros().size();
        heroDao.deleteAllHeros();
        assertTrue(daoSize > 0 && daoSize > heroDao.getAllHeros().size());

    }


    @AfterEach
    void tearDown() {
        conn.close();
    }
}