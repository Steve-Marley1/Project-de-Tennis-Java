/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.app;

/**
 *
 * @author steve
 */

import java.util.List;
import java.util.Scanner;

import tennis.model.match.Match;
import tennis.model.match.ModeMatch;
import tennis.model.tournoi.Tournoi;
import tennis.model.tournoi.VilleTournoi;

/**
 * Programme de test pour le tournoi.
 *
 * Crée un tournoi, génère les participants,
 * crée le premier tour Simple Homme,
 * puis lance un match dans le mode choisi par l'utilisateur.
 */
public class TestTournoi {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("=== TEST TOURNOI GRAND CHELEM ===");

            int annee = 2025;
            try {
                System.out.print("Entrez l'année du tournoi (par défaut 2025) : ");
                String saisie = scanner.nextLine();
                if (!saisie.isBlank()) {
                    annee = Integer.parseInt(saisie.trim());
                }
            } catch (NumberFormatException e) {
                System.out.println("Année invalide, utilisation de 2025.");
                annee = 2025;
            }

            Tournoi tournoi = new Tournoi(VilleTournoi.PARIS, annee);
            System.out.println("Création du tournoi : " + tournoi);

            System.out.println("Génération automatique des joueurs, arbitres et spectateurs...");
            tournoi.genererParticipantsAutomatiquement();
            System.out.println("Participants générés.");

            System.out.println("Création du premier tour Simple Homme...");
            tournoi.creerPremierTourSimpleHomme();

            List<List<Match>> tableauH = tournoi.getTableauSimpleHomme();
            if (tableauH.isEmpty()) {
                System.out.println("Aucun tour Simple Homme n'a été créé.");
                return;
            }

            List<Match> premierTour = tableauH.get(0);
            if (premierTour.isEmpty()) {
                System.out.println("Aucun match dans le premier tour Simple Homme.");
                return;
            }

            System.out.println("Nombre de matchs au premier tour Simple Homme : " + premierTour.size());
            Match match = premierTour.get(0);

            System.out.println();
            System.out.println("Match sélectionné :");
            System.out.println(match.toString());
            System.out.println();

            System.out.println("Choisissez le mode de déroulement du match :");
            System.out.println("1 - Manuel");
            System.out.println("2 - Automatique (silencieux)");
            System.out.println("3 - Automatique (avec détails)");
            System.out.print("Votre choix : ");

            String choix = scanner.nextLine();
            ModeMatch mode;

            switch (choix) {
                case "1":
                    mode = ModeMatch.MANUEL;
                    break;
                case "2":
                    mode = ModeMatch.AUTO_SILENCE;
                    break;
                case "3":
                    mode = ModeMatch.AUTO_AVEC_DETAILS;
                    break;
                default:
                    System.out.println("Choix invalide, passage en mode automatique silencieux.");
                    mode = ModeMatch.AUTO_SILENCE;
                    break;
            }

            System.out.println();
            System.out.println("Démarrage du match en mode : " + mode);
            match.demarrerMatch(mode);

            System.out.println();
            System.out.println("Résultat final du match :");
            System.out.println(match.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur de configuration du tournoi ou du match : " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erreur inattendue : " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
