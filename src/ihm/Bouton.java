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
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;

/**
 *
 * @author Mathieu
 */
public class Bouton extends JButton implements MouseListener{
    private final String name;
    private Image img;
    private String couleur = "jaune";
    
    public Bouton(String str){
        super(str);
        this.name = str;
        try{
            img=ImageIO.read(new File("jaune.png"));
        }catch(IOException e){
        }
        this.addMouseListener(this);
    }

    @Override
    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;
        GradientPaint gp = new GradientPaint(0, 0, Color.blue, 0, 20, Color.cyan, true);
        g2d.setPaint(gp);
        g2d.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        g2d.setColor(Color.black);
        g2d.drawString(this.name, this.getWidth() / 2 -(this.getWidth()/2/4)+80, (this.getHeight()/2)+5);
    }
    
    @Override
    public void mouseExited(MouseEvent event) {
        if("jaune".equals(couleur)){
            try{
                img = ImageIO.read(new File("jaune.png"));
            }catch(IOException e){
            }
        }
        
    }
    
    @Override
    public void mouseClicked(MouseEvent event) {
        couleur = "vert";
        try{
            img = ImageIO.read(new File("vert.png"));
        }catch(IOException e){
        }
    }

    @Override
    public void mousePressed(MouseEvent event) {
        couleur = "vert";
        try{
            img = ImageIO.read(new File("vert.png"));
        }catch(IOException e){
        }
    }

    @Override
    public void mouseReleased(MouseEvent event) {
        if("jaune".equals(couleur)){
            try{
                img = ImageIO.read(new File("jaune.png"));
            }catch(IOException e){
            }
        }
        
    }

    @Override
    public void mouseEntered(MouseEvent event) {

        try{
            img = ImageIO.read(new File("vert.png"));
        }catch(IOException e){
        }
    }

    public void setCouleur(String c){
        couleur=c;
    }
    
}
