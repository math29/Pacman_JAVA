package jeu;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Jeu;

public class Joueur extends Personnage{
	private int score;
	private int vies;
	
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
            //Jeu.getInstance().exitGame();
        }
        super.set_displayGraphic(tmp_image.getScaledInstance(20, 20, Image.SCALE_FAST));
        
        /* Numérotation du joueur */
        //numJoueur = num;

    }
        
        public void mourrir(){
            this.setCoordonnes(new Coordonnees(0,0));
            vies--;
        }
        
	public void gagnePoint(int nbPoint){
		score+=nbPoint;
	}
	public void gagneVie(){
		vies+=1;
	}
	public void perdVie(){
		vies-=1;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getVies() {
		return vies;
	}
	public void setVies(int vies) {
		this.vies = vies;
	}

}
