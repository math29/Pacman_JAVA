/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeu;

import java.util.ArrayList;
import jeu.Case.Type;

/**
 *
 * @author Mathieu
 */
public class DifficulteCarte {
    /**
     * Il existe différent type de difficulté de niveau, déterminée empiriquement par le créateur du niveau.
     */
    public enum Niveau {
        FACILE, MOYEN, DIFFICILE
    }
    /**
     * Un niveau a une difficulté.
     */
    private Niveau _niv;
    /**
     * Un niveau a une description des cases qui le compose.
     */
    private ArrayList<ArrayList<Type>> _carte;

    /**
     * Créer un nouveau descripteur de niveau dans la difficulté MOYEN.
     */
    public DifficulteCarte() {
        this._niv = _niv.FACILE;
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
     *         Une descritption d'un niveau facile.
     */
    public ArrayList<ArrayList<Type>> carteFacile() {
        ArrayList<ArrayList<Type>> descMoyen = new ArrayList<ArrayList<Type>>();

        /* LIGNE 1 on va de bas en haut*/
            ArrayList<Type> ligne_1 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_2 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_3 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_4 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_5 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_6 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_7 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_8 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_9 = new ArrayList<Type>();
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
            ArrayList<Type> ligne_10 = new ArrayList<Type>();
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

    public Niveau getNiv() {
        return _niv;
    }

    public void setNiv(Niveau _niv) {
        this._niv = _niv;
    }

    public ArrayList<ArrayList<Type>> getCarte() {
        return _carte;
    }

    public void setCarte(ArrayList<ArrayList<Type>> _carte) {
        this._carte = _carte;
    }
    
    /**
     *         Une descritption d'un niveau moyen.
     */
    public ArrayList<ArrayList<Type>> carteMoyen() {
        return carteFacile();
    }

    /**
     *         Une descritption d'un niveau difficile.
     */
    public ArrayList<ArrayList<Type>> carteDifficile() {
        return carteMoyen();
    }
    
}
