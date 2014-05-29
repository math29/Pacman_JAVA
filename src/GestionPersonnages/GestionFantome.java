/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package GestionPersonnages;

import ihm.AffichageJoueur;
import ihm.AffichageJoueur.Direction;
import ihm.AffichageLabyrinthe;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import jeu.Case;
import jeu.Coordonnees;
import jeu.Fantome;
import jeu.Joueur;
import jeu.Personnage;
import main.Jeu;

/**
 *
 * @author Mathieu
 */
public class GestionFantome extends Thread{
    private Fantome _fantome1;
    private Fantome _fantome2;
    private Fantome _fantome3;
    private boolean mouvementFait;
    private AffichageLabyrinthe _affLab;
 
    private Direction _directionF1;
    private Direction _directionF2;
    private Direction _directionF3;
    
    private Direction _DirectionJoueur;
    private Joueur _joueur;
    private AffichageJoueur _affJoueur;
    private Jeu _jeu ;
    private int _rapidite;
    
    public GestionFantome(Jeu jeu, Fantome fantome1, Fantome fantome2,Fantome fantome3, AffichageLabyrinthe afficheLab, Joueur joueur, AffichageJoueur affJoueur, int r){
        _fantome1 = fantome1;
        _fantome2 = fantome2;
        _fantome3 = fantome3;
        _affLab = afficheLab;
        _joueur = joueur;
        _affJoueur = affJoueur;
        _jeu = jeu;
        _rapidite = r;
    }
    
    public void run() {
        Coordonnees coord = null;
        Coordonnees coordF2 = null;
        Coordonnees coordF3 = null;
        
        Case caseActuelleF1 = null;
        Case caseActuelleF2 = null;
        Case caseActuelleF3 = null;
        
        Case caseActuelleJoueur = null;
        _directionF1=Direction.HAUT;
        _directionF2=Direction.HAUT;
        _directionF3=Direction.HAUT;
        _DirectionJoueur=Direction.HAUT;
        int choixChemin=1;
        GregorianCalendar d = new GregorianCalendar();
        Random rand = new Random(d.get(Calendar.SECOND));
        while(true){
            
        while(true){
            caseActuelleF1 = _affLab.getLab().getCases().get((int)_fantome1.getY()/Personnage.facteurPrecision).get((int)_fantome1.getX()/Personnage.facteurPrecision);
            caseActuelleF2 = _affLab.getLab().getCases().get((int)_fantome2.getY()/Personnage.facteurPrecision).get((int)_fantome2.getX()/Personnage.facteurPrecision);
            caseActuelleF3 = _affLab.getLab().getCases().get((int)_fantome3.getY()/Personnage.facteurPrecision).get((int)_fantome3.getX()/Personnage.facteurPrecision);
            caseActuelleJoueur = _affLab.getLab().getCases().get((int)_joueur.getY()/Personnage.facteurPrecision).get((int)_joueur.getX()/Personnage.facteurPrecision);
                    
        /* Test pour continuer dans la meme direction */
        switch(_directionF1){
            
            case HAUT :
                coord = new Coordonnees((int)_fantome1.getCoordonnes().getX(), (int)_fantome1.getCoordonnes().getY()+1);
                break;
            case BAS :
                coord = new Coordonnees((int)_fantome1.getCoordonnes().getX(), (int)_fantome1.getCoordonnes().getY()-1);
                break;
            case GAUCHE :
                coord = new Coordonnees((int)_fantome1.getCoordonnes().getX()-1, (int)_fantome1.getCoordonnes().getY());
                break;
            case DROITE :
                coord = new Coordonnees((int)_fantome1.getCoordonnes().getX()+1, (int)_fantome1.getCoordonnes().getY());
                break;
        }
        
        switch(_directionF2){
            
            case HAUT :
                coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX(), (int)_fantome2.getCoordonnes().getY()+1);
                break;
            case BAS :
                coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX(), (int)_fantome2.getCoordonnes().getY()-1);
                break;
            case GAUCHE :
                coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX()-1, (int)_fantome2.getCoordonnes().getY());
                break;
            case DROITE :
                coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX()+1, (int)_fantome2.getCoordonnes().getY());
                break;
        }
        
        switch(_directionF3){
            
            case HAUT :
                coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX(), (int)_fantome3.getCoordonnes().getY()+1);
                break;
            case BAS :
                coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX(), (int)_fantome3.getCoordonnes().getY()-1);
                break;
            case GAUCHE :
                coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX()-1, (int)_fantome3.getCoordonnes().getY());
                break;
            case DROITE :
                coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX()+1, (int)_fantome3.getCoordonnes().getY());
                break;
        }
        
        if(caseActuelleF1.mouvementPossible(coord)){
            _fantome1.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
            //_affFantome.regarderVers(AffichageJoueur.Direction.DROITE);
        }else{
            // Boucle de mouvement du Fantome
            
                mouvementFait = false;
                
                while(mouvementFait==false){
                    choixChemin=(rand.nextInt(4-1+1)+1);
                    switch(choixChemin){
                        case 1 : //Droite
                            coord = new Coordonnees((int)_fantome1.getCoordonnes().getX()+1, (int)_fantome1.getCoordonnes().getY());
                            if (caseActuelleF1.mouvementPossible(coord)) {
                                _fantome1.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.DROITE);
                                mouvementFait=true;
                                _directionF1=Direction.DROITE;
                            }
                            break;
                        
                        case 2 : // Gauche
                            coord = new Coordonnees((int)_fantome1.getCoordonnes().getX()-1, (int)_fantome1.getCoordonnes().getY());
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF1.mouvementPossible(coord)) {
                                _fantome1.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.GAUCHE);
                                mouvementFait=true;
                                _directionF1=Direction.GAUCHE;
                            }
                            break;
                        
                        case 3 : // Haut
                            coord = new Coordonnees((int)_fantome1.getCoordonnes().getX(), (int)_fantome1.getCoordonnes().getY()+1);
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF1.mouvementPossible(coord)) {
                                _fantome1.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.GAUCHE);
                                mouvementFait=true;
                                _directionF1=Direction.HAUT;
                            }
                            break;
                        
                        case 4 : // BAS
                            coord = new Coordonnees((int)_fantome1.getCoordonnes().getX(), (int)_fantome1.getCoordonnes().getY()-1);
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF1.mouvementPossible(coord)) {
                                /* On déplace le personnage */
                                _fantome1.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                                /* On le fait regarder dans la bonne direction */
                                //_affFantome.regarderVers(AffichageJoueur.Direction.HAUT);
                                mouvementFait=true;
                                _directionF1=Direction.BAS;
                            }
                            break;
                    }
                }
            }
        
        if(caseActuelleF2.mouvementPossible(coordF2)){
            _fantome2.setCoordonnes(new Coordonnees(coordF2.getX(),coordF2.getY()));
            //_affFantome.regarderVers(AffichageJoueur.Direction.DROITE);
        }else{
            // Boucle de mouvement du Fantome
            
                mouvementFait = false;
                
                while(mouvementFait==false){
                    choixChemin=(rand.nextInt(4-1+1)+1);
                    switch(choixChemin){
                        case 1 : //Droite
                            coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX()+1, (int)_fantome2.getCoordonnes().getY());
                            if (caseActuelleF2.mouvementPossible(coordF2)) {
                                _fantome2.setCoordonnes(new Coordonnees(coordF2.getX(),coordF2.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.DROITE);
                                mouvementFait=true;
                                _directionF2=Direction.DROITE;
                            }
                            break;
                        
                        case 2 : // Gauche
                            coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX()-1, (int)_fantome2.getCoordonnes().getY());
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF2.mouvementPossible(coordF2)) {
                                _fantome2.setCoordonnes(new Coordonnees(coordF2.getX(),coordF2.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.GAUCHE);
                                mouvementFait=true;
                                _directionF2=Direction.GAUCHE;
                            }
                            break;
                        
                        case 3 : // Haut
                            coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX(), (int)_fantome2.getCoordonnes().getY()+1);
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF2.mouvementPossible(coordF2)) {
                                _fantome2.setCoordonnes(new Coordonnees(coordF2.getX(),coordF2.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.GAUCHE);
                                mouvementFait=true;
                                _directionF2=Direction.HAUT;
                            }
                            break;
                        
                        case 4 : // BAS
                            coordF2 = new Coordonnees((int)_fantome2.getCoordonnes().getX(), (int)_fantome2.getCoordonnes().getY()-1);
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF2.mouvementPossible(coordF2)) {
                                /* On déplace le personnage */
                                _fantome2.setCoordonnes(new Coordonnees(coordF2.getX(),coordF2.getY()));
                                /* On le fait regarder dans la bonne direction */
                                //_affFantome.regarderVers(AffichageJoueur.Direction.HAUT);
                                mouvementFait=true;
                                _directionF2=Direction.BAS;
                            }
                            break;
                    }
                }
            }
        
        if(caseActuelleF3.mouvementPossible(coordF3)){
            _fantome3.setCoordonnes(new Coordonnees(coordF3.getX(),coordF3.getY()));
            //_affFantome.regarderVers(AffichageJoueur.Direction.DROITE);
        }else{
            // Boucle de mouvement du Fantome
            
                mouvementFait = false;
                
                while(mouvementFait==false){
                    choixChemin=(rand.nextInt(4-1+1)+1);
                    switch(choixChemin){
                        case 1 : //Droite
                            coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX()+1, (int)_fantome3.getCoordonnes().getY());
                            if (caseActuelleF3.mouvementPossible(coordF3)) {
                                _fantome3.setCoordonnes(new Coordonnees(coordF3.getX(),coordF3.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.DROITE);
                                mouvementFait=true;
                                _directionF3=Direction.DROITE;
                            }
                            break;
                        
                        case 2 : // Gauche
                            coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX()-1, (int)_fantome3.getCoordonnes().getY());
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF3.mouvementPossible(coordF3)) {
                                _fantome3.setCoordonnes(new Coordonnees(coordF3.getX(),coordF3.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.GAUCHE);
                                mouvementFait=true;
                                _directionF3=Direction.GAUCHE;
                            }
                            break;
                        
                        case 3 : // Haut
                            coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX(), (int)_fantome3.getCoordonnes().getY()+1);
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF3.mouvementPossible(coordF3)) {
                                _fantome3.setCoordonnes(new Coordonnees(coordF3.getX(),coordF3.getY()));
                                //_affFantome.regarderVers(AffichageJoueur.Direction.GAUCHE);
                                mouvementFait=true;
                                _directionF3=Direction.HAUT;
                            }
                            break;
                        
                        case 4 : // BAS
                            coordF3 = new Coordonnees((int)_fantome3.getCoordonnes().getX(), (int)_fantome3.getCoordonnes().getY()-1);
                    
                            /* Si le mouvement est possible */
                            if (caseActuelleF3.mouvementPossible(coordF3)) {
                                /* On déplace le personnage */
                                _fantome3.setCoordonnes(new Coordonnees(coordF3.getX(),coordF3.getY()));
                                /* On le fait regarder dans la bonne direction */
                                //_affFantome.regarderVers(AffichageJoueur.Direction.HAUT);
                                mouvementFait=true;
                                _directionF3=Direction.BAS;
                            }
                            break;
                    }
                }
            }
            
            /*
            *
            *   Gestion collision Pacman / Fantomes
            */
            // Impossible d'utiliser directement coordonnees, voir pourquoi ? Utilisation de x puis de y
            int x = (int) Math.abs(_fantome1.getCoordonnes().getX()- _joueur.getCoordonnes().getX());
            int y = (int) Math.abs(_fantome1.getCoordonnes().getY() - _joueur.getCoordonnes().getY());
            if( x<3 && y<3){
                _joueur.mourrir();
            }
            
            int x2 = (int) Math.abs(_fantome2.getCoordonnes().getX()- _joueur.getCoordonnes().getX());
            int y2 = (int) Math.abs(_fantome2.getCoordonnes().getY() - _joueur.getCoordonnes().getY());
            if( x2<3 && y2<3){
                _joueur.mourrir();
            }
            
            int x3 = (int) Math.abs(_fantome3.getCoordonnes().getX()- _joueur.getCoordonnes().getX());
            int y3 = (int) Math.abs(_fantome3.getCoordonnes().getY() - _joueur.getCoordonnes().getY());
            if( x3<3 && y3<3){
                _joueur.mourrir();
            }
            
            /*
            *   Check si le joueur a encore des vies ou s'il a atteint le score maximal !
            *   S'il n'en a plus (de vies), c'est la fin de la partie !
            */
            
            if(_joueur.getVies()<0 || _joueur.getScore()==100){
                break;
            }
            
            /*
            * Pour le joueur
            */
            
            switch(_DirectionJoueur){
                case DROITE :
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX()+1, (int)_joueur.getCoordonnes().getY());
                    if (caseActuelleJoueur.mouvementPossible(coord)) {
                        
                        _joueur.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                        _affLab.repaintLabyrinthe();
                        if ( caseActuelleJoueur.estPlein() )
                        {
                            //On teste si on mange une pillule ou un fruit
                            if ( caseActuelleJoueur.getObjets().get(0) instanceof jeu.Cerise )
                            {
                                _joueur.gagnePoint(5);
                                //_affLab.getLab().change_etat();
                            }
                            else
                            {
                                _joueur.gagnePoint(1);
                            }
                            caseActuelleJoueur.supprObjets();

                        }
                        
                    }
                    break;
                
                case GAUCHE :
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX()-1, (int)_joueur.getCoordonnes().getY());
                    
                    if (caseActuelleJoueur.mouvementPossible(coord)) {
                        _joueur.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                        
                        _affLab.repaintLabyrinthe();
                        if ( caseActuelleJoueur.estPlein() )
                        {
                            //On teste si on mange une pillule ou un fruit
                            if ( caseActuelleJoueur.getObjets().get(0) instanceof jeu.Cerise )
                            {
                                _joueur.gagnePoint(5);
                                //_affLab.getLab().change_etat();
                            }
                            else
                            {
                                _joueur.gagnePoint(1);
                            }
                            caseActuelleJoueur.supprObjets();

                        }
                    }
                    break;
                case HAUT : 
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX(), (int)_joueur.getCoordonnes().getY()-1);
                    
                    if (caseActuelleJoueur.mouvementPossible(coord)) {
                        
                        /* On déplace le personnage */
                        _joueur.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                        /* On le fait regarder dans la bonne direction */
                        
                        if ( caseActuelleJoueur.estPlein() )
                        {
                            //On teste si on mange une pillule ou un fruit
                            if ( caseActuelleJoueur.getObjets().get(0) instanceof jeu.Cerise )
                            {
                                _joueur.gagnePoint(5);
                                //_affLab.getLab().change_etat();
                            }
                            else
                            {
                                _joueur.gagnePoint(1);
                            }
                            caseActuelleJoueur.supprObjets();

                        }
                    }
                    break;
                case BAS :
                    coord = new Coordonnees((int)_joueur.getCoordonnes().getX(), (int)_joueur.getCoordonnes().getY()+1);
                    if (caseActuelleJoueur.mouvementPossible(coord)) {
                    _joueur.setCoordonnes(new Coordonnees(coord.getX(),coord.getY()));
                        
                        _affLab.repaintLabyrinthe();
                        if ( caseActuelleJoueur.estPlein() )
                        {
                            //On teste si on mange une pillule ou un fruit
                            if ( caseActuelleJoueur.getObjets().get(0) instanceof jeu.Cerise )
                            {
                                _joueur.gagnePoint(5);
                                //_affLab.getLab().change_etat();
                            }
                            else
                            {
                                _joueur.gagnePoint(1);
                            }
                            caseActuelleJoueur.supprObjets();

                        }
                    }
                    break;
            }
            // On actualise le labyrinthe
            _affLab.repaintLabyrinthe();
            try {
                this.sleep(_rapidite);
            } catch (InterruptedException ex) {
                Logger.getLogger(GestionFantome.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        _jeu.end();
      }
    }
    
    public void setDirectionJoueur(Direction dir){
        _DirectionJoueur = dir;
    }
}


