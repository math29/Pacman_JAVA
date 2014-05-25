package main;

import ihm.FenetreLancement;
import static java.lang.Thread.sleep;

public class Main {
	public static void main(String[] args) throws InterruptedException {

		
        /* Image de lancement du jeu */
        FenetreLancement wind = new FenetreLancement();
        wind.setVisible(true);
        sleep(500);
        wind.setVisible(false);
        /* On lance la partie */
        Jeu.getInstance().run();
        }
        
}
