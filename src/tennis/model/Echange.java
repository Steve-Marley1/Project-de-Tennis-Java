/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model;

/**
 *
 * @author steve
 */

import java.util.Scanner;
import java.util.InputMismatchException;

//Notion de composition 
public class Echange {

    private Joueur serveur;
    private Joueur receveur;
   
        public Echange(Joueur serveur, Joueur receveur) {
        if (serveur == null || receveur == null) {
            throw new IllegalArgumentException("Les joueurs de l'échange ne peuvent pas être nuls.");
        }
        this.serveur = serveur;
        this.receveur = receveur;
    }

    public Joueur getServeur() {
        return serveur;
    }

    public Joueur getReceveur() {
        return receveur;
    }
    
        public Joueur jouerEchange(Scanner scanner, Arbitre arbitre) {
        if (scanner == null) {
            throw new IllegalArgumentException("Le scanner ne doit pas être nul.");
        }
        if (arbitre == null) {
            throw new IllegalArgumentException("L'arbitre ne doit pas être nul.");
        }

        int numeroService = 1;

        while (true) {
            System.out.println();
            System.out.println("Service n°" + numeroService + " de " + serveur.getPrenom() + " : ");
            System.out.println("  1 - Faute (filet ou dehors)");
            System.out.println("  2 - Filet mais balle bonne (let, service à rejouer)");
            System.out.println("  3 - Service correct");
            int choix = lireChoix(scanner, 1, 3);

            switch (choix) {
                case 1: // Faute
                    if (numeroService == 1) {
                        arbitre.annoncer("Première balle de " + serveur.getPrenom() + " faute.");
                        numeroService = 2;
                    } else {
                        arbitre.annoncer("Double faute de " + serveur.getPrenom() + ".");
                        return receveur;
                    }
                    break;

                case 2: // Filet mais balle bonne (let)
                    arbitre.annoncer("Let, service à rejouer.");
                    // On rejoue une première balle, donc on revient à 1
                    numeroService = 1;
                    break;

                case 3: // Service correct
                    arbitre.annoncer("Service correct de " + serveur.getPrenom() + ".");
                    return determinerGagnantPoint(scanner, arbitre);
            }
        }
    }
        
            private Joueur determinerGagnantPoint(Scanner scanner, Arbitre arbitre) {
        System.out.println();
        System.out.println("Qui gagne l'échange ?");
        System.out.println("  1 - " + serveur.getPrenom() + " (serveur)");
        System.out.println("  2 - " + receveur.getPrenom() + " (receveur)");
        int choixGagnant = lireChoix(scanner, 1, 2);

        Joueur gagnant = (choixGagnant == 1) ? serveur : receveur;
        arbitre.annoncer("Point remporté par " + gagnant.getPrenom() + ".");
        return gagnant;
    }
    private int lireChoix(Scanner scanner, int min, int max) {
        while (true) {
            System.out.print("Votre choix (" + min + "-" + max + ") : ");
            try {
                int valeur = scanner.nextInt();
                scanner.nextLine(); // vider la fin de ligne
                if (valeur < min || valeur > max) {
                    System.out.println("Veuillez saisir un nombre entre " + min + " et " + max + ".");
                } else {
                    return valeur;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, merci de saisir un nombre.");
                scanner.nextLine(); // on vide la saisie erronée
            }
        }
    }
}