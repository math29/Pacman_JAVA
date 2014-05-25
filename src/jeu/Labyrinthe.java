/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeu;

import java.awt.Point;
import java.util.ArrayList;

/**
 *
 * @author Mathieu
 */
public class Labyrinthe {
    
    /* Taille du labyrinthe (forme carré) */
    public static final int _TAILLE = 10;

    /* ArrauList contenant les cases de notre labyrinthe */
    private ArrayList<ArrayList<Case>> _cases;
    
    /**
     * Carte de notre labyrinthe
     */
    private DifficulteCarte _carte;

    

    /*
     * Un état de jeu : si mis ŕ false, pacman peut maner les fantomes
     */
    private boolean _modeNormal;

    /**
     * Construit un labyrinthe. Créer les chemins (cases) et place les objets.
     */
    public Labyrinthe (DifficulteCarte carte) {
        /* Récupération de la description du niveau */
        this._carte = carte;
        creerCases();
        /* Etat par defaut ŕ true, le pacman se fait manger par les fantomes */
        _modeNormal = true;
    }

    /**
     * Créer les cases contenant les chemins du labyrinthe.
     */
    private void creerCases() {
        /* Préparation des cases. */
        _cases = new ArrayList<ArrayList<Case>>();
        Case caseTmp = null;
        /* Création des cases qui composent le labyrinthe en fonction de la carte du niveau demandé */
        for (int i = 0; i < _TAILLE; i++) {
            _cases.add(new ArrayList<Case>(_TAILLE));
            for (int j = 0; j < _TAILLE; j++) {
                caseTmp = new Case(_carte.getCarte().get(i).get(j) , new Point(i, j));
                caseTmp.addContenu();
                _cases.get(i).add(caseTmp);

            }
        }
    }

    public ArrayList<ArrayList<Case>> getCases() {
        return _cases;
    }

    public void setCases(ArrayList<ArrayList<Case>> _cases) {
        this._cases = _cases;
    }

    public DifficulteCarte getCarte() {
        return _carte;
    }

    public void setCarte(DifficulteCarte _carte) {
        this._carte = _carte;
    }

    public boolean isModeNormal() {
        return _modeNormal;
    }

    public void setModeNormal(boolean _modeNormal) {
        this._modeNormal = _modeNormal;
    }
}
