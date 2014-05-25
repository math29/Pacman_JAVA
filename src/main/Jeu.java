package main;

import GestionPersonnages.GestionFantome;
import Musique.MusiqueJeu;
import ihm.AffichageBackground;
import ihm.FenetrePrincipale;
import java.awt.Dimension;
import jeu.Coordonnees;
import jeu.DifficulteCarte;
import jeu.Fantome;
import jeu.Joueur;
import jeu.Labyrinthe;

/*
 *	@author Mathieu
 *  import java.awt.Dimension;
import jeu.DifficulteCarte;
Classe qui va g�rer le jeu
 * 
 */

public class Jeu {
	
	/* instanciation du jeu */
	private static Jeu Game;
	
	/* Dimension de la fenetre de jeu */
	Dimension _resolution;
	
	/* 1 si jeu en cours de fonctionnement, 0 sinon */
	private boolean partieEnCours;
   
	/* 1 si jeu en _pause, 0 sinon */
	private boolean _pause;
   
	/* 1 si jeu termin�, 0 sinon */
	private boolean _fin=true;
        
        /* La carte */
	private DifficulteCarte _carte;
        
        /* Le labyrinthe */
        private Labyrinthe _lab;
        
        private FenetrePrincipale _mainWindow;
        
        private Joueur _joueur;
        
        private Fantome _fantome1;
        private Fantome _fantome2;
        private Fantome _fantome3;
        
        private AffichageBackground _affAccueil;
        
        private MusiqueJeu threadMusiqueAccueil;
        
        private MusiqueJeu threadMusiquePartie;
        
        private GestionFantome _gestionF;
        
        private FenetrePrincipale _fen;
        
        private String _skinJoueur;
	// Constructeur
	private Jeu(){
		_resolution = new Dimension(800, 600);		// Dimensions par d�fault du jeu
                _skinJoueur="pacman_ouvert.png";
	}

	public void run(){         
                /* instanciation de la fenetre graphique principale */
                _fen = new FenetrePrincipale(this, 1);
                threadMusiqueAccueil = new MusiqueJeu("EFFECTS01.WAV");
                threadMusiqueAccueil.start();
	}
	
	/* D�marre une nouvelle partie */
	
	public void nouvellePartie(){
		// Arret de la musique d'accueil
                threadMusiqueAccueil.stop();
                if(isPartieEnCours()){
                    threadMusiquePartie.stop();
                }
                
                // Lancement musique de partie
                threadMusiquePartie = new MusiqueJeu("Nyan-Cat-ringtone-6-second-loop.wav.wav");
                threadMusiquePartie.start();
                
		// cr�ation Description labyrinthe 
		_carte = new DifficulteCarte();
		//Instanciation d'un Labyrinthe 
		_lab = new Labyrinthe(_carte);
                
                /* On place le joueur et le/les fantomes */ 
                Coordonnees _coordonnes = new Coordonnees(0, 0);
                _joueur = new Joueur(_coordonnes, _skinJoueur);
                _fantome1 = new Fantome(new Coordonnees(10,10), "le-fantome-de-pacman.gif");
                _fantome2 = new Fantome(new Coordonnees(20,20), "le-fantome-de-pacman.gif");
                _fantome3 = new Fantome(new Coordonnees(30,30), "le-fantome-de-pacman.gif");
                
		// Initialisation des param�tres
		partieEnCours = true;
                _pause = false;
                _fin = false;
                
                // On lance le thread qui gère les fantomes
                
                _fen.affichePanel(3);
                
                _gestionF = new GestionFantome(this, _fantome1, _fantome2, _fantome3, _fen.getAfficheLabyrinthe(), _joueur, _fen.getAffichageLabyrinthe().getAfficheJoueur());
                _fen.getAffichageLabyrinthe().getControle().setgestionFantome(_gestionF);
                _gestionF.start();
	}

    public static Jeu getGame() {
        return Game;
    }

    public static void setGame(Jeu Game) {
        Jeu.Game = Game;
    }

    public boolean isPartieEnCours() {
        return partieEnCours;
    }

    public void setPartieEnCours(boolean partieEnCours) {
        this.partieEnCours = partieEnCours;
    }

    public boolean isPause() {
        return _pause;
    }

    public void setPause(boolean pause) {
        this._pause = pause;
    }

    public boolean isFin() {
        return _fin;
    }

    public void setFin(boolean fin) {
        this._fin = fin;
    }

    public DifficulteCarte getCarte() {
        return _carte;
    }

    public void setCarte(DifficulteCarte _carte) {
        this._carte = _carte;
    }

    public Labyrinthe getLab() {
        return _lab;
    }

    public void setLab(Labyrinthe _lab) {
        this._lab = _lab;
    }
	
	/* Retourne l'instance du jeu */
	
    public static Jeu getInstance() {
        if (!(Game instanceof Jeu)) {		// Si pas d'instance, on en fait une
            Game = new Jeu();
        }
        return Game;
    }
	
    /* Retourne les dimensions de la fen�tre */
    
	public Dimension getResolution() {
		return _resolution;
	}

    /**
     * Met en _pause le jeu.
     */
    public void pause(){
        /* Le jeu est en _pause. */
        _pause = true;
        partieEnCours = false;
        _fin = false;
        
        this.stopFantomes();
        this.stopMusique();
    }

    public void restart(){
        /* Le jeu reprend après une pause. */
        _fen.affichePanel(3);
        _pause = false;
        partieEnCours = true;
        _fin = false;
        
        threadMusiquePartie = new MusiqueJeu("Nyan-Cat-ringtone-6-second-loop.wav.wav");
        //_gestionF = new GestionFantome(_fantome, _fen.getAfficheLabyrinthe());
        
        _gestionF.start();
        threadMusiquePartie.start();
    }
    
    /**
     * Met _fin au jeu.
     */
    public void end() {
        /* Le jeu est terminé. */
        
        _pause = false;
        partieEnCours = false;
        _fin = true;

        
        this.stopMusique();
        

        _fen.affichePanel(6);
        this.stopFantomes();
    }
    
    public Joueur getJoueur(){
        return _joueur;
    }

    public void stopMusique(){
        threadMusiquePartie.stop();
    }
    
    public void startMusique(String titre){
        threadMusiquePartie = new MusiqueJeu(titre);
        threadMusiquePartie.start();
    }

    public void stopFantomes(){
        _gestionF.stop();
    }
    
    public Fantome getFantome1() {
        return _fantome1;
    }
    
        public Fantome getFantome2() {
        return _fantome2;
    }
        
        public Fantome getFantome3() {
        return _fantome3;
    }
        
        public void setSkinJoueur(String skin){
            _skinJoueur = skin;
        }
}