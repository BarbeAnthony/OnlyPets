package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Create_Account", value = "/Servlet_Create_Account")
public class Servlet_Create_Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // récupère infos du formulaire de création de compte : username, password, email
        //TODO criptage du mdp (chercher une bibliothèque Java qui le fait)
        //TODO création du nouvel utilisateur dans la BDD
        //TODO renvoie à my_account.jsp en étant connecté, pour ajout du premier animal
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        HttpSession session = request.getSession();

        /* Verification de pseudo et email disponibles:
        sinon : renvoi à page de connexion
        si ok : enregistrement dans bdd
         */
        session.setAttribute("username", username);
        //TODO création de cookies

        this.getServletContext().getRequestDispatcher("/jsp_files/my_account.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
