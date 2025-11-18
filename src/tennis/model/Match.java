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
import java.util.concurrent.ThreadLocalRandom;

public class Match {

    private final Joueur joueur1;
    private final Joueur joueur2;
    private final Arbitre arbitre;
    private final CategorieMatch categorie;
    private final NiveauMatch niveau;

    private final int nbSetsPourGagner;

    private final List<SetTennis> sets;
    private int setsJoueur1;
    private int setsJoueur2;

    private boolean termine;
    private Joueur vainqueur;

    public Match(Joueur joueur1,
                 Joueur joueur2,
                 Arbitre arbitre,
                 CategorieMatch categorie,
                 NiveauMatch niveau) {

        if (joueur1 == null || joueur2 == null) {
            throw new IllegalArgumentException("Les joueurs du match ne peuvent pas être nuls.");
        }
        if (arbitre == null) {
            throw new IllegalArgumentException("L'arbitre ne peut pas être nul.");
        }
        if (categorie == null) {
            throw new IllegalArgumentException("La catégorie ne peut pas être nulle.");
        }
        if (niveau == null) {
            throw new IllegalArgumentException("Le niveau ne peut pas être nul.");
        }

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.arbitre = arbitre;
        this.categorie = categorie;
        this.niveau = niveau;

        if (categorie == CategorieMatch.SIMPLE_HOMME) {
            this.nbSetsPourGagner = 3;
        } else {
            this.nbSetsPourGagner = 2;
        }

        this.sets = new ArrayList<>();
        this.setsJoueur1 = 0;
        this.setsJoueur2 = 0;
        this.termine = false;
        this.vainqueur = null;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public Arbitre getArbitre() {
        return arbitre;
    }

    public CategorieMatch getCategorie() {
        return categorie;
    }

    public NiveauMatch getNiveau() {
        return niveau;
    }

    public int getNbSetsPourGagner() {
        return nbSetsPourGagner;
    }

    public int getSetsJoueur1() {
        return setsJoueur1;
    }

    public int getSetsJoueur2() {
        return setsJoueur2;
    }

    public boolean isTermine() {
        return termine;
    }

    public Joueur getVainqueur() {
        return vainqueur;
    }

    public List<SetTennis> getSets() {
        return sets;
    }

    public Joueur demarrerMatch(Scanner scanner) {
        if (scanner == null) {
            throw new IllegalArgumentException("Le scanner ne doit pas être nul.");
        }

        System.out.println("=== Nouveau Match ===");
        System.out.println("Joueur 1 : " + joueur1.getPrenom());
        System.out.println("Joueur 2 : " + joueur2.getPrenom());
        System.out.println("Catégorie : " + categorie);
        System.out.println("Niveau : " + niveau);
        System.out.println("Nombre de sets à gagner : " + nbSetsPourGagner);

        Joueur serveurInitial = ThreadLocalRandom.current().nextBoolean() ? joueur1 : joueur2;
        arbitre.annoncer("Tirage au sort : " + serveurInitial.getPrenom() + " servira au premier set.");

        Joueur serveurCourant = serveurInitial;

        while (setsJoueur1 < nbSetsPourGagner && setsJoueur2 < nbSetsPourGagner) {
            SetTennis set = new SetTennis(joueur1, joueur2, serveurCourant);
            Joueur gagnantSet = set.jouerSet(scanner, arbitre);
            sets.add(set);

            if (gagnantSet == joueur1) {
                setsJoueur1++;
            } else if (gagnantSet == joueur2) {
                setsJoueur2++;
            } else {
                throw new IllegalStateException("Gagnant du set inconnu.");
            }

            arbitre.annoncerFinSet(gagnantSet, setsJoueur1, setsJoueur2);

            serveurCourant = (serveurCourant == joueur1) ? joueur2 : joueur1;
        }

        termine = true;
        vainqueur = (setsJoueur1 > setsJoueur2) ? joueur1 : joueur2;

        arbitre.annoncerFinMatch(vainqueur, setsJoueur1, setsJoueur2);
        vainqueur.crierVictoire();
        Joueur perdant = (vainqueur == joueur1) ? joueur2 : joueur1;
        perdant.crierDefaite();

        return vainqueur;
    }

    @Override
    public String toString() {
        return "Match : " + joueur1.getPrenom() + " vs " + joueur2.getPrenom()
                + " | Sets : " + setsJoueur1 + " - " + setsJoueur2
                + " | Terminé=" + termine;
    }
}
