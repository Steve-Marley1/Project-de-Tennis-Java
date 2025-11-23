/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tennis.model.support;

/**
 *
 * @author steve
 */

/**
 * Représente un supporter de tennis dans le public.
 * Il réagit aux points, encourage ou hue les joueurs.
 */
public interface Supporter {

    // Applaudir le joueur ou l'action en cours.
    void applaudir();

    // Crier pour encourager un joueur.
    void crier();

    // Huer une décision ou un mauvais coup.
    void huer();

    // Ne plus suivre le match (fatigue, ennui...).
    void dormir();

    // Réagit quand le joueur qu'il soutient gagne un point important.
    void reagirPointGagne();

    // Réagit quand le joueur qu'il soutient perd un point important.
    void reagirPointPerdu();
}
