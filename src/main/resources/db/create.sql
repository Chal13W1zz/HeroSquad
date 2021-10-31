SET MODE PostgresSQL;

CREATE TABLE IF NOT EXISTS squads(
    id int PRIMARY KEY auto_increment,
    squad_name VARCHAR,
    squad_cause VARCHAR,
    max_size int,
    squad_full BOOLEAN

);