package servlets;

import beans.Post;
import dao.PostDAO;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "Servlet_Custom_Index", value = "/Servlet_Custom_Index")
public class Servlet_Custom_Index extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO? + gestion des pages (si 20 images max par page)
        //TODO appel à la BDD pour récupérer uniquement les post filtrés
        //TODO rappelle index.jsp avec nouveaux paramètres et afficher uniquement les éléments choisis
        String filtre = request.getParameter("filtre");
        System.out.println(filtre);
        String[] selected_species = request.getParameterValues("species");
        List<String> list = new ArrayList<String>();

        if(selected_species != null){
            for(int i=0; i<selected_species.length; i++){
                list.add(selected_species[i]);
            }
        }

        PostDAO postDAO = new PostDAO();
        postDAO.initialisation();
        List<Post> postList = postDAO.customFilter(list, filtre, 20);
        request.setAttribute("postList", postList);
        postDAO.cloture();
        System.out.println(postList);

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);

        /*if (selected_species != null && selected_species.length != 0){
            System.out.println("you have selected this options : ");
            for (int i = 0; i < selected_species.length; i++) {
                System.out.println(selected_species[i] + "\n" + "Thank you");
            }
        }*/

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
