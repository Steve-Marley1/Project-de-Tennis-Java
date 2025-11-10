/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model;

/**
 *
 * @author steve
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SetTennis {

    private Joueur joueur1;
    private Joueur joueur2;

    private int jeuxJoueur1;
    private int jeuxJoueur2;

    private List<Jeu> jeux;

    private boolean termine;
    private Joueur gagnant;

    public SetTennis(Joueur joueur1, Joueur joueur2) {
        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.jeuxJoueur1 = 0;
        this.jeuxJoueur2 = 0;
        this.jeux = new ArrayList<>();
        this.termine = false;
        this.gagnant = null;
    }

    public int getJeuxJoueur1() {
        return jeuxJoueur1;
    }

    public int getJeuxJoueur2() {
        return jeuxJoueur2;
    }

    public boolean isTermine() {
        return termine;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    public String getScoreSet() {
        return jeuxJoueur1 + " - " + jeuxJoueur2;
    }

    public Joueur jouerSet(Scanner scanner, ArbitreCentral arbitre, Joueur serveurInitial) {
        Joueur serveur = serveurInitial;
        Joueur receveur = (serveur == joueur1) ? joueur2 : joueur1;

        while (!termine) {
            Jeu jeu = new Jeu(serveur, receveur);
            jeux.add(jeu);

            Joueur gagnantJeu = jeu.jouerJeu(scanner, arbitre);
            if (gagnantJeu == joueur1) {
                jeuxJoueur1++;
            } else {
                jeuxJoueur2++;
            }

            // Arbitre annonce fin de jeu + score du set
            arbitre.annoncerFinJeu(gagnantJeu, this);

            // Vérifier si le set est gagné (sans tie-break ici)
            if ((jeuxJoueur1 >= 6 || jeuxJoueur2 >= 6)
                    && Math.abs(jeuxJoueur1 - jeuxJoueur2) >= 2) {
                termine = true;
                gagnant = (jeuxJoueur1 > jeuxJoueur2) ? joueur1 : joueur2;
                arbitre.annoncerFinSet(gagnant, this);
            }

            // inversion serveur/receveur pour le jeu suivant
            Joueur tmp = serveur;
            serveur = receveur;
            receveur = tmp;
        }

        return gagnant;
    }
}

