package appModels;

public class Animal extends Wildlife{
    private static final String young = "";
    private  static final String type="";
    private int id;
    public static String DATABASE_TYPE ="Animal";

    public Animal(String animalName, String type,String young, int id){
        super(animalName,type,young);
        this.id = id;
        this.setType(DATABASE_TYPE);
    }

}
