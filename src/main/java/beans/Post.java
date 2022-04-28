package beans;

public class Post {

    private int petID = -1;
    private String titre;
    private String photo;
    private String description;

    // Constructor
    public Post(int petID, String titre, String photo, String description) {
        this.petID = petID;
        this.titre = titre;
        this.photo = photo;
        this.description = description;
    }
     public Post(){

     }

     // Methods

    @Override
    public String toString() {
        return "Post{" +
                "petID=" + petID +
                ", titre='" + titre + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    // Getters et Setters

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
