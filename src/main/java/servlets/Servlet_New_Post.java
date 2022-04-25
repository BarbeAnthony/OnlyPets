package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_New_Post", value = "/Servlet_New_Post")
public class Servlet_New_Post extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO pré remplissage du formulaire de création de post si appelé depuis "my_account.jsp"
        //TODO menus du formulaire adapté à l'utilisateur (liste de ses animaux)
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
