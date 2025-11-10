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

    private boolean porteLunettes;

    public Spectatrice(String nomNaissance,
                       String prenom,
                       String surnom,
                       LocalDate dateNaissance,
                       String lieuNaissance,
                       String nationalite,
                       String tribune,
                       int numeroPlace,
                       double prixBillet) {

        super(nomNaissance, Genre.FEMME, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite,
              tribune, numeroPlace, prixBillet);

        this.porteLunettes = false;
    }

    public boolean isPorteLunettes() {
        return porteLunettes;
    }

    public void setPorteLunettes(boolean porteLunettes) {
        this.porteLunettes = porteLunettes;
        System.out.println(toString()
                + " est reconnue par ses lunettes : "
                + (porteLunettes ? "oui" : "non") + ".");
    }
}