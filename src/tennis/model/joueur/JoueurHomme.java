/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.joueur;

/**
 *
 * @author steve
 */

import java.time.LocalDate;
import tennis.model.personne.Genre;

/**
 * Représente un joueur de tennis masculin.
 */
public class JoueurHomme extends Joueur {

    /**
     * Crée un joueur homme avec ses informations personnelles et sportives.
     *
     * @param nomNaissance nom de naissance
     * @param nomCourant nom courant
     * @param prenom prénom
     * @param surnom surnom éventuel
     * @param dateNaissance date de naissance
     * @param lieuNaissance lieu de naissance
     * @param nationalite nationalité
     * @param taille taille en cm
     * @param poids poids en kg
     * @param main main dominante (DROITIER / GAUCHER)
     * @param sponsor sponsor principal (non vide)
     * @param entraineur nom de l'entraîneur (non vide)
     */
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
                       String entraineur) {

        super(nomNaissance,
              nomCourant,
              prenom,
              surnom,
              dateNaissance,
              lieuNaissance,
              nationalite,
              taille,
              poids,
              Genre.HOMME,
              main,
              sponsor,
              entraineur);
    }

    @Override
    public String toString() {
        return "Joueur Homme : " + super.toString();
    }
}
