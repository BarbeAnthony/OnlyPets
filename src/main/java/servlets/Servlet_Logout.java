package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "Servlet_Logout", value = "/Servlet_Logout")
public class Servlet_Logout extends HttpServlet {

    private static void setCookie( HttpServletResponse response, String nom, String valeur, int maxAge ) {

        Cookie cookie = new Cookie( nom, valeur );
        cookie.setMaxAge( maxAge );
        response.addCookie( cookie );
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        session.invalidate();

        setCookie(response,"username","lamort",0);

        this.getServletContext().getRequestDispatcher("/Servlet_Default_Index").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
