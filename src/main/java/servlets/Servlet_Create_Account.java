package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Create_Account", value = "/Servlet_Create_Account")
public class Servlet_Create_Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO récupère infos du formulaire de création de compte
        //TODO criptage du mdp (chercher une bibliothèque Java qui le fait)
        //TODO création du nouvel utilisateur dans la BDD
        //TODO renvoie à my_account.jsp en étant connecté, pour ajout du premier animal
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
