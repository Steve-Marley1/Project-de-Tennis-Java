/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.arbitre;

/**
 *
 * @author steve
 */

import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

import tennis.model.personne.Genre;
import tennis.model.personne.Personne;

/**
 * Représente un arbitre de tennis.
 * Un arbitre peut annoncer les scores, gérer les litiges
 * et possède une réputation influençant certaines décisions.
 */
public class Arbitre extends Personne {

    private final boolean aMicro;
    private double reputation; // compris entre 0.0 et 1.0

    /**
     * Constructeur d'un arbitre.
     *
     * @param nomNaissance nom de naissance
     * @param nomCourant nom courant
     * @param prenom prénom
     * @param surnom surnom éventuel
     * @param dateNaissance date de naissance
     * @param lieuNaissance lieu de naissance
     * @param nationalite nationalité
     * @param taille taille en cm
     * @param poids poids en kg
     * @param reputation réputation entre 0.0 et 1.0
     */
    public Arbitre(String nomNaissance,
                   String nomCourant,
                   String prenom,
                   String surnom,
                   LocalDate dateNaissance,
                   String lieuNaissance,
                   String nationalite,
                   int taille,
                   double poids,
                   double reputation) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite,
              taille, poids, Genre.HOMME);

        try {
            if (reputation < 0.0 || reputation > 1.0) {
                throw new IllegalArgumentException("La réputation doit être comprise entre 0.0 et 1.0.");
            }
            this.reputation = reputation;
            this.aMicro = true;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public double getReputation() {
        return reputation;
    }

    public void setReputation(double reputation) {
        try {
            if (reputation < 0.0 || reputation > 1.0) {
                throw new IllegalArgumentException("La réputation doit être comprise entre 0.0 et 1.0.");
            }
            this.reputation = reputation;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public boolean hasaMicro() {
        return aMicro;
    }

    public void annoncer(String message) {
        System.out.println((aMicro ? "Arbitre (micro) : " : "Arbitre : ") + message);
    }

    public void annoncerScoreJeu(String prenomServeur,
                                 int pointsServeur,
                                 String prenomReceveur,
                                 int pointsReceveur) {
        String scoreServeur = convertirPoints(pointsServeur);
        String scoreReceveur = convertirPoints(pointsReceveur);
        annoncer("Score du jeu : " + prenomServeur + " " + scoreServeur
                + " / " + prenomReceveur + " " + scoreReceveur);
    }

    public void annoncerFinJeu(String prenomGagnantJeu,
                               int jeuxJoueur1,
                               int jeuxJoueur2) {
        annoncer("Jeu remporté par " + prenomGagnantJeu
                + ". Score du set : " + jeuxJoueur1 + " - " + jeuxJoueur2 + ".");
    }

    public void annoncerFinSet(String prenomGagnantSet,
                               int jeuxJoueur1,
                               int jeuxJoueur2) {
        annoncer("Set remporté par " + prenomGagnantSet
                + ". Score du match : " + jeuxJoueur1 + " sets à " + jeuxJoueur2 + ".");
    }

    public void annoncerFinMatch(String prenomGagnantMatch,
                                 int setsJoueur1,
                                 int setsJoueur2) {
        annoncer("Victoire de " + prenomGagnantMatch
                + " sur le score final de " + setsJoueur1 + " sets à " + setsJoueur2 + ".");
    }

    /**
     * Simule une gestion de litige influencée par :
     * - l’humeur aléatoire de l’arbitre
     * - la "réputation" ou classement du joueur
     * - la réputation de l’arbitre
     *
     * @param classementJoueur valeur positive (ex : classement ATP)
     * @return true si la décision va en faveur du joueur, false sinon
     */
    public boolean trancherLitige(int classementJoueur) {
        try {
            if (classementJoueur < 0) {
                throw new IllegalArgumentException("Le classement du joueur doit être positif ou nul.");
            }

            double humeur = ThreadLocalRandom.current().nextDouble(); // 0.0 → 1.0
            double reputationJoueur = 1.0 / (classementJoueur + 1.0);

            double scoreDecision = 0.4 * humeur
                                 + 0.4 * reputationJoueur
                                 + 0.2 * reputation;

            boolean decisionPourJoueur = scoreDecision >= 0.5;

            if (decisionPourJoueur) {
                annoncer("Décision en faveur du joueur (classement " + classementJoueur + ").");
            } else {
                annoncer("Décision défavorable au joueur (classement " + classementJoueur + ").");
            }

            return decisionPourJoueur;

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private String convertirPoints(int p) {
        switch (p) {
            case 0:  return "0";
            case 1:  return "15";
            case 2:  return "30";
            case 3:  return "40";
            default: return "40";
        }
    }

    @Override
    public String toString() {
        return "Arbitre : " + super.toString()
                + " | Réputation : " + reputation;
    }
}
