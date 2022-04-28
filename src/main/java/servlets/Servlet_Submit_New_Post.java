package servlets;

import beans.Post;
import beans.Pet;
import beans.PetPost;
import dao.PostDAO;
import dao.PetDAO;
import dao.PetPostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Submit_New_Post", value = "/Servlet_Submit_New_Post")
public class Servlet_Submit_New_Post extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int petID = Integer.parseInt(request.getParameter("petID"));
        String title = request.getParameter("title");
        String photo = request.getParameter("photo");
        String description = request.getParameter("description");
        HttpSession session = request.getSession();
        PetDAO petDAO = new PetDAO();
        PostDAO postDAO = new PostDAO();
        Post newPost = new Post();
        int newPostID;
        PetPostDAO petPostDAO = new PetPostDAO();


        //TODO pré remplissage du formulaire de création de post si appelé depuis "my_account.jsp"
        //TODO menus du formulaire adapté à l'utilisateur (liste de ses animaux)

        // Configuration du nouveau post
        newPost.setPetID(petID);
        newPost.setTitle(title);
        newPost.setPhoto(photo);
        newPost.setDescription(description);

        // Injection dans la BDD
        postDAO.initialisation();
        postDAO.addPost(newPost);
        newPostID = postDAO.getLastInsertId();
        postDAO.cloture();

        //Erreur si problème d'injection
        if (newPostID == -1){
            System.out.println("Erreur, impossible de récupérer l'ID de l'animal crée, impossible de créer un lien animal-post dans la BDD.");
            return;
        }

        // Création du lien Pet-Post dans le BDD
        petPostDAO.initialisation();
        petPostDAO.addPetPost(new PetPost(newPostID, petID));
        petPostDAO.cloture();

        // Appel jsp suivant
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
