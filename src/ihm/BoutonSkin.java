/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.ImageObserver;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author Mathieu
 */
public class BoutonSkin extends JButton implements MouseListener{
    
    private Icon img;
    private Image image;
    private ImageObserver imageObserver;
    public BoutonSkin(Image img){
        super();
        image = img;
        imageObserver = new ImageIcon(img).getImageObserver();
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        
    }
    
    @Override
    public void mouseExited(MouseEvent event) {
        
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        
    }

    @Override
    public void mousePressed(MouseEvent event) {
        this.setBorder(BorderFactory.createLineBorder(Color.green));
    }

    @Override
    public void mouseEntered(MouseEvent event) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        
    }
    
    public void paint( Graphics g ) {
            super.paint( g );
            g.drawImage(image,  0 , 0 , getWidth() , getHeight() , imageObserver);
        }
    
}