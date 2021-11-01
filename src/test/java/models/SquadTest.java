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
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = setupNewSquad();
        assertNotNull(squad);
    }

    @Test
    public void SquadInstantiatesWithNameAndCause_true() throws Exception {
        Squad squad = setupNewSquad();
        assertTrue(squad.getSquadName() != null && squad.getSquadCause() != null );
    }

    @Test
    public void isSquadFullIsFalseAfterInstantiation() throws Exception{
        Squad squad = setupNewSquad();
        assertFalse(squad.isSquadFull());
    }


    //helper methods
    public  Squad setupNewSquad(){
        return new Squad("Avengers","Fight Thanos",2);
    }

    @AfterEach
    void tearDown() {
    }
}