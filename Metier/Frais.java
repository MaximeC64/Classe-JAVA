/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Metier;

/**
 *
 * @author utilisateur
 */
public class Frais extends Depense{
    private String Date_Frais;

    public Frais(String Date_Frais, int Id_Depense, String DatePaiement_Depense, String Libelle_Depense, String Commentaire_Depense, float MontantRemboursement_Depense, int Id_Notefrais) {
        super(Id_Depense, DatePaiement_Depense, Libelle_Depense, Commentaire_Depense, MontantRemboursement_Depense, Id_Notefrais);
        this.Date_Frais = Date_Frais;
    }

    public String getDate_Frais() {
        return Date_Frais;
    }
    public void setDate_Frais(String Date_Frais) {
        this.Date_Frais = Date_Frais;
    }
}
