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
import java.util.Random;

public class Arbitre extends Personne {

    private boolean microActif;

    public Arbitre(String nomNaissance,
                   Genre genre,
                   String prenom,
                   String surnom,
                   LocalDate dateNaissance,
                   String lieuNaissance,
                   String nationalite) {

        super(nomNaissance, genre, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, 0, 0.0);

        this.microActif = true;
    }

    public boolean isMicroActif() {
        return microActif;
    }

    public void setMicroActif(boolean microActif) {
        this.microActif = microActif;
    }

    public void annoncer(String message) {
        if (microActif) {
            System.out.println("Arbitre " + toString() + " (micro) : " + message);
        } else {
            System.out.println("Arbitre " + toString() + " : " + message);
        }
    }

    public void annoncerScoreJeu(Jeu jeu) {
        annoncer("Score du jeu : " + jeu.getScoreTexte());
    }

    public void annoncerFinJeu(Joueur gagnantJeu, SetTennis set) {
        annoncer("Jeu " + gagnantJeu + " ! Score du set : " + set.getScoreSet());
    }

    public void annoncerFinSet(Joueur gagnantSet, SetTennis set) {
        annoncer("Set " + gagnantSet + " ! Score du set : " + set.getScoreSet());
    }

    public void annoncerScoreMatch(Match match) {
        annoncer("Score du match : " + match.getScoreMatch());
    }

    /*
     * Gestion simple d'un litige :
     * paramètre aléatoire + réputation approximée via le classement du joueur.
     */
    public boolean trancherLitige(String motif, Joueur joueurAppelant) {
        annoncer("Litige appelé par " + joueurAppelant + " : " + motif);

        Random random = new Random();
        int humeur = random.nextInt(100); // 0..99

        // plus le joueur est bien classé (classement petit), plus il a de chances
        int bonusReputation = Math.max(0, 50 - joueurAppelant.getClassement());

        int scoreDecision = humeur + bonusReputation;

        boolean enFaveur = scoreDecision >= 70;

        if (enFaveur) {
            annoncer("Décision en faveur de " + joueurAppelant + ".");
        } else {
            annoncer("Décision défavorable à " + joueurAppelant + ".");
        }

        return enFaveur;
    }
}
