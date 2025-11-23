/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.app;

/**
 *
 * @author steve
 */
import java.time.LocalDate;

import tennis.model.arbitre.ArbitreCentral;
import tennis.model.joueur.Joueuse;
import tennis.model.joueur.JoueurHomme;
import tennis.model.joueur.Main;
import tennis.model.match.CategorieMatch;
import tennis.model.match.NiveauMatch;
import tennis.model.match.Match;
import tennis.model.spectateur.SpectateurHomme;
import tennis.model.spectateur.Spectatrice;

public class TestPartie1 {

    public static void main(String[] args) {

        try {
            // Création des joueurs
            JoueurHomme joueur1 = new JoueurHomme(
                    "DUPONT",              // nom de naissance
                    "DUPONT",              // nom courant
                    "Jean",                // prénom
                    "Jeannot",             // surnom
                    LocalDate.of(1998, 5, 12), // date de naissance
                    "Paris",               // lieu de naissance
                    "Française",           // nationalité
                    185,                   // taille
                    78.0,                  // poids
                    Main.DROITIER,         // main
                    "Lacoste",             // sponsor
                    "Coach Martin"         // entraîneur
            );

            Joueuse joueuse1 = new Joueuse(
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

            // Création de l'arbitre central
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
                    0.85,              // réputation
                    "Arbitre de chaise"
            );

            // Création de spectateurs
            SpectateurHomme spectateur1 = new SpectateurHomme(
                    "LEFEBVRE",
                    "LEFEBVRE",
                    "Paul",
                    "Polo",
                    LocalDate.of(1995, 9, 5),
                    "Lille",
                    "Française",
                    178,
                    80.0,
                    joueur1,    // joueur favori
                    8           // niveau de passion
            );

            Spectatrice spectatrice1 = new Spectatrice(
                    "MOREAU",
                    "MOREAU",
                    "Julie",
                    "Ju",
                    LocalDate.of(1997, 11, 2),
                    "Bordeaux",
                    "Française",
                    165,
                    58.0,
                    joueuse1,
                    9
            );

            // Affichage des informations
            System.out.println("=== Informations des personnes ===");
            System.out.println(joueur1);
            System.out.println(joueuse1);
            System.out.println(arbitreCentral);
            System.out.println(spectateur1);
            System.out.println(spectatrice1);

            // Petite simulation d'ambiance
            System.out.println();
            System.out.println("=== Ambiance dans le stade ===");
            spectateur1.applaudir();
            spectatrice1.crier();

            System.out.println();
            System.out.println("=== Réactions au point gagné / perdu ===");
            spectateur1.reagirPointGagne();
            spectatrice1.reagirPointPerdu();

            // Création d'un match simple pour montrer la cohérence du modèle
            Match match = new Match(
                    joueur1,
                    joueuse1,
                    arbitreCentral,
                    CategorieMatch.SIMPLE_HOMME, // ou SIMPLE_FEMME selon la logique que tu veux
                    NiveauMatch.FINALE
            );

            System.out.println();
            System.out.println("=== Match créé ===");
            System.out.println(match);

            // Exemple d'appel de comportements joueurs après un match
            System.out.println();
            System.out.println("=== Exemple de réactions de joueurs ===");
            joueur1.encourager();
            joueuse1.boire();

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de données dans la création d'un objet : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
    }
}