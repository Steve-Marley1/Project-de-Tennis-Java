package tennis.model.match;

import tennis.model.joueur.Joueur;

/**
 * Représente un échange dans un jeu.
 * Un échange a toujours un gagnant (le joueur qui remporte le point).
 */
class Echange {   // visible seulement dans le package match

    private Joueur gagnant;

    /**
     * Crée un échange gagné par un joueur.
     *
     * @param gagnant joueur ayant remporté l'échange (obligatoire)
     * @throws IllegalArgumentException si le gagnant est null
     */
    protected Echange(Joueur gagnant) {
        if (gagnant == null) {
            throw new IllegalArgumentException("Le gagnant de l'échange ne peut pas être null.");
        }
        this.gagnant = gagnant;
    }

    protected Joueur getGagnant() {
        return gagnant;
    }

    /**
     * Change le gagnant d'un échange.
     *
     * @param gagnant nouveau gagnant
     * @throws IllegalArgumentException si gagnant est null
     */
    protected void setGagnant(Joueur gagnant) {
        if (gagnant == null) {
            throw new IllegalArgumentException("Le gagnant de l'échange ne peut pas être null.");
        }
        this.gagnant = gagnant;
    }

    @Override
    public String toString() {
        return "Échange remporté par : " + gagnant.getPrenom() + " " + gagnant.getNomCourant();
    }
}
