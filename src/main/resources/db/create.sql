SET MODE PostgresSQL;

CREATE TABLE IF NOT EXISTS squads(
    id int PRIMARY KEY auto_increment,
    hero_name VARCHAR,
    hero_age INT,
    hero_power VARCHAR,
    hero_weakness VARCHAR,
    hero_avatar VARCHAR

);