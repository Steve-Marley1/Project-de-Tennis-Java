/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.stats;

/**
 *
 * @author steve
 */


/**
 * Représente les statistiques d'un joueur pour un match donné.
 *
 * Cette classe est prévue pour stocker les statistiques d'UN joueur
 * sur UN match (et non pas sur toute sa carrière).
 */
public class StatistiquesMatch {

    /** Nombre de sets joués par le joueur dans ce match. */
    private int setsJoues;

    /** Nombre de jeux joués par le joueur dans ce match. */
    private int jeuxJoues;

    /** Nombre total d'échanges joués par le joueur. */
    private int echangesJoues;

    /** Nombre total de points remportés par le joueur. */
    private int pointsGagnes;

    /** Nombre total d'aces effectués. */
    private int aces;

    /** Nombre de premiers services tentés. */
    private int premiersServices;

    /** Nombre de seconds services tentés. */
    private int deuxiemesServices;

    /** Nombre de doubles fautes commises. */
    private int doublesFautes;

    /** Nombre de balles de break obtenues. */
    private int ballesDeBreak;

    /** Nombre de balles de break remportées. */
    private int ballesDeBreakGagnees;

    /** Somme des vitesses des premiers services. */
    private double sommeVitessesService1;

    /** Nombre de premiers services mesurés. */
    private int nbServices1Mesures;

    /** Somme des vitesses des seconds services. */
    private double sommeVitessesService2;

    /** Nombre de seconds services mesurés. */
    private int nbServices2Mesures;

    /**
     * Construit un objet StatistiquesMatch initialisé à zéro.
     */
    public StatistiquesMatch() {
        this.setsJoues = 0;
        this.jeuxJoues = 0;
        this.echangesJoues = 0;
        this.pointsGagnes = 0;
        this.aces = 0;
        this.premiersServices = 0;
        this.deuxiemesServices = 0;
        this.doublesFautes = 0;
        this.ballesDeBreak = 0;
        this.ballesDeBreakGagnees = 0;
        this.sommeVitessesService1 = 0.0;
        this.nbServices1Mesures = 0;
        this.sommeVitessesService2 = 0.0;
        this.nbServices2Mesures = 0;
    }

    /**
     * Construit un objet StatistiquesMatch avec des valeurs initiales.
     *
     * Toutes les valeurs doivent être positives ou nulles.
     */
    public StatistiquesMatch(int setsJoues,
                             int jeuxJoues,
                             int echangesJoues,
                             int pointsGagnes,
                             int aces,
                             int premiersServices,
                             int deuxiemesServices,
                             int doublesFautes,
                             int ballesDeBreak,
                             int ballesDeBreakGagnees,
                             double sommeVitessesService1,
                             int nbServices1Mesures,
                             double sommeVitessesService2,
                             int nbServices2Mesures) {

        if (setsJoues < 0 || jeuxJoues < 0 || echangesJoues < 0 || pointsGagnes < 0
                || aces < 0 || premiersServices < 0 || deuxiemesServices < 0
                || doublesFautes < 0 || ballesDeBreak < 0 || ballesDeBreakGagnees < 0
                || sommeVitessesService1 < 0.0 || sommeVitessesService2 < 0.0
                || nbServices1Mesures < 0 || nbServices2Mesures < 0) {
            throw new IllegalArgumentException("Les statistiques de match doivent être positives ou nulles.");
        }

        if (ballesDeBreakGagnees > ballesDeBreak) {
            throw new IllegalArgumentException("Les balles de break gagnées ne peuvent pas dépasser les balles de break obtenues.");
        }

        this.setsJoues = setsJoues;
        this.jeuxJoues = jeuxJoues;
        this.echangesJoues = echangesJoues;
        this.pointsGagnes = pointsGagnes;
        this.aces = aces;
        this.premiersServices = premiersServices;
        this.deuxiemesServices = deuxiemesServices;
        this.doublesFautes = doublesFautes;
        this.ballesDeBreak = ballesDeBreak;
        this.ballesDeBreakGagnees = ballesDeBreakGagnees;
        this.sommeVitessesService1 = sommeVitessesService1;
        this.nbServices1Mesures = nbServices1Mesures;
        this.sommeVitessesService2 = sommeVitessesService2;
        this.nbServices2Mesures = nbServices2Mesures;
    }

    public int getSetsJoues() {
        return setsJoues;
    }

    public int getJeuxJoues() {
        return jeuxJoues;
    }

    public int getEchangesJoues() {
        return echangesJoues;
    }

    public int getPointsGagnes() {
        return pointsGagnes;
    }

    public int getAces() {
        return aces;
    }

    public int getPremiersServices() {
        return premiersServices;
    }

    public int getDeuxiemesServices() {
        return deuxiemesServices;
    }

    public int getDoublesFautes() {
        return doublesFautes;
    }

    public int getBallesDeBreak() {
        return ballesDeBreak;
    }

    public int getBallesDeBreakGagnees() {
        return ballesDeBreakGagnees;
    }

    /**
     * Retourne la vitesse moyenne des premiers services.
     *
     * @return vitesse moyenne en km/h (ou 0.0 s'il n'y a pas de service mesuré)
     */
    public double getVitesseMoyenneService1() {
        if (nbServices1Mesures == 0) {
            return 0.0;
        }
        return sommeVitessesService1 / nbServices1Mesures;
    }

    /**
     * Retourne la vitesse moyenne des seconds services.
     *
     * @return vitesse moyenne en km/h (ou 0.0 s'il n'y a pas de service mesuré)
     */
    public double getVitesseMoyenneService2() {
        if (nbServices2Mesures == 0) {
            return 0.0;
        }
        return sommeVitessesService2 / nbServices2Mesures;
    }

    /**
     * Enregistre un set supplémentaire joué par le joueur.
     */
    public void enregistrerSetJoue() {
        this.setsJoues++;
    }

    /**
     * Enregistre un jeu supplémentaire joué par le joueur.
     */
    public void enregistrerJeuJoue() {
        this.jeuxJoues++;
    }

    /**
     * Enregistre un échange gagné par le joueur.
     * Incrémente le nombre d'échanges joués et de points gagnés.
     */
    public void enregistrerEchangeGagne() {
        this.echangesJoues++;
        this.pointsGagnes++;
    }

    /**
     * Enregistre un échange perdu par le joueur.
     * Incrémente uniquement le nombre d'échanges joués.
     */
    public void enregistrerEchangePerdu() {
        this.echangesJoues++;
    }

    /**
     * Ajoute un ace au compteur du joueur.
     */
    public void ajouterAce() {
        this.aces++;
    }

    /**
     * Enregistre un premier service effectué, avec sa vitesse.
     *
     * @param vitesse vitesse du service (>= 0.0)
     */
    public void ajouterPremierService(double vitesse) {
        if (vitesse < 0.0) {
            throw new IllegalArgumentException("La vitesse d'un service doit être positive ou nulle.");
        }
        this.premiersServices++;
        this.sommeVitessesService1 += vitesse;
        this.nbServices1Mesures++;
    }

    /**
     * Enregistre un second service effectué, avec sa vitesse.
     *
     * @param vitesse vitesse du service (>= 0.0)
     */
    public void ajouterDeuxiemeService(double vitesse) {
        if (vitesse < 0.0) {
            throw new IllegalArgumentException("La vitesse d'un service doit être positive ou nulle.");
        }
        this.deuxiemesServices++;
        this.sommeVitessesService2 += vitesse;
        this.nbServices2Mesures++;
    }

    /**
     * Ajoute une double faute au compteur.
     */
    public void ajouterDoubleFaute() {
        this.doublesFautes++;
    }

    /**
     * Enregistre une balle de break obtenue.
     *
     * @param remportee true si la balle de break est gagnée, false sinon
     */
    public void ajouterBalleDeBreak(boolean remportee) {
        this.ballesDeBreak++;
        if (remportee) {
            this.ballesDeBreakGagnees++;
        }
    }

    @Override
    public String toString() {
        return "Statistiques Match : "
                + "sets joués = " + setsJoues
                + ", jeux joués = " + jeuxJoues
                + ", échanges joués = " + echangesJoues
                + ", points gagnés = " + pointsGagnes
                + ", aces = " + aces
                + ", premiers services = " + premiersServices
                + ", seconds services = " + deuxiemesServices
                + ", doubles fautes = " + doublesFautes
                + ", balles de break = " + ballesDeBreak
                + ", balles de break gagnées = " + ballesDeBreakGagnees
                + ", vitesse moyenne 1er service = " + getVitesseMoyenneService1()
                + ", vitesse moyenne 2nd service = " + getVitesseMoyenneService2();
    }

    public void ajouterJeuxJoues(int jeuxJ1) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

