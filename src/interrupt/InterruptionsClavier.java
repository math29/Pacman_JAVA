/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package interrupt;

import GestionPersonnages.GestionFantome;
import ihm.AffichageJoueur;
import ihm.AffichageJoueur.Direction;
import ihm.AffichageLabyrinthe;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import jeu.Case;
import jeu.Coordonnees;
import jeu.Joueur;
import jeu.Personnage;

/**
 *
 * @author Mathieu
 */
public class InterruptionsClavier implements KeyListener {

    private Joueur _joueur;
    private AffichageLabyrinthe _affLab;
    private AffichageJoueur _affJoueur;
    private GestionFantome _gestionF;
    
    public InterruptionsClavier(Joueur joueur, AffichageLabyrinthe affLab){
        _joueur = joueur;
        _affLab = affLab;
    }

    @Override
    public void keyPressed(KeyEvent arg0) {
        Coordonnees coord = null;
        Case caseActuelle = null;
        _affJoueur = _affLab.getAfficheJoueur();
        
        
        caseActuelle = _affLab.getLab().getCases().get((int)_joueur.getY()/Personnage.facteurPrecision).get((int)_joueur.getX()/Personnage.facteurPrecision);
        switch (arg0.getKeyCode()) {
                
                case 39: /* DROITE */
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX()+1, (int)_joueur.getCoordonnes().getY());
                    _affJoueur.regarderVers(Direction.DROITE);
                    /* Si le mouvement est possible */
                    if (caseActuelle.mouvementPossible(coord)) {
                        _gestionF.setDirectionJoueur(Direction.DROITE);
                        
                    }
                    break;
                case 37: /* GAUCHE */
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX()-1, (int)_joueur.getCoordonnes().getY());
                    _affJoueur.regarderVers(Direction.GAUCHE);
                    /* Si le mouvement est possible */
                    if (caseActuelle.mouvementPossible(coord)) {
                        _gestionF.setDirectionJoueur(Direction.GAUCHE);
                    }
                    break;
                        
                case 38: /* HAUT */
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX(), (int)_joueur.getCoordonnes().getY()-1);
                    _affJoueur.regarderVers(Direction.HAUT);
                    /* Si le mouvement est possible */
                    if (caseActuelle.mouvementPossible(coord)) {
                        _gestionF.setDirectionJoueur(Direction.HAUT);
                        
                    }
                    break;
                case 40: /* BAS */
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX(), (int)_joueur.getCoordonnes().getY()+1);
                    _affJoueur.regarderVers(Direction.BAS);
                    /* Si le mouvement est possible */
                    if (caseActuelle.mouvementPossible(coord)) {
                        _gestionF.setDirectionJoueur(Direction.BAS);
                    }
                default:
                    break;
                }
    }

    @Override
    public void keyReleased(KeyEvent arg0) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyTyped(KeyEvent arg0) {
        ; //To change body of generated methods, choose Tools | Templates.
    }

    public void setgestionFantome(GestionFantome gestionF) {
        _gestionF=gestionF;
    }
}

   
