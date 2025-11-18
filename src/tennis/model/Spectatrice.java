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
public class Spectatrice extends Spectateur {

    private String descriptionLunettes;
    public Spectatrice(String nomNaissance,
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
                       String descriptionLunettes) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids,
              Genre.FEMME, tribune, numeroPlace, prixBillet);

        if (descriptionLunettes == null || descriptionLunettes.isBlank()) {
            throw new IllegalArgumentException("La description des lunettes doit être renseignée.");
        }
        this.descriptionLunettes = descriptionLunettes;
    }

    public String getDescriptionLunettes() {
        return descriptionLunettes;
    }

     public void setDescriptionLunettes(String nouvelleDescription) {
        if (nouvelleDescription == null || nouvelleDescription.isBlank()) {
            throw new IllegalArgumentException("La description des lunettes doit être renseignée.");
        }

        if (!nouvelleDescription.equalsIgnoreCase(this.descriptionLunettes)) {
            System.out.println(getPrenom() + " en tribune " + getTribune()
                    + " change de lunettes : " + nouvelleDescription + ".");
        }
        this.descriptionLunettes = nouvelleDescription;
    }

    @Override
    public String toString() {
        return "Spectatrice : " + super.toString()
               + " | Lunettes : " + descriptionLunettes;
    } 
}