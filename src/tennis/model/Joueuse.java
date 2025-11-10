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

public class Joueuse extends Joueur {

    private String couleurJupe;

    public Joueuse(String nomNaissance,
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

        super(nomNaissance, Genre.FEMME, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids,
              main, sponsor, entraineur);

        this.couleurJupe = "noir";
    }

    @Override
    public String getTenue() {
        return "jupe " + couleurJupe;
    }

    @Override
    public void changerCouleurTenue(String nouvelleCouleur) {
        if (nouvelleCouleur == null || nouvelleCouleur.isBlank()) {
            return;
        }
        String ancienne = this.couleurJupe;
        this.couleurJupe = nouvelleCouleur;
        System.out.println(toString()
                + " annonce : J'ai changé ma jupe "
                + ancienne + " pour " + nouvelleCouleur + ".");
    }
}