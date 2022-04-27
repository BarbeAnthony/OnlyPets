package dao;

import beans.User;

import java.sql.*;

public class UserDAO {

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

    public void addUser(User user){
        try {
            Statement statement = connexion.createStatement();
            String requete = "INSERT INTO users VALUES(default, '" + user.getUsername() + "','" +
                    user.getPassword()  + "','" +
                    user.getEmail() + "');";
            statement.executeUpdate(requete);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean usernameExists(String username) {
        try {
            Statement statement = connexion.createStatement();

            //TODO nettoyer username pour protection sql injection

            String requete = "SELECT username FROM users WHERE username= '" + username + "';";
            ResultSet rs = statement.executeQuery(requete);
            if (rs.next() != false) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean emailExists(String email) {
        try {
            Statement statement = connexion.createStatement();

            //TODO nettoyer username pour protection sql injection

            String requete = "SELECT email FROM users WHERE email= '" + email + "';";
            ResultSet rs = statement.executeQuery(requete);
            if (rs.next() != false) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public String getUsernameAtConnection(String password, String email) {
        String username = "";
        try {
            Statement statement = connexion.createStatement();

            //TODO nettoyer password et email pour protection sql injection

            String requete = "SELECT username FROM users WHERE password= '" + password + "' AND email = '" + email + "';";
            ResultSet rs = statement.executeQuery(requete);
            if (rs.next() != false) {
                username = rs.getString("username");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return username;
    }

    /* TODO A supprimer si pas besoin d'adapter pour users
    public List<Appartement> retournerTousLesAppartements() {
        List<Appartement> appartList = new ArrayList<>();
        try {
            Statement statement = connexion.createStatement();
            String requete = "SELECT * FROM appartements;";
            ResultSet rs = statement.executeQuery(requete);
            while (rs.next()) {
                Appartement appart = new Appartement(rs.getInt("pieces"), rs.getInt("surface"), rs.getString("murs"), rs.getString("sol"));
                appartList.add(appart);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return appartList;
    }
    */
}
