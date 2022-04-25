package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Custom_Index", value = "/Servlet_Custom_Index")
public class Servlet_Custom_Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO récupère les données de formulaire de filtre dans index.jsp
        //TODO? + gestion des pages (si 20 images max par page)
        //TODO appel à la BDD pour récupérer uniquement les post filtrés
        //TODO rappelle index.jsp avec nouveaux paramètres et afficher uniquement les éléments choisis
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
