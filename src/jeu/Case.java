package jeu;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Case extends Point2D{

	/* Nous donne les coordonnees de la case */ 
	private Point _coordonnees;
	
	/* Liste des differents types de case possible, voir doc pour plus de détails */
	public enum Type{
		HORIZONTALE, VERTICALE,
        T_NORMAL, T_INVERSE, T_DROITE, T_GAUCHE,
        ANGLE_HAUT_GAUCHE, ANGLE_HAUT_DROIT,
        ANGLE_BAS_GAUCHE, ANGLE_BAS_DROIT,
        CROIX
	}
        


    
	
	/* une instance de Type */
	private Type type;
        
        /* Objets contenus dans une case */
	ArrayList<Objet2D>Contenu;
        
        /* variable de remplissage de la case */
        private boolean estPlein;
        
	/* Constructeur */
	public Case(Type TYPE, Point POS){
            type = TYPE;
                
            switch(type){
            default:
            case HORIZONTALE:
            case VERTICALE:
                Contenu = new ArrayList<Objet2D>(2);
                break;
            case T_NORMAL:
            case T_INVERSE:
            case T_DROITE:
            case T_GAUCHE:
            case ANGLE_HAUT_GAUCHE:
            case ANGLE_HAUT_DROIT:
            case ANGLE_BAS_GAUCHE:
            case ANGLE_BAS_DROIT:
                Contenu = new ArrayList<Objet2D>(3);
                break;
            case CROIX:
                Contenu = new ArrayList<Objet2D>(3);
                break;
            }   
            _coordonnees = new Point(POS);
		
        }


	public boolean mouvementPossible(Coordonnees coord){
            double x = 0, y = 0;
            /* traductions des coordonn�es labyrinthe --> coordonn�es case */
            x = ((coord.getX()/Personnage.facteurPrecision) - _coordonnees.y) * 50;
            y = ((coord.getY()/Personnage.facteurPrecision) - _coordonnees.x) * 50;
            switch (type) {
                case HORIZONTALE:
                    return (y == 0.);
                case VERTICALE:
                    return (x == 0.);

                case   ANGLE_BAS_GAUCHE: // Angle en bas a gauche
                    return (    x >= 9. && y == 0.
                    ||    x == 0. && y <= 0.);
                case  ANGLE_HAUT_GAUCHE: // En haut a gauche
                    return (    x >= 9. && y == 0.
                    ||    x == 0. && y >= 0.);
                case    ANGLE_BAS_DROIT:    // Angle en bas a droite
                    return (    x <= 0. && y == 0.
                            ||    x == 0. && y <= 0.);
                case   ANGLE_HAUT_DROIT:  // EN haut a droite
                  return (    x <= 9. && y == 0.
                          ||    x == 0. && y >= 0.);

                case T_NORMAL :
                   return (    x == 0. && y >= 9.
                          ||    y == 0);
                case T_INVERSE :
                  return (    x == 0. && y <= 9.
                          ||    y == 0);
                case T_DROITE:
                 return (    x >= 0. && y == 0.
                           ||    x == 0);
             case T_GAUCHE:
                  return (    x <= 0. && y == 0.
                          ||    x == 0);

               case CROIX:
                  return (    y == 0.
                         ||    x == 0);
                    
              default:
                    return true;
             }
           }
    
    /* Penser a générer la création d'une cerise tous les X temps */
    public void addContenu(){
        PieceOr piece = new PieceOr();
        Contenu.add(piece);
        estPlein=true;
    }
    
    public void supprObjets(){
        Contenu.clear();
        estPlein=false;
    }

    public Point getCoordonnees() {
        return _coordonnees;
    }

    public Type getType() {
        return type;
    }

    public ArrayList<Objet2D> getContenu() {
        return Contenu;
    }
	
    @Override
    public double getX() {
	// TODO Auto-generated method stub
        return 0;
    }


	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public void setLocation(double x, double y) {
		// TODO Auto-generated method stub
		
	}
        
    public ArrayList<Objet2D> getObjets() {
        return Contenu;
    }

    public void setObjets(ArrayList<Objet2D> _objets) {
        this.Contenu = _objets;
    }
    
    public boolean estPlein(){
        return estPlein;
    }
}
