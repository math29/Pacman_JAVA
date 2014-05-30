package jeu;

import java.awt.Image;
import java.util.ArrayList;

/**
 * Classe héritée par les joueurs et les fantomes, les Personnages !
 * @author Mathieu
 */
public abstract class Personnage {
    
    public static final int facteurPrecision = 5;
    /* L'élément graphique représentant le personnage */
    protected Image _displayGraphic;
    /* La liste des éléments graphique pour l'animation du personnage */
    protected ArrayList<Image> _animGraphics;
	
    protected Coordonnees _coordonnees;
	
    /**
     * Créer un personnage représentant un joueur.
     */
    public Personnage() {
        _coordonnees = new Coordonnees(0,9*facteurPrecision);
    }
    
    /**
     * Créer un personnage représentant un joueur, à l'emplacement passé en paramčtre.
     * @param pos
     */
    public Personnage(Coordonnees pos) {
        _coordonnees = new Coordonnees(pos.getX(), pos.getY());
    }

    /**
     *
     * @return les coordonnees
     */
    public Coordonnees getCoordonnes() {
		return _coordonnees;
	}

    /**
     * Permet de saisir les coordonnees
     * @param coordonnes
     */
    public void setCoordonnes(Coordonnees coordonnes) {
		this._coordonnees = coordonnes;
	}

    /**
     * 
     * @return the _displayGraphic
     */
    public Image get_displayGraphic() {
        return _displayGraphic;
    }
    /**
     * 
     * @param graphic the _displayGraphic to set
     */
    public void set_displayGraphic(Image graphic) {
        _displayGraphic = graphic;
    }
    /**
     * 
     * @return the _animGraphics
     */
    public ArrayList<Image> get_animGraphics() {
        return _animGraphics;
    }
    /**
     * 
     * @param graphics the _animGraphics to set
     */
    public void set_animGraphics(ArrayList<Image> graphics) {
        _animGraphics = graphics;
    }
    
    /**
     *
     * @return
     */
    public double getX(){
        return _coordonnees.getX();
    }
    
    /**
     *
     * @return
     */
    public double getY(){
        return _coordonnees.getY();
    }
    
 
    
}
