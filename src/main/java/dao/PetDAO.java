package dao;

import beans.Pet;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public List<Pet> lesPetDunUser( String username){
        List<Pet> petList = new ArrayList<>();
        try{
            Statement statement = connexion.createStatement();
            String requete = "SELECT p.ID,p.userID, p.name, p.species, p.presentation , p.birthday  from pets p join userpets u on p.ID = u.petID join users u2 on u2.ID = u.userID where u2.username = '" + username+"';";
            ResultSet rs = statement.executeQuery(requete);
            while (rs.next()) {
                Pet pet = new Pet(rs.getInt("ID"), rs.getInt("userID"), rs.getString("name"), rs.getString("species"),rs.getString("presentation"), rs.getString("birthday"));
                petList.add(pet);
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return petList;
    }

}
