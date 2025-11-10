/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.app;

/**
 *
 * @author steve
 */
import tennis.model.*;
import java.time.LocalDate;

public class TestPartie2 {

    public static void main(String[] args) {

        JoueurHomme j1 = new JoueurHomme(
                "Nadal", "Rafael", "Rafa",
                LocalDate.of(1986, 6, 3),
                "Manacor", "Espagnole",
                185, 85.0,
                Main.GAUCHER,
                "Nike", "Moya"
        );

        Joueuse j2 = new Joueuse(
                "Williams", "Serena", null,
                LocalDate.of(1981, 9, 26),
                "Saginaw", "Américaine",
                175, 70.0,
                Main.DROITIER,
                "Nike", "Mouratoglou"
        );

        ArbitreCentral ac = new ArbitreCentral(
                "Bernardes", Genre.HOMME, "Carlos", null,
                LocalDate.of(1976, 3, 11),
                "Recife", "Brésilienne",
                "Chaise centrale Court Philippe-Chatrier"
        );

        Match match = new Match(
                j1,
                j2,
                ac,
                CategorieMatch.SIMPLE_HOMME,
                NiveauMatch.AMICAL,
                2        // 2 sets gagnants
        );

        match.demarrerMatch();
    }
}