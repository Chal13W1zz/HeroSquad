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
        String connectionString = "jdbc:postgresql://localhost:5432/hero_test";
        Sql2o sql2o = new Sql2o(connectionString,"ftm","sparkpass");
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @Test
    public void addingHeroSetsId() throws Exception {
        Hero hero = setUpNewHero();
        int originalHeroId = hero.getId();
        heroDao.addHero(hero);
       // System.out.println(heroDao.findHeroById(1).getHeroName());
        assertNotEquals(originalHeroId, hero.getId());
    }

    @Test
    public void existingHeroCanBeFoundById() throws Exception {
        Hero hero = setUpNewHero();
        heroDao.addHero(hero);
        Hero foundHero = heroDao.findHeroById(hero.getId());
        assertEquals(hero, foundHero);
    }

    @Test
    public void deleteByIdDeletesCorrectHero() throws Exception {
        Hero hero = new Hero("Thor",35,"Lightning","Black Widow",2,"https://wallsdesk.com/wp-content/uploads/2016/12/Thor-High-Quality-Wallpapers.jpg");
        heroDao.addHero(hero);
        heroDao.deleteHeroById(hero.getId());
        assertEquals(0,heroDao.getAllHeros().size());
    }

    @Test
    public void clearAllHerosClearsAll() throws Exception {
        Hero hero = setUpNewHero();
        Hero hero1 = new Hero("Thor",35,"Lightning","Black Widow",2,"https://wallsdesk.com/wp-content/uploads/2016/12/Thor-High-Quality-Wallpapers.jpg");
        heroDao.addHero(hero);
        heroDao.addHero(hero1);
        int daoSize = heroDao.getAllHeros().size();
        heroDao.deleteAllHeros();
        assertTrue(daoSize > 0 && daoSize > heroDao.getAllHeros().size());
    }

    @Test
    public void squadIdIsReturnedCorrectly() throws Exception{
        Hero hero = setUpNewHero();
        int originalSquadId = hero.getSquadId();
        heroDao.addHero(hero);
        assertEquals(originalSquadId,heroDao.findHeroById(hero.getId()).getSquadId());
    }

    //helper classes
    public Hero setUpNewHero(){
        return new Hero("Ironman",30,"Genius","Swimming",2,"https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg");
    }


    @AfterEach
    void tearDown() {
        heroDao.deleteAllHeros();
        conn.close();
    }
}