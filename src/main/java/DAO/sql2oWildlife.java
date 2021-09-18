package DAO;

import java.util.List;

public interface sql2oWildlife {
    List<Endangered> getAllEndangeredAnimals();

    void saveAgeOfAnimal(String age);

    void saveHealthOfAnimal(String health);
}
