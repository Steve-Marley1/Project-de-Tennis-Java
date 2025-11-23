/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.app;

/**
 *
 * @author steve
 */



import tennis.model.tournoi.Tournoi;
import tennis.model.tournoi.VilleTournoi;

import tennis.model.match.Match;

import java.util.List;

/**
 * Classe de test pour vérifier le bon fonctionnement du tournoi :
 * - génération automatique des joueurs, arbitres, spectateurs
 * - création du premier tour Simple Homme / Simple Femme
 */
public class TestTournoi {

    public static void main(String[] args) {

        try {
            System.out.println("=== TEST TOURNOI ===");

            // Création du tournoi
            Tournoi tournoi = new Tournoi(VilleTournoi.PARIS, 2025);

            System.out.println("\nCréation du tournoi...");
            System.out.println(tournoi);

            // Génération des participants
            System.out.println("\nGénération automatique des participants...");
            tournoi.genererParticipantsAutomatiquement();
            System.out.println("Participants générés avec succès !");
            System.out.println(tournoi);

            // Premier tour Simple Homme
            System.out.println("\nCréation du premier tour Simple Homme...");
            tournoi.creerPremierTourSimpleHomme();
            System.out.println("Premier tour SH généré !");

            // Premier tour Simple Femme
            System.out.println("\nCréation du premier tour Simple Femme...");
            tournoi.creerPremierTourSimpleFemme();
            System.out.println("Premier tour SF généré !");

            // Afficher les 3 premiers matchs de Simple Homme
            System.out.println("\n=== APERÇU DES MATCHS SIMPLE HOMME ===");
            List<List<Match>> tableauSH = tournoi.getTableauSimpleHomme();
            List<Match> tour1SH = tableauSH.get(0);

            for (int i = 0; i < 3; i++) {
                Match m = tour1SH.get(i);
                System.out.println((i + 1) + ") " 
                        + m.getJoueur1().getPrenom()
                        + " vs " 
                        + m.getJoueur2().getPrenom());
            }

            // Afficher les 3 premiers matchs de Simple Femme
            System.out.println("\n=== APERÇU DES MATCHS SIMPLE FEMME ===");
            List<List<Match>> tableauSF = tournoi.getTableauSimpleFemme();
            List<Match> tour1SF = tableauSF.get(0);

            for (int i = 0; i < 3; i++) {
                Match m = tour1SF.get(i);
                System.out.println((i + 1) + ") " 
                        + m.getJoueur1().getPrenom()
                        + " vs " 
                        + m.getJoueur2().getPrenom());
            }

            System.out.println("\n=== TEST OK ===");

        } catch (IllegalArgumentException e) {
            System.err.println("\nErreur détectée : " + e.getMessage());
        } catch (Exception e) {
            System.err.println("\nErreur inattendue : " + e.getMessage());
        }
    }
}
