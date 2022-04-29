package servlets;

import beans.Pet;
import beans.User;
import beans.UserPet;
import dao.PetDAO;
import dao.UserDAO;
import dao.UserPetDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Submit_New_Pet", value = "/Servlet_Submit_New_Pet")
public class Servlet_Submit_New_Pet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String species = request.getParameter("species");
        String presentation = request.getParameter("presentation");
        String birthday = request.getParameter("birthday");
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        int userID;
        PetDAO petDAO = new PetDAO();
        Pet newPet = new Pet();
        int newPetID;
        UserPetDAO userPetDAO = new UserPetDAO();

        //TODO à supprimer si pas besoin au final, pour premier appel de la page sans parametres à récupérer
        /*if(username == null && password == null && email == null ){
            this.getServletContext().getRequestDispatcher("/jsp_files/new_user.jsp").forward(request, response);
            return;
        }*/

        //Récupération de l'ID de l'utilisateur, erreur si échec
        userDAO.initialisation();
        userID = userDAO.getUserIdByUsername((String) session.getAttribute("username"));
        userDAO.cloture();

        if (userID ==-1) {
            System.out.println("Erreur, impossible de récupérer l'ID de l'utilisateur connecté.");
            return;
        }

        // Configuration du nouvel animal
        newPet.setUserID(userID);
        newPet.setName(name);
        newPet.setSpecies(species);
        newPet.setPresentation(presentation);
        newPet.setBirthday(birthday);

        //Injection dans la BDD
        petDAO.initialisation();
        petDAO.addPet(newPet);
        newPetID = petDAO.getLastInsertId();
        petDAO.cloture();

        //Erreur si problème d'injection
        if (newPetID ==-1 || newPetID == 0) {
            System.out.println("Erreur, impossible de récupérer l'ID de l'animal créé, impossible de créer un lien utilisateur-animal dans la BDD.");
            //TODO insérer message d'erreur
            this.getServletContext().getRequestDispatcher("/jsp_files/new_pet.jsp").forward(request, response);
            return;
        }

        //Création du lien User-Pet dans la BDD
        userPetDAO.initialisation();
        userPetDAO.addUserPet(new UserPet(userID, newPetID));
        userPetDAO.cloture();

        //Appel du jsp suivant
        this.getServletContext().getRequestDispatcher("/Servlet_Default_Index").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
