package main;

import GestionPersonnages.GestionFantome;
import Musique.MusiqueJeu;
import ihm.AffichageBackground;
import ihm.FenetrePrincipale;
import java.awt.Dimension;
import jeu.Coordonnees;
import jeu.DifficulteCarte;
import jeu.DifficulteCarte.Niveau;
import jeu.Fantome;
import jeu.Joueur;
import jeu.Labyrinthe;

/**
 * Classe contenant le jeu et tous les elements ou presque pour le manipuler
 * @author Mathieu
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
   
	/* 1 si jeu terminé, 0 sinon */
	private boolean _fin=true;
        
        /* La carte */
	private DifficulteCarte _carte;
        
        /* Le labyrinthe */
        private Labyrinthe _lab;
        
        /* Le Pacman et son skin sélectionné*/
        private Joueur _joueur;
        private String _skinJoueur = "pacman_ouvert.png";
        
        /* Nos 3 fantomes */
        private Fantome _fantome1;
        private Fantome _fantome2;
        private Fantome _fantome3;
        
        /* Affichage du fond d'écran des menus avant le lancement du jeu */
        private AffichageBackground _affAccueil;
        
        /* Thread faisant tourner la musique en arrière plan, pour l'accueil et le jeu */ 
        private MusiqueJeu threadMusiqueAccueil;
        private MusiqueJeu threadMusiquePartie;
        
        /* Thread qui gère les déplacements des fantomes, les collisions .. etc */
        private GestionFantome _gestionF;
        
        /* La JFrame contenant notre jeu */
        private FenetrePrincipale _fen;
        
        /* Choix des options avec la difficulte, la music et la couleur de fond d'écran choisis */
        private int _difficulte=150;
        private String _music="Nyan-Cat-ringtone-6-second-loop.wav.wav";
        Niveau _level=Niveau.MOYEN;
        
        // Constructeur
	private Jeu(){
                /* Dimensions par défault de notre fenetre de jeu*/
		_resolution = new Dimension(800, 600);
	}

    /**
     * Méthode lancée au démarrage du jeu
     */
    public void run(){         
                /* instanciation de la fenetre graphique principale */
                _fen = new FenetrePrincipale(this, 1);
                
                /* On lance la musique de l'accueil en arriere plan via un thread */
                threadMusiqueAccueil = new MusiqueJeu("EFFECTS01.WAV");
                threadMusiqueAccueil.start();
	}
    
    /**
     * Méthode lancée au lancement d'une partie
     */
	public void nouvellePartie(){
		// Arret de la musique d'accueil
                threadMusiqueAccueil.stop();
                if(isPartieEnCours()){
                    threadMusiquePartie.stop();
                }
                
                // Lancement musique de partie
                threadMusiquePartie = new MusiqueJeu(_music);
                threadMusiquePartie.start();
                
		// création Description labyrinthe 
		_carte = new DifficulteCarte(_level);
                
		//Instanciation d'un Labyrinthe 
		_lab = new Labyrinthe(_carte);
                
                /* On place le joueur et le/les fantomes */ 
                Coordonnees _coordonnes = new Coordonnees(0, 0);
                _joueur = new Joueur(_coordonnes, _skinJoueur);
                _fantome1 = new Fantome(new Coordonnees(10,10), "le-fantome-de-pacman.gif");
                _fantome2 = new Fantome(new Coordonnees(20,20), "le-fantome-de-pacman.gif");
                _fantome3 = new Fantome(new Coordonnees(30,30), "le-fantome-de-pacman.gif");
                
		// Initialisation des paramètres
		partieEnCours = true;
                _pause = false;
                _fin = false;
                
                /* On affiche la fenetre de jeu */
                _fen.affichePanel(3);
                
                // On lance le thread qui gère les fantomes
                _gestionF = new GestionFantome(this, _fantome1, _fantome2, _fantome3, _fen.getAffichageLabyrinthe(), _joueur, _fen.getAffichageLabyrinthe().getAfficheJoueur(), _difficulte);
                _fen.getAffichageLabyrinthe().getControle().setgestionFantome(_gestionF);
                _gestionF.start();
	}

    /**
     * Retourne l'instance du jeu en cours
     * @return
     */
    public static Jeu getGame() {
        return Game;
    }

    /**
     * Set l'instance du jeu en cours
     * @param Game 
     */
    public static void setGame(Jeu Game) {
        Jeu.Game = Game;
    }

    /**
     * Retourne 1 si la partie est en cours, 0 sinon
     * @return
     */
    public boolean isPartieEnCours() {
        return partieEnCours;
    }

    /**
     * Set 1 ou 0 pour définir si la partie est en cours ou non
     * @param partieEnCours
     */
    public void setPartieEnCours(boolean partieEnCours) {
        this.partieEnCours = partieEnCours;
    }

    /**
     * Retourne 1 si la partie est en pause, 0 sinon
     * @return
     */
    public boolean isPause() {
        return _pause;
    }

    /**
     * Met le jeu en pause avec 1 et 0 pour enlever la pause
     * @param pause
     */
    public void setPause(boolean pause) {
        this._pause = pause;
    }

    /**
     * Retourne 1 si la partie est finie, 0 sinon
     * @return
     */
    public boolean isFin() {
        return _fin;
    }

    /**
     * Mettre 1 si la partie est finie, 0 sinon
     * @param fin
     */
    public void setFin(boolean fin) {
        this._fin = fin;
    }

    /**
     * Retourne la carte
     * @return
     */
    public DifficulteCarte getCarte() {
        return _carte;
    }

    /**
     * Permet de mettre la carte
     * @param _carte
     */
    public void setCarte(DifficulteCarte _carte) {
        this._carte = _carte;
    }

    /**
     * Retourne le labyrinthe
     * @return
     */
    public Labyrinthe getLab() {
        return _lab;
    }

    /**
     * Met le labyrinthe du jeu
     * @param _lab
     */
    public void setLab(Labyrinthe _lab) {
        this._lab = _lab;
    }
	
    /**
     * Retourne l'instance du jeu en cours
     * @return
     */
    
	
    public static Jeu getInstance() {
        if (!(Game instanceof Jeu)) {		// Si pas d'instance, on en fait une
            Game = new Jeu();
        }
        return Game;
    }
	
    /**
     * Retourne les dimensions de la fenetre
     * @return
     */
	public Dimension getResolution() {
		return _resolution;
	}

    /**
     * Permet de redémarrer une partie
     */
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
     * Met fin à la partie en cours
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
    
    /**
     * Retourne le joueur
     * @return
     */
    public Joueur getJoueur(){
        return _joueur;
    }

    /**
     * Permet d'arreter la musique en cours
     */
    public void stopMusique(){
        threadMusiquePartie.stop();
    }
    
    /**
     * Permet de démarrer une musique en lui passant le nom de la musique située dans la racine
     * @param titre
     */
    public void startMusique(String titre){
        threadMusiquePartie = new MusiqueJeu(titre);
        threadMusiquePartie.start();
    }

    /**
     * Arrete la gestion des fantomes
     */
    public void stopFantomes(){
        _gestionF.stop();
    }
    
    /**
     * Retourne le fantome 1
     * @return
     */
    public Fantome getFantome1() {
        return _fantome1;
    }
    
    /**
     * Retourne le fantome 2
     * @return
     */
    public Fantome getFantome2() {
        return _fantome2;
    }
        
    /**
     * Retourne le fantome 3
     * @return
     */
    public Fantome getFantome3() {
        return _fantome3;
    }
        
    /**
     * Permet de mettre le skin que va avoir notre joueur pour la prochaine partie
     * @param skin
     */
    public void setSkinJoueur(String skin){
            _skinJoueur = skin;
        }
        
    /**
     * Permet de déterminer la difficulté du jeu (en terme de vitesse)
     * @param d
     */
    public void setDifficulte(int d){
            _difficulte=d;
        }
        
    /**
     * Permet de déterminer la musique qui va etre joué durant la prochaine partie
     * @param music
     */
    public void setMusic(String music) {
            this._music = music;
	}
        
    /**
     * Permet de mettre la carte qui va etre jouée
     * @param l
     */
    public void setLevel(Niveau l){
            _level = l;
        }
        
    /** 
     * Retourne la carte actuellement selectionnée
     * @return
     */
    public Niveau getLevel(){
            return _level;
        }
}