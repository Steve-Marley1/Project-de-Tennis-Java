package tennis.model;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author steve
 */

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SetTennis {

    private final Joueur joueur1;
    private final Joueur joueur2;

    private int jeuxJoueur1;
    private int jeuxJoueur2;

    private final List<Jeu> jeux; 
    private boolean termine;
    private Joueur gagnant;
    
    /*
     -Joueur qui sert au début du Set.
     - Le service alterne à chaque Jeu.
     */
    private Joueur serveurCourant;
    
    public SetTennis(Joueur joueur1, Joueur joueur2, Joueur serveurInitial) {
        if (joueur1 == null || joueur2 == null) {
            throw new IllegalArgumentException("Les joueurs du Set ne peuvent pas être nuls.");
        }
        if (serveurInitial == null) {
            throw new IllegalArgumentException("Le serveur initial ne peut pas être nul.");
        }
        if (serveurInitial != joueur1 && serveurInitial != joueur2) {
            throw new IllegalArgumentException("Le serveur initial doit être l'un des deux joueurs du Set.");
        }

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.serveurCourant = serveurInitial;

        this.jeuxJoueur1 = 0;
        this.jeuxJoueur2 = 0;
        this.termine = false;
        this.gagnant = null;

        this.jeux = new LinkedList<>();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
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

    public List<Jeu> getJeux() {
        return jeux;
    }

    public Joueur getServeurCourant() {
        return serveurCourant;
    }

    public Joueur jouerSet(Scanner scanner, Arbitre arbitre) {
        if (scanner == null) {
            throw new IllegalArgumentException("Le scanner ne doit pas être nul.");
        }
        if (arbitre == null) {
            throw new IllegalArgumentException("L'arbitre ne doit pas être nul.");
        }

        System.out.println();
        System.out.println("=== Nouveau Set ===");
        System.out.println("Joueur 1 : " + joueur1.getPrenom());
        System.out.println("Joueur 2 : " + joueur2.getPrenom());
        System.out.println("Serveur initial : " + serveurCourant.getPrenom());

        while (!termine) {
            Joueur receveur = (serveurCourant == joueur1) ? joueur2 : joueur1;

            Jeu jeu = new Jeu(serveurCourant, receveur);
            Joueur gagnantJeu = jeu.jouerJeu(scanner, arbitre);

            jeux.add(jeu);

            if (gagnantJeu == joueur1) {
                jeuxJoueur1++;
            } else if (gagnantJeu == joueur2) {
                jeuxJoueur2++;
            } else {
                throw new IllegalStateException("Gagnant du Jeu inconnu.");
            }

            arbitre.annoncerFinJeu(gagnantJeu, jeuxJoueur1, jeuxJoueur2);

            verifierFinSet(arbitre);

            serveurCourant = receveur;
        }

        return gagnant;
    }

    private void verifierFinSet(Arbitre arbitre) {
        if (jeuxJoueur1 >= 6 || jeuxJoueur2 >= 6) {
            int ecart = Math.abs(jeuxJoueur1 - jeuxJoueur2);
            if (ecart >= 2 || jeuxJoueur1 == 7 || jeuxJoueur2 == 7) {
                termine = true;
                gagnant = (jeuxJoueur1 > jeuxJoueur2) ? joueur1 : joueur2;
                arbitre.annoncerFinSet(gagnant, jeuxJoueur1, jeuxJoueur2);
            }
        }
    }

    @Override
    public String toString() {
        return "Set : " + joueur1.getPrenom() + " " + jeuxJoueur1
                + " / " + joueur2.getPrenom() + " " + jeuxJoueur2
                + " | Terminé=" + termine;
    }
}
