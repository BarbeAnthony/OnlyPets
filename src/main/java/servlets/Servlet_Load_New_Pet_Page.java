package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Load_New_Pet_Page", value = "/Servlet_Load_New_Pet_Page")
public class Servlet_Load_New_Pet_Page extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO pré remplissage du formulaire de modification avec infos utilisateurs ??
        //TODO Appelle new_pet.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
