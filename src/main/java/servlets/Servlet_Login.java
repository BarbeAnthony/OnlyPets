package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Login", value = "/Servlet_Login")
public class Servlet_Login extends HttpServlet {


    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {

        Cookie cookie = new Cookie( nom, valeur );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Récupère les identifiants et MdPs depuis formulaire dans user_login.jsp
        //TODO cryptage du mdp saisi pour comparer avec le mdp de la BDD (si mdp enregistrés cryptés)

        //TODO Création de cookie de connexion
        //TODO Renvoie vers index.jsp en étant connecté, ou vers user_login.jsp avec message d'erreur si identifiants incorrects

        final int COOKIE_MAX_AGE = 60 *60 *24 *365;
        String email = (String)request.getParameter("email");
        HttpSession session = request.getSession();



        session.setAttribute("email", email);
        setCookie(response,"email",email,COOKIE_MAX_AGE);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
