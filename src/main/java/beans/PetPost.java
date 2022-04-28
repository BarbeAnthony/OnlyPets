package beans;

public class PetPost {

    private int petID;
    private int postID;

    //Constructeur


    public PetPost(int petID, int postID) {
        this.petID = petID;
        this.postID = postID;
    }

    public PetPost() {
    }

    //Getteur et setteur

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }

    public int getPostID() {
        return postID;
    }

    public void setPostID(int postID) {
        this.postID = postID;
    }
}
