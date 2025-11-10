/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.app;
import tennis.model.*;
import java.time.LocalDate;

/**
 *
 * @author steve
 */
public class TestPartie1 {
    
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

        SpectateurHomme sh = new SpectateurHomme(
                "Dupont", "Jean", null,
                LocalDate.of(1990, 1, 1),
                "Lille", "Française",
                "Tribune A", 42, 80.0
        );

        Spectatrice sf = new Spectatrice(
                "Martin", "Claire", null,
                LocalDate.of(1995, 5, 12),
                "Lyon", "Française",
                "Tribune B", 17, 65.0
        );

        System.out.println(j1 + " age=" + j1.getAge() + ", tenue=" + j1.getTenue());
        j1.changerCouleurTenue("blanc");

        System.out.println(j2 + " age=" + j2.getAge() + ", tenue=" + j2.getTenue());
        j2.changerCouleurTenue("rouge");

        ac.annoncer("Début du match.");

        sh.applaudir();
        sh.changerCouleurChemise("verte");

        sf.crier();
        sf.setPorteLunettes(true);
    }

    
}
