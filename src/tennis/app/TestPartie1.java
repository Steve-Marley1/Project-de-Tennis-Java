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
import tennis.model.*;

public class TestPartie1 {

    public static void main(String[] args) {

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

        Joueuse joueuse1 = new Joueuse(
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

        SpectateurHomme spectateur1 = new SpectateurHomme(
                "DURAND",
                "DURAND",
                "Paul",
                "",
                LocalDate.of(1980, 1, 15),
                "Marseille",
                "Française",
                178,
                82.0,
                "A",
                12,
                50.0,
                "Blanche"
        );

        Spectatrice spectatrice1 = new Spectatrice(
                "LEFEBVRE",
                "LEFEBVRE",
                "Sophie",
                "",
                LocalDate.of(1985, 9, 5),
                "Lille",
                "Française",
                165,
                60.0,
                "B",
                34,
                45.0,
                "Lunettes noires rondes"
        );

        ArbitreCentral arbitreCentral = new ArbitreCentral(
                "LAMBERT",
                "LAMBERT",
                "Jacques",
                "",
                LocalDate.of(1975, 7, 30),
                "Bordeaux",
                "Française",
                180,
                78.0,
                0.8,
                "Arbitre de chaise"
        );

        System.out.println(joueur1);
        System.out.println(joueuse1);
        System.out.println(spectateur1);
        System.out.println(spectatrice1);
        System.out.println(arbitreCentral);

        spectateur1.applaudir();
        spectatrice1.crier();

        joueur1.encourager();
        joueuse1.boire();

        arbitreCentral.annoncer("Début de l'échauffement.");

        joueur1.appelerArbitre(arbitreCentral, "Balle annoncée faute.");
    }
}
