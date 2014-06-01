package ihm;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import jeu.Case;
import main.Jeu;

/**
 * Classe qui gère l'affichage des cases
 * @author Mathieu
 */
public final class AffichageCase extends JPanel{
    
    private final Case _case;
    private double _rotationImage;
    private AffichageObjet AObj;
    private final Dimension _dim;
    private final Point _pointImage;
    private Image _im;
    AffichageObjet _AObj;
    
    /**
     * Créera l'objet permettant de dessiner une case.
     * @param c
     */
    public AffichageCase(Case c) {
        super();

        this._case = c;

        _pointImage = new Point();
        _rotationImage = 0.;
        _dim = new Dimension(50, 50);
        
        _AObj = new AffichageObjet(_case.getContenu().get(0));
        
        setBackground(Color.RED);

        setLayout(null);
        setVisible(true);
        setPreferredSize(_dim);

        calculImage();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g); // On dessine la classe mčre
        ((Graphics2D)g).rotate(_rotationImage * Math.PI / 180.0, 25, 25); // On effectue les rotations nécessaires
        /* On dessine :
         *  - A partir de l'image des cases
         *  - Dans un rectangle de taille 50px par 50px (coin supérieur gauche en 0,0 et inférieur droit en 50,50)
         *  - La portion de l'image de la case dont le coin supérieur gauche est en _pointImage.x,_pointImage.y
         *  - Et dont le coin inférieur droit est 50px plus bas et 50px ŕ droite
         *  - Dans le contexte de la Vue.
         *
         */

        //_viewObj = new VueObjet();
        //this.add(_viewObj);
        g.drawImage(_im, 0, 0, 50, 50, _pointImage.x, _pointImage.y, _pointImage.x + 50, _pointImage.y + 50, this);
    }
    
    /**
     * Calcul l'image qui sera affichée pour cette case.
     */
    public void calculImage() {
        BufferedImage tmp_image = null;
        try {
            tmp_image = ImageIO.read(new File("mini_case.png"));
        } catch (IOException e) {
            System.err.println("L'image du skin n'a pas été trouvée !");
            Jeu.getInstance().end();
        }

        switch (_case.getType()) {
        /* Coude */
        case ANGLE_BAS_GAUCHE:
            _pointImage.x = 100;
            _pointImage.y = 50;
            break;
        case ANGLE_HAUT_GAUCHE:
            _pointImage.x = 0;
            _pointImage.y = 50;

            _rotationImage = 180.;
            break;
        case ANGLE_BAS_DROIT:
            _pointImage.x = 0;
            _pointImage.y = 50;
            break;
        case ANGLE_HAUT_DROIT:
            _pointImage.x = 100;
            _pointImage.y = 50;

            _rotationImage = 180.;
            break;

        /* Classique */
        case HORIZONTALE:
            _pointImage.x = _pointImage.y = 0;

            _rotationImage = 90.;
            break;
        case VERTICALE:
            _pointImage.x = _pointImage.y = 0;
            break;

        /* Croix */
        case CROIX:
            _pointImage.x = 50;
            _pointImage.y = 50;
            break;

        /* T */
        case T_NORMAL:
            _pointImage.x = 50;
            _pointImage.y = 0;
            break;
        case T_DROITE:
            _pointImage.x = 50;
            _pointImage.y = 0;

            _rotationImage = 270.;
            break;
        case T_GAUCHE:
            _pointImage.x = 50;
            _pointImage.y = 0;

            _rotationImage = 90.;
            break;
        case T_INVERSE:
            _pointImage.x = 50;
            _pointImage.y = 0;

            _rotationImage = 180.;
            break;
        }

        _im = tmp_image.getScaledInstance(tmp_image.getWidth(), tmp_image.getHeight(), Image.SCALE_FAST);
    }
}
