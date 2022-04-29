package beans;

import dao.PetDAO;
import dao.UserDAO;
import dao.PostDAO;

import java.util.ArrayList;
import java.util.List;

public class test {
    public static void main(String[] args) {
        /*
        UserDAO userDAO = new UserDAO();
        userDAO.initialisation();
        System.out.println(userDAO.usernameExists("boby"));
        System.out.println(userDAO.emailExists("hgfd@gmail.com"));
        userDAO.cloture();

        PetDAO petDao = new PetDAO();
        petDao.initialisation();
        System.out.print(petDao.lesPetDunUser("charlie"));*/

        List<String> speciesList = new ArrayList<>();
        speciesList.add("chien");
        PostDAO postDAO=new PostDAO();
        List<Post> postList;
        postDAO.initialisation();
        postList= postDAO.customFilter(speciesList, "youngerFirst", 20);

        for (Post post: postList
             ) {
            System.out.println(post);
        }
        postDAO.cloture();
    }
}
