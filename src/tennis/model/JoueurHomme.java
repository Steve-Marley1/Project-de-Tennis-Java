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

public class JoueurHomme extends Joueur {

    private String couleurShort;

    public JoueurHomme(String nomNaissance,
                       String prenom,
                       String surnom,
                       LocalDate dateNaissance,
                       String lieuNaissance,
                       String nationalite,
                       int taille,
                       double poids,
                       Main main,
                       String sponsor,
                       String entraineur) {

        super(nomNaissance, Genre.HOMME, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids,
              main, sponsor, entraineur);

        this.couleurShort = "noir"; // valeur par défaut
    }

    @Override
    public String getTenue() {
        return "short " + couleurShort;
    }

    @Override
    public void changerCouleurTenue(String nouvelleCouleur) {
        if (nouvelleCouleur == null || nouvelleCouleur.isBlank()) {
            return;
        }
        String ancienne = this.couleurShort;
        this.couleurShort = nouvelleCouleur;
        System.out.println(toString()
                + " annonce : J'ai changé mon short "
                + ancienne + " pour " + nouvelleCouleur + ".");
    }
}
