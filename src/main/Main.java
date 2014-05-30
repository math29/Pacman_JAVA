package main;

import ihm.FenetreLancement;
import static java.lang.Thread.sleep;

/**
 *
 * @author Mathieu
 */
public class Main {

    /**
     *
     * @param args
     * @throws InterruptedException
     */
    public static void main(String[] args) throws InterruptedException {

		
        /* Image de lancement du jeu qui ne reste affichee qu'un certain temps*/
        FenetreLancement wind = new FenetreLancement();
        wind.setVisible(true);
        sleep(5000);
        wind.setVisible(false);
        
        /* On lance maintenant le jeu */
        Jeu.getInstance().run();
        }
        
}
