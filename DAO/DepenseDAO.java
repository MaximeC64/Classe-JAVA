/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connexion.GestionConnection;
import Metier.Depense;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class DepenseDAO {
private final Connection laConnection;

    public  DepenseDAO() {
        laConnection = GestionConnection.getLaConnection();
    }
    
    public ArrayList<Depense> listDepense() throws SQLException{
        ArrayList<Depense> listDepense = new ArrayList<Depense>();
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM depense;";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            Depense d = new Depense(resultat.getInt("Id_Depense"),resultat.getString("DatePaiement_Depense"),resultat.getString("Libelle_Depense"),resultat.getString("Commentaire_Depense"), resultat.getFloat("MontantRemboursement_Depense"),resultat.getInt("Id_Notefrais"));
            listDepense.add(d);
        }
        return listDepense;
    }
    
    public ArrayList<Depense> listDepenseByIdNote(int id) throws SQLException{
        ArrayList<Depense> listDepense = new ArrayList<Depense>();
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM depense WHERE Id_Notefrais = "+id+";";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            Depense d = new Depense(resultat.getInt("Id_Depense"),resultat.getString("DatePaiement_Depense"),resultat.getString("Libelle_Depense"),resultat.getString("Commentaire_Depense"), resultat.getFloat("MontantRemboursement_Depense"),resultat.getInt("Id_Notefrais"));
            listDepense.add(d);
        }
        return listDepense;
    }
    
    public float montantTotalNote(int id) throws SQLException{
        float total = 0;
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT SUM(`MontantRemboursement_Depense`) as Total FROM `depense` WHERE `Id_Notefrais`="+ id ;
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            total= resultat.getFloat("Total");
        }
        return total;
    }
}

