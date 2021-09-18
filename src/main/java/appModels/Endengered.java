package appModels;

public class Endengered extends  Wildlife{
    public  String health;
    public String age;

    public Endengered(String animalName, String type, String young,String age, String health){
        super(animalName,type,young);
        this.health = health;
        this.age = age;
    }
}
