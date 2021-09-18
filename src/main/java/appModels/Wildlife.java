package appModels;

public abstract class Wildlife {
    public  static int id;
    private String animalName;
    private String type;

    public Wildlife(String animalName,String type,String young) {
        this.type =type;
        this.animalName = animalName;
    }
}
