package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeroTest {

    @Test
    public void newHeroObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = setUpNewHero();
        assertTrue(hero != null);
        }

        @Test
        public void heroInstantiatesWithNameAgePowerWeaknessAndAvetar() throws Exception {
        Hero hero = setUpNewHero();
        assertEquals("Ironman,30,Genius,Swimming,https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg",String.format("%s,%d,%s,%s,%s",hero.getHeroName(), hero.getHeroAge(), hero.getHeroPower(), hero.getHeroWeakness(), hero.getAvatarUrl()));
        }

        //helper classes
    public Hero setUpNewHero(){
        return new Hero("Ironman",30,"Genius","Swimming","https://www.pixel4k.com/wp-content/uploads/2019/09/ironman_1568055212.jpg");
    }

}