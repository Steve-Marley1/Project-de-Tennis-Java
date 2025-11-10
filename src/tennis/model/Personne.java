/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tennis.model;

import java.time.LocalDate;
import java.time.Period ;

/**
 *
 * @author steve
 */
public class Personne {
    // Immuables après création
    private final String nomNaissance;
    private final Genre genre;
    private final LocalDate dateNaissance;
    private final String lieuNaissance;
    private final LocalDate dateDeces;   // peut être null si la personne est vivante

    // Modifiables
    private String nomCourant;           // seulement pour femme mariée (logique métier)
    private String prenom;
    private String surnom;
    private String nationalite;
    private int taille;                  // en cm
    private double poids;                // en kg

    // 1er constructeur : personne vivante
    public Personne(String nomNaissance,
                    Genre genre,
                    String prenom,
                    String surnom,
                    LocalDate dateNaissance,
                    String lieuNaissance,
                    String nationalite,
                    int taille,
                    double poids) {

        this.nomNaissance = nomNaissance;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.dateDeces = null;   // vivant

        this.prenom = prenom;
        this.surnom = surnom;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.nomCourant = null;
    }

    // 2e constructeur : personne décédée
    public Personne(String nomNaissance,
                    Genre genre,
                    String prenom,
                    String surnom,
                    LocalDate dateNaissance,
                    String lieuNaissance,
                    LocalDate dateDeces,
                    String nationalite,
                    int taille,
                    double poids) {

        this.nomNaissance = nomNaissance;
        this.genre = genre;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.dateDeces = dateDeces;  // décédée

        this.prenom = prenom;
        this.surnom = surnom;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.nomCourant = null;
    }

    // Getters immuables
    public String getNomNaissance() {
        return nomNaissance;
    }

    public Genre getGenre() {
        return genre;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public LocalDate getDateDeces() {
        return dateDeces;
    }

    // Getters / setters modifiables

    public String getNomCourant() {
        return nomCourant;
    }

    // On respecte la règle métier : nomCourant que pour une femme
    public void setNomCourant(String nomCourant) {
        if (this.genre == Genre.FEMME) {
            this.nomCourant = nomCourant;
        }
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom;
    }

    public String getNationalite() {
        return nationalite;
    }

    public void setNationalite(String nationalite) {
        this.nationalite = nationalite;
    }

    public int getTaille() {
        return taille;
    }

    public void setTaille(int taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    // d) âge vivant ou décédé
    public int getAge() {
        LocalDate fin = (dateDeces != null) ? dateDeces : LocalDate.now();
        return Period.between(dateNaissance, fin).getYears();
    }

    @Override
    public String toString() {
        String nomAffiche = (nomCourant != null && !nomCourant.isBlank())
                ? nomCourant
                : nomNaissance;
        return nomAffiche + " " + prenom;
    }
    
    
}
