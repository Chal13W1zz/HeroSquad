package models;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SquadTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true(){
        Squad squad = setupNewSquad();
        assertNotNull(squad);
    }


    //helper methods
    public  Squad setupNewSquad(){
        return new Squad("Avengers","Fight Thanos",4);
    }

    @AfterEach
    void tearDown() {
    }
}