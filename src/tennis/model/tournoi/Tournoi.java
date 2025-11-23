/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tennis.model.tournoi;

/**
 *
 * @author steve
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

import tennis.model.support.Supporter;
import tennis.model.arbitre.ArbitreCentral;
import tennis.model.joueur.Joueuse;
import tennis.model.joueur.Joueur;
import tennis.model.joueur.JoueurHomme;
import tennis.model.joueur.Main;
import tennis.model.match.CategorieMatch;
import tennis.model.match.Match;
import tennis.model.match.NiveauMatch;

/**
 * Représente un tournoi de tennis du Grand Chelem.
 *
 * Un tournoi est défini par :
 * - une ville (Melbourne, Paris, Londres, New York)
 * - une année
 * - une surface automatique selon la ville
 *
 * Le tournoi contient :
 * - 128 joueurs hommes
 * - 128 joueuses femmes
 * - 10 arbitres
 * - au moins 100 spectateurs
 *
 * Il possède également les tableaux de Simple Homme et Simple Femme,
 * composés de 7 tours chacun (128 → Finale).
 */
public class Tournoi {

    private static final int NB_JOUEURS_PAR_TABLEAU = 128;
    private static final int NB_ARBITRES = 10;
    private static final int NB_SPECTATEURS_MIN = 100;

    private final VilleTournoi ville;
    private final int annee;
    private final Surface surface;

    private final List<JoueurHomme> joueursHommes;
    private final List<Joueuse> joueuses;
    private final List<ArbitreCentral> arbitres;
    private final List<Supporter> spectateurs;

    private final List<List<Match>> tableauSimpleHomme;
    private final List<List<Match>> tableauSimpleFemme;

    /**
     * Crée un tournoi.
     *
     * @param ville ville du tournoi
     * @param annee année du tournoi (>= 2000)
     * @throws IllegalArgumentException si la ville est nulle ou si l'année est invalide
     */
    public Tournoi(VilleTournoi ville, int annee) {

        try {
            if (ville == null) {
                throw new IllegalArgumentException("La ville du tournoi est obligatoire.");
            }
            if (annee < 2000) {
                throw new IllegalArgumentException("L'année du tournoi doit être >= 2000.");
            }

            this.ville = ville;
            this.annee = annee;
            this.surface = determinerSurface(ville);

            this.joueursHommes = new ArrayList<>();
            this.joueuses = new ArrayList<>();
            this.arbitres = new ArrayList<>();
            this.spectateurs = new ArrayList<>();

            this.tableauSimpleHomme = new ArrayList<>();
            this.tableauSimpleFemme = new ArrayList<>();

        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    public VilleTournoi getVille() {
        return ville;
    }

    public int getAnnee() {
        return annee;
    }

    public Surface getSurface() {
        return surface;
    }

    public List<JoueurHomme> getJoueursHommes() {
        return joueursHommes;
    }

    public List<Joueuse> getJoueuses() {
        return joueuses;
    }

    public List<ArbitreCentral> getArbitres() {
        return arbitres;
    }

    public List<Supporter> getSpectateurs() {
        return spectateurs;
    }

    public List<List<Match>> getTableauSimpleHomme() {
        return tableauSimpleHomme;
    }

    public List<List<Match>> getTableauSimpleFemme() {
        return tableauSimpleFemme;
    }

    /**
     * Détermine la surface en fonction de la ville.
     *
     * @param ville ville du tournoi
     * @return surface correspondante
     */
    private Surface determinerSurface(VilleTournoi ville) {
        switch (ville) {
            case MELBOURNE:
                return Surface.PLEXICUSHION;
            case PARIS:
                return Surface.TERRE_BATTUE;
            case LONDRES:
                return Surface.GAZON;
            case NEW_YORK:
                return Surface.DECOTURF;
            default:
                throw new IllegalArgumentException("Ville inconnue.");
        }
    }

    /**
     * Génère automatiquement :
     * - 128 joueurs hommes
     * - 128 joueuses
     * - 10 arbitres
     * - au moins 100 spectateurs
     *
     * @throws IllegalArgumentException en cas d'erreur de génération
     */
    public void genererParticipantsAutomatiquement() {

        try {
            joueursHommes.clear();
            joueuses.clear();
            arbitres.clear();
            spectateurs.clear();

            genererJoueursHommes();
            genererJoueuses();
            genererArbitres();
            genererSpectateurs();

        } catch (Exception e) {
            throw new IllegalArgumentException("Erreur lors de la génération des participants : " + e.getMessage());
        }
    }

    private void genererJoueursHommes() {
        for (int i = 1; i <= NB_JOUEURS_PAR_TABLEAU; i++) {

            String nom = "JH" + i;
            String prenom = "JoueurH" + i;
            String surnom = "H" + i;

            LocalDate dateNaissance = genererDateNaissanceAleatoire();
            String lieu = "VilleH" + i;
            String nationalite = "Française";
            int taille = 175 + ThreadLocalRandom.current().nextInt(0, 21);
            double poids = 68.0 + ThreadLocalRandom.current().nextDouble(0.0, 15.0);
            Main main = (i % 2 == 0) ? Main.DROITIER : Main.GAUCHER;
            String sponsor = "SponsorH" + i;
            String entraineur = "CoachH" + i;

            JoueurHomme joueur = new JoueurHomme(
                    nom, nom, prenom, surnom,
                    dateNaissance,
                    lieu,
                    nationalite,
                    taille,
                    poids,
                    main,
                    sponsor,
                    entraineur
            );

            joueursHommes.add(joueur);
        }
    }

    private void genererJoueuses() {
        for (int i = 1; i <= NB_JOUEURS_PAR_TABLEAU; i++) {

            String nom = "JF" + i;
            String prenom = "Joueuse" + i;
            String surnom = "F" + i;

            LocalDate dateNaissance = genererDateNaissanceAleatoire();
            String lieu = "VilleF" + i;
            String nationalite = "Française";
            int taille = 165 + ThreadLocalRandom.current().nextInt(0, 21);
            double poids = 55.0 + ThreadLocalRandom.current().nextDouble(0.0, 15.0);
            Main main = (i % 2 == 0) ? Main.DROITIER : Main.GAUCHER;
            String sponsor = "SponsorF" + i;
            String entraineur = "CoachF" + i;

            Joueuse joueuse = new Joueuse(
                    nom, nom, prenom, surnom,
                    dateNaissance,
                    lieu,
                    nationalite,
                    taille,
                    poids,
                    main,
                    sponsor,
                    entraineur
            );

            joueuses.add(joueuse);
        }
    }

    private void genererArbitres() {
        for (int i = 1; i <= NB_ARBITRES; i++) {

            String nom = "ARB" + i;
            String prenom = "Arbitre" + i;
            String surnom = "A" + i;

            LocalDate dateNaissance = genererDateNaissanceAleatoire();
            String lieu = "VilleA" + i;
            String nationalite = "Française";
            int taille = 170 + ThreadLocalRandom.current().nextInt(0, 21);
            double poids = 65.0 + ThreadLocalRandom.current().nextDouble(0.0, 20.0);
            double reputation = ThreadLocalRandom.current().nextDouble(0.5, 1.0);
            String poste = "Arbitre de chaise";

            ArbitreCentral arbitre = new ArbitreCentral(
                    nom, nom, prenom, surnom,
                    dateNaissance,
                    lieu,
                    nationalite,
                    taille,
                    poids,
                    reputation,
                    poste
            );

            arbitres.add(arbitre);
        }
    }

    /**
     * Génère les spectateurs en choisissant un joueur favori
     * parmi l'ensemble des joueurs hommes et femmes.
     */
    private void genererSpectateurs() {

        List<Joueur> favoris = new ArrayList<>();
        favoris.addAll(joueursHommes);
        favoris.addAll(joueuses);

        if (favoris.isEmpty()) {
            throw new IllegalArgumentException("Impossible de générer des spectateurs sans joueurs.");
        }

        for (int i = 1; i <= NB_SPECTATEURS_MIN; i++) {

            boolean homme = (i % 2 == 0);
            Joueur favori = favoris.get(ThreadLocalRandom.current().nextInt(favoris.size()));

            String nom = (homme ? "SPH" : "SPF") + i;
            String prenom = homme ? "Paul" + i : "Julie" + i;
            String surnom = homme ? "FanH" + i : "FanF" + i;

            LocalDate dateNaissance = genererDateNaissanceSpectateur();
            String lieu = "VilleS" + i;
            String nationalite = "Française";
            int taille = 160 + ThreadLocalRandom.current().nextInt(0, 31);
            double poids = 55.0 + ThreadLocalRandom.current().nextDouble(0.0, 25.0);
            int passion = ThreadLocalRandom.current().nextInt(3, 11);

            Supporter s = homme
                    ? new tennis.model.spectateur.SpectateurHomme(
                            nom, nom, prenom, surnom,
                            dateNaissance, lieu, nationalite, taille, poids,
                            favori, passion)
                    : new tennis.model.spectateur.Spectatrice(
                            nom, nom, prenom, surnom,
                            dateNaissance, lieu, nationalite, taille, poids,
                            favori, passion);

            spectateurs.add(s);
        }
    }

    /**
     * Mélange une liste (shuffle).
     *
     * @param liste liste à mélanger
     */
    private <T> void melangerListe(List<T> liste) {
        try {
            java.util.Collections.shuffle(liste);
        } catch (Exception e) {
            throw new IllegalArgumentException("Erreur lors du mélange : " + e.getMessage());
        }
    }

    /**
     * Crée le premier tour du tableau Simple Homme.
     *
     * @throws IllegalArgumentException si le nombre de joueurs est incorrect
     */
    public void creerPremierTourSimpleHomme() {

        if (joueursHommes.size() != NB_JOUEURS_PAR_TABLEAU) {
            throw new IllegalArgumentException("Il faut 128 joueurs hommes.");
        }

        melangerListe(joueursHommes);

        List<Match> premierTour = new ArrayList<>();

        for (int i = 0; i < NB_JOUEURS_PAR_TABLEAU; i += 2) {

            JoueurHomme j1 = joueursHommes.get(i);
            JoueurHomme j2 = joueursHommes.get(i + 1);

            ArbitreCentral arbitre = arbitres.get(i % arbitres.size());

            Match m = new Match(j1, j2, arbitre,
                    CategorieMatch.SIMPLE_HOMME,
                    NiveauMatch.ROUND1);

            premierTour.add(m);
        }

        tableauSimpleHomme.add(premierTour);
    }

    /**
     * Crée le premier tour du tableau Simple Femme.
     *
     * @throws IllegalArgumentException si le nombre de joueuses est incorrect
     */
    public void creerPremierTourSimpleFemme() {

        if (joueuses.size() != NB_JOUEURS_PAR_TABLEAU) {
            throw new IllegalArgumentException("Il faut 128 joueuses.");
        }

        melangerListe(joueuses);

        List<Match> premierTour = new ArrayList<>();

        for (int i = 0; i < NB_JOUEURS_PAR_TABLEAU; i += 2) {

            Joueuse j1 = joueuses.get(i);
            Joueuse j2 = joueuses.get(i + 1);

            ArbitreCentral arbitre = arbitres.get(i % arbitres.size());

            Match m = new Match(j1, j2, arbitre,
                    CategorieMatch.SIMPLE_FEMME,
                    NiveauMatch.ROUND1);

            premierTour.add(m);
        }

        tableauSimpleFemme.add(premierTour);
    }

    /**
     * Crée un tour suivant (2e tour, 3e tour, etc.)
     * à partir des vainqueurs du tour précédent.
     *
     * @param precedent tour précédent
     * @param categorie catégorie du match
     * @param niveau    niveau du nouveau tour
     * @return liste de matchs du nouveau tour
     */
    public List<Match> creerTourSuivant(List<Match> precedent,
                                        CategorieMatch categorie,
                                        NiveauMatch niveau) {

        if (precedent == null || precedent.isEmpty()) {
            throw new IllegalArgumentException("Tour précédent vide.");
        }
        if (precedent.size() % 2 != 0) {
            throw new IllegalArgumentException("Nombre de vainqueurs impair.");
        }

        List<Match> nouveauTour = new ArrayList<>();

        for (int i = 0; i < precedent.size(); i += 2) {

            Joueur g1 = precedent.get(i).getVainqueur();
            Joueur g2 = precedent.get(i + 1).getVainqueur();

            if (g1 == null || g2 == null) {
                throw new IllegalArgumentException("Tous les matchs du tour précédent doivent être terminés.");
            }

            ArbitreCentral arbitre = arbitres.get(i % arbitres.size());

            Match m = new Match(g1, g2, arbitre, categorie, niveau);
            nouveauTour.add(m);
        }

        return nouveauTour;
    }

    private LocalDate genererDateNaissanceAleatoire() {
        int min = annee - 35;
        int max = annee - 18;
        int a = ThreadLocalRandom.current().nextInt(min, max + 1);
        int m = ThreadLocalRandom.current().nextInt(1, 13);
        int j = ThreadLocalRandom.current().nextInt(1, 28);
        return LocalDate.of(a, m, j);
    }

    private LocalDate genererDateNaissanceSpectateur() {
        int min = annee - 70;
        int max = annee - 10;
        int a = ThreadLocalRandom.current().nextInt(min, max + 1);
        int m = ThreadLocalRandom.current().nextInt(1, 13);
        int j = ThreadLocalRandom.current().nextInt(1, 28);
        return LocalDate.of(a, m, j);
    }

    @Override
    public String toString() {
        return "Tournoi " + ville + " " + annee
                + " | Surface : " + surface
                + " | Joueurs H : " + joueursHommes.size()
                + " | Joueurs F : " + joueuses.size()
                + " | Arbitres : " + arbitres.size()
                + " | Spectateurs : " + spectateurs.size();
    }
}
