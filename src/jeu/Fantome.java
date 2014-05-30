package jeu;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.Jeu;

/**
 * Classe gérant nos fantomes, leur aspect, leurs vies ...
 * @author Mathieu
 */
public class Fantome extends Personnage{
        
    private boolean _enVie=false;
    private final String _skin;

    /**
     * Constructeur qui initialise un fantome à un lieu, réprésenté par son skin
     * @param coord
     * @param skin
     */
    public Fantome(Coordonnees coord, String skin) {
        super(coord);
        _skin = skin;
        _enVie=true;
        
        BufferedImage tmp_image = null;
        try {
            tmp_image = ImageIO.read(new File(_skin));
        } catch (IOException e) {
            System.err.println("L'image du fantome n'a pas été trouvée !");
            Jeu.getInstance().end();
        }
        super.set_displayGraphic(tmp_image.getScaledInstance(20, 20, Image.SCALE_FAST));

    }
    
    /**
     * Retourne 1 si le fantome est vivant, 0 sinon
     * @return
     */
    public boolean estVivant(){
        return _enVie;
    }
    
    /**
     * Tue le fantome
     */
    public void meurt(){
        _enVie = false;
    }
    
}
