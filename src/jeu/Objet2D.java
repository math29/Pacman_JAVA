package jeu;

import java.awt.Image;
import java.awt.geom.Point2D;

/**
 * Ceci est la class abstracte de toutes les classes d'objets presents dans le labyrinthe
 * @author Mathieu
 */
public abstract  class Objet2D extends Point2D {
	private Image Im;
	
    /**
     * Retourne l'image de l'objet
     * @return
     */
    public Image getIm(){
		return Im;
	}
	
    /**
     * PErmet de saisir l'image de l'objet
     * @param Im
     */
    public void setIm(Image Im){
		this.Im=Im;
	}
}
