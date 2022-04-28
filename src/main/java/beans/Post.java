package beans;

public class Post {

    private int postID = -1;
    private int petID = -1;
    private String title;
    private String photo;
    private String description;
    private String petname ="";
    private String username ="";


    // Constructor
    public Post(int petID, String title, String photo, String description) {
        this.petID = petID;
        this.title = title;
        this.photo = photo;
        this.description = description;
    }

     public Post(){

     }

    public Post(int postID, int petID, String title, String photo, String description, String petname, String username) {
        this.postID = postID;
        this.petID = petID;
        this.title = title;
        this.photo = photo;
        this.description = description;
        this.petname = petname;
        this.username = username;
    }

    // Methods

    @Override
    public String toString() {
        return "Post{" +
                "postID=" + postID +
                ", petID=" + petID +
                ", title='" + title + '\'' +
                ", photo='" + photo + '\'' +
                ", description='" + description + '\'' +
                ", petname='" + petname + '\'' +
                ", username='" + username + '\'' +
                '}';
    }


    // Getters et Setters


    public String getPetname() {
        return petname;
    }

    public void setPetname(String petname) {
        this.petname = petname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }

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
