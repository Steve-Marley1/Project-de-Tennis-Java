package tennis.model.match;

import java.util.ArrayList;
import java.util.List;

import tennis.model.arbitre.Arbitre;
import tennis.model.joueur.Joueur;

/**
 * Représente un jeu de tennis (succession d'échanges jusqu'à ce qu'un joueur
 * remporte le jeu). Gère les points, le gagnant du jeu et la liste des échanges.
 */
public class Jeu {

    private final Joueur serveur;
    private final Joueur receveur;

    private int pointsServeur;
    private int pointsReceveur;

    private boolean termine;
    private Joueur gagnant;

    private final List<Echange> echanges;

    /**
     * Crée un nouveau jeu entre deux joueurs.
     *
     * @param serveur  joueur au service
     * @param receveur joueur à la réception
     * @throws IllegalArgumentException si l'un des joueurs est null ou si ce sont le même
     */
    public Jeu(Joueur serveur, Joueur receveur) {
        if (serveur == null || receveur == null) {
            throw new IllegalArgumentException("Les joueurs d'un jeu ne peuvent pas être nuls.");
        }
        if (serveur == receveur) {
            throw new IllegalArgumentException("Le serveur et le receveur doivent être deux joueurs différents.");
        }

        this.serveur = serveur;
        this.receveur = receveur;
        this.pointsServeur = 0;
        this.pointsReceveur = 0;
        this.termine = false;
        this.gagnant = null;
        this.echanges = new ArrayList<>();
    }

    public Joueur getServeur() {
        return serveur;
    }

    public Joueur getReceveur() {
        return receveur;
    }

    public int getPointsServeur() {
        return pointsServeur;
    }

    public int getPointsReceveur() {
        return pointsReceveur;
    }

    public boolean isTermine() {
        return termine;
    }

    public Joueur getGagnant() {
        return gagnant;
    }

    public List<Echange> getEchanges() {
        return echanges;
    }

    /**
     * Enregistre un échange gagné par un des deux joueurs.
     * Met à jour le score du jeu et vérifie si le jeu est terminé.
     *
     * @param gagnantEchange joueur ayant gagné l'échange
     * @param arbitre        arbitre pour annoncer le score (peut être null)
     * @throws IllegalArgumentException si le jeu est déjà terminé ou si le gagnant est invalide
     */
    public void enregistrerEchangeGagnePar(Joueur gagnantEchange, Arbitre arbitre) {
        if (termine) {
            throw new IllegalArgumentException("Le jeu est déjà terminé, impossible d'ajouter un échange.");
        }
        if (gagnantEchange == null) {
            throw new IllegalArgumentException("Le gagnant de l'échange ne peut pas être null.");
        }
        if (gagnantEchange != serveur && gagnantEchange != receveur) {
            throw new IllegalArgumentException("Le gagnant de l'échange doit être le serveur ou le receveur.");
        }

        Echange echange = new Echange(gagnantEchange);
        echanges.add(echange);

        if (gagnantEchange == serveur) {
            pointsServeur++;
        } else {
            pointsReceveur++;
        }

        if (arbitre != null) {
            arbitre.annoncerScoreJeu(
                    serveur.getPrenom(),
                    pointsServeur,
                    receveur.getPrenom(),
                    pointsReceveur
            );
        }

        verifierFinJeu();
    }

    /**
     * Vérifie si le jeu est terminé selon les règles du tennis :
     * au moins 4 points pour un joueur et 2 points d'écart.
     */
    private void verifierFinJeu() {
        int maxPoints = Math.max(pointsServeur, pointsReceveur);
        int ecart = Math.abs(pointsServeur - pointsReceveur);

        if (maxPoints >= 4 && ecart >= 2) {
            termine = true;
            gagnant = (pointsServeur > pointsReceveur) ? serveur : receveur;
        }
    }

    @Override
    public String toString() {
        return "Jeu (" + serveur.getPrenom() + " au service) : "
                + convertirPoints(pointsServeur) + " / " + convertirPoints(pointsReceveur)
                + (termine ? " | Gagnant : " + gagnant.getPrenom() : "");
    }

    /**
     * Convertit un nombre de points en notation de tennis.
     */
    private String convertirPoints(int p) {
        switch (p) {
            case 0: return "0";
            case 1: return "15";
            case 2: return "30";
            case 3: return "40";
            default: return "40";
        }
    }
}
