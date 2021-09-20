package models;

import java.util.Objects;

public class Animal {
//    private static final String young ="";
//    private static final String type="";
//    private int id ;
//    public static final String DATABASE_TYPE ="Animal";
//
//
//    public Animal(String animalName, String type, String young, int id) {
//        super(animalName, type, young);
//        this.id = id;
//        this.setType(DATABASE_TYPE);
//    }
    public int id;
    private String name;
    private String age;
    private String health;

    public Animal(int id, String name, String age, String health) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.health = health;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Animal)) return false;
        Animal animal = (Animal) o;
        return getId() == animal.getId() &&
                Objects.equals(getName(), animal.getName()) &&
                Objects.equals(getAge(), animal.getAge()) &&
                Objects.equals(getHealth(), animal.getHealth());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getAge(), getHealth());
    }
}

