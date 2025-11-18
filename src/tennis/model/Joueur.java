/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model;

/**
 *
 * @author steve
 */

import java.time.LocalDate;

public abstract class Joueur extends Personne {

    private static int compteurClassement = 1;

    private Main main;
    private String sponsor;
    private int classement;
    private String entraineur;

    public Joueur(String nomNaissance,
                  String nomCourant,
                  String prenom,
                  String surnom,
                  LocalDate dateNaissance,
                  String lieuNaissance,
                  String nationalite,
                  int taille,
                  double poids,
                  Genre genre,
                  Main main,
                  String sponsor,
                  String entraineur) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids, genre);

        if (main == null) {
            throw new IllegalArgumentException("La main de jeu ne peut pas être nulle.");
        }

        this.main = main;
        this.sponsor = sponsor;
        this.entraineur = entraineur;
        this.classement = compteurClassement++;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        if (main == null) {
            throw new IllegalArgumentException("La main de jeu ne peut pas être nulle.");
        }
        this.main = main;
    }

    public String getSponsor() {
        return sponsor;
    }

    public void setSponsor(String sponsor) {
        if (sponsor == null || sponsor.isBlank()) {
            throw new IllegalArgumentException("Le sponsor doit être non vide.");
        }
        this.sponsor = sponsor;
    }

    public int getClassement() {
        return classement;
    }

    public void setClassement(int classement) {
        if (classement <= 0) {
            throw new IllegalArgumentException("Le classement doit être positif.");
        }
        this.classement = classement;
    }

    public String getEntraineur() {
        return entraineur;
    }

    public void setEntraineur(String entraineur) {
        if (entraineur == null || entraineur.isBlank()) {
            throw new IllegalArgumentException("L'entraîneur doit être non vide.");
        }
        this.entraineur = entraineur;
    }

    public void servir() {
        System.out.println(getPrenom() + " " + getNomCourant() + " sert.");
    }

    public void retournerService() {
        System.out.println(getPrenom() + " retourne le service.");
    }

    public void renvoyerBalle() {
        System.out.println(getPrenom() + " renvoie la balle.");
    }

    public void faireFaute() {
        System.out.println(getPrenom() + " fait une faute.");
    }

    public void appelerArbitre(Arbitre arbitre, String motif) {
        System.out.println(getPrenom() + " appelle l'arbitre pour : " + motif);
        arbitre.trancherLitige(this, motif);
    }

    public void encourager() {
        System.out.println(getPrenom() + " s'encourage.");
    }

    public void boire() {
        System.out.println(getPrenom() + " boit un peu d'eau.");
    }

    public void crierVictoire() {
        System.out.println(getPrenom() + " remporte la rencontre !");
    }

    public void crierDefaite() {
        System.out.println(getPrenom() + " perd le match...");
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Classement : " + classement
                + " | Main : " + main
                + " | Sponsor : " + sponsor
                + " | Entraîneur : " + entraineur;
    }
}
