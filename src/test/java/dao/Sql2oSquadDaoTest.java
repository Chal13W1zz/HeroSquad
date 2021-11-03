package dao;

import models.Hero;
import models.Squad;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sql2o.Connection;
import org.sql2o.Sql2o;

import static org.junit.jupiter.api.Assertions.*;

class Sql2oSquadDaoTest {
    private Sql2oSquadDao squadDao;
    private Sql2oHeroDao heroDao;
    private Connection conn;

    @BeforeEach
    void setUp() {
        String connectionString = "jdbc:postgresql://localhost:5432/hero_test";
        Sql2o sql2o = new Sql2o(connectionString,"ftm","sparkpass");
        squadDao = new Sql2oSquadDao(sql2o);
        heroDao = new Sql2oHeroDao(sql2o);
        conn = sql2o.open();
    }

    @Test
    public void addingSquadSetsId() throws Exception {
        Squad squad = setUpNewSquad();
        int originalSquadId = squad.getId();
        squadDao.addSquad(squad);
        assertNotEquals(originalSquadId,squad.getId());
    }

    @Test
    public void existingSquadCanBeFoundById() throws Exception {
        Squad squad = setUpNewSquad();
        squadDao.addSquad(squad);
        Squad foundSquad = squadDao.findSquadById(squad.getId());
        assertEquals(squad,foundSquad);
    }

    @Test
    public void addedSquadsAreReturnedFromGetAllSquads() throws Exception {
        Squad squad = setUpNewSquad();
        squadDao.addSquad(squad);
        assertEquals(1,squadDao.getAllSquads().size());
    }

    @Test
    public void noSquadReturnEmptyList() throws Exception {
        assertEquals(0,squadDao.getAllSquads().size());
    }

    @Test
    public void deleteSquadByIdDeletesCorrectSquad() throws Exception {
        Squad squad = setUpNewSquad();
        squadDao.addSquad(squad);
        squadDao.deleteSquadById(squad.getId());
        assertEquals(0,squadDao.getAllSquads().size());
    }

    @Test
    public void deleteAllSquadsDeletesAllSquads() throws Exception {
        Squad squad = setUpNewSquad();
        Squad squad1 = new Squad("Justice League","Save the planet",5);
        squadDao.addSquad(squad);
        squadDao.addSquad(squad1);
        int daoSize = squadDao.getAllSquads().size();
        squadDao.deleteAllSquads();
        assertTrue(daoSize >0 && daoSize > squadDao.getAllSquads().size());
    }

    @Test
    public void getAllHerosBySquadReturnsHerosCorrectly() throws Exception{
        Squad squad = setUpNewSquad();
        squadDao.addSquad(squad);
        int squadId = squad.getId();
        Hero hero1 = new Hero("Ironman",30,"Genius","Swimming",squadId,"https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg");
        Hero hero2 = new Hero("Thor",35,"Lightning","Black Widow",squadId,"https://wallsdesk.com/wp-content/uploads/2016/12/Thor-High-Quality-Wallpapers.jpg");
        Hero horo3 = new Hero("Captain America",120,"Strength","infinity stones",squadId,"https://www.animatedtimes.com/wp-content/uploads/2020/07/avengers-endgame-captain-america-mjolnir.jpg");
        heroDao.addHero(hero1);
        heroDao.addHero(hero2);

        assertEquals(2,squadDao.getAllHerosBySquad(squadId).size());
        assertTrue(squadDao.getAllHerosBySquad(squadId).contains(hero1));
        assertFalse(squadDao.getAllHerosBySquad(squadId).contains(horo3));
    }

    //helper method
    public Squad setUpNewSquad(){
        return new Squad("Avengers","Save Earth From Thanos",10);
    }

    @AfterEach
    void tearDown() {
        squadDao.deleteAllSquads();
        heroDao.deleteAllHeros();
        conn.close();
    }
}