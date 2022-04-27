package servlets;

import dao.UserDAO;

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

        //TODO cryptage du mdp saisi pour comparer avec le mdp de la BDD (si mdp enregistrés cryptés)


        final int COOKIE_MAX_AGE = 60 *60 *24 *365;


            String email = request.getParameter("email");
            String password = request.getParameter("password");

       if(email == null && password == null){
           this.getServletContext().getRequestDispatcher("/jsp_files/user_login.jsp").forward(request, response);
           return;
       }

        HttpSession session = request.getSession();
        String username = "";

        UserDAO userDAO = new UserDAO();
        userDAO.initialisation();

        username=userDAO.getUsernameAtConnection(password,email);

        userDAO.cloture();

        if(username.equals("")){

            this.getServletContext().getRequestDispatcher("/jsp_files/user_login.jsp").forward(request, response);
        }else{
            session.setAttribute("username", username);
            setCookie(response,"username",username,COOKIE_MAX_AGE);
            this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
        }



    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

}
