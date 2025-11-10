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

public abstract class Joueur extends Personne {

    private static int compteurCreation = 0; // pour le classement initial

    private Main main;
    private String sponsor;
    private int classement;
    private String entraineur;

    protected Joueur(String nomNaissance,
                     Genre genre,
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

        super(nomNaissance, genre, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids);

        this.main = main;
        this.sponsor = sponsor;
        this.entraineur = entraineur;

        compteurCreation++;
        this.classement = compteurCreation;
    }

    // Getters / setters
    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        this.sponsor = sponsor;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        this.classement = classement;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        this.entraineur = entraineur;
    }

    // Tenue : sera définie dans les sous-classes
    public abstract String getTenue();

    public abstract void changerCouleurTenue(String nouvelleCouleur);
    
        // --- Comportements (Partie 2) ---

    public void servir() {
        System.out.println(this + " sert.");
    }

    public void retournerService() {
        System.out.println(this + " retourne le service.");
    }

    public void renvoyerBalle() {
        System.out.println(this + " renvoie la balle.");
    }

    public void faireFaute() {
        System.out.println(this + " commet une faute.");
    }

    public void appelerArbitre(Arbitre arbitre, String motif) {
        System.out.println(this + " appelle l'arbitre : " + motif);
        arbitre.trancherLitige(motif, this);
    }

    public void sEncourager() {
        System.out.println(this + " s'encourage : \"Allez !\" ");
    }

    public void boire() {
        System.out.println(this + " boit à sa chaise.");
    }

    public void crierVictoire() {
        System.out.println(this + " remporte le match et crie sa victoire !");
    }

    public void crierDefaite() {
        System.out.println(this + " perd le match et accuse le vent, le soleil et les balles.");
    }

}

