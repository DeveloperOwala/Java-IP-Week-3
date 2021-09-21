import org.sql2o.*;

/**
 * Authored by @erickokumu
 **
 */
public class DB {
    // connecting to server -- Heroku.
    // for this you'll replace when you deploy yours
    // for now just create your own connection string connecting to your local db
    public static String connection = "jdbc:postgresql://localhost:5432/wildlifetracker";
    public static Sql2o sql2o = new Sql2o(connection, "moringa", "access");

}

//connect to database locally

/*
    CREATE DATABASE wildlife CREATE TABLE animals CREATE TABLE sightings CREATE TABLE endangered
*/

/*
    Table contents, that is the column names and their data types, do check in respective model classes
*/




