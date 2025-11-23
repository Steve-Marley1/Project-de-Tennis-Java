/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.stats;

/**
 *
 * @author steve
 */

/**
 * Statistiques personnelles d'un joueur.
 *
 * On distingue :
 * - les statistiques de carrière
 * - les statistiques sur la saison en cours.
 */
public class StatistiquesJoueur {

    /** Matchs joués en carrière. */
    private int matchsJouesCarriere;

    /** Matchs gagnés en carrière. */
    private int matchsGagnesCarriere;

    /** Matchs joués sur la saison actuelle. */
    private int matchsJouesSaison;

    /** Matchs gagnés sur la saison actuelle. */
    private int matchsGagnesSaison;

    /** Nombre de tournois auxquels le joueur a participé (carrière). */
    private int tournoisJoues;

    /** Gains totaux en carrière (en euros). */
    private double gainsTotaux;

    /**
     * Constructeur par défaut.
     * Initialise toutes les statistiques à zéro.
     */
    public StatistiquesJoueur() {
        this.matchsJouesCarriere = 0;
        this.matchsGagnesCarriere = 0;
        this.matchsJouesSaison = 0;
        this.matchsGagnesSaison = 0;
        this.tournoisJoues = 0;
        this.gainsTotaux = 0.0;
    }

    public int getMatchsJouesCarriere() {
        return matchsJouesCarriere;
    }

    public int getMatchsGagnesCarriere() {
        return matchsGagnesCarriere;
    }

    public int getMatchsJouesSaison() {
        return matchsJouesSaison;
    }

    public int getMatchsGagnesSaison() {
        return matchsGagnesSaison;
    }

    public int getTournoisJoues() {
        return tournoisJoues;
    }

    public double getGainsTotaux() {
        return gainsTotaux;
    }

    /**
     * Enregistre un match joué (victoire ou défaite).
     *
     * @param victoire true si le match est remporté, false sinon
     */
    public void enregistrerMatch(boolean victoire) {
        try {
            matchsJouesCarriere++;
            matchsJouesSaison++;

            if (victoire) {
                matchsGagnesCarriere++;
                matchsGagnesSaison++;
            }
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Enregistre la participation à un tournoi.
     */
    public void enregistrerTournoiParticipe() {
        tournoisJoues++;
    }

    /**
     * Ajoute des gains au total de la carrière.
     *
     * @param montant montant à ajouter (>= 0)
     */
    public void ajouterGains(double montant) {
        try {
            if (montant < 0.0) {
                throw new IllegalArgumentException("Le montant des gains doit être positif ou nul.");
            }
            gainsTotaux += montant;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Réinitialise les statistiques de la saison
     * (par exemple au début d'une nouvelle année).
     */
    public void reinitialiserSaison() {
        this.matchsJouesSaison = 0;
        this.matchsGagnesSaison = 0;
    }

    @Override
    public String toString() {
        return "StatistiquesJoueur{" +
                "matchsJouesCarriere=" + matchsJouesCarriere +
                ", matchsGagnesCarriere=" + matchsGagnesCarriere +
                ", matchsJouesSaison=" + matchsJouesSaison +
                ", matchsGagnesSaison=" + matchsGagnesSaison +
                ", tournoisJoues=" + tournoisJoues +
                ", gainsTotaux=" + gainsTotaux +
                '}';
    }
}
