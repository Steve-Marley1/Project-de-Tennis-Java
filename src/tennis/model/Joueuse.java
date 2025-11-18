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
                   String nomCourant,
                   String prenom,
                   String surnom,
                   LocalDate dateNaissance,
                   String lieuNaissance,
                   String nationalite,
                   int taille,
                   double poids,
                   Main main,
                   String sponsor,
                   String entraineur,
                   String couleurJupe) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids,
              Genre.FEMME, main, sponsor, entraineur);

        if (couleurJupe == null || couleurJupe.isBlank()) {
            throw new IllegalArgumentException("La couleur de la jupe doit être renseignée.");
        }
        this.couleurJupe = couleurJupe;
    }

    public String getCouleurJupe() {
        return couleurJupe;
    }

     
      //Change la couleur de la jupe et annonce le changement.
    public void setCouleurJupe(String nouvelleCouleur) {
        if (nouvelleCouleur == null || nouvelleCouleur.isBlank()) {
            throw new IllegalArgumentException("La couleur de la jupe doit être renseignée.");
        }

        if (!nouvelleCouleur.equalsIgnoreCase(this.couleurJupe)) {
            System.out.println(getPrenom() + " " + getNomCourant()
                    + " change de jupe, nouvelle couleur : " + nouvelleCouleur + ".");
        }
        this.couleurJupe = nouvelleCouleur;
    }

    @Override
    public String toString() {
        return "Joueuse : " + super.toString()
               + " | Jupe : " + couleurJupe;
    }
    
}