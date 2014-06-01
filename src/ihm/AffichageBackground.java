package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Classe qui gère l'affichage du fond d'écran de nos fenetres de menus
 * @author Mathieu
 */
public class AffichageBackground extends JPanel{
    @Override
    public void paintComponent(Graphics g){
        try {
            Image img = ImageIO.read(new File("imageAccueil.jpg"));
            g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        } catch (IOException ex) {
            System.out.println("Erreur, l'image n'est pas chargeable");
        }
    }
}
