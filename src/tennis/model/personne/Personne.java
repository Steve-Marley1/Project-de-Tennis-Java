/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.personne;

/**
 *
 * @author steve
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Représente une personne de base (nom, prénom, date de naissance, etc.)
 * Classe abstraite destinée à être héritée par Joueur, Arbitre, Spectateur, etc.
 */
public abstract class Personne {

    private String nomNaissance;
    private String nomCourant;
    private String prenom;
    private String surnom;
    private LocalDate dateNaissance;
    private String lieuNaissance;
    private String nationalite;
    private int taille;      // en cm
    private double poids;    // en kg
    private Genre genre;

    /**
     * Crée une personne avec ses informations principales.
     *
     * @param nomNaissance nom de naissance (obligatoire)
     * @param nomCourant nom courant (obligatoire)
     * @param prenom prénom (obligatoire)
     * @param surnom surnom (facultatif, peut être null ou vide)
     * @param dateNaissance date de naissance (obligatoire, ne doit pas être future)
     * @param lieuNaissance lieu de naissance (obligatoire)
     * @param nationalite nationalité (obligatoire)
     * @param taille taille en centimètres (> 0)
     * @param poids poids en kilogrammes (> 0)
     * @param genre genre de la personne (HOMME / FEMME)
     * @throws IllegalArgumentException si une donnée est invalide
     */
    public Personne(String nomNaissance,
                    String nomCourant,
                    String prenom,
                    String surnom,
                    LocalDate dateNaissance,
                    String lieuNaissance,
                    String nationalite,
                    int taille,
                    double poids,
                    Genre genre) {

        if (nomNaissance == null || nomNaissance.isBlank()) {
            throw new IllegalArgumentException("Le nom de naissance est obligatoire.");
        }
        if (nomCourant == null || nomCourant.isBlank()) {
            throw new IllegalArgumentException("Le nom courant est obligatoire.");
        }
        if (prenom == null || prenom.isBlank()) {
            throw new IllegalArgumentException("Le prénom est obligatoire.");
        }
        if (dateNaissance == null) {
            throw new IllegalArgumentException("La date de naissance est obligatoire.");
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date de naissance ne peut pas être dans le futur.");
        }
        if (lieuNaissance == null || lieuNaissance.isBlank()) {
            throw new IllegalArgumentException("Le lieu de naissance est obligatoire.");
        }
        if (nationalite == null || nationalite.isBlank()) {
            throw new IllegalArgumentException("La nationalité est obligatoire.");
        }
        if (taille <= 0) {
            throw new IllegalArgumentException("La taille doit être strictement positive.");
        }
        if (poids <= 0) {
            throw new IllegalArgumentException("Le poids doit être strictement positif.");
        }
        if (genre == null) {
            throw new IllegalArgumentException("Le genre est obligatoire.");
        }

        this.nomNaissance = nomNaissance;
        this.nomCourant = nomCourant;
        this.prenom = prenom;
        this.surnom = (surnom == null || surnom.isBlank()) ? null : surnom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.genre = genre;
    }

    public String getNomNaissance() {
        return nomNaissance;
    }

    protected void setNomNaissance(String nomNaissance) {
        if (nomNaissance == null || nomNaissance.isBlank()) {
            throw new IllegalArgumentException("Le nom de naissance est obligatoire.");
        }
        this.nomNaissance = nomNaissance;
    }

    public String getNomCourant() {
        return nomCourant;
    }

    protected void setNomCourant(String nomCourant) {
        if (nomCourant == null || nomCourant.isBlank()) {
            throw new IllegalArgumentException("Le nom courant est obligatoire.");
        }
        this.nomCourant = nomCourant;
    }

    public String getPrenom() {
        return prenom;
    }

    protected void setPrenom(String prenom) {
        if (prenom == null || prenom.isBlank()) {
            throw new IllegalArgumentException("Le prénom est obligatoire.");
        }
        this.prenom = prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    protected void setSurnom(String surnom) {
        this.surnom = (surnom == null || surnom.isBlank()) ? null : surnom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    protected void setDateNaissance(LocalDate dateNaissance) {
        if (dateNaissance == null) {
            throw new IllegalArgumentException("La date de naissance est obligatoire.");
        }
        if (dateNaissance.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La date de naissance ne peut pas être dans le futur.");
        }
        this.dateNaissance = dateNaissance;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    protected void setLieuNaissance(String lieuNaissance) {
        if (lieuNaissance == null || lieuNaissance.isBlank()) {
            throw new IllegalArgumentException("Le lieu de naissance est obligatoire.");
        }
        this.lieuNaissance = lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    protected void setNationalite(String nationalite) {
        if (nationalite == null || nationalite.isBlank()) {
            throw new IllegalArgumentException("La nationalité est obligatoire.");
        }
        this.nationalite = nationalite;
    }

    public int getTaille() {
        return taille;
    }

    protected void setTaille(int taille) {
        if (taille <= 0) {
            throw new IllegalArgumentException("La taille doit être strictement positive.");
        }
        this.taille = taille;
    }

    public double getPoids() {
        return poids;
    }

    protected void setPoids(double poids) {
        if (poids <= 0) {
            throw new IllegalArgumentException("Le poids doit être strictement positif.");
        }
        this.poids = poids;
    }

    public Genre getGenre() {
        return genre;
    }

    protected void setGenre(Genre genre) {
        if (genre == null) {
            throw new IllegalArgumentException("Le genre est obligatoire.");
        }
        this.genre = genre;
    }

    /**
     * Calcule l'âge de la personne à partir de la date du jour.
     *
     * @return âge en années
     */
    public int getAge() {
        return Period.between(dateNaissance, LocalDate.now()).getYears();
    }

    @Override
    public String toString() {
        String affichageSurnom = (surnom != null) ? " \"" + surnom + "\"" : "";
        return prenom + " " + nomCourant + affichageSurnom
                + " (" + genre + ", " + getAge() + " ans, " + nationalite + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne)) return false;
        Personne personne = (Personne) o;
        return Objects.equals(nomNaissance, personne.nomNaissance)
                && Objects.equals(prenom, personne.prenom)
                && Objects.equals(dateNaissance, personne.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomNaissance, prenom, dateNaissance);
    }
}
