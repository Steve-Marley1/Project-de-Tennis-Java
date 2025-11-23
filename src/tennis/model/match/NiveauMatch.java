package tennis.model.match;

/**
 * Niveau d'un match dans un tournoi.
 *
 * Chaque valeur correspond à un tour du tableau de 128 joueurs.
 */
public enum NiveauMatch {

    // 1er tour (128 joueurs -> 64)
    ROUND1,
    PREMIER_TOUR,

    // 2e tour (64 -> 32)
    ROUND2,
    DEUXIEME_TOUR,

    // 3e tour (32 -> 16)
    ROUND3,

    // Huitièmes de finale (16 -> 8)
    HUITIEME,

    // Quarts de finale (8 -> 4)
    QUART,

    // Demi-finale (4 -> 2)
    DEMI,

    // Finale (2 -> 1)
    FINALE;
}
