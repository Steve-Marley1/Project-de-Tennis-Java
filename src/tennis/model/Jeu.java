/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model;

/**
 *
 * @author steve
 */
import java.util.Scanner;

public class Jeu {

    private Joueur serveur;
    private Joueur receveur;

    private int pointsServeur;
    private int pointsReceveur;

    private boolean termine;
    private Joueur gagnant;

    public Jeu(Joueur serveur, Joueur receveur) {
        this.serveur = serveur;
        this.receveur = receveur;
        this.pointsServeur = 0;
        this.pointsReceveur = 0;
        this.termine = false;
        this.gagnant = null;
    }

    public Joueur getServeur() {
        return serveur;
    }

    public Joueur getReceveur() {
        return receveur;
    }

    public boolean isTermine() {
        return termine;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    public String getScoreTexte() {
        return scoreTexte(pointsServeur, pointsReceveur);
    }

    private String scoreTexte(int pS, int pR) {
        // gestion du cas avantage/égalité
        if (pS >= 3 && pR >= 3) {
            if (pS == pR) {
                return "40 - 40";
            } else if (pS == pR + 1) {
                return "AV " + serveur;
            } else if (pR == pS + 1) {
                return "AV " + receveur;
            }
        }
        return convertirPoint(pS) + " - " + convertirPoint(pR);
    }

    private String convertirPoint(int p) {
        switch (p) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "40"; // en pratique on ne devrait pas venir ici hors avantage
        }
    }

    public Joueur jouerJeu(Scanner scanner, ArbitreCentral arbitre) {
        while (!termine) {
            Echange echange = new Echange(serveur, receveur);
            Joueur gagnantPoint = echange.jouerEchange(scanner);

            if (gagnantPoint == serveur) {
                pointsServeur++;
            } else {
                pointsReceveur++;
            }

            // Vérifier si le jeu est gagné
            if (pointsServeur >= 4 || pointsReceveur >= 4) {
                int diff = Math.abs(pointsServeur - pointsReceveur);
                if (diff >= 2) {
                    termine = true;
                    gagnant = (pointsServeur > pointsReceveur) ? serveur : receveur;
                }
            }

            // L'arbitre annonce le score du jeu à la fin de l'échange
            arbitre.annoncerScoreJeu(this);
        }

        return gagnant;
    }
}