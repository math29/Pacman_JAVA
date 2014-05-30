package jeu;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Jeu;

/**
 * Classe de gestion de notre joueur (ses vies, ses points ...)
 * @author Mathieu
 */
public class Joueur extends Personnage{
	private int score;
	private int vies;
	
    /**
     * Constructeur qui initialise un personnage a un lieu et avec un skin
     * @param coord
     * @param skin
     */
    public Joueur(Coordonnees coord, String skin) {
        super(coord);
        score = 0;
        vies = 3;
        
        BufferedImage tmp_image = null;
        try {
            tmp_image = ImageIO.read(new File(skin));
        } catch (IOException e) {
            System.err.println("L'image du pacman n'a pas été trouvée !");
            Jeu.getInstance().end();
        }
        super.set_displayGraphic(tmp_image.getScaledInstance(20, 20, Image.SCALE_FAST));
    }
        
    /**
     * Permet de tuer le personnage
     */
    public void mourrir(){
            this.setCoordonnes(new Coordonnees(0,0));
            vies--;
        }
        
    /**
     * gagne nbPoints
     * @param nbPoint
     */
    public void gagnePoint(int nbPoint){
		score+=nbPoint;
	}

    /**
     * Le perso gagne une vie
     */
    public void gagneVie(){
		vies+=1;
	}

    /**
     * Le perso Perd une vie
     */
    public void perdVie(){
		vies-=1;
	}
	
    /**
     * Retourne le score du personnage
     * @return
     */
    public int getScore() {
		return score;
	}

    /**
     * Permet de changer le score du personnage
     * @param score
     */
    public void setScore(int score) {
		this.score = score;
	}

    /**
     * Retourne les vies du personnage
     * @return
     */
    public int getVies() {
		return vies;
	}

    /**
     * Permet de changer le nombre de vies du perso
     * @param vies
     */
    public void setVies(int vies) {
		this.vies = vies;
	}

}
