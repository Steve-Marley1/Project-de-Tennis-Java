/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.app;

/**
 *
 * @author steve
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import tennis.model.match.Match;
import tennis.model.match.ModeMatch;
import tennis.model.tournoi.Tournoi;
import tennis.model.tournoi.VilleTournoi;

/**
 * Application principale en mode console pour gérer
 * des tournois de tennis du Grand Chelem.
 */
public class TennisApp {

    private static final List<Tournoi> tournois = new ArrayList<>();

    public static void main(String[] args) {

        System.setProperty("file.encoding", "UTF-8");
        System.setProperty("sun.stdout.encoding", "UTF-8");
        System.setProperty("sun.stderr.encoding", "UTF-8");

        Scanner scanner = new Scanner(System.in);

        boolean quitter = false;

        while (!quitter) {
            afficherMenuPrincipal();
            int choix = lireChoix(scanner, 1, 4);

            switch (choix) {
                case 1 -> creerTournoi(scanner);
                case 2 -> listerTournois();
                case 3 -> gererTournoi(scanner);
                case 4 -> {
                    quitter = true;
                    System.out.println("Au revoir.");
                }
                default -> System.out.println("Choix invalide.");
            }
        }

        scanner.close();
    }

    /**
     * Affiche le menu principal.
     */
    private static void afficherMenuPrincipal() {
        System.out.println();
        System.out.println("=== MENU PRINCIPAL TENNIS ===");
        System.out.println("1 - Créer un tournoi");
        System.out.println("2 - Lister les tournois");
        System.out.println("3 - Gérer un tournoi");
        System.out.println("4 - Quitter");
        System.out.print("Votre choix : ");
    }

    /**
     * Lit un choix entier dans un intervalle donné.
     *
     * @param scanner scanner de saisie
     * @param min     minimum inclus
     * @param max     maximum inclus
     * @return choix entier
     */
    private static int lireChoix(Scanner scanner, int min, int max) {

        int choix = -1;
        boolean ok = false;

        while (!ok) {
            try {
                String ligne = scanner.nextLine();
                choix = Integer.parseInt(ligne.trim());
                if (choix < min || choix > max) {
                    System.out.print("Veuillez entrer un nombre entre " + min + " et " + max + " : ");
                } else {
                    ok = true;
                }
            } catch (NumberFormatException e) {
                System.out.print("Saisie invalide, entrez un nombre : ");
            }
        }

        return choix;
    }

    /**
     * Permet de créer un tournoi et de générer automatiquement
     * les joueurs, arbitres et spectateurs.
     *
     * @param scanner scanner de saisie
     */
    private static void creerTournoi(Scanner scanner) {

        try {
            System.out.println();
            System.out.println("=== CRÉATION D'UN TOURNOI ===");

            System.out.println("Choisissez la ville du tournoi :");
            System.out.println("1 - Melbourne");
            System.out.println("2 - Paris");
            System.out.println("3 - Londres");
            System.out.println("4 - New York");
            System.out.print("Votre choix : ");

            int choixVille = lireChoix(scanner, 1, 4);
            VilleTournoi ville;

            ville = switch (choixVille) {
                case 1 -> VilleTournoi.MELBOURNE;
                case 2 -> VilleTournoi.PARIS;
                case 3 -> VilleTournoi.LONDRES;
                case 4 -> VilleTournoi.NEW_YORK;
                default -> VilleTournoi.PARIS;
            };

            int annee = 2025;
            System.out.print("Entrez l'année du tournoi (par défaut 2025) : ");
            String saisieAnnee = scanner.nextLine();
            if (!saisieAnnee.isBlank()) {
                try {
                    annee = Integer.parseInt(saisieAnnee.trim());
                } catch (NumberFormatException e) {
                    System.out.println("Année invalide, utilisation de 2025.");
                    annee = 2025;
                }
            }

            Tournoi tournoi = new Tournoi(ville, annee);

            System.out.println("Génération automatique des joueurs, arbitres et spectateurs...");
            tournoi.genererParticipantsAutomatiquement();

            tournois.add(tournoi);

            System.out.println("Tournoi créé : " + tournoi.toString());

        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors de la création du tournoi : " + e.getMessage());
        }
    }

    /**
     * Affiche la liste des tournois existants.
     */
    private static void listerTournois() {

        System.out.println();
        System.out.println("=== LISTE DES TOURNOIS ===");

        if (tournois.isEmpty()) {
            System.out.println("Aucun tournoi créé pour le moment.");
            return;
        }

        for (int i = 0; i < tournois.size(); i++) {
            System.out.println((i + 1) + " - " + tournois.get(i).toString());
        }
    }

    /**
     * Permet de sélectionner un tournoi et d'afficher
     * un sous-menu de gestion.
     *
     * @param scanner scanner de saisie
     */
    private static void gererTournoi(Scanner scanner) {

        if (tournois.isEmpty()) {
            System.out.println("Aucun tournoi à gérer. Créez-en un d'abord.");
            return;
        }

        listerTournois();
        System.out.print("Sélectionnez un tournoi (numéro) : ");
        int index = lireChoix(scanner, 1, tournois.size()) - 1;

        Tournoi tournoi = tournois.get(index);

        boolean retour = false;
        while (!retour) {
            afficherMenuTournoi(tournoi);
            int choix = lireChoix(scanner, 1, 6);

            switch (choix) {
                case 1 -> afficherResumeTournoi(tournoi);
                case 2 -> creerPremierTourSimpleHomme(tournoi);
                case 3 -> creerPremierTourSimpleFemme(tournoi);
                case 4 -> lancerMatchPremierTour(tournoi, true, scanner);
                case 5 -> lancerMatchPremierTour(tournoi, false, scanner);
                case 6 -> retour = true;
                default -> System.out.println("Choix invalide.");
            }
        }
    }

    /**
     * Affiche le menu de gestion d'un tournoi.
     *
     * @param tournoi tournoi sélectionné
     */
    private static void afficherMenuTournoi(Tournoi tournoi) {
        System.out.println();
        System.out.println("=== GESTION DU TOURNOI ===");
        System.out.println(tournoi.toString());
        System.out.println("1 - Afficher un résumé du tournoi");
        System.out.println("2 - Créer le premier tour Simple Homme");
        System.out.println("3 - Créer le premier tour Simple Femme");
        System.out.println("4 - Lancer un match du 1er tour Simple Homme");
        System.out.println("5 - Lancer un match du 1er tour Simple Femme");
        System.out.println("6 - Retour au menu principal");
        System.out.print("Votre choix : ");
    }

    /**
     * Affiche un petit résumé du tournoi.
     *
     * @param tournoi tournoi dont on veut le résumé
     */
    private static void afficherResumeTournoi(Tournoi tournoi) {
        System.out.println();
        System.out.println("=== RÉSUMÉ DU TOURNOI ===");
        System.out.println(tournoi.toString());
        System.out.println("Nombre de tours Simple Homme : " + tournoi.getTableauSimpleHomme().size());
        System.out.println("Nombre de tours Simple Femme : " + tournoi.getTableauSimpleFemme().size());
    }

    /**
     * Crée le premier tour Simple Homme si ce n'est pas déjà fait.
     *
     * @param tournoi tournoi concerné
     */
    private static void creerPremierTourSimpleHomme(Tournoi tournoi) {
        try {
            if (!tournoi.getTableauSimpleHomme().isEmpty()) {
                System.out.println("Le premier tour Simple Homme existe déjà.");
                return;
            }
            tournoi.creerPremierTourSimpleHomme();
            System.out.println("Premier tour Simple Homme créé.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    /**
     * Crée le premier tour Simple Femme si ce n'est pas déjà fait.
     *
     * @param tournoi tournoi concerné
     */
    private static void creerPremierTourSimpleFemme(Tournoi tournoi) {
        try {
            if (!tournoi.getTableauSimpleFemme().isEmpty()) {
                System.out.println("Le premier tour Simple Femme existe déjà.");
                return;
            }
            tournoi.creerPremierTourSimpleFemme();
            System.out.println("Premier tour Simple Femme créé.");
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }

    /**
     * Permet de choisir et de lancer un match du premier tour.
     *
     * @param tournoi        tournoi concerné
     * @param simpleHomme    true pour tableau homme, false pour femme
     * @param scanner        scanner de saisie
     */
    private static void lancerMatchPremierTour(Tournoi tournoi,
                                               boolean simpleHomme,
                                               Scanner scanner) {

        List<List<Match>> tableau = simpleHomme
                ? tournoi.getTableauSimpleHomme()
                : tournoi.getTableauSimpleFemme();

        if (tableau.isEmpty()) {
            System.out.println("Le premier tour correspondant n'a pas encore été créé.");
            return;
        }

        List<Match> premierTour = tableau.get(0);
        if (premierTour.isEmpty()) {
            System.out.println("Aucun match dans ce tour.");
            return;
        }

        System.out.println();
        System.out.println("=== MATCHS DU PREMIER TOUR " + (simpleHomme ? "SIMPLE HOMME" : "SIMPLE FEMME") + " ===");
        for (int i = 0; i < premierTour.size(); i++) {
            Match m = premierTour.get(i);
            String etat = m.isTermine() ? "TERMINÉ" : "EN COURS / À JOUER";
            System.out.println((i + 1) + " - " + m.toString() + " [" + etat + "]");
        }

        System.out.print("Sélectionnez un match (numéro) : ");
        int index = lireChoix(scanner, 1, premierTour.size()) - 1;

        Match match = premierTour.get(index);
        if (match.isTermine()) {
            System.out.println("Ce match est déjà terminé.");
            return;
        }

        System.out.println();
        System.out.println("Choisissez le mode de déroulement du match :");
        System.out.println("1 - Manuel");
        System.out.println("2 - Automatique (silencieux)");
        System.out.println("3 - Automatique (avec détails)");
        System.out.print("Votre choix : ");

        int choixMode = lireChoix(scanner, 1, 3);
        ModeMatch mode;

        switch (choixMode) {
            case 1:
                mode = ModeMatch.MANUEL;
                break;
            case 2:
                mode = ModeMatch.AUTO_SILENCE;
                break;
            case 3:
                mode = ModeMatch.AUTO_AVEC_DETAILS;
                break;
            default:
                mode = ModeMatch.AUTO_SILENCE;
                break;
        }

        try {
            System.out.println();
            System.out.println("Démarrage du match en mode : " + mode);
            match.demarrerMatch(mode);
            System.out.println("Match terminé :");
            System.out.println(match.toString());
        } catch (IllegalArgumentException e) {
            System.out.println("Erreur lors du déroulement du match : " + e.getMessage());
        }
    }
}
