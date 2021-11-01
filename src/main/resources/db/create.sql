SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heros(
    id int PRIMARY KEY auto_increment,
    heroName VARCHAR,
    heroAge INT,
    heroPower VARCHAR,
    heroWeakness VARCHAR,
    avatarUrl VARCHAR

);