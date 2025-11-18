/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package tennis.model;

import java.time.LocalDate;
import java.time.Period ;
import java.util.Objects;
/**
 *
 * @author steve
 */

public class Personne {
    // Attribut Immuables
    private final String nomNaissance;
    private final LocalDate dateNaissance;
    private final String lieuNaissance;
    private final Genre genre;
    
    //Attributs modifiables
    private String nomCourant;
    private String prenom;
    private String surnom;
    private LocalDate dateDeces;
    private String nationalite;
    private int taille;  // en cm
    private double poids; // en kg
    
    //Constructeur
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

        if (nomNaissance == null || nomNaissance.isBlank())
            throw new IllegalArgumentException("Le nom de naissance ne peut pas être vide.");

        if (prenom == null || prenom.isBlank())
            throw new IllegalArgumentException("Le prénom ne peut pas être vide.");

        if (dateNaissance == null || dateNaissance.isAfter(LocalDate.now()))
            throw new IllegalArgumentException("La date de naissance est invalide.");

        if (lieuNaissance == null || lieuNaissance.isBlank())
            throw new IllegalArgumentException("Le lieu de naissance est obligatoire.");

        if (taille <= 0)
            throw new IllegalArgumentException("La taille doit être positive.");

        if (poids <= 0)
            throw new IllegalArgumentException("Le poids doit être positif.");

        if (genre == null)
            throw new IllegalArgumentException("Le genre ne peut pas être nul.");

        this.nomNaissance = nomNaissance;
        this.nomCourant = (nomCourant == null || nomCourant.isBlank()) ? nomNaissance : nomCourant; //utilisation d'opérateur ternaire pour factoriser le code
        this.prenom = prenom;
        this.surnom = surnom;
        this.dateNaissance = dateNaissance;
        this.lieuNaissance = lieuNaissance;
        this.nationalite = nationalite;
        this.taille = taille;
        this.poids = poids;
        this.genre = genre;
        
        

    }
    //Getters 
    public String getNomNaissance() {
        return nomNaissance;
    }

    public String getNomCourant() {
        return nomCourant;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getSurnom() {
        return surnom;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public LocalDate getDateDeces() {
        return dateDeces;
    }

    public String getLieuNaissance() {
        return lieuNaissance;
    }

    public String getNationalite() {
        return nationalite;
    }

    public int getTaille() {
        return taille;
    }

    public double getPoids() {
        return poids;
    }

    public Genre getGenre() {
        return genre;
    }

    // Setters
    
        public void setNomCourant(String nomCourant) {
        if (nomCourant == null || nomCourant.isBlank())
            throw new IllegalArgumentException("Le nom courant ne peut pas être vide.");
        this.nomCourant = nomCourant;
    }

    public void setPrenom(String prenom) {
        if (prenom == null || prenom.isBlank())
            throw new IllegalArgumentException("Le prénom ne peut pas être vide.");
        this.prenom = prenom;
    }

    public void setSurnom(String surnom) {
        this.surnom = surnom; // peut être vide ou nul
    }

    
      //La date de décès, une fois définie, ne peut plus être modifiée.
  
    public void setDateDeces(LocalDate dateDeces) {
        if (this.dateDeces != null)
            throw new IllegalStateException("La date de décès est déjà définie et ne peut plus changer.");

        if (dateDeces != null && dateDeces.isBefore(dateNaissance))
            throw new IllegalArgumentException("La date de décès ne peut pas être avant la naissance.");

        this.dateDeces = dateDeces;
    }

    public void setNationalite(String nationalite) {
        if (nationalite == null || nationalite.isBlank())
            throw new IllegalArgumentException("La nationalité ne peut pas être vide.");
        this.nationalite = nationalite;
    }

    public void setTaille(int taille) {
        if (taille <= 0)
            throw new IllegalArgumentException("La taille doit être positive.");
        this.taille = taille;
    }

    public void setPoids(double poids) {
        if (poids <= 0)
            throw new IllegalArgumentException("Le poids doit être positif.");
        this.poids = poids;
    }
    
/*
      Renvoie l'âge de la personne :
       - si vivante → âge actuel
       - si décédée → âge au moment du décès
     */    
    
     public int getAge() {
        LocalDate fin = (dateDeces == null) ? LocalDate.now() : dateDeces;
        return Period.between(dateNaissance, fin).getYears();
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Personne)) return false;
        Personne p = (Personne) o;
        return nomNaissance.equalsIgnoreCase(p.nomNaissance) &&
               prenom.equalsIgnoreCase(p.prenom) &&
               dateNaissance.equals(p.dateNaissance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nomNaissance.toLowerCase(), prenom.toLowerCase(), dateNaissance);
    }
  @Override
    public String toString() {
        return prenom + " " + nomCourant + " (" + genre + ")";
    }

}