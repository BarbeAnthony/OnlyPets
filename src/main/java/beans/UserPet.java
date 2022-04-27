package beans;

public class UserPet {

    private int userID;
    private int petID;

    //CONSTRUCTOR


    public UserPet(int userID, int petID) {
        this.userID = userID;
        this.petID = petID;
    }

    public UserPet() {
    }

    //GETTERS AND SETTERS

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getPetID() {
        return petID;
    }

    public void setPetID(int petID) {
        this.petID = petID;
    }
}
