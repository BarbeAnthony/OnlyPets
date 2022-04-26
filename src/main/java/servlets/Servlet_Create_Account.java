package servlets;

import beans.User;
import dao.UserDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Create_Account", value = "/Servlet_Create_Account")
public class Servlet_Create_Account extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        final int COOKIE_MAX_AGE = 60 *60 *24 *365;
        String username = request.getParameter("username");
        String password = request.getParameter("password1"); //TODO à corriger avec Elodie dans new_user.jsp
        String email = request.getParameter("email");
        HttpSession session = request.getSession();
        UserDAO userDAO = new UserDAO();
        boolean usernameAlareadyTakken = false;
        boolean emailAlreadyTakken = false;
        User newUser = new User();

        //vérification des disponibilités dans la BDD
        userDAO.initialisation();
        usernameAlareadyTakken = userDAO.usernameExists(username);
        emailAlreadyTakken = userDAO.emailExists(email);

        //Si identifiants déjà utilisés, retour à la page d'inscription
        if (usernameAlareadyTakken) {
            request.setAttribute("userNameAlreadyTakken", true);
        }
        if (emailAlreadyTakken) {
            request.setAttribute("emailAlreadyTakken", true);
        }
        //TODO récupérer ces variables sur la new_user.jsp pour afficher les bandeaux d'erreur
        if (usernameAlareadyTakken || emailAlreadyTakken) {
            userDAO.cloture();
            this.getServletContext().getRequestDispatcher("/jsp_files/new_user.jsp").forward(request, response);
            return;
        }

        //Si identifiants disponibles:
        // ajout de l'utilisateur à la BDD
        newUser.setUsername(username);
        newUser.setPassword(password);  //TODO criptage du mdp (chercher une bibliothèque Java qui le fait)
        newUser.setEmail(email);
        userDAO.addUser(newUser);
        userDAO.cloture();

        //connexion au site  //TODO vérifier si possible d'appeler le servlet de connexion en lui passant les infos
        session.setAttribute("username", username);
        session.setAttribute("email", email); //TODO pour développement, à supprimer quand inutile
        setCookie(response,"username",username,COOKIE_MAX_AGE);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {
        Cookie cookie = new Cookie(nom, valeur);
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }
}
