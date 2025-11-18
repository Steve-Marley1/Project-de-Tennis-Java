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
public abstract class Spectateur extends Personne implements Supporter {

    private String tribune;
    private int numeroPlace;
    private double prixBillet;
    
        public Spectateur(String nomNaissance,
                      String nomCourant,
                      String prenom,
                      String surnom,
                      LocalDate dateNaissance,
                      String lieuNaissance,
                      String nationalite,
                      int taille,
                      double poids,
                      Genre genre,
                      String tribune,
                      int numeroPlace,
                      double prixBillet) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids, genre);

        if (tribune == null || tribune.isBlank())
            throw new IllegalArgumentException("La tribune doit être renseignée.");

        if (numeroPlace <= 0)
            throw new IllegalArgumentException("Le numéro de place doit être positif.");

        if (prixBillet < 0)
            throw new IllegalArgumentException("Le prix du billet ne peut pas être négatif.");

        this.tribune = tribune;
        this.numeroPlace = numeroPlace;
        this.prixBillet = prixBillet;
    }

        
    public String getTribune() {
        return tribune;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public double getPrixBillet() {
        return prixBillet;
    }

        public void setTribune(String tribune) {
        if (tribune == null || tribune.isBlank())
            throw new IllegalArgumentException("La tribune doit être renseignée.");
        this.tribune = tribune;
    }

    public void setNumeroPlace(int numeroPlace) {
        if (numeroPlace <= 0)
            throw new IllegalArgumentException("Le numéro de place doit être positif.");
        this.numeroPlace = numeroPlace;
    }

    public void setPrixBillet(double prixBillet) {
        if (prixBillet < 0)
            throw new IllegalArgumentException("Le prix du billet ne peut pas être négatif.");
        this.prixBillet = prixBillet;
    }

        //comportement

    @Override
    public void applaudir() {
        System.out.println(getPrenom() + " applaudit !");
    }

    @Override
    public void crier() {
        System.out.println(getPrenom() + " crie pour encourager son joueur préféré !");
    }

    @Override
    public void huer() {
        System.out.println(getPrenom() + " hue !");
    }

    @Override
    public void dormir() {
        System.out.println(getPrenom() + " s'assoupit un instant dans les gradins...");
    }

    

    @Override
    public String toString() {
        return super.toString()
                + " | Tribune : " + tribune
                + " | Place : " + numeroPlace
                + " | Billet : " + prixBillet + " €";
    } 
 
}