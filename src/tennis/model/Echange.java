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

public class Echange {

    private Joueur serveur;
    private Joueur receveur;
    private boolean termine;
    private Joueur gagnant;

    public Echange(Joueur serveur, Joueur receveur) {
        this.serveur = serveur;
        this.receveur = receveur;
        this.termine = false;
        this.gagnant = null;
    }

    public Joueur getServeur() {
        return serveur;
    }

    public Joueur getReceveur() {
        return receveur;
    }

    public boolean isTermine() {
        return termine;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    /*
     * Joue un échange en demandant à l'utilisateur ce qui se passe sur le service.
     * Événements possibles :
     *  - "faute"  : faute de service
     *  - "filet"  : let, on rejoue la première balle
     *  - "correct": service bon, puis on demande qui gagne le point
     */
    public Joueur jouerEchange(Scanner scanner) {
        int numeroService = 1;
        while (!termine) {
            System.out.println("Service n°" + numeroService + " (faute / filet / correct) : ");
            String saisie = scanner.nextLine().trim().toLowerCase();

            switch (saisie) {
                case "faute":
                    System.out.println("Service faute.");
                    if (numeroService == 1) {
                        numeroService = 2;
                        System.out.println("Deuxième balle.");
                    } else {
                        System.out.println("Double faute, point pour le receveur.");
                        gagnant = receveur;
                        termine = true;
                    }
                    break;

                case "filet":
                    System.out.println("Let : la balle touche le filet mais est bonne, on rejoue la première balle.");
                    numeroService = 1;
                    break;

                case "correct":
                    System.out.println("Service correct.");
                    // On demande qui gagne le point
                    System.out.println("Qui gagne l'échange ? (s = serveur, r = receveur) : ");
                    String gagnantSaisie = scanner.nextLine().trim().toLowerCase();
                    if (gagnantSaisie.equals("s")) {
                        gagnant = serveur;
                    } else {
                        gagnant = receveur;
                    }
                    termine = true;
                    break;

                default:
                    System.out.println("Saisie invalide, recommence.");
                    break;
            }
        }
        return gagnant;
    }
}