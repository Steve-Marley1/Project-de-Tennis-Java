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
import tennis.model.joueur.JoueurHomme;
import tennis.model.joueur.Joueuse;
import tennis.model.joueur.Main;
import tennis.model.match.CategorieMatch;
import tennis.model.match.Match;
import tennis.model.match.NiveauMatch;

public class TestMatchCategorie {

    public static void main(String[] args) {

        try {
            System.out.println("=== MATCH HOMME CORRECT ===");

            JoueurHomme homme1 = new JoueurHomme(
                    "DUPONT", "DUPONT", "Jean", "Jeannot",
                    LocalDate.of(1998, 5, 12),
                    "Paris", "Française",
                    185, 78.0,
                    Main.DROITIER,
                    "Lacoste",
                    "Coach Martin"
            );

            JoueurHomme homme2 = new JoueurHomme(
                    "MARTIN", "MARTIN", "Lucas", "Lu",
                    LocalDate.of(1997, 2, 3),
                    "Lyon", "Française",
                    182, 76.0,
                    Main.GAUCHER,
                    "Adidas",
                    "Coach Pierre"
            );

            ArbitreCentral arbitre = new ArbitreCentral(
                    "DURAND", "DURAND", "Alain", "L'arbitre",
                    LocalDate.of(1980, 1, 1),
                    "Marseille", "Française",
                    180, 75.0,
                    0.85,
                    "Arbitre de chaise"
            );

            Match matchHomme = new Match(
                    homme1,
                    homme2,
                    arbitre,
                    CategorieMatch.SIMPLE_HOMME,
                    NiveauMatch.FINALE
            );

            System.out.println(matchHomme);
            System.out.println();


            System.out.println("=== MATCH FEMME CORRECT ===");

            Joueuse femme1 = new Joueuse(
                    "MOREAU", "MOREAU", "Claire", "Clacla",
                    LocalDate.of(2000, 3, 20),
                    "Nice", "Française",
                    172, 62.5,
                    Main.GAUCHER,
                    "Nike",
                    "Coach Sophie"
            );

            Joueuse femme2 = new Joueuse(
                    "BENOIT", "BENOIT", "Julie", "Ju",
                    LocalDate.of(1999, 11, 8),
                    "Toulouse", "Française",
                    169, 59.0,
                    Main.DROITIER,
                    "Wilson",
                    "Coach Emma"
            );

            Match matchFemme = new Match(
                    femme1,
                    femme2,
                    arbitre,
                    CategorieMatch.SIMPLE_FEMME,
                    NiveauMatch.DEMI
            );

            System.out.println(matchFemme);
            System.out.println();


            System.out.println("=== MATCH INCORRECT (HOMME + FEMME) ===");

            try {
                // ceci doit déclencher l'exception
                Match matchErreur = new Match(
                        homme1,
                        femme1,
                        arbitre,
                        CategorieMatch.SIMPLE_HOMME,
                        NiveauMatch.QUART
                );

                // Si ça passe (ce qui ne doit JAMAIS arriver), on l'affiche :
                System.out.println(matchErreur);

            } catch (IllegalArgumentException e) {
                System.out.println("ERREUR NORMALE : " + e.getMessage());
            }

        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        }
    }
}