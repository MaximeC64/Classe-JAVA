/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author utilisateur
 */
public class GestionConnection {
    private static final String url = "jdbc:mysql://87.98.154.146:3306/moralesmryexpens";
    private static final String login = "moralesmryexpens";
    private static final String mdp = "Expensemanager01";
    private static final String driver = "com.mysql.jdbc.Driver";
    private static Connection laConnection;
    
    public GestionConnection(){
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException ex) {
            System.out.println("Problème de driver "+ex.getMessage());
        }
        try {
            laConnection = DriverManager.getConnection(url, login, mdp);
        } catch (SQLException ex) {
            System.out.println("Problème de BDD "+ex.getMessage());
        }
    }
    public static Connection getLaConnection(){
        if (laConnection == null){
            new GestionConnection();
        }
        return laConnection;
    }
    public static void libere() throws SQLException{
        laConnection.close();
        laConnection = null;
    }
}
