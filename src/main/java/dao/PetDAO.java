package dao;

import beans.Pet;

import java.sql.*;

public class PetDAO {

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

    public void addPet(Pet pet){
        try {
            Statement statement = connexion.createStatement();
            String requete = "INSERT INTO pets VALUES(default, " + pet.getUserID() + ",'" +
                    pet.getName().replace("'", "''") + "','" +
                    pet.getSpecies().replace("'", "''") + "','" +
                    pet.getPresentation().replace("'", "''") + "','" +
                    pet.getBirthday().replace("'", "''") + "');";
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
