package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Load_Delete_Account_Page", value = "/Servlet_Load_Delete_Account_Page")
public class Servlet_Load_Delete_Account_Page extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO A discuter si page nécessaire. Pas forcément si passage par Session. Il faut relire le cour
        //TODO remplissage de la page avec infos utilisateur
        //TODO chargement de delete_account.jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
