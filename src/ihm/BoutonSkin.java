package ihm;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * Classe qui gère les boutons utilisés pour le choix des skins
 * @author Mathieu
 */
public class BoutonSkin extends JButton implements MouseListener{
    
    private Icon img;
    private final Image image;
    private final ImageObserver imageObserver;
    private String couleur = "white";
    
    /**
     * Constructeur a partir de l'image de chaque skin
     * @param img
     */
    public BoutonSkin(Image img){
        super();
        image = img;
        imageObserver = new ImageIcon(img).getImageObserver();
        this.addMouseListener(this);
    }
    
    @Override
    public void mouseExited(MouseEvent event) {
        if("white".equals(couleur)){
            this.setBorder(BorderFactory.createLineBorder(Color.white));
        }
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        couleur = "vert";
        this.setBorder(BorderFactory.createLineBorder(Color.green));
    }

    @Override
    public void mousePressed(MouseEvent event) {
        couleur = "vert";
        this.setBorder(BorderFactory.createLineBorder(Color.green));
    }

    @Override
    public void mouseEntered(MouseEvent event) {
        this.setBorder(BorderFactory.createLineBorder(Color.green));
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if("white".equals(couleur)){
            this.setBorder(BorderFactory.createLineBorder(Color.white));
        }
    }
    
    @Override
    public void paint( Graphics g ) {
            super.paint( g );
            g.drawImage(image,  0 , 0 , getWidth() , getHeight() , imageObserver);
        }
    
    /**
     * Défini la couleur de l'encadrement autour du skin actuellement
     * @param c
     */
    public void setCouleur(String c){
        couleur=c;
    }
    
}