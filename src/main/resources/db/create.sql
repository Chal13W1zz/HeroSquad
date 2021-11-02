SET MODE PostgreSQL;

CREATE TABLE IF NOT EXISTS heros(
    id int PRIMARY KEY auto_increment,
    heroName VARCHAR,
    heroAge INT,
    heroPower VARCHAR,
    heroWeakness VARCHAR,
    avatarUrl VARCHAR,
    squadId INT
);

CREATE TABLE IF NOT EXISTS squads (
   id int PRIMARY KEY auto_increment,
   squadName VARCHAR,
   squadCause VARCHAR,
   maxSize INT,
   squadFull BOOLEAN
);