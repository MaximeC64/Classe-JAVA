/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Connexion.GestionConnection;
import Metier.Client;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author utilisateur
 */
public class ClientDAO {
    private final Connection laConnection;

    public ClientDAO() {
        laConnection = GestionConnection.getLaConnection();
    }
    
    public ArrayList<Client> listClient() throws SQLException{
        ArrayList<Client> listClient = new ArrayList<Client>();
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM Client;";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            Client c = new Client (resultat.getInt("Id_Client"), resultat.getString("Nom_Client"), resultat.getString("Prenom_Client"));
            listClient.add(c);
        }
        return listClient;
    }
    public Client readOneClient(int id) throws SQLException{
        Client oneClient = null;
        Statement transmission;
        transmission = laConnection.createStatement();
        ResultSet resultat;
        String sql = "SELECT * FROM Client WHERE Id_Client = "+id+";";
        resultat = transmission.executeQuery(sql);
        while(resultat.next()){
            oneClient = new Client (resultat.getInt("Id_Client"), resultat.getString("Nom_Client"), resultat.getString("Prenom_Client"));
        }
        return oneClient;
    }
}

