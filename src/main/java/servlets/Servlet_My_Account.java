package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_My_Account", value = "/Servlet_My_Account")
public class Servlet_My_Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Depuis index, accède à la page de gestion du compte de l'utilisateur my_account.jsp
        //TODO my_account.jsp doit afficher son nom et la liste de ses animaux. Nombre de posts par animal? lien vers leurs pages?
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
