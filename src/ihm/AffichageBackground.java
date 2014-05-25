/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
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
