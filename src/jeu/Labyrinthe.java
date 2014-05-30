package jeu;

import java.awt.Point;
import java.util.ArrayList;

/**
 * Classe de gestion du labyrinthe
 * @author Mathieu
 */
public class Labyrinthe {
    
    /* Taille du labyrinthe (forme carré) */
    public static final int _TAILLE = 10;

    /* ArrayList contenant les cases de notre labyrinthe */
    private ArrayList<ArrayList<Case>> _cases;
    
    /* Carte de notre labyrinthe */
    private DifficulteCarte _carte;

    /* Un état de jeu : si mis ŕ false, pacman peut maner les fantomes */
    private boolean _modeNormal;

    /**
     * Construit un labyrinthe. Créer les chemins (cases) et place les objets.
     * @param carte
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
        _cases = new ArrayList<>();
        Case caseTmp;
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

    /**
     * Retourne les cases du labyrinthe
     * @return
     */
    public ArrayList<ArrayList<Case>> getCases() {
        return _cases;
    }

    /**
     * Permet de saisir les cases du lab
     * @param _cases
     */
    public void setCases(ArrayList<ArrayList<Case>> _cases) {
        this._cases = _cases;
    }

    /**
     * Retourne la carte 
     * @return
     */
    public DifficulteCarte getCarte() {
        return _carte;
    }

    /**
     * Permet de choisir la carte
     * @param _carte
     */
    public void setCarte(DifficulteCarte _carte) {
        this._carte = _carte;
    }

    /**
     * Retourn 1 si le mode de jeu est normal actuellement
     * @return
     */
    public boolean isModeNormal() {
        return _modeNormal;
    }

    /**
     * Permet de changer le mode de jeu
     * @param _modeNormal
     */
    public void setModeNormal(boolean _modeNormal) {
        this._modeNormal = _modeNormal;
    }
}
