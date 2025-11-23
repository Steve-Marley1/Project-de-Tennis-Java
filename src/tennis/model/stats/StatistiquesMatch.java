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
 * Statistiques détaillées pour un joueur sur un match donné.
 *
 * On y retrouve :
 * - nombre de sets et de jeux joués / gagnés
 * - nombre d'échanges joués et de points gagnés
 * - statistiques de service (aces, 1ers/2nds services, doubles fautes)
 * - balles de break (obtenues et converties)
 * - vitesse moyenne des 1ers et 2nds services.
 */
public class StatistiquesMatch {

    /** Nombre total de sets joués dans ce match. */
    private int setsJoues;

    /** Nombre de sets gagnés dans ce match. */
    private int setsGagnes;

    /** Nombre total de jeux joués. */
    private int jeuxJoues;

    /** Nombre de jeux gagnés. */
    private int jeuxGagnes;

    /** Nombre total d'échanges joués. */
    private int echangesJoues;

    /** Nombre total de points gagnés. */
    private int pointsGagnes;

    /** Nombre total d'aces. */
    private int aces;

    /** Nombre de 1ers services tentés. */
    private int premiersServices;

    /** Nombre de 2nds services tentés. */
    private int secondsServices;

    /** Nombre de doubles fautes. */
    private int doublesFautes;

    /** Nombre de balles de break obtenues. */
    private int ballesDeBreak;

    /** Nombre de balles de break converties. */
    private int ballesDeBreakGagnees;

    /** Somme des vitesses des 1ers services (pour moyenne). */
    private double sommeVit1erService;

    /** Nombre de 1ers services mesurés. */
    private int nb1erServiceMesures;

    /** Somme des vitesses des 2nds services (pour moyenne). */
    private double sommeVit2ndService;

    /** Nombre de 2nds services mesurés. */
    private int nb2ndServiceMesures;

    /**
     * Constructeur par défaut.
     * Initialise toutes les statistiques à zéro.
     */
    public StatistiquesMatch() {
        this.setsJoues = 0;
        this.setsGagnes = 0;
        this.jeuxJoues = 0;
        this.jeuxGagnes = 0;
        this.echangesJoues = 0;
        this.pointsGagnes = 0;
        this.aces = 0;
        this.premiersServices = 0;
        this.secondsServices = 0;
        this.doublesFautes = 0;
        this.ballesDeBreak = 0;
        this.ballesDeBreakGagnees = 0;
        this.sommeVit1erService = 0.0;
        this.nb1erServiceMesures = 0;
        this.sommeVit2ndService = 0.0;
        this.nb2ndServiceMesures = 0;
    }

    public int getSetsJoues() {
        return setsJoues;
    }

    public int getSetsGagnes() {
        return setsGagnes;
    }

    public int getJeuxJoues() {
        return jeuxJoues;
    }

    public int getJeuxGagnes() {
        return jeuxGagnes;
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

    public int getSecondsServices() {
        return secondsServices;
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
     * Vitesse moyenne des 1ers services (km/h).
     *
     * @return moyenne, ou 0.0 s'il n'y a aucune mesure.
     */
    public double getVitesseMoyennePremierService() {
        if (nb1erServiceMesures == 0) {
            return 0.0;
        }
        return sommeVit1erService / nb1erServiceMesures;
    }

    /**
     * Vitesse moyenne des 2nds services (km/h).
     *
     * @return moyenne, ou 0.0 s'il n'y a aucune mesure.
     */
    public double getVitesseMoyenneSecondService() {
        if (nb2ndServiceMesures == 0) {
            return 0.0;
        }
        return sommeVit2ndService / nb2ndServiceMesures;
    }

    /**
     * Enregistre un set joué.
     * Incrémente simplement le compteur de sets joués.
     */
    public void enregistrerSetJoue() {
        setsJoues++;
    }

    /**
     * Enregistre un set gagné.
     * Incrémente le nombre de sets gagnés,
     * sans modifier le nombre de sets joués.
     */
    public void enregistrerSetGagne() {
        setsGagnes++;
    }

    /**
     * Ajoute des jeux joués.
     *
     * @param nb nombre de jeux à ajouter (>= 0)
     */
    public void ajouterJeuxJoues(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre de jeux ajoutés doit être positif ou nul.");
            }
            jeuxJoues += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Ajoute des jeux gagnés.
     *
     * @param nb nombre de jeux gagnés à ajouter (>= 0)
     */
    public void ajouterJeuxGagnes(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre de jeux gagnés doit être positif ou nul.");
            }
            jeuxGagnes += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Ajoute des échanges joués.
     *
     * @param nb nombre d'échanges à ajouter (>= 0)
     */
    public void ajouterEchangesJoues(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre d'échanges joués doit être positif ou nul.");
            }
            echangesJoues += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Ajoute des points gagnés.
     *
     * @param nb nombre de points à ajouter (>= 0)
     */
    public void ajouterPointsGagnes(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre de points gagnés doit être positif ou nul.");
            }
            pointsGagnes += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Ajoute un certain nombre d'aces.
     *
     * @param nb nombre d'aces (>= 0)
     */
    public void ajouterAces(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre d'aces doit être positif ou nul.");
            }
            aces += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Incrémente le compteur de 1ers services tentés.
     */
    public void enregistrerPremierService() {
        premiersServices++;
    }

    /**
     * Incrémente le compteur de 2nds services tentés.
     */
    public void enregistrerSecondService() {
        secondsServices++;
    }

    /**
     * Ajoute des doubles fautes.
     *
     * @param nb nombre de doubles fautes (>= 0)
     */
    public void ajouterDoublesFautes(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre de doubles fautes doit être positif ou nul.");
            }
            doublesFautes += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Ajoute des balles de break obtenues.
     *
     * @param nb nombre de balles de break (>= 0)
     */
    public void ajouterBallesDeBreak(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre de balles de break doit être positif ou nul.");
            }
            ballesDeBreak += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Ajoute des balles de break converties.
     *
     * @param nb nombre de balles de break gagnées (>= 0)
     */
    public void ajouterBallesDeBreakGagnees(int nb) {
        try {
            if (nb < 0) {
                throw new IllegalArgumentException("Le nombre de balles de break gagnées doit être positif ou nul.");
            }
            ballesDeBreakGagnees += nb;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Enregistre la vitesse d'un 1er service.
     *
     * @param vitesse vitesse en km/h (> 0)
     */
    public void enregistrerVitessePremierService(double vitesse) {
        try {
            if (vitesse <= 0.0) {
                throw new IllegalArgumentException("La vitesse d'un service doit être positive.");
            }
            sommeVit1erService += vitesse;
            nb1erServiceMesures++;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    /**
     * Enregistre la vitesse d'un 2nd service.
     *
     * @param vitesse vitesse en km/h (> 0)
     */
    public void enregistrerVitesseSecondService(double vitesse) {
        try {
            if (vitesse <= 0.0) {
                throw new IllegalArgumentException("La vitesse d'un service doit être positive.");
            }
            sommeVit2ndService += vitesse;
            nb2ndServiceMesures++;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    @Override
    public String toString() {
        return "StatsMatch{" +
                "setsJoues=" + setsJoues +
                ", setsGagnes=" + setsGagnes +
                ", jeuxJoues=" + jeuxJoues +
                ", jeuxGagnes=" + jeuxGagnes +
                ", echangesJoues=" + echangesJoues +
                ", pointsGagnes=" + pointsGagnes +
                ", aces=" + aces +
                ", premiersServices=" + premiersServices +
                ", secondsServices=" + secondsServices +
                ", doublesFautes=" + doublesFautes +
                ", ballesDeBreak=" + ballesDeBreak +
                ", ballesDeBreakGagnees=" + ballesDeBreakGagnees +
                ", vitMoy1er=" + getVitesseMoyennePremierService() +
                ", vitMoy2nd=" + getVitesseMoyenneSecondService() +
                '}';
    }
}
