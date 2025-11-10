/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model;
import java.time.LocalDate;

/**
 *
 * @author steve
 */
public class SpectateurHomme extends Spectateur {

    private String couleurChemise;

    public SpectateurHomme(String nomNaissance,
                           String prenom,
                           String surnom,
                           LocalDate dateNaissance,
                           String lieuNaissance,
                           String nationalite,
                           String tribune,
                           int numeroPlace,
                           double prixBillet) {

        super(nomNaissance, Genre.HOMME, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite,
              tribune, numeroPlace, prixBillet);

        this.couleurChemise = "bleu";
    }

    public String getCouleurChemise() {
        return couleurChemise;
    }

    public void changerCouleurChemise(String nouvelleCouleur) {
        if (nouvelleCouleur == null || nouvelleCouleur.isBlank()) {
            return;
        }
        String ancienne = this.couleurChemise;
        this.couleurChemise = nouvelleCouleur;
        System.out.println(toString()
                + " met en évidence sa chemise "
                + ancienne + " remplacée par " + nouvelleCouleur + ".");
    }
}