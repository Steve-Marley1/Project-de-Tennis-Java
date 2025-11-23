/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.spectateur;

/**
 *
 * @author steve
 */

import java.time.LocalDate;

import tennis.model.joueur.Joueur;
import tennis.model.personne.Genre;

/**
 * Spectatrice (femme) dans le public.
 */
public class Spectatrice extends Spectateur {

    public Spectatrice(String nomNaissance,
                       String nomCourant,
                       String prenom,
                       String surnom,
                       LocalDate dateNaissance,
                       String lieuNaissance,
                       String nationalite,
                       int taille,
                       double poids,
                       Joueur joueurFavori,
                       int niveauPassion) {

        super(nomNaissance,
              nomCourant,
              prenom,
              surnom,
              dateNaissance,
              lieuNaissance,
              nationalite,
              taille,
              poids,
              Genre.FEMME,
              joueurFavori,
              niveauPassion);
    }

    @Override
    public String toString() {
        return "Spectatrice : " + super.toString();
    }
}
