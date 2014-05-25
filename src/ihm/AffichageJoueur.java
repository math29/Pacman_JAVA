/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
 *
 * @author Mathieu
 */
public class AffichageJoueur extends JPanel{
    
    private Joueur _joueur;
    private Dimension _resolution;
    public enum Direction {
        GAUCHE, DROITE, HAUT, BAS
    }
    private Direction _orientation;
    private Image _image;
    private double _rotation;
    
    
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

    public void rafraichir() {
        repaint();
    }

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

    public BufferedImage effetMirroir(BufferedImage theImage) {
        // Get an AffineTransform object that can be used to
        // shift the image to the right by an amount equal to
        // its width.
        AffineTransform transformObj = AffineTransform.getTranslateInstance(
                theImage.getWidth(), 0);

        // Concatenate this transform with a scaling
        // transformation.
        transformObj.scale(-1.0, 1.0);

        // Display the six values in the transformation matrix.
        double[] theMatrix = new double[6];
        transformObj.getMatrix(theMatrix);

        // Get a translation filter object based on the
        // AffineTransform object.
        AffineTransformOp filterObj = new AffineTransformOp(transformObj,
                AffineTransformOp.TYPE_BICUBIC);

        /*
         * Note: Normally, I would perform the filteringoperation and return the
         * filtered result simply byexecuting the following statement:
         *
         * return filterObj.filter(theImage, null);
         *
         * However, for reasons that I am unable to explain,when I do that for
         * the AffineTransformOp class, theColorModel of the BufferedImage
         * object that isreturned to the framework program named ImgMod05 isnot
         * compatible with the method used by that programto write the output
         * JPEG file. This results in anoutput file in which the image data
         * appears to bescrambled. Therefore, it was necessary for me touse the
         * following alternative code instead.
         */

        // Create a destination BufferedImage object to receive
        // the filtered image. Force the ColorModel of the
        // destination object to match the ColorModel of the
        // incoming object.
        BufferedImage dest = filterObj.createCompatibleDestImage(theImage,
                theImage.getColorModel());

        // Filter the image and save the filtered image in the
        // destination object.
        filterObj.filter(theImage, dest);

        // Return a reference to the destination object.
        return dest;

    }

    // This method returns a buffered image with the contents of an image
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
