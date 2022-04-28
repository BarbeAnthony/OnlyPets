package beans;

public class Post {

    private int petID = -1;
    private String title;
    private String photo;
    private String description;

    // Constructor
    public Post(int petID, String title, String photo, String description) {
        this.petID = petID;
        this.title = title;
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
                ", title='" + title + '\'' +
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
