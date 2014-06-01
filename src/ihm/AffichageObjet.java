package ihm;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import jeu.Objet2D;
import jeu.PieceOr;

/**
 * Classe qui gère l'affichage des objets sur le labyrinthe
 * @author Mathieu
 */
public class AffichageObjet extends JPanel {
    
    private final Objet2D _objet;
    
    /**
     * Constructeur de cette classe a partir de l'objet a afficher
     * @param objet
     */
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

        g.fillRect(0, 0, 5, 5);


    }
}
