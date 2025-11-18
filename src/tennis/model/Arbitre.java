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
import java.util.concurrent.ThreadLocalRandom;

public class Arbitre extends Personne {

    /* Indique si l'arbitre dispose d'un micro (toujours vrai ici). */
    private final boolean aMicro;
    
    //Niveau de réputation de l'arbitre lui-même, compris entre 0.0 et 1.0.
    private double reputationArbitre;
    
    public Arbitre(String nomNaissance,
                   String nomCourant,
                   String prenom,
                   String surnom,
                   LocalDate dateNaissance,
                   String lieuNaissance,
                   String nationalite,
                   int taille,
                   double poids,
                   double reputationArbitre) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids, Genre.HOMME);

        if (reputationArbitre < 0.0 || reputationArbitre > 1.0) {
            throw new IllegalArgumentException("La réputation de l'arbitre doit être comprise entre 0.0 et 1.0.");
        }

        this.aMicro = true;
        this.reputationArbitre = reputationArbitre;
    }

    public boolean isaMicro() {
        return aMicro;
    }

    public double getReputationArbitre() {
        return reputationArbitre;
    }

    public void setReputationArbitre(double reputationArbitre) {
        if (reputationArbitre < 0.0 || reputationArbitre > 1.0) {
            throw new IllegalArgumentException("La réputation de l'arbitre doit être comprise entre 0.0 et 1.0.");
        }
        this.reputationArbitre = reputationArbitre;
    }
        
    public void annoncer(String message){
        if (!aMicro) {
            System.out.println("L'arbitre (sans micro) : " + message);
        } else {
            System.out.println("Arbitre (au micro) : " + message);
        }
    }
    
    public void annoncerScoreJeu(Joueur serveur,
                                 Joueur receveur,
                                 int pointsServeur,
                                 int pointsReceveur) {

        String scoreServeur = convertirScore(pointsServeur, pointsReceveur);
        String scoreReceveur = convertirScore(pointsReceveur, pointsServeur);

        annoncer("Score du Jeu : " + serveur.getPrenom() + " " + scoreServeur
                + " / " + receveur.getPrenom() + " " + scoreReceveur);
    }
    
    private String convertirScore(int pointsJoueur, int pointsAdversaire) {
        if (pointsJoueur >= 3 && pointsAdversaire >= 3) {
            if (pointsJoueur == pointsAdversaire) {
                return "40";
            } else if (pointsJoueur == pointsAdversaire + 1) {
                return "AV";
            } else {
                return "40"; // cas théorique au-delà, géré ailleurs
            }
        }

        switch (pointsJoueur) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "40";
        }
    }
              
    public void annoncerFinJeu(Joueur gagnant,
                               int jeuxJoueur1,
                               int jeuxJoueur2) {
        annoncer("Jeu remporté par " + gagnant.getPrenom() + ". Score du Set : "
                + jeuxJoueur1 + " - " + jeuxJoueur2 + ".");
    }   

    public void annoncerFinSet(Joueur gagnant,
                               int setsJoueur1,
                               int setsJoueur2) {
        annoncer("Set remporté par " + gagnant.getPrenom()
                + ". Score du match : " + setsJoueur1 + " sets à " + setsJoueur2 + ".");
    }
    
    public void annoncerFinMatch(Joueur gagnant,
                                 int setsJoueur1,
                                 int setsJoueur2) {
        annoncer("Victoire de " + gagnant.getPrenom()
                + " sur le score final de " + setsJoueur1 + " sets à " + setsJoueur2 + ".");
    }
  
    public boolean trancherLitige(Joueur joueurAppelant, String motif) {
        annoncer("Litige appelé par " + joueurAppelant.getPrenom()
                + " : " + motif);

        // Humeur du juge : paramètre aléatoire entre 0.0 et 1.0
        double humeur = ThreadLocalRandom.current().nextDouble(0.0, 1.0);

        // Réputation du joueur : plus le classement est proche de 1, meilleure est la réputation.
        double reputationJoueur = 1.0 / (joueurAppelant.getClassement() + 1.0);

        // Score global : combinaison humeur / réputation joueur / réputation arbitre
        double scoreDecision = 0.4 * humeur
                             + 0.4 * reputationJoueur
                             + 0.2 * reputationArbitre;

        boolean decisionPourJoueur = scoreDecision >= 0.5;

        if (decisionPourJoueur) {
            annoncer("Décision en faveur de " + joueurAppelant.getPrenom() + ".");
        } else {
            annoncer("Décision défavorable à " + joueurAppelant.getPrenom() + ".");
        }

        return decisionPourJoueur;
    }

    @Override
    public String toString() {
        return "Arbitre : " + super.toString()
               + " | Réputation : " + reputationArbitre;
    }
}
