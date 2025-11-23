/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.spectateur;

/**
 *
 * @author steve
 */

import java.time.LocalDate;

import tennis.model.support.Supporter;
import tennis.model.joueur.Joueur;
import tennis.model.personne.Genre;
import tennis.model.personne.Personne;

/**
 * Représente un spectateur de tennis abstrait.
 * Implémente l'interface Supporter et gère un joueur favori
 * ainsi qu'un niveau de passion.
 */
public abstract class Spectateur extends Personne implements Supporter {

    private Joueur joueurFavori;
    private int niveauPassion; // de 0 à 10

    protected Spectateur(String nomNaissance,
                         String nomCourant,
                         String prenom,
                         String surnom,
                         LocalDate dateNaissance,
                         String lieuNaissance,
                         String nationalite,
                         int taille,
                         double poids,
                         Genre genre,
                         Joueur joueurFavori,
                         int niveauPassion) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite,
              taille, poids, genre);

        if (niveauPassion < 0 || niveauPassion > 10) {
            throw new IllegalArgumentException("Le niveau de passion doit être compris entre 0 et 10.");
        }

        this.joueurFavori = joueurFavori;
        this.niveauPassion = niveauPassion;
    }

    public Joueur getJoueurFavori() {
        return joueurFavori;
    }

    protected void setJoueurFavori(Joueur joueurFavori) {
        this.joueurFavori = joueurFavori;
    }

    public int getNiveauPassion() {
        return niveauPassion;
    }

    protected void setNiveauPassion(int niveauPassion) {
        if (niveauPassion < 0 || niveauPassion > 10) {
            throw new IllegalArgumentException("Le niveau de passion doit être compris entre 0 et 10.");
        }
        this.niveauPassion = niveauPassion;
    }

    @Override
    public void applaudir() {
        System.out.println(getPrenom() + " applaudit avec enthousiasme (niveau " + niveauPassion + ").");
    }

    @Override
    public void crier() {
        String cible = (joueurFavori != null) ? joueurFavori.getPrenom() : "son joueur favori";
        System.out.println(getPrenom() + " crie pour encourager " + cible + " !");
    }

    @Override
    public void huer() {
        System.out.println(getPrenom() + " hue une décision de l'arbitre.");
    }

    @Override
    public void dormir() {
        System.out.println(getPrenom() + " commence à somnoler dans les tribunes...");
    }

    @Override
    public void reagirPointGagne() {
        String cible = (joueurFavori != null) ? joueurFavori.getPrenom() : "son joueur";
        System.out.println(getPrenom() + " se lève et crie : « Allez " + cible + " ! »");
    }

    @Override
    public void reagirPointPerdu() {
        String cible = (joueurFavori != null) ? joueurFavori.getPrenom() : "son joueur";
        System.out.println(getPrenom() + " grimace après le point perdu de " + cible + ".");
    }

    @Override
    public String toString() {
        String nomFavori = (joueurFavori != null) ? joueurFavori.getPrenom() : "aucun";
        return super.toString()
                + " | Spectateur (favori : " + nomFavori
                + ", passion = " + niveauPassion + ")";
    }
}
