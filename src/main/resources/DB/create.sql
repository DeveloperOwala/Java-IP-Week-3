SET MODE Postgresql;

--CREATE DATABASE to_do;

--\c wildlife_tracker;

CREATE  TABLE IF NOT EXISTS animals(
  id int PRIMARY KEY auto_increament,
  name varchar,
  age varchar,
  health varchar
);




