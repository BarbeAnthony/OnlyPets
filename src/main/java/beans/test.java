package beans;

public class test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        userDAO.initialisation();
        System.out.println(userDAO.getUsername("xxxxxxxxxxxxx", "test@gmail.com"));
        userDAO.cloture();
    }
}
