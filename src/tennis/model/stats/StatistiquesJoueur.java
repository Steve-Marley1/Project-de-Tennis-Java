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
 * Représente les statistiques globales d'un joueur de tennis
 * sur sa carrière et sur la saison en cours.
 */
public class StatistiquesJoueur {

    /** Nombre total de matchs joués en carrière. */
    private int matchsJouesCarriere;

    /** Nombre total de matchs remportés en carrière. */
    private int matchsGagnesCarriere;

    /** Nombre de tournois auxquels le joueur a participé. */
    private int tournoisJoues;

    /** Montant total des gains en carrière. */
    private double gainsCarriere;

    /** Montant total des gains sur la saison en cours. */
    private double gainsSaison;

    /**
     * Construit un objet StatistiquesJoueur initialisé à zéro.
     */
    public StatistiquesJoueur() {
        this.matchsJouesCarriere = 0;
        this.matchsGagnesCarriere = 0;
        this.tournoisJoues = 0;
        this.gainsCarriere = 0.0;
        this.gainsSaison = 0.0;
    }

    /**
     * Construit un objet StatistiquesJoueur avec des valeurs initiales.
     *
     * @param matchsJouesCarriere nombre de matchs joués en carrière (>= 0)
     * @param matchsGagnesCarriere nombre de matchs gagnés en carrière (>= 0)
     * @param tournoisJoues nombre de tournois joués (>= 0)
     * @param gainsCarriere gains de carrière (>= 0.0)
     * @param gainsSaison gains de la saison (>= 0.0)
     */
    public StatistiquesJoueur(int matchsJouesCarriere,
                              int matchsGagnesCarriere,
                              int tournoisJoues,
                              double gainsCarriere,
                              double gainsSaison) {

        if (matchsJouesCarriere < 0 || matchsGagnesCarriere < 0 ||
            tournoisJoues < 0 || gainsCarriere < 0.0 || gainsSaison < 0.0) {
            throw new IllegalArgumentException("Les statistiques ne peuvent pas être négatives.");
        }

        if (matchsGagnesCarriere > matchsJouesCarriere) {
            throw new IllegalArgumentException("Les matchs gagnés ne peuvent pas dépasser les matchs joués.");
        }

        this.matchsJouesCarriere = matchsJouesCarriere;
        this.matchsGagnesCarriere = matchsGagnesCarriere;
        this.tournoisJoues = tournoisJoues;
        this.gainsCarriere = gainsCarriere;
        this.gainsSaison = gainsSaison;
    }

    public int getMatchsJouesCarriere() {
        return matchsJouesCarriere;
    }

    public int getMatchsGagnesCarriere() {
        return matchsGagnesCarriere;
    }

    public int getTournoisJoues() {
        return tournoisJoues;
    }

    public double getGainsCarriere() {
        return gainsCarriere;
    }

    public double getGainsSaison() {
        return gainsSaison;
    }

    /**
     * Enregistre un match joué.
     *
     * @param gagne true si le joueur a gagné le match
     */
    public void enregistrerMatch(boolean gagne) {
        this.matchsJouesCarriere++;
        if (gagne) {
            this.matchsGagnesCarriere++;
        }
    }

    /**
     * Enregistre la participation à un tournoi.
     */
    public void enregistrerParticipationTournoi() {
        this.tournoisJoues++;
    }

    /**
     * Ajoute un montant aux gains.
     *
     * @param montant montant positif ou nul
     */
    public void ajouterGains(double montant) {
        if (montant < 0.0) {
            throw new IllegalArgumentException("Les gains doivent être positifs ou nuls.");
        }

        this.gainsCarriere += montant;
        this.gainsSaison += montant;
    }

    /**
     * Réinitialise les gains de la saison (début nouvelle saison).
     */
    public void reinitialiserGainsSaison() {
        this.gainsSaison = 0.0;
    }

    @Override
    public String toString() {
        return "Statistiques Joueur : " +
                "Matchs joués = " + matchsJouesCarriere +
                ", Matchs gagnés = " + matchsGagnesCarriere +
                ", Tournois joués = " + tournoisJoues +
                ", Gains carrière = " + gainsCarriere +
                ", Gains saison = " + gainsSaison;
    }
}