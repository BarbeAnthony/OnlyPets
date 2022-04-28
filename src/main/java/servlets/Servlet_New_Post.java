package servlets;

import beans.Post;
import beans.Pet;
import beans.PetPost;
import dao.PostDAO;
import dao.PetDAO;
import dao.PetPostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Servlet_New_Post", value = "/Servlet_New_Post")
public class Servlet_New_Post extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        PetDAO petDao = new PetDAO();
        petDao.initialisation();
        List<Pet> petList = petDao.lesPetDunUser(username);
        request.setAttribute("petList", petList);
        petDao.cloture();

        this.getServletContext().getRequestDispatcher("/jsp_files/new_post.jsp").forward(request, response);

    }



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
