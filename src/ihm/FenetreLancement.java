package ihm;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 * JWindows qui gère l'affichage de l'image au lancement du jeu
 * @author Mathieu
 */
public class FenetreLancement extends JWindow{
    
    /**
     * Constructeur de la classe avec définition des paramètres de l'image et de la fenetre ...
     */
    public FenetreLancement(){
        setSize(800, 600);
        setLocationRelativeTo(null);
        JPanel pan = new JPanel();
        JLabel img = new JLabel(new ImageIcon("imageLancement.jpeg"));
        img.setVerticalAlignment(JLabel.CENTER);
        img.setHorizontalAlignment(JLabel.CENTER);
        img.setBorder(BorderFactory.createLineBorder(Color.blue));
        pan.add(img);
        getContentPane().add(pan);
    }
}
