package DB;

import org.sql2o.Sql2o;

public class DB {
    public static Sql2o sql2o  = new Sql2o( "jdbc:h2:~/todolist.db;INIT=RUNSCRIPT from 'classpath:db/create.sql'");
//    Sql2o sql2o = new Sql2o(connectionString, "xosgwzkzwjyqct", "a0fbbed62a424ededccff1329253efc108f22d07c59d72d4140b13f7e9976d48");
//    public static Sql2o sql2o = new Sql2o("jdbc:postgresql://localhost:5432/wildlife_tracker", "moringa", "Access");
}

