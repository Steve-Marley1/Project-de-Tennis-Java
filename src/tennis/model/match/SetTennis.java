package tennis.model.match;

import java.util.ArrayList;
import java.util.List;

import tennis.model.arbitre.Arbitre;
import tennis.model.joueur.Joueur;

/**
 * Représente un set de tennis composé de plusieurs jeux.
 * Le Set reçoit des jeux terminés et met à jour le score du set.
 */
public class SetTennis {

    private final Joueur joueur1;
    private final Joueur joueur2;

    private int jeuxJoueur1;
    private int jeuxJoueur2;

    private boolean termine;
    private Joueur gagnant;

    private Joueur serveurCourant;

    private final List<Jeu> jeux;

    public SetTennis(Joueur joueur1, Joueur joueur2, Joueur serveurInitial) {

        if (joueur1 == null || joueur2 == null) {
            throw new IllegalArgumentException("Les joueurs ne peuvent pas être nuls.");
        }
        if (joueur1 == joueur2) {
            throw new IllegalArgumentException("Les deux joueurs doivent être différents.");
        }
        if (serveurInitial == null || (serveurInitial != joueur1 && serveurInitial != joueur2)) {
            throw new IllegalArgumentException("Le serveur initial doit être l’un des deux joueurs.");
        }

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.serveurCourant = serveurInitial;

        this.jeuxJoueur1 = 0;
        this.jeuxJoueur2 = 0;
        this.termine = false;
        this.gagnant = null;
        this.jeux = new ArrayList<>();
    }

    public Joueur getJoueur1() { return joueur1; }

    public Joueur getJoueur2() { return joueur2; }

    public int getJeuxJoueur1() { return jeuxJoueur1; }

    public int getJeuxJoueur2() { return jeuxJoueur2; }

    public boolean isTermine() { return termine; }

    public Joueur getGagnant() { return gagnant; }

    public List<Jeu> getJeux() { return jeux; }

    public Joueur getServeurCourant() { return serveurCourant; }

    /**
     * Ajoute un jeu terminé au set.
     *
     * @param jeu jeu terminé
     * @param arbitre arbitre pour les annonces
     */
    public void ajouterJeuTermine(Jeu jeu, Arbitre arbitre) {

        if (jeu == null) {
            throw new IllegalArgumentException("Le jeu ajouté ne peut pas être null.");
        }
        if (!jeu.isTermine()) {
            throw new IllegalArgumentException("On ne peut ajouter qu'un jeu terminé.");
        }
        if (termine) {
            throw new IllegalArgumentException("Le set est déjà terminé.");
        }

        jeux.add(jeu);

        Joueur gagnantJeu = jeu.getGagnant();

        if (gagnantJeu == joueur1) {
            jeuxJoueur1++;
        } else if (gagnantJeu == joueur2) {
            jeuxJoueur2++;
        } else {
            throw new IllegalArgumentException("Le gagnant du jeu n'appartient pas au set.");
        }

        if (arbitre != null) {
            arbitre.annoncerFinJeu(
                    gagnantJeu.getPrenom(),
                    jeuxJoueur1,
                    jeuxJoueur2
            );
        }

        verifierFinSet(arbitre);
        alternerServeur();
    }

    private void verifierFinSet(Arbitre arbitre) {

        int max = Math.max(jeuxJoueur1, jeuxJoueur2);
        int ecart = Math.abs(jeuxJoueur1 - jeuxJoueur2);

        if (max >= 6 && ecart >= 2) {
            termine = true;
            gagnant = (jeuxJoueur1 > jeuxJoueur2) ? joueur1 : joueur2;

            if (arbitre != null) {
                arbitre.annoncerFinSet(
                        gagnant.getPrenom(),
                        jeuxJoueur1,
                        jeuxJoueur2
                );
            }
        }
    }

    private void alternerServeur() {
        serveurCourant = (serveurCourant == joueur1) ? joueur2 : joueur1;
    }

    @Override
    public String toString() {
        return "Set : " + joueur1.getPrenom() + " " + jeuxJoueur1
                + " / " + joueur2.getPrenom() + " " + jeuxJoueur2
                + (termine ? " | Gagnant : " + gagnant.getPrenom() : "");
    }
}
