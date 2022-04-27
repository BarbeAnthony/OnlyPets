package servlets;

import beans.Pet;
import beans.User;
import dao.PetDAO;
import dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Submit_New_Pet", value = "/Servlet_Submit_New_Pet")
public class Servlet_Submit_New_Pet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int userID;
        String name = request.getParameter("name");
        String species = request.getParameter("species");
        String presentation = request.getParameter("presentation");
        String birthday = request.getParameter("birthday");
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        PetDAO petDAO = new PetDAO();
        Pet newPet = new Pet();

        //TODO à supprimer si pas besoin au final
        /*if(username == null && password == null && email == null ){
            this.getServletContext().getRequestDispatcher("/jsp_files/new_user.jsp").forward(request, response);
            return;
        }*/

        userDAO.initialisation();
        userID = userDAO.getUserIdByUsername((String) session.getAttribute("username"));
        userDAO.cloture();

        // ajout de l'animal à la BDD
        newPet.setUserID(userID);
        newPet.setName(name);
        newPet.setSpecies(species);
        newPet.setPresentation(presentation);
        newPet.setBirthday(birthday);

        petDAO.initialisation();
        petDAO.addPet(newPet);
        petDAO.cloture();

        //TODO récupérer ID du pet et créer lien user-pet

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
