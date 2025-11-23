/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.joueur;

/**
 *
 * @author steve
 */


import java.time.LocalDate;


import tennis.model.personne.Genre;
import tennis.model.personne.Personne;
import tennis.model.stats.StatistiquesJoueur;
import tennis.model.support.Supporter;

/**
 * Représente un joueur de tennis (homme ou femme).
 * Un joueur peut également être spectateur lorsqu'il n'est pas sur le court.
 */
public abstract class Joueur extends Personne implements Supporter {

    private static int compteurClassement = 1;

    /** Main dominante du joueur. */
    private Main main;

    /** Sponsor principal du joueur. */
    private String sponsor;

    /** Classement du joueur dans le tournoi/saison. */
    private int classement;

    /** Entraîneur personnel. */
    private String entraineur;

    /** Statistiques de carrière. */
    private final StatistiquesJoueur statistiques;

    /** Statistiques simples. */
    private int matchsJoues;
    private int matchsGagnes;
    private int setsGagnes;
    private int jeuxGagnes;
    private int aces;
    private int doublesFautes;
    /** Niveau de passion dans le rôle de supporter. */

    /**
     * Constructeur d'un joueur.
     * @param nomNaissance
     * @param nomCourant
     * @param prenom
     * @param surnom
     * @param dateNaissance
     * @param lieuNaissance
     * @param nationalite
     * @param taille
     * @param poids
     * @param genre
     * @param main
     * @param entraineur
     * @param sponsor
     */
    public Joueur(String nomNaissance,
                  String nomCourant,
                  String prenom,
                  String surnom,
                  LocalDate dateNaissance,
                  String lieuNaissance,
                  String nationalite,
                  int taille,
                  double poids,
                  Genre genre,
                  Main main,
                  String sponsor,
                  String entraineur) {

        super(nomNaissance, nomCourant, prenom, surnom,
              dateNaissance, lieuNaissance, nationalite, taille, poids, genre);

        if (main == null) {
            throw new IllegalArgumentException("La main de jeu est obligatoire.");
        }
        if (sponsor == null || sponsor.isBlank()) {
            throw new IllegalArgumentException("Le sponsor est obligatoire.");
        }
        if (entraineur == null || entraineur.isBlank()) {
            throw new IllegalArgumentException("L'entraîneur est obligatoire.");
        }

        this.main = main;
        this.sponsor = sponsor;
        this.entraineur = entraineur;

        this.classement = compteurClassement++;

        this.matchsJoues = 0;
        this.matchsGagnes = 0;
        this.setsGagnes = 0;
        this.jeuxGagnes = 0;
        this.aces = 0;
        this.doublesFautes = 0;

        this.statistiques = new StatistiquesJoueur();
    }

    public Main getMain() {
        return main;
    }

    protected void setMain(Main main) {
        if (main == null) {
            throw new IllegalArgumentException("La main de jeu est obligatoire.");
        }
        this.main = main;
    }

    public String getSponsor() {
        return sponsor;
    }

    protected void setSponsor(String sponsor) {
        if (sponsor == null || sponsor.isBlank()) {
            throw new IllegalArgumentException("Le sponsor est obligatoire.");
        }
        this.sponsor = sponsor;
    }

    public int getClassement() {
        return classement;
    }

    protected void setClassement(int classement) {
        if (classement <= 0) {
            throw new IllegalArgumentException("Le classement doit être positif.");
        }
        this.classement = classement;
    }

    public String getEntraineur() {
        return entraineur;
    }

    protected void setEntraineur(String entraineur) {
        if (entraineur == null || entraineur.isBlank()) {
            throw new IllegalArgumentException("L'entraîneur est obligatoire.");
        }
        this.entraineur = entraineur;
    }

    public int getMatchsJoues() {
        return matchsJoues;
    }

    public int getMatchsGagnes() {
        return matchsGagnes;
    }

    public int getSetsGagnes() {
        return setsGagnes;
    }

    public int getJeuxGagnes() {
        return jeuxGagnes;
    }

    public int getAces() {
        return aces;
    }

    public int getDoublesFautes() {
        return doublesFautes;
    }

    /**
     * Retourne les statistiques de carrière du joueur.
     * @return 
     */
    public StatistiquesJoueur getStatistiques() {
        return statistiques;
    }

    /**
     * Enregistre une victoire en match.
     * @param setsGagnesDansMatch
     * @param jeuxGagnesDansMatch
     */
    public void enregistrerVictoireMatch(int setsGagnesDansMatch, int jeuxGagnesDansMatch) {

        if (setsGagnesDansMatch < 0 || jeuxGagnesDansMatch < 0) {
            throw new IllegalArgumentException("Les sets/jeux gagnés doivent être positifs ou nuls.");
        }

        matchsJoues++;
        matchsGagnes++;
        setsGagnes += setsGagnesDansMatch;
        jeuxGagnes += jeuxGagnesDansMatch;

        statistiques.enregistrerMatch(true);
    }

    /**
     * Enregistre une défaite en match.
     * @param setsGagnesDansMatch
     * @param jeuxGagnesDansMatch
     */
    public void enregistrerDefaiteMatch(int setsGagnesDansMatch, int jeuxGagnesDansMatch) {

        if (setsGagnesDansMatch < 0 || jeuxGagnesDansMatch < 0) {
            throw new IllegalArgumentException("Les sets/jeux gagnés doivent être positifs ou nuls.");
        }

        matchsJoues++;
        setsGagnes += setsGagnesDansMatch;
        jeuxGagnes += jeuxGagnesDansMatch;

        statistiques.enregistrerMatch(false);
    }

    public void ajouterAces(int nbAces) {
        if (nbAces < 0) {
            throw new IllegalArgumentException("Le nombre d'aces doit être positif ou nul.");
        }
        aces += nbAces;
    }

    public void ajouterDoublesFautes(int nbDoublesFautes) {
        if (nbDoublesFautes < 0) {
            throw new IllegalArgumentException("Le nombre de doubles fautes doit être positif ou nul.");
        }
        doublesFautes += nbDoublesFautes;
    }


    /* ====== MÉTHODES SUPPLÉMENTAIRES MANQUANTES ====== */

    public void encourager() {
        System.out.println(getPrenom() + " s'encourage.");
    }

    public void boire() {
        System.out.println(getPrenom() + " boit un peu d'eau.");
    }

    public void crierVictoire() {
        System.out.println(getPrenom() + " remporte la rencontre !");
    }

    public void crierDefaite() {
        System.out.println(getPrenom() + " perd le match...");
    }


    /* ====== MÉTHODES SUPPORTER ====== */

    @Override
    public void applaudir() {
        System.out.println(getPrenom() + " applaudit depuis les tribunes.");
    }

    @Override
    public void crier() {
        System.out.println(getPrenom() + " encourage les joueurs !");
    }

    @Override
    public void huer() {
        System.out.println(getPrenom() + " hue une décision de l'arbitre.");
    }

    @Override
    public void dormir() {
        System.out.println(getPrenom() + " somnole dans les tribunes...");
    }

    @Override
    public void reagirPointGagne() {
        System.out.println(getPrenom() + " applaudit un beau point !");
    }

    @Override
    public void reagirPointPerdu() {
        System.out.println(getPrenom() + " fait une grimace après un point perdu.");
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Classement : " + classement
                + " | Main : " + main
                + " | Sponsor : " + sponsor
                + " | Entraîneur : " + entraineur;
    }
}

