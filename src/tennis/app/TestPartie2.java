/*
 * Test de la partie 2 : simulation d'un set de tennis
 * avec saisie clavier et utilisation de Jeu, SetTennis et Match.
 */
package tennis.app;

import java.time.LocalDate;
import java.util.Scanner;

import tennis.model.arbitre.ArbitreCentral;
import tennis.model.joueur.Joueuse;
import tennis.model.joueur.JoueurHomme;
import tennis.model.joueur.Main;
import tennis.model.match.CategorieMatch;
import tennis.model.match.Jeu;
import tennis.model.match.Match;
import tennis.model.match.NiveauMatch;
import tennis.model.match.SetTennis;

public class TestPartie2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            // Création des joueurs (mêmes que dans TestPartie1 pour la cohérence)
            JoueurHomme joueur1 = new JoueurHomme(
                    "DUPONT",
                    "DUPONT",
                    "Jean",
                    "Jeannot",
                    LocalDate.of(1998, 5, 12),
                    "Paris",
                    "Française",
                    185,
                    78.0,
                    Main.DROITIER,
                    "Lacoste",
                    "Coach Martin"
            );

            Joueuse joueur2 = new Joueuse(
                    "DURAND",
                    "DURAND",
                    "Claire",
                    "Clacla",
                    LocalDate.of(2000, 3, 20),
                    "Lyon",
                    "Française",
                    172,
                    62.5,
                    Main.GAUCHER,
                    "Nike",
                    "Coach Sophie"
            );

            // Arbitre central
            ArbitreCentral arbitreCentral = new ArbitreCentral(
                    "MARTIN",
                    "MARTIN",
                    "Alain",
                    "L'arbitre",
                    LocalDate.of(1980, 1, 10),
                    "Marseille",
                    "Française",
                    180,
                    75.0,
                    0.85,
                    "Arbitre de chaise"
            );

            // Match : on suppose ici un match en 1 set gagnant (pour simplifier la démo)
            Match match = new Match(
                    joueur1,
                    joueur2,
                    arbitreCentral,
                    CategorieMatch.SIMPLE_HOMME, // ou SIMPLE_FEMME si tu préfères
                    NiveauMatch.FINALE
            );

            // Set : joueur1 commence au service
            SetTennis set = new SetTennis(joueur1, joueur2, joueur1);

            System.out.println("=== Début du set ===");
            System.out.println("Joueur 1 : " + joueur1.getPrenom());
            System.out.println("Joueur 2 : " + joueur2.getPrenom());
            System.out.println();

            // Boucle sur les jeux jusqu'à fin de set
            while (!set.isTermine()) {

                System.out.println("-----------------------------------");
                System.out.println("Nouveau jeu");
                System.out.println("Score actuel du set : "
                        + set.getJeuxJoueur1() + " - " + set.getJeuxJoueur2());

                // Détermination du serveur et du receveur pour ce jeu
                var serveur = set.getServeurCourant();
                var receveur = (serveur == joueur1) ? joueur2 : joueur1;

                System.out.println("Au service : " + serveur.getPrenom()
                        + " (contre " + receveur.getPrenom() + ")");

                // Création du jeu
                Jeu jeu = new Jeu(serveur, receveur);

                // Saisie des échanges jusqu'à ce que le jeu soit terminé
                while (!jeu.isTermine()) {
                    System.out.println();
                    System.out.println("Qui gagne l'échange ? (1 = "
                            + serveur.getPrenom() + ", 2 = " + receveur.getPrenom() + ")");
                    System.out.print("Votre choix : ");

                    String saisie = scanner.nextLine().trim();

                    try {
                        int choix = Integer.parseInt(saisie);
                        if (choix != 1 && choix != 2) {
                            System.out.println("Veuillez entrer 1 ou 2.");
                            continue;
                        }

                        if (choix == 1) {
                            jeu.enregistrerEchangeGagnePar(serveur, arbitreCentral);
                        } else {
                            jeu.enregistrerEchangeGagnePar(receveur, arbitreCentral);
                        }

                    } catch (NumberFormatException e) {
                        System.out.println("Saisie invalide. Veuillez entrer un nombre (1 ou 2).");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Erreur de logique dans le jeu : " + e.getMessage());
                    }
                }

                // Jeu terminé : on l'ajoute au set
                set.ajouterJeuTermine(jeu, arbitreCentral);

                System.out.println("Jeu terminé. Nouveau score du set : "
                        + set.getJeuxJoueur1() + " - " + set.getJeuxJoueur2());
                System.out.println();
            }

            // Set terminé : on l'ajoute au match
            match.ajouterSetTermine(set);

            System.out.println("=== Set terminé ===");
            System.out.println("Score final du set : "
                    + set.getJeuxJoueur1() + " - " + set.getJeuxJoueur2());
            System.out.println();

            System.out.println("=== Résumé du match ===");
            System.out.println(match);

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de données : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
