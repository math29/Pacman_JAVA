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
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import jeu.Fantome;

/**
 *
 * @author Mathieu
 */
public class AffichageFantome extends JPanel{
    private final Fantome _fantome;
    private final Dimension _resolution;
    private final Image _image;
    private double _rotation;
    
    
    public AffichageFantome(Fantome fantome) {
        _fantome = fantome;
        _resolution = new Dimension(20,20);
        /* Insertion de l'image du PACMAN */
        BufferedImage buff_img = toBufferedImage(_fantome.get_displayGraphic());
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
