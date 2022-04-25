package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Delete_Account", value = "/Servlet_Delete_Account")
public class Servlet_Delete_Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Confirmation par Mdp
        //TODO Suppression des données de la BDD
        //TODO Suppression des cookies + déconnexion
        //TODO Retour à index via Servlet_Default_Index
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
