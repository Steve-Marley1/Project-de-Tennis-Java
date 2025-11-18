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
                           String nomCourant,
                           String prenom,
                           String surnom,
                           LocalDate dateNaissance,
                           String lieuNaissance,
                           String nationalite,
                           int taille,
                           double poids,
                           String tribune,
                           int numeroPlace,
                           double prixBillet,
                           String couleurChemise) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids,
              Genre.HOMME, tribune, numeroPlace, prixBillet);

        if (couleurChemise == null || couleurChemise.isBlank()) {
            throw new IllegalArgumentException("La couleur de la chemise doit être renseignée.");
        }
        this.couleurChemise = couleurChemise;
    }

    public String getCouleurChemise() {
        return couleurChemise;
    }
      public void setCouleurChemise(String nouvelleCouleur) {
        if (nouvelleCouleur == null || nouvelleCouleur.isBlank()) {
            throw new IllegalArgumentException("La couleur de la chemise doit être renseignée.");
        }

        if (!nouvelleCouleur.equalsIgnoreCase(this.couleurChemise)) {
            System.out.println(getPrenom() + " en tribune " + getTribune()
                    + " met en évidence sa nouvelle chemise " + nouvelleCouleur + ".");
        }
        this.couleurChemise = nouvelleCouleur;
    }

    @Override
    public String toString() {
        return "Spectateur Homme : " + super.toString()
               + " | Chemise : " + couleurChemise;
    }

}