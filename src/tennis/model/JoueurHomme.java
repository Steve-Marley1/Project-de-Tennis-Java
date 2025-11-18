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
                       String couleurShort) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids,
              Genre.HOMME, main, sponsor, entraineur);

        if (couleurShort == null || couleurShort.isBlank()) {
            throw new IllegalArgumentException("La couleur du short doit être renseignée.");
        }
        this.couleurShort = couleurShort;
    }

    public String getCouleurShort() {
        return couleurShort;
    }
   
    //changer la couleur du short et annonce le changement 
   public void setCouleurShort(String nouvelleCouleur) {
        if (nouvelleCouleur == null || nouvelleCouleur.isBlank()) {
            throw new IllegalArgumentException("La couleur du short doit être renseignée.");
        }
        if (!nouvelleCouleur.equalsIgnoreCase(this.couleurShort)) {
            System.out.println(getPrenom() + " " + getNomCourant()
                    + " change de short, nouvelle couleur : " + nouvelleCouleur + ".");
        }
        this.couleurShort = nouvelleCouleur;
    }
   
    @Override
    public String toString() {
        return "Joueur Homme : " + super.toString()
               + " | Short : " + couleurShort;
    }
}
