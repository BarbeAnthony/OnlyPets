package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Submit_Account_Update", value = "/Servlet_Submit_Account_Update")
public class Servlet_Submit_Account_Update extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Vérifier que le mot de passe est correct
        //TODO MAJ de la BDD
        //TODO charge my_account.jsp apres validation, ou annulation.
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    //Bonjour les amigos
}
