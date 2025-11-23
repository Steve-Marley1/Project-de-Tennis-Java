/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.arbitre;

/**
 *
 * @author steve
 */

import java.time.LocalDate;

/**
 * Représente l'arbitre central d'un match de tennis.
 * Hérite d'Arbitre et ajoute la notion de poste (ex : "Arbitre de chaise").
 */
public class ArbitreCentral extends Arbitre {

    private String poste;

    /**
     * Constructeur d'un arbitre central.
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
     * @param reputation réputation de l'arbitre (0.0 à 1.0)
     * @param poste poste occupé (ex : "Arbitre de chaise")
     */
    public ArbitreCentral(String nomNaissance,
                          String nomCourant,
                          String prenom,
                          String surnom,
                          LocalDate dateNaissance,
                          String lieuNaissance,
                          String nationalite,
                          int taille,
                          double poids,
                          double reputation,
                          String poste) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite,
              taille, poids, reputation);

        try {
            if (poste == null || poste.isBlank()) {
                throw new IllegalArgumentException("Le poste est obligatoire pour un arbitre central.");
            }
            this.poste = poste;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        try {
            if (poste == null || poste.isBlank()) {
                throw new IllegalArgumentException("Le poste de l'arbitre central est obligatoire.");
            }
            this.poste = poste;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * L'arbitre central monte sur sa chaise (action typique).
     */
    public void monterSurChaise() {
        annoncer("L'arbitre central (" + poste + ") monte sur sa chaise.");
    }

    /**
     * L'arbitre central descend de sa chaise (fin du match).
     */
    public void descendreDeChaise() {
        annoncer("L'arbitre central (" + poste + ") descend de sa chaise.");
    }

    @Override
    public String toString() {
        return "Arbitre Central (" + poste + ") : " + super.toString();
    }
}
