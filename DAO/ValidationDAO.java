/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connexion.GestionConnection;
import Metier.Validation;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class ValidationDAO {
    private final Connection laConnection;

    public ValidationDAO() {
        laConnection = GestionConnection.getLaConnection();
    }
    
    public ArrayList<Validation> listValidation() throws SQLException{
        ArrayList<Validation> listValidation = new ArrayList<Validation>();
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM Valider;";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            Validation v = new Validation(resultat.getString("Etat_Validation"), resultat.getString("Date_Validation"), resultat.getInt("Id_Utilisateur"), resultat.getInt("Id_Depense"), resultat.getInt("Id_Notefrais"));
            listValidation.add(v);
        }
        return listValidation;
    }
    
    public ArrayList<Validation> listValidationByIdNode(int id) throws SQLException{
        ArrayList<Validation> listValidation = new ArrayList<Validation>();
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM Valider WHERE Id_Notefrais = "+id+";";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            Validation v = new Validation(resultat.getString("Etat_Validation"), resultat.getString("Date_Validation"), resultat.getInt("Id_Utilisateur"), resultat.getInt("Id_Depense"), resultat.getInt("Id_Notefrais"));
            listValidation.add(v);
        }
        return listValidation;
    }
    
    public void updateValidation(Validation v) throws SQLException{
        Statement transmission;
        transmission = laConnection.createStatement();
        String sql = "UPDATE Valider SET Etat_Validation = '"+v.getEtat_Validation()+"', Date_Validation = '"+v.getDate_Validation()+"', Id_Utilisateur = "+v.getId_Utilisateur()+", Id_Depense = '"+v.getId_Depense()+"', Id_Notefrais = '"+v.getId_Notefrais()+"' WHERE Valider.Id_Utilisateur = '"+v.getId_Utilisateur()+"';";
        
        int res = transmission.executeUpdate(sql);
        
        if(res==1){
            System.out.println("Modification OK");
        } else {
            System.out.println("Echec de la modification");
        }
    }
    public void addValidation(Validation v) throws SQLException{
        Statement transmission;
        transmission = laConnection.createStatement();
        String sql = "INSERT INTO Valider (Etat_Validation, Date_Validation, Id_Utilisateur, Id_Depense, Id_Notefrais) VALUES ('"+v.getEtat_Validation()+"','"+v.getDate_Validation()+"',"+v.getId_Utilisateur()+",'"+v.getId_Depense()+"','"+v.getId_Notefrais()+");";
        
        int res = transmission.executeUpdate(sql);
        
        if(res==1){
            System.out.println("Insertion OK");
        } else {
            System.out.println("Echec de l'insertion");
        }
    }
}
