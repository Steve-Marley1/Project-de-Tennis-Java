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
public class ArbitreCentral extends Arbitre {
    
/*Intitulé ou description du poste occupé par l'arbitre central. */
    private String poste;
    
     public ArbitreCentral(String nomNaissance,
                          String nomCourant,
                          String prenom,
                          String surnom,
                          LocalDate dateNaissance,
                          String lieuNaissance,
                          String nationalite,
                          int taille,
                          double poids,
                          double reputationArbitre,
                          String poste) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids, reputationArbitre);

        if (poste == null || poste.isBlank()) {
            throw new IllegalArgumentException("Le poste de l'arbitre central doit être renseigné.");
        }
        this.poste = poste;
    }
    public String getPoste() {
           return poste;
       }
    
    @Override
    public void annoncer(String message) {
        System.out.println("Arbitre central (" + poste + ") : " + message);
    }

    @Override
    public String toString() {
        return "Arbitre Central : " + super.toString()
               + " | Poste : " + poste;
    }

}