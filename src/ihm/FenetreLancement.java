/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm;

import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JWindow;

/**
 *
 * @author Mathieu
 */
public class FenetreLancement extends JWindow{
    
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
