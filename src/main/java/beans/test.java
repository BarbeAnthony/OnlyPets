package beans;

import dao.UserDAO;

public class test {
    public static void main(String[] args) {
        UserDAO userDAO = new UserDAO();

        userDAO.initialisation();
        System.out.println(userDAO.usernameExists("boby"));
        System.out.println(userDAO.emailExists("hgfd@gmail.com"));
        userDAO.cloture();
    }
}
