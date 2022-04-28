package beans;

public class Pet {

    private int petID = -1;
    private int userID;
    private String name;
    private String species;
    private String presentation;
    private String birthday;

    //CONSTRUCTOR

    public Pet(int userID, String name, String species, String presentation, String birthday) {
        //TODO gérer le cas où le birthday n'a pas été saisi
        this.userID = userID;
        this.name = name;
        this.species = species;
        this.presentation = presentation;
        this.birthday = birthday;
    }

    public Pet() {
    }

    //METHODS

    @Override
    public String toString() {
        return "Pet{" +
                "petID=" + petID +
                ", userID=" + userID +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", presentation='" + presentation + '\'' +
                ", birthday=" + birthday +
                '}';
    }


    //GETTERS AND SETTERS


    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
