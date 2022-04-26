package beans;

public class test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        userDAO.initialisation();
        System.out.println(userDAO.isUsernameAvailable("boby"));
        System.out.println(userDAO.isEmailAvailable("hgfd@gmail.com"));
        userDAO.cloture();
    }
}
