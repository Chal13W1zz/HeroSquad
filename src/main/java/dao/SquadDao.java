package dao;

import models.Hero;
import models.Squad;

import java.util.List;

public interface SquadDao {

    //list
    List<Squad> getAllSquads();

    //create
    void addSquad(Squad squad);

    //find by id/read
    Squad findSquadById(int id);
    List<Hero> getAllHerosBySquad(int squadId);

    //Squad update
    //void squadUpdate(int id, String squadName, String squadCause, int maxSize);

    //delete squad
    void deleteSquadById(int id);
    void deleteAllSquads();

}
