package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Load_Update_Account_Page", value = "/Servlet_Load_Update_Account_Page")
public class Servlet_Load_Update_Account_Page extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO pré remplissage du formulaire de modification avec infos utilisateurs
        //TODO Appelle update_account.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
