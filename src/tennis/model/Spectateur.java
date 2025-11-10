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
public abstract class Spectateur extends Personne {

    private String tribune;
    private int numeroPlace;
    private double prixBillet;

    protected Spectateur(String nomNaissance,
                         Genre genre,
                         String prenom,
                         String surnom,
                         LocalDate dateNaissance,
                         String lieuNaissance,
                         String nationalite,
                         String tribune,
                         int numeroPlace,
                         double prixBillet) {

        super(nomNaissance, genre, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, 0, 0.0);

        this.tribune = tribune;
        this.numeroPlace = numeroPlace;
        this.prixBillet = prixBillet;
    }

    public String getTribune() {
        return tribune;
    }

    public void setTribune(String tribune) {
        this.tribune = tribune;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public double getPrixBillet() {
        return prixBillet;
    }

    public void setPrixBillet(double prixBillet) {
        this.prixBillet = prixBillet;
    }

    public void applaudir() {
        System.out.println(toString() + " applaudit !");
    }

    public void crier() {
        System.out.println(toString() + " crie !");
    }

    public void huer() {
        System.out.println(toString() + " hue !");
    }

    public void dormir() {
        System.out.println(toString() + " s'endort (c'est rare)...");
    }
}