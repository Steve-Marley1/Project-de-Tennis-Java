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

    
    private final Joueur serveur;
    private final Joueur receveur;
    private int pointsServeur;
    private int pointsReceveur;
    private boolean termine;
    private Joueur gagnant;

    
        public Jeu(Joueur serveur, Joueur receveur) {
        if (serveur == null || receveur == null) {
            throw new IllegalArgumentException("Les joueurs du Jeu ne peuvent pas être nuls.");
        }
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

    public int getPointsServeur() {
        return pointsServeur;
    }

    public int getPointsReceveur() {
        return pointsReceveur;
    }

    public boolean isTermine() {
        return termine;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

        public Joueur jouerJeu(Scanner scanner, Arbitre arbitre) {
        if (scanner == null) {
            throw new IllegalArgumentException("Le scanner ne doit pas être nul.");
        }
        if (arbitre == null) {
            throw new IllegalArgumentException("L'arbitre ne doit pas être nul.");
        }

        System.out.println();
        System.out.println("=== Nouveau Jeu ===");
        System.out.println("Serveur : " + serveur.getPrenom()
                + " | Receveur : " + receveur.getPrenom());

        while (!termine) {
            // On joue un échange
            Echange echange = new Echange(serveur, receveur);
            Joueur gagnantPoint = echange.jouerEchange(scanner, arbitre);

            if (gagnantPoint == serveur) {
                pointsServeur++;
            } else if (gagnantPoint == receveur) {
                pointsReceveur++;
            } else {
                throw new IllegalStateException("Gagnant de l'échange inconnu.");
            }

            // L'arbitre annonce le score du Jeu
            arbitre.annoncerScoreJeu(serveur, receveur, pointsServeur, pointsReceveur);

            // Vérifier si le Jeu est gagné
            verifierFinJeu(arbitre);
        }

        return gagnant;
    }
            private void verifierFinJeu(Arbitre arbitre) {
        if (pointsServeur >= 4 || pointsReceveur >= 4) {
            int ecart = Math.abs(pointsServeur - pointsReceveur);
            if (ecart >= 2) {
                termine = true;
                gagnant = (pointsServeur > pointsReceveur) ? serveur : receveur;
                arbitre.annoncer("Jeu " + gagnant.getPrenom() + ".");
            }
        }
    }

    @Override
    public String toString() {
        return "Jeu : Serveur=" + serveur.getPrenom()
                + ", Receveur=" + receveur.getPrenom()
                + ", Points Serveur=" + pointsServeur
                + ", Points Receveur=" + pointsReceveur
                + ", Terminé=" + termine;
    }
}