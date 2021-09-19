SET MODE Postgresql;

CREATE DATABASE to_do;

\c to_do;

CREATE  TABLE IF NOT EXISTS animals
id SERIAL PRIMARY KEY,
animalName VARCHAR,
type VARCHAR,
health VARCHAR,
age VARCHAR
);


