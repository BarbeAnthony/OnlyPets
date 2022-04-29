package dao;

import beans.Pet;
import beans.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDAO {
    private Connection connexion = null;

    public void initialisation(){
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String nomUtilisateur = "root";
            String motDePasse = "pass";
            String nomBase = "onlypets";

            String connec = "jdbc:mariadb://localhost:3306/";
            connec += nomBase + "?user="+nomUtilisateur;
            connec += "&password="+motDePasse;

            connexion = DriverManager.getConnection(connec);
        } catch (Exception e) {
            System.out.println("Exception : " + e.getMessage());
        }
    }

    public void cloture() {
        try {
            connexion.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void addPost(Post post){
        try {
            Statement statement = connexion.createStatement();
            String requete = "INSERT INTO posts VALUES(default, " + post.getPetID() + ",'" +
                    post.getTitle().replace("'", "''") + "','" +
                    post.getPhoto().replace("'", "''") + "','" +
                    post.getDescription().replace("'", "''")+"');";

            statement.executeUpdate(requete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public int getLastInsertId(){
        int lastInsertId = -1;
        try {
            Statement statement = connexion.createStatement();
            String requete = "SELECT LAST_INSERT_ID();";
            ResultSet rs = statement.executeQuery(requete);
            if (rs.next() != false) {
                lastInsertId = rs.getInt("LAST_INSERT_ID()");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return lastInsertId;
    }

    public List<Post> lesXdernierposts(int nbpost){
        List<Post> postList = new ArrayList<>();
        int compteurPosts = 0;
        try{
            Statement statement = connexion.createStatement();
            String requete = "select posts.ID, pets.name, users.username, posts.title ,posts.photo ,posts.description, posts.petID from posts " +
                    "inner join petpost on petpost.postID = posts.ID " +
                    "inner join pets on petpost.petID = pets.ID " +
                    "inner join userpets on userpets.petID = pets.ID " +
                    "inner join users on userpets.userID  = users.ID order by ID desc ;";
            ResultSet rs = statement.executeQuery(requete);
            while (rs.next()&&compteurPosts<nbpost) {
                Post post = new Post(rs.getInt("ID"), rs.getInt("petID"), rs.getString("title"),
                        rs.getString("photo"),rs.getString("description"), rs.getString("name"),
                        rs.getString("username"));
                postList.add(post);
                compteurPosts++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

    public List<Post> customFilter(List<String> selectedSpecies, String selectedSort, int nbpost){
        List<Post> postList = new ArrayList<>();
        int compteurPosts = 0;
        String whereRequest = "";
        String sortRequest = "ORDER BY ";

        //Construction de la composante WHERE de la requete sql
        if (selectedSpecies.size() > 0) {
            whereRequest += "WHERE pets.species IN (";
            for (String species:selectedSpecies) {
                whereRequest += "'" + species.replace("'", "''") + "', ";
            }
            whereRequest = whereRequest.substring(0, whereRequest.length()-2);
            whereRequest += ") ";
        }

        //Construction de la composante ORDER BY de la requete SQL
        switch (selectedSort) {
            case "olderFirst" :
                sortRequest += "ID";
                break;
            case "AtoZ" :
                sortRequest += "name";
                break;
            case "ZtoA" :
                sortRequest += "name desc";
                break;
            default :
                sortRequest += "ID desc";
        }

        try{
            Statement statement = connexion.createStatement();
            String requete = "select posts.ID, pets.name, users.username, posts.title ,posts.photo ,posts.description, posts.petID from posts " +
                    "inner join petpost on petpost.postID = posts.ID " +
                    "inner join pets on petpost.petID = pets.ID " +
                    "inner join userpets on userpets.petID = pets.ID " +
                    "inner join users on userpets.userID  = users.ID " +
                    whereRequest +
                    sortRequest + ";";
            ResultSet rs = statement.executeQuery(requete);
            while (rs.next()&&compteurPosts<nbpost) {
                Post post = new Post(rs.getInt("ID"), rs.getInt("petID"), rs.getString("title"),
                        rs.getString("photo"),rs.getString("description"), rs.getString("name"),
                        rs.getString("username"));
                postList.add(post);
                compteurPosts++;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return postList;
    }

}
