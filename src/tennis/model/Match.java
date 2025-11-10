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
import java.util.Random;
import java.util.Scanner;

public class Match {

    private Joueur joueur1;
    private Joueur joueur2;
    private ArbitreCentral arbitre;

    private CategorieMatch categorie;
    private NiveauMatch niveau;
    private int nbSetsGagnants; // 2 ou 3

    private List<SetTennis> sets;

    private int setsJoueur1;
    private int setsJoueur2;

    private Joueur vainqueur;
    private Joueur perdant;

    public Match(Joueur joueur1,
                 Joueur joueur2,
                 ArbitreCentral arbitre,
                 CategorieMatch categorie,
                 NiveauMatch niveau,
                 int nbSetsGagnants) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.arbitre = arbitre;
        this.categorie = categorie;
        this.niveau = niveau;
        this.nbSetsGagnants = nbSetsGagnants;
        this.sets = new ArrayList<>();
        this.setsJoueur1 = 0;
        this.setsJoueur2 = 0;
    }

    public Joueur getVainqueur() {
        return vainqueur;
    }

    public Joueur getPerdant() {
        return perdant;
    }

    public String getScoreMatch() {
        return setsJoueur1 + " sets à " + setsJoueur2;
    }

    private Joueur tirageServeurInitial() {
        Random random = new Random();
        return random.nextBoolean() ? joueur1 : joueur2;
    }

    /**
     * Méthode principale pour démarrer le match et gérer son déroulement.
     * Utilise le clavier (Scanner) pour les Echanges.
     */
    public void demarrerMatch() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Début du match ===");
        System.out.println("Catégorie : " + categorie + ", Niveau : " + niveau);
        System.out.println("Joueur 1 : " + joueur1);
        System.out.println("Joueur 2 : " + joueur2);

        Joueur serveurInitial = tirageServeurInitial();
        System.out.println("Le tirage au sort désigne " + serveurInitial + " au service pour le premier jeu.");

        Joueur serveurSet = serveurInitial;

        while (setsJoueur1 < nbSetsGagnants && setsJoueur2 < nbSetsGagnants) {

            SetTennis set = new SetTennis(joueur1, joueur2);
            sets.add(set);

            Joueur gagnantSet = set.jouerSet(scanner, arbitre, serveurSet);

            if (gagnantSet == joueur1) {
                setsJoueur1++;
            } else {
                setsJoueur2++;
            }

            // Score actuel du match
            arbitre.annoncerScoreMatch(this);

            // Le serveur du prochain set : on peut garder le même ou alterner.
            // Ici, on garde le même pour rester simple.
        }

        if (setsJoueur1 > setsJoueur2) {
            vainqueur = joueur1;
            perdant = joueur2;
        } else {
            vainqueur = joueur2;
            perdant = joueur1;
        }

        vainqueur.crierVictoire();
        perdant.crierDefaite();

        System.out.println("Match terminé. Vainqueur : " + vainqueur
                + " sur le score de " + getScoreMatch());
    }
}
