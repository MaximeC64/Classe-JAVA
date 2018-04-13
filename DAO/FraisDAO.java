/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connexion.GestionConnection;
import Metier.Frais;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class FraisDAO {
    private final Connection laConnection;

    public FraisDAO() {
        laConnection = GestionConnection.getLaConnection();
    }
    
    public ArrayList<Frais> listFrais() throws SQLException{
        ArrayList<Frais> listFrais = new ArrayList<Frais>();
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM Depense, Frais;";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            Frais f = new Frais(resultat.getString("Date_Frais"), resultat.getInt("Id_Depense"), resultat.getString("DatePaiement_Depense"), resultat.getString("Libelle_Depense"), resultat.getString("Commentaire_Depense"), resultat.getFloat("MontantRemboursement_Depense"), resultat.getInt("Id_Notefrais"));
            listFrais.add(f);
        }
        return listFrais;
    }
}
