package ihm;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import jeu.Joueur;

/**
 * Classe qui gère l'affichage du joueur
 * @author Mathieu
 */
public final class AffichageJoueur extends JPanel{
    
    private final Joueur _joueur;
    private final Dimension _resolution;

    /**
     * Définit la direction acutelle du joueur
     */
    public enum Direction {
        GAUCHE, DROITE, HAUT, BAS
    }
    private Direction _orientation;
    private Image _image;
    private double _rotation;
    
    /**
     * Constructeur de la classe à partir du joueur
     * @param joueur
     */
    public AffichageJoueur(Joueur joueur) {
        _joueur = joueur;
        _resolution = new Dimension(20,20);
        _orientation=Direction.DROITE;
        regarderVers(_orientation);
        /* Insertion de l'image du PACMAN */
        BufferedImage buff_img = toBufferedImage(joueur.get_displayGraphic());
        _image = buff_img.getScaledInstance(_resolution.width, _resolution.height, Image.SCALE_FAST);

        setLayout(null);
        setVisible(true);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (_image != null) {
            // On effectue les rotations nécessaires
            ((Graphics2D)g).rotate(    _rotation * Math.PI / 180.0,
                                    _resolution.width / 2,
                                    _resolution.height / 2);
            g.drawImage(_image,
                        0, 0, _resolution.width, _resolution.height,
                        0, 0, _resolution.width, _resolution.height,
                        this);
        }
    }

    /**
     * Repaint le joueur
     */
    public void rafraichir() {
        repaint();
    }

    /**
     * Gère le direction vers laquelle va le joueur (image) : n'est pas encore très au point
     * @param dir
     */
    public void regarderVers(Direction dir) {
            BufferedImage buff_img = toBufferedImage(_joueur.get_displayGraphic());
            if (dir != _orientation) {
                _orientation = dir;
                switch (dir) {
                case GAUCHE:
                    buff_img = effetMirroir(buff_img);
                    break;
                case DROITE:
                    buff_img = effetMirroir(buff_img);
                    break;
                case HAUT:
                    _rotation = -90;
                    break;
                case BAS:
                    _rotation = 90;
                    break;
                default:
                    break;
                }
                _image = buff_img.getScaledInstance(_resolution.width, _resolution.height, Image.SCALE_FAST);
            }
    }

    /**
     * Lié à la direction prise, permet d'inverser l'image 
     * @param theImage
     * @return
     */
    public BufferedImage effetMirroir(BufferedImage theImage) {

        AffineTransform transformObj = AffineTransform.getTranslateInstance(
                theImage.getWidth(), 0);

        transformObj.scale(-1.0, 1.0);

        double[] theMatrix = new double[6];
        transformObj.getMatrix(theMatrix);

        AffineTransformOp filterObj = new AffineTransformOp(transformObj,
                AffineTransformOp.TYPE_BICUBIC);

        BufferedImage dest = filterObj.createCompatibleDestImage(theImage,
                theImage.getColorModel());


        filterObj.filter(theImage, dest);

        return dest;

    }

    /**
     * Gère le chargement de l'image pour pouvoir la réutiliser par la suite
     * @param image
     * @return
     */
    public static BufferedImage toBufferedImage(Image image) {
        if (image instanceof BufferedImage) {
            return (BufferedImage) image;
        }

        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();

        // Determine if the image has transparent pixels; for this method's
        // implementation, see Determining If an Image Has Transparent Pixels
        boolean hasAlpha = false;

        // Create a buffered image with a format that's compatible with the
        // screen
        BufferedImage bimage = null;
        GraphicsEnvironment ge = GraphicsEnvironment
                .getLocalGraphicsEnvironment();
        try {
            // Determine the type of transparency of the new buffered image
            int transparency = Transparency.OPAQUE;
            if (hasAlpha) {
                transparency = Transparency.BITMASK;
            }

            // Create the buffered image
            GraphicsDevice gs = ge.getDefaultScreenDevice();
            GraphicsConfiguration gc = gs.getDefaultConfiguration();
            bimage = gc.createCompatibleImage(image.getWidth(null), image
                    .getHeight(null), transparency);
        } catch (HeadlessException e) {
            // The system does not have a screen
        }

        if (bimage == null) {
            // Create a buffered image using the default color model
            int type = BufferedImage.TYPE_INT_RGB;
            if (hasAlpha) {
                type = BufferedImage.TYPE_INT_ARGB;
            }
            bimage = new BufferedImage(image.getWidth(null), image
                    .getHeight(null), type);
        }

        // Copy image to buffered image
        Graphics g = bimage.createGraphics();

        // Paint the image onto the buffered image
        g.drawImage(image, 0, 0, null);
        g.dispose();

        return bimage;
    }
}
