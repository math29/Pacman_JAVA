package jeu;

import java.util.ArrayList;
import jeu.Case.Type;

/**
 * Classe qui va nous permettre de dessiner la carte de notre labyrinthe
 * @author Mathieu
 */
public final class DifficulteCarte {
    /**
     * Nous avons ici les 3 cartes différentes classées par difficulté
     */
    public enum Niveau {
        FACILE, MOYEN, DIFFICILE
    }
    
    private Niveau _niv;
    private ArrayList<ArrayList<Type>> _carte;
    
    /**
     * Constructeur qui, par défault, nous met la carte facile (pratique pour les tests)
     */
    public DifficulteCarte() {
        this._niv = Niveau.FACILE;
        this._carte = carteFacile();
    }
    
    /**
     * Créer un nouveau niveau en fonction du niveau demandé
     * @param niv
     */
    public DifficulteCarte(Niveau niv) {
        this._niv = niv;
        switch (_niv) {
        case FACILE:
            this._carte = carteFacile();
            break;
        default: case MOYEN:
            this._carte = carteMoyen();
            break;
        case DIFFICILE:
            this._carte = carteDifficile();
            break;
        }
    }

    /**
     * Une descritption d'un niveau facile.
     * @return 
     */
    public ArrayList<ArrayList<Type>> carteMoyen() {
        ArrayList<ArrayList<Type>> descMoyen = new ArrayList<>();

        /* LIGNE 1 on va de bas en haut*/
            ArrayList<Type> ligne_1 = new ArrayList<>();
                ligne_1.add(Type.ANGLE_BAS_GAUCHE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.T_INVERSE);
                ligne_1.add(Type.T_INVERSE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 2 */
            ArrayList<Type> ligne_2 = new ArrayList<>();
                ligne_2.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_2.add(Type.T_INVERSE);
                ligne_2.add(Type.ANGLE_BAS_DROIT);
                ligne_2.add(Type.ANGLE_BAS_GAUCHE);
                ligne_2.add(Type.ANGLE_HAUT_DROIT);
                ligne_2.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_2.add(Type.ANGLE_BAS_DROIT);
                ligne_2.add(Type.ANGLE_BAS_GAUCHE);
                ligne_2.add(Type.T_INVERSE);
                ligne_2.add(Type.ANGLE_HAUT_DROIT);
        /* LIGNE 3 */
            ArrayList<Type> ligne_3 = new ArrayList<>();
                ligne_3.add(Type.ANGLE_BAS_GAUCHE);
                ligne_3.add(Type.ANGLE_HAUT_DROIT);
                ligne_3.add(Type.T_DROITE);
                ligne_3.add(Type.T_NORMAL);
                ligne_3.add(Type.T_INVERSE);
                ligne_3.add(Type.T_INVERSE);
                ligne_3.add(Type.T_NORMAL);
                ligne_3.add(Type.T_GAUCHE);
                ligne_3.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_3.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 4 */
            ArrayList<Type> ligne_4 = new ArrayList<>();
                ligne_4.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.CROIX);
                ligne_4.add(Type.T_INVERSE);
                ligne_4.add(Type.ANGLE_HAUT_DROIT);
                ligne_4.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_4.add(Type.T_INVERSE);
                ligne_4.add(Type.CROIX);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.ANGLE_HAUT_DROIT);
        /* LIGNE 5 */
            ArrayList<Type> ligne_5 = new ArrayList<>();
                ligne_5.add(Type.ANGLE_BAS_GAUCHE);
                ligne_5.add(Type.HORIZONTALE);
                ligne_5.add(Type.T_GAUCHE);
                ligne_5.add(Type.T_DROITE);
                ligne_5.add(Type.HORIZONTALE);
                ligne_5.add(Type.HORIZONTALE);
                ligne_5.add(Type.T_GAUCHE);
                ligne_5.add(Type.T_DROITE);
                ligne_5.add(Type.HORIZONTALE);
                ligne_5.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 6 */
            ArrayList<Type> ligne_6 = new ArrayList<>();
                ligne_6.add(Type.T_DROITE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.CROIX);
                ligne_6.add(Type.T_GAUCHE);
                ligne_6.add(Type.ANGLE_BAS_GAUCHE);
                ligne_6.add(Type.ANGLE_BAS_DROIT);
                ligne_6.add(Type.T_DROITE);
                ligne_6.add(Type.CROIX);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.T_GAUCHE);
        /* LIGNE 7 */
            ArrayList<Type> ligne_7 = new ArrayList<>();
                ligne_7.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.T_GAUCHE);
                ligne_7.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_7.add(Type.CROIX);
                ligne_7.add(Type.CROIX);
                ligne_7.add(Type.ANGLE_HAUT_DROIT);
                ligne_7.add(Type.T_DROITE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.ANGLE_HAUT_DROIT);
        /* LIGNE 8 */
            ArrayList<Type> ligne_8 = new ArrayList<>();
                ligne_8.add(Type.ANGLE_BAS_GAUCHE);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.T_GAUCHE);
                ligne_8.add(Type.ANGLE_BAS_GAUCHE);
                ligne_8.add(Type.ANGLE_HAUT_DROIT);
                ligne_8.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_8.add(Type.ANGLE_BAS_DROIT);
                ligne_8.add(Type.T_DROITE);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 9 */
            ArrayList<Type> ligne_9 = new ArrayList<>();
                ligne_9.add(Type.T_DROITE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.CROIX);
                ligne_9.add(Type.T_NORMAL);
                ligne_9.add(Type.T_INVERSE);
                ligne_9.add(Type.T_INVERSE);
                ligne_9.add(Type.T_NORMAL);
                ligne_9.add(Type.CROIX);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.T_GAUCHE);
        /* LIGNE 10 */
            ArrayList<Type> ligne_10 = new ArrayList<>();
                ligne_10.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.T_NORMAL);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.ANGLE_HAUT_DROIT);
                ligne_10.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.T_NORMAL);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.ANGLE_HAUT_DROIT);

        descMoyen.add(ligne_10);
        descMoyen.add(ligne_9);
        descMoyen.add(ligne_8);
        descMoyen.add(ligne_7);
        descMoyen.add(ligne_6);
        descMoyen.add(ligne_5);
        descMoyen.add(ligne_4);
        descMoyen.add(ligne_3);
        descMoyen.add(ligne_2);
        descMoyen.add(ligne_1);

        return descMoyen;
    }

    /**
     * Retourne le niveau actuellement choisit
     * @return
     */
    public Niveau getNiv() {
        return _niv;
    }

    /**
     * Permet de choisir un niveau
     * @param _niv
     */
    public void setNiv(Niveau _niv) {
        this._niv = _niv;
    }

    /**
     * Retourne la carte
     * @return
     */
    public ArrayList<ArrayList<Type>> getCarte() {
        return _carte;
    }

    /**
     * Permet de mettre une carte
     * @param _carte
     */
    public void setCarte(ArrayList<ArrayList<Type>> _carte) {
        this._carte = _carte;
    }
    
    /**
     * Une descritption d'un niveau moyen.
     * @return 
     */
    public ArrayList<ArrayList<Type>> carteFacile() {
           	ArrayList<ArrayList<Type>> descFacile = new ArrayList<>();

        /* LIGNE 1 on va de bas en haut*/
            ArrayList<Type> ligne_1 = new ArrayList<>();
                ligne_1.add(Type.ANGLE_BAS_GAUCHE);
                ligne_1.add(Type.T_INVERSE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 2 */
            ArrayList<Type> ligne_2 = new ArrayList<>();
                ligne_2.add(Type.VERTICALE);
                ligne_2.add(Type.VERTICALE);
                ligne_2.add(Type.ANGLE_BAS_GAUCHE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.ANGLE_BAS_DROIT);
                ligne_2.add(Type.ANGLE_BAS_GAUCHE);
                ligne_2.add(Type.T_INVERSE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.ANGLE_BAS_DROIT);
                ligne_2.add(Type.VERTICALE);
        /* LIGNE 3 */
            ArrayList<Type> ligne_3 = new ArrayList<>();
                ligne_3.add(Type.T_DROITE);
                ligne_3.add(Type.CROIX);
                ligne_3.add(Type.T_NORMAL);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.ANGLE_HAUT_DROIT);
                ligne_3.add(Type.VERTICALE);
                ligne_3.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.T_NORMAL);
                ligne_3.add(Type.T_GAUCHE);
        /* LIGNE 4 */
            ArrayList<Type> ligne_4 = new ArrayList<>();
                ligne_4.add(Type.VERTICALE);
                ligne_4.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_4.add(Type.ANGLE_BAS_DROIT);
                ligne_4.add(Type.ANGLE_BAS_GAUCHE);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.T_NORMAL);
                ligne_4.add(Type.ANGLE_BAS_DROIT);
                ligne_4.add(Type.ANGLE_BAS_GAUCHE);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.ANGLE_HAUT_DROIT);
        /* LIGNE 5 */
            ArrayList<Type> ligne_5 = new ArrayList<>();
            	ligne_5.add(Type.ANGLE_HAUT_GAUCHE);
            	ligne_5.add(Type.HORIZONTALE);
            	ligne_5.add(Type.T_GAUCHE);
            	ligne_5.add(Type.VERTICALE);
            	ligne_5.add(Type.ANGLE_BAS_GAUCHE);
            	ligne_5.add(Type.HORIZONTALE);
            	ligne_5.add(Type.ANGLE_HAUT_DROIT);
            	ligne_5.add(Type.ANGLE_HAUT_GAUCHE);
            	ligne_5.add(Type.HORIZONTALE);
            	ligne_5.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 6 */
            ArrayList<Type> ligne_6 = new ArrayList<>();
                ligne_6.add(Type.ANGLE_BAS_GAUCHE);
                ligne_6.add(Type.ANGLE_BAS_DROIT);
                ligne_6.add(Type.VERTICALE);
                ligne_6.add(Type.VERTICALE);
                ligne_6.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.T_GAUCHE);
        /* LIGNE 7 */
            ArrayList<Type> ligne_7 = new ArrayList<>();
                ligne_7.add(Type.VERTICALE);
                ligne_7.add(Type.VERTICALE);
                ligne_7.add(Type.T_DROITE);
                ligne_7.add(Type.CROIX);
                ligne_7.add(Type.T_INVERSE);
                ligne_7.add(Type.ANGLE_BAS_DROIT);
                ligne_7.add(Type.ANGLE_BAS_GAUCHE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.T_GAUCHE);
        /* LIGNE 8 */
            ArrayList<Type> ligne_8 = new ArrayList<>();
                ligne_8.add(Type.VERTICALE);
                ligne_8.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_8.add(Type.CROIX);
                ligne_8.add(Type.T_GAUCHE);
                ligne_8.add(Type.VERTICALE);
                ligne_8.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_8.add(Type.CROIX);
                ligne_8.add(Type.T_INVERSE);
                ligne_8.add(Type.T_INVERSE);
                ligne_8.add(Type.T_GAUCHE);
        /* LIGNE 9 */
            ArrayList<Type> ligne_9 = new ArrayList<>();
                ligne_9.add(Type.T_DROITE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.CROIX);
                ligne_9.add(Type.ANGLE_HAUT_DROIT);
                ligne_9.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.T_NORMAL);
                ligne_9.add(Type.ANGLE_HAUT_DROIT);
                ligne_9.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_9.add(Type.T_GAUCHE);
        /* LIGNE 10 */
            ArrayList<Type> ligne_10 = new ArrayList<>();
                ligne_10.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.T_NORMAL);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.ANGLE_HAUT_DROIT);

        descFacile.add(ligne_10);
        descFacile.add(ligne_9);
        descFacile.add(ligne_8);
        descFacile.add(ligne_7);
        descFacile.add(ligne_6);
        descFacile.add(ligne_5);
        descFacile.add(ligne_4);
        descFacile.add(ligne_3);
        descFacile.add(ligne_2);
        descFacile.add(ligne_1);

        return descFacile;
    }

    /**
     * Une descritption d'un niveau difficile.
     * @return 
     */
    public ArrayList<ArrayList<Type>> carteDifficile() {
        ArrayList<ArrayList<Type>> descDifficile = new ArrayList<>();

        /* LIGNE 1 on va de bas en haut*/
            ArrayList<Type> ligne_1 = new ArrayList<>();
                ligne_1.add(Type.ANGLE_BAS_GAUCHE);
                ligne_1.add(Type.T_INVERSE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.HORIZONTALE);
                ligne_1.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 2 */
            ArrayList<Type> ligne_2 = new ArrayList<>();
                ligne_2.add(Type.VERTICALE);
                ligne_2.add(Type.T_DROITE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.HORIZONTALE);
                ligne_2.add(Type.T_GAUCHE);
        /* LIGNE 3 */
            ArrayList<Type> ligne_3 = new ArrayList<>();
                ligne_3.add(Type.VERTICALE);
                ligne_3.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.HORIZONTALE);
                ligne_3.add(Type.ANGLE_HAUT_DROIT);
        /* LIGNE 4 */
            ArrayList<Type> ligne_4 = new ArrayList<>();
                ligne_4.add(Type.VERTICALE);
                ligne_4.add(Type.ANGLE_BAS_GAUCHE);
                ligne_4.add(Type.T_INVERSE);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.HORIZONTALE);
                ligne_4.add(Type.T_INVERSE);
                ligne_4.add(Type.T_INVERSE);
                ligne_4.add(Type.T_INVERSE);
                ligne_4.add(Type.ANGLE_BAS_DROIT);
        /* LIGNE 5 */
            ArrayList<Type> ligne_5 = new ArrayList<>();
            	ligne_5.add(Type.VERTICALE);
            	ligne_5.add(Type.VERTICALE);
            	ligne_5.add(Type.ANGLE_HAUT_GAUCHE);
            	ligne_5.add(Type.HORIZONTALE);
            	ligne_5.add(Type.HORIZONTALE);
            	ligne_5.add(Type.HORIZONTALE);
            	ligne_5.add(Type.ANGLE_HAUT_DROIT);
            	ligne_5.add(Type.VERTICALE);
            	ligne_5.add(Type.VERTICALE);
            	ligne_5.add(Type.VERTICALE);
        /* LIGNE 6 */
            ArrayList<Type> ligne_6 = new ArrayList<>();
                ligne_6.add(Type.VERTICALE);
                ligne_6.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_6.add(Type.T_INVERSE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.HORIZONTALE);
                ligne_6.add(Type.ANGLE_HAUT_DROIT);
                ligne_6.add(Type.VERTICALE);
                ligne_6.add(Type.VERTICALE);
        /* LIGNE 7 */
            ArrayList<Type> ligne_7 = new ArrayList<>();
                ligne_7.add(Type.VERTICALE);
                ligne_7.add(Type.ANGLE_BAS_GAUCHE);
                ligne_7.add(Type.CROIX);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.T_INVERSE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.HORIZONTALE);
                ligne_7.add(Type.ANGLE_HAUT_DROIT);
                ligne_7.add(Type.VERTICALE);
        /* LIGNE 8 */
            ArrayList<Type> ligne_8 = new ArrayList<>();
                ligne_8.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_8.add(Type.T_NORMAL);
                ligne_8.add(Type.CROIX);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.T_NORMAL);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.HORIZONTALE);
                ligne_8.add(Type.T_GAUCHE);
        /* LIGNE 9 */
            ArrayList<Type> ligne_9 = new ArrayList<>();
                ligne_9.add(Type.ANGLE_BAS_GAUCHE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.T_NORMAL);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.HORIZONTALE);
                ligne_9.add(Type.T_GAUCHE);
        /* LIGNE 10 */
            ArrayList<Type> ligne_10 = new ArrayList<>();
                ligne_10.add(Type.ANGLE_HAUT_GAUCHE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.HORIZONTALE);
                ligne_10.add(Type.ANGLE_HAUT_DROIT);

        descDifficile.add(ligne_10);
        descDifficile.add(ligne_9);
        descDifficile.add(ligne_8);
        descDifficile.add(ligne_7);
        descDifficile.add(ligne_6);
        descDifficile.add(ligne_5);
        descDifficile.add(ligne_4);
        descDifficile.add(ligne_3);
        descDifficile.add(ligne_2);
        descDifficile.add(ligne_1);

        return descDifficile;
    }
    
}
