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

    private String poste; // ex: "Chaise centrale Court Philippe-Chatrier"

    public ArbitreCentral(String nomNaissance,
                          Genre genre,
                          String prenom,
                          String surnom,
                          LocalDate dateNaissance,
                          String lieuNaissance,
                          String nationalite,
                          String poste) {

        super(nomNaissance, genre, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite);
        this.poste = poste;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    @Override
    public void annoncer(String message) {
        if (isMicroActif()) {
            System.out.println("[Arbitre central] " + toString() + " (micro) : " + message);
        } else {
            System.out.println("[Arbitre central] " + toString() + " (sans micro) : " + message);
        }
    }
}