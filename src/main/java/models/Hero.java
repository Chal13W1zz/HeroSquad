package models;

import java.util.Objects;

public class Hero {
    private String heroName;
    private int heroAge;
    private String heroPower;
    private String heroWeakness;
    private String avatarUrl;
    private int id;

    public Hero(String heroName, int heroAge, String heroPower, String heroWeakness, String avatarUrl) {
        this.heroName = heroName;
        this.heroAge = heroAge;
        this.heroPower = heroPower;
        this.heroWeakness = heroWeakness;
        this.avatarUrl = avatarUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hero hero = (Hero) o;
        return heroAge == hero.heroAge && heroName.equals(hero.heroName) && heroPower.equals(hero.heroPower) && heroWeakness.equals(hero.heroWeakness) && avatarUrl.equals(hero.avatarUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(heroName, heroAge, heroPower, heroWeakness, avatarUrl);
    }

    public String getHeroName() {
        return heroName;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public int getHeroAge() {
        return heroAge;
    }

    public void setHeroAge(int heroAge) {
        this.heroAge = heroAge;
    }

    public String getHeroPower() {
        return heroPower;
    }

    public void setHeroPower(String heroPower) {
        this.heroPower = heroPower;
    }

    public String getHeroWeakness() {
        return heroWeakness;
    }

    public void setHeroWeakness(String heroWeakness) {
        this.heroWeakness = heroWeakness;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
