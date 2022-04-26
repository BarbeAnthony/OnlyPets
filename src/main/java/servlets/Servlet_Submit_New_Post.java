package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Submit_New_Post", value = "/Servlet_Submit_New_Post")
public class Servlet_Submit_New_Post extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            //TODO Récupère infos du formulaire new_post.jsp
            //TODO Crée nouveau post dans BDD
            //TODO appelle Servlet_Default_Index si possible? à vérifier dans le cours
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
