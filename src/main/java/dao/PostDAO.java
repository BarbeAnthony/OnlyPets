package dao;

import beans.Post;

import java.sql.*;

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
            String requete = "INSERT INTO post VALUES(default, " + post.getPetID() + ",'" +
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
}
