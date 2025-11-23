/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.match;

/**
 *
 * @author steve
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

import tennis.model.arbitre.Arbitre;
import tennis.model.joueur.Joueur;
import tennis.model.personne.Genre;
import tennis.model.stats.StatistiquesMatch;

/**
 * Représente un match de tennis entre deux joueurs.
 * Gère la catégorie, le niveau, la liste des sets joués,
 * le score global en sets et les statistiques de match.
 */
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

    private final StatistiquesMatch statsJoueur1;
    private final StatistiquesMatch statsJoueur2;

    /**
     * Crée un match entre deux joueurs.
     *
     * @param joueur1   premier joueur
     * @param joueur2   second joueur
     * @param arbitre   arbitre en charge du match
     * @param categorie catégorie (SIMPLE_HOMME / SIMPLE_FEMME)
     * @param niveau    niveau du match (tournoi)
     * @throws IllegalArgumentException si un paramètre est invalide
     */
    public Match(Joueur joueur1,
                 Joueur joueur2,
                 Arbitre arbitre,
                 CategorieMatch categorie,
                 NiveauMatch niveau) {

        try {
            if (joueur1 == null || joueur2 == null) {
                throw new IllegalArgumentException("Les joueurs du match ne peuvent pas être nuls.");
            }
            if (joueur1 == joueur2) {
                throw new IllegalArgumentException("Un match doit opposer deux joueurs différents.");
            }
            if (arbitre == null) {
                throw new IllegalArgumentException("L'arbitre du match ne peut pas être nul.");
            }
            if (categorie == null) {
                throw new IllegalArgumentException("La catégorie du match est obligatoire.");
            }
            if (niveau == null) {
                throw new IllegalArgumentException("Le niveau du match est obligatoire.");
            }

            int nbSets;
            switch (categorie) {
                case SIMPLE_HOMME -> {
                    if (joueur1.getGenre() != Genre.HOMME || joueur2.getGenre() != Genre.HOMME) {
                        throw new IllegalArgumentException(
                                "Un match homme doit opposer deux joueurs hommes (pas mélange homme/femme).");
                    }
                    nbSets = 3;
                }

                case SIMPLE_FEMME -> {
                    if (joueur1.getGenre() != Genre.FEMME || joueur2.getGenre() != Genre.FEMME) {
                        throw new IllegalArgumentException(
                                "Un match femme doit opposer deux joueuses femmes (pas mélange homme/femme).");
                    }
                    nbSets = 2;
                }

                default -> throw new IllegalArgumentException("Catégorie de match inconnue.");
            }

            this.joueur1 = joueur1;
            this.joueur2 = joueur2;
            this.arbitre = arbitre;
            this.categorie = categorie;
            this.niveau = niveau;
            this.nbSetsPourGagner = nbSets;

            this.sets = new ArrayList<>();
            this.setsJoueur1 = 0;
            this.setsJoueur2 = 0;
            this.termine = false;
            this.vainqueur = null;

            this.statsJoueur1 = new StatistiquesMatch();
            this.statsJoueur2 = new StatistiquesMatch();

        } catch (IllegalArgumentException e) {
            throw e;
        }
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

    public List<SetTennis> getSets() {
        return sets;
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

    /**
     * Statistiques du joueur 1 pour ce match.
     *
     * @return statistiques du joueur 1
     */
    public StatistiquesMatch getStatistiquesJoueur1() {
        return statsJoueur1;
    }

    /**
     * Statistiques du joueur 2 pour ce match.
     *
     * @return statistiques du joueur 2
     */
    public StatistiquesMatch getStatistiquesJoueur2() {
        return statsJoueur2;
    }

    /**
     * Ajoute un set terminé au match et met à jour le score en sets
     * et les statistiques de match (sets et jeux joués).
     *
     * @param set set terminé à ajouter
     * @throws IllegalArgumentException si le set est invalide ou ne correspond pas aux joueurs du match
     */
    public void ajouterSetTermine(SetTennis set) {

        try {
            if (set == null) {
                throw new IllegalArgumentException("Le set ajouté ne peut pas être null.");
            }
            if (!set.isTermine()) {
                throw new IllegalArgumentException("Le set doit être terminé pour être ajouté au match.");
            }
            if (termine) {
                throw new IllegalArgumentException("Le match est déjà terminé, impossible d'ajouter un nouveau set.");
            }
            if (set.getJoueur1() != joueur1 || set.getJoueur2() != joueur2) {
                throw new IllegalArgumentException("Les joueurs du set doivent être les mêmes que ceux du match.");
            }

            sets.add(set);

            Joueur gagnantSet = set.getGagnant();
            if (gagnantSet == null) {
                throw new IllegalArgumentException("Le set doit avoir un gagnant.");
            }

            if (gagnantSet == joueur1) {
                setsJoueur1++;
            } else if (gagnantSet == joueur2) {
                setsJoueur2++;
            } else {
                throw new IllegalArgumentException("Le gagnant du set n'est pas un joueur du match.");
            }

            int jeuxJ1 = set.getJeuxJoueur1();
            int jeuxJ2 = set.getJeuxJoueur2();

            statsJoueur1.enregistrerSetJoue();
            statsJoueur2.enregistrerSetJoue();
            statsJoueur1.ajouterJeuxJoues(jeuxJ1);
            statsJoueur2.ajouterJeuxJoues(jeuxJ2);

            if (setsJoueur1 >= nbSetsPourGagner || setsJoueur2 >= nbSetsPourGagner) {
                terminerMatch(jeuxJ1, jeuxJ2);
            }

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Termine le match, détermine le vainqueur,
     * met à jour les statistiques globales des joueurs
     * et demande à l'arbitre d'annoncer le résultat.
     *
     * @param derniersJeuxJ1 nombre de jeux gagnés par le joueur 1 dans le dernier set
     * @param derniersJeuxJ2 nombre de jeux gagnés par le joueur 2 dans le dernier set
     */
    private void terminerMatch(int derniersJeuxJ1, int derniersJeuxJ2) {

        try {
            if (termine) {
                return;
            }

            this.termine = true;

            if (setsJoueur1 > setsJoueur2) {
                this.vainqueur = joueur1;
                joueur1.enregistrerVictoireMatch(1, derniersJeuxJ1);
                joueur2.enregistrerDefaiteMatch(0, derniersJeuxJ2);
            } else {
                this.vainqueur = joueur2;
                joueur2.enregistrerVictoireMatch(1, derniersJeuxJ2);
                joueur1.enregistrerDefaiteMatch(0, derniersJeuxJ1);
            }

            arbitre.annoncerFinMatch(
                    vainqueur.getPrenom(),
                    setsJoueur1,
                    setsJoueur2
            );

            vainqueur.crierVictoire();
            Joueur perdant = (vainqueur == joueur1) ? joueur2 : joueur1;
            perdant.crierDefaite();

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Démarre le match selon le mode choisi.
     *
     * @param mode mode de déroulement (manuel, automatique silencieux ou détaillé)
     * @throws IllegalArgumentException si le mode est null ou si le match est déjà terminé
     */
    public void demarrerMatch(ModeMatch mode) {

        try {
            if (mode == null) {
                throw new IllegalArgumentException("Le mode du match ne peut pas être null.");
            }
            if (termine) {
                throw new IllegalArgumentException("Ce match est déjà terminé.");
            }

            switch (mode) {

                case MANUEL:
                    jouerMatchManuel();
                    break;

                case AUTO_SILENCE:
                    jouerMatchAutomatique(false);
                    break;

                case AUTO_AVEC_DETAILS:
                    jouerMatchAutomatique(true);
                    break;

                default:
                    throw new IllegalArgumentException("Mode inconnu.");
            }

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Déroulement manuel du match.
     * L'utilisateur saisit le déroulement du set avec le clavier,
     * via la méthode jouerSet de SetTennis.
     */
    private void jouerMatchManuel() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Début du match MANUEL ===");
        System.out.println("Match : " + joueur1.getPrenom() + " vs " + joueur2.getPrenom());

        while (!termine) {
            try {
                System.out.println("Appuyez sur Entrée pour jouer un nouveau set...");
                scanner.nextLine();

                SetTennis set = new SetTennis(joueur1, joueur2, joueur1);
                Joueur gagnantSet = set.jouerSet(scanner, arbitre);

                System.out.println("Set remporté par : " + gagnantSet.getPrenom());

                ajouterSetTermine(set);

            } catch (Exception ex) {
                System.out.println("Erreur lors du déroulement manuel du match : " + ex.getMessage());
            }
        }

        System.out.println("=== Fin du match ===");
    }

    /**
     * Déroulement automatique du match.
     *
     * @param avecDetails vrai pour afficher le déroulement, faux pour un mode silencieux
     */
    private void jouerMatchAutomatique(boolean avecDetails) {

        Random random = new Random();

        if (avecDetails) {
            System.out.println("=== Début du match AUTOMATIQUE ===");
            System.out.println("Match : " + joueur1.getPrenom() + " vs " + joueur2.getPrenom());
        }

        while (!termine) {
            try {
                Joueur serveurInit = random.nextBoolean() ? joueur1 : joueur2;

                SetTennis set = new SetTennis(joueur1, joueur2, serveurInit);

                if (avecDetails) {
                    System.out.println("Nouveau set. Serveur initial : " + serveurInit.getPrenom());
                }

                // En mode automatique, on ne dépend pas réellement de la saisie clavier.
                // On passe un Scanner "vide" uniquement pour respecter la signature.
                Scanner scannerVide = new Scanner("");
                Joueur gagnantSet = set.jouerSet(scannerVide, arbitre);

                if (avecDetails) {
                    System.out.println("Set remporté par : " + gagnantSet.getPrenom());
                }

                ajouterSetTermine(set);

            } catch (Exception ex) {
                System.out.println("Erreur lors du déroulement automatique du match : " + ex.getMessage());
                break;
            }
        }

        if (avecDetails) {
            System.out.println("=== Fin du match AUTOMATIQUE ===");
        }
    }

    @Override
    public String toString() {
        return "Match : " + joueur1.getPrenom() + " vs " + joueur2.getPrenom()
                + " | Catégorie : " + categorie
                + " | Niveau : " + niveau
                + " | Score en sets : " + setsJoueur1 + " - " + setsJoueur2
                + (termine ? " | Vainqueur : " + vainqueur.getPrenom() : "");
    }
}
