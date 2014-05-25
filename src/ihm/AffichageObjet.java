/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import jeu.Cerise;
import jeu.Objet2D;
import jeu.PieceOr;

/**
 *
 * @author Mathieu
 */
public class AffichageObjet extends JPanel {
    
    private Objet2D _objet;
    
    public AffichageObjet(Objet2D objet) {
        _objet = objet;

        setLayout(null);
        setVisible(true);
    }


    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // On dessine la classe mčre

        if(_objet instanceof PieceOr)
        {
            g.setColor(Color.YELLOW);
        }
        else if (_objet instanceof Cerise)
        {
            g.setColor(Color.RED);
        }

        g.fillRect(0, 0, 5, 5);


    }
}
