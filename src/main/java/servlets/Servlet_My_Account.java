package servlets;

import beans.Pet;
import dao.PetDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_My_Account", value = "/Servlet_My_Account")
public class Servlet_My_Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Depuis index, accède à la page de gestion du compte de l'utilisateur my_account.jsp
        //TODO my_account.jsp doit afficher son nom et la liste de ses animaux. Nombre de posts par animal? lien vers leurs pages?
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        PetDAO petDao = new PetDAO();
        petDao.initialisation();
        List<Pet> petList = petDao.lesPetDunUser(username);
        request.setAttribute("petList", petList);
        petDao.cloture();

        this.getServletContext().getRequestDispatcher("/jsp_files/my_account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
