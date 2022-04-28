package servlets;

import beans.Post;
import dao.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_Default_Index", value = "/Servlet_Default_Index")
public class Servlet_Default_Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO Vérifie les cookies pour afficher l'index en étant connecté ou non
        HttpSession session = request.getSession();
        PostDAO postDAO = new PostDAO();
        postDAO.initialisation();
        List<Post> postList = postDAO.lesXdernierposts(20);
        request.setAttribute("postList", postList);
        postDAO.cloture();
        System.out.println(postList);
        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
