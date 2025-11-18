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
import java.util.Scanner;
import tennis.model.*;

public class TestPartie2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        JoueurHomme joueur1 = new JoueurHomme(
                "DUPONT",
                "DUPONT",
                "Pierre",
                "Pierrot",
                LocalDate.of(1995, 5, 10),
                "Paris",
                "Française",
                185,
                80.0,
                Main.DROITIER,
                "Nike",
                "Coach Jean",
                "Bleu"
        );

        Joueuse joueur2 = new Joueuse(
                "MARTIN",
                "MARTIN",
                "Claire",
                "Cla",
                LocalDate.of(1998, 3, 22),
                "Lyon",
                "Française",
                172,
                65.0,
                Main.GAUCHER,
                "Adidas",
                "Coach Marie",
                "Rouge"
        );

        Arbitre arbitre = new Arbitre(
                "LAMBERT",
                "LAMBERT",
                "Jacques",
                "",
                LocalDate.of(1975, 7, 30),
                "Bordeaux",
                "Française",
                180,
                78.0,
                0.8
        );

        Match match = new Match(
                joueur1,
                joueur2,
                arbitre,
                CategorieMatch.SIMPLE_HOMME,
                NiveauMatch.PREMIER_TOUR
        );

        match.demarrerMatch(scanner);

        scanner.close();
    }
}
