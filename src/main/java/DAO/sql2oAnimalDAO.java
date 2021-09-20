package DAO;

import models.Animal;
import models.Wildlife;
import org.sql2o.Connection;
import org.sql2o.Sql2o;
import org.sql2o.Sql2oException;


import java.util.List;

public class sql2oAnimalDAO implements AnimalDAO{

    private final Sql2o sql2o;

    public sql2oAnimalDAO(Sql2o sql2o) {

        this.sql2o = sql2o;
    }

    public void add(Animal animal) {
        String sql = "INSERT INTO animals(name, age,health) VALUES(:name, :age, :health)";
        try (Connection con = sql2o.open()) {
            int id = (int) con.createQuery(sql, true)
                    .bind(animal)
                    .executeUpdate()
                    .getKey();
            animal.setId(id);
        }catch (Sql2oException ex){
            System.out.println(ex);
        }
    }

    @Override
    public List<Animal> getAllAnimals() {
        try(Connection con = sql2o.open()){
            return con.createQuery("SELECT * FROM animals")
                    .executeAndFetch(Animal.class);
        }
    }

}
