package dao;

import models.Hero;

import java.util.List;

public interface HeroDao {

    //List all heros
    List<Hero> getAllHeros();

    //create an new hero
    void addHero(Hero hero);

    //get a specific hero
    Hero findHeroById(int id);

    //Update a hero


    //Delete a hero

}
