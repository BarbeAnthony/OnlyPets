package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Default_Index", value = "/Servlet_Default_Index")
public class Servlet_Default_Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Vérifie les cookies pour afficher l'index en étant connecté ou non
        //TODO Par défaut, afficher les derniers posts du plus récent au plus ancien

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
