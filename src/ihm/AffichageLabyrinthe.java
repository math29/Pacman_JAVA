/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ihm;

import interrupt.InterruptionsClavier;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;
import jeu.Fantome;
import jeu.Joueur;
import jeu.Labyrinthe;

/**
 *
 * @author Mathieu
 */
public class AffichageLabyrinthe extends JPanel{
    private static final int offsetX = 140;
    private static final int offsetY = 25;
    
    /*déclaration des variables */
    
    private Labyrinthe _lab;
    private final Dimension _dimLab;
    private ArrayList<ArrayList<AffichageCase>> _Cases;
    private ArrayList<ArrayList<AffichageObjet>> _Objets;
    private AffichageJoueur _afficheJoueur;
    private final Joueur _joueur;
    
    private final Fantome _fantome1;
    private final Fantome _fantome2;
    private final Fantome _fantome3;
    
    private AffichageFantome _affFantome1;
    private AffichageFantome _affFantome2;
    private AffichageFantome _affFantome3;
    
    private boolean _initialDraw;
    
    private InterruptionsClavier _controle;
    
    
        /**
     * Créer une nouvelle vue qui dessinera le labyrinthe
     * @param lab
     * @param joueur
     * @param fantome1
     * @param fantome2
     * @param fantome3
     * @param background
     * @param dim
     */
    public AffichageLabyrinthe(Labyrinthe lab, Joueur joueur, Fantome fantome1, Fantome fantome2,Fantome fantome3, Dimension dim, Color background) {
        super();

        this._joueur=joueur;
        _fantome1 = fantome1;
        _fantome2 = fantome2;
        _fantome3 = fantome3;
        this._lab = lab;
        this._dimLab = dim;
        setBackground(background);
        setPreferredSize(_dimLab);
        setLayout(null);
        setVisible(true);

        _controle = new InterruptionsClavier(_joueur, this);
        addKeyListener(_controle);

        _initialDraw = true;
    }





    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        AffichageCase CaseTemp;
        AffichageObjet ObjetTemp;

        if (_initialDraw) {
            // Dessin des cases.
            //On réinitialise le dessin des cases
            _Cases = new ArrayList<>(_lab.getCases().size());
            // On initialise le dessin des objets
            _Objets = new ArrayList<>(_lab.getCases().size());

            // Ainsi que celui des joueurs
            // On dessine les cases 
            for (int i = 0; i < _lab.getCases().size(); i++) {
                // Nouvelle ligne de cases 
                _Cases.add(new ArrayList<AffichageCase>(_lab.getCases().get(i).size()));
                _Objets.add(new ArrayList<AffichageObjet>(_lab.getCases().get(i).size()));
                for (int j = 0; j < _lab.getCases().get(i).size(); j++) {

                ObjetTemp = new AffichageObjet(_lab.getCases().get(j).get(i).getContenu().get(0));
                ObjetTemp.setBounds(i * 50 + 22 +AffichageLabyrinthe.offsetX, j * 50 + 22 + AffichageLabyrinthe.offsetY, 5, 5);
                _Objets.get(i).add(ObjetTemp);                 
                this.add(ObjetTemp);

                    // Nouvelle case ŕ la colonne j 
                    CaseTemp = new AffichageCase(_lab.getCases().get(j).get(i));
                    CaseTemp.setBounds(    i * 50 + AffichageLabyrinthe.offsetX,
                                            j * 50 + AffichageLabyrinthe.offsetY,
                                            50, 50);
                    _Cases.get(i).add(CaseTemp);
                    this.add(CaseTemp);
                }
            }
             /* On créer l'affichage du joueur */
                _afficheJoueur = new AffichageJoueur(_joueur);
                _afficheJoueur.setBounds((int) _joueur.getX() * 50 + AffichageLabyrinthe.offsetX + 15,
                                        (int) _joueur.getY() * 50 + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);
            /* On créé l'affichage du/des fantomes */
                // Fantome 1 :
                _affFantome1 = new AffichageFantome(_fantome1);
                _affFantome1.setBounds((int) _fantome1.getX() * 50 + AffichageLabyrinthe.offsetX + 15,
                                        (int) _fantome1.getY() * 50 + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);
                
                // Fantome 2 :
                _affFantome2 = new AffichageFantome(_fantome1);
                _affFantome2.setBounds((int) _fantome2.getX() * 50 + AffichageLabyrinthe.offsetX + 15,
                                        (int) _fantome2.getY() * 50 + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);
                
                // Fantome 3 :
                _affFantome3 = new AffichageFantome(_fantome1);
                _affFantome3.setBounds((int) _fantome3.getX() * 50 + AffichageLabyrinthe.offsetX + 15,
                                        (int) _fantome3.getY() * 50 + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);
        _initialDraw=false;
        }
         else {
            /**
             * Dessin des objets sur le terrain (pillules et fruits).
             */
            /* On dessine les cases */
            for (int i = 0; i < _Objets.size(); i++) {
                for (int j = 0; j < _Objets.size(); j++) {
                    if ( (_Objets.get(j) !=  null) && !(_lab.getCases().get(i).get(j).estPlein()))
                    {
                        /* On enlčve du labyrinthe le dessin du personnage */
                        this.remove(_Objets.get(j).get(i));
                        /* On l'enlčve également de la liste des vues */
                        //_vuesObjets.remove(i);
                    }

                }
            }
            
            /*
             * Dessin du score
             */

                Font font = new Font("Calibri", Font.BOLD, 12);
                g.setFont(font);
                g.setColor(Color.red);
                g.drawString(Integer.toString(_joueur.getScore()), 10, 20);
                g.drawString(Integer.toString(_joueur.getVies()), 10, 40);
                
                /* On définit une nouvelle vue pour le joueur */ 
                this.remove(_afficheJoueur);
                _afficheJoueur = new AffichageJoueur(_joueur/*, _vuesJoueurs.get(i).get_orientation()*/);
                /* On lui donne les nouvelles  coordonnées du personnage du joueur considéré */
                _afficheJoueur.setBounds((int) _joueur.getX() * (50 / Joueur.facteurPrecision) + AffichageLabyrinthe.offsetX + 15,
                                        (int) _joueur.getY() * (50 / Joueur.facteurPrecision) + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);

                this.add(_afficheJoueur);
                
                /* On définit une nouvelle vue pour les fantomes ! */ 
                this.remove(_affFantome1);
                _affFantome1 = new AffichageFantome(_fantome1);
                /* On lui donne les nouvelles  coordonnées du personnage du joueur considéré */
                _affFantome1.setBounds((int) _fantome1.getX() * (50 / Fantome.facteurPrecision) + AffichageLabyrinthe.offsetX + 15,
                                        (int) _fantome1.getY() * (50 / Fantome.facteurPrecision) + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);
                
                this.remove(_affFantome2);
                _affFantome2 = new AffichageFantome(_fantome2);
                /* On lui donne les nouvelles  coordonnées du personnage du joueur considéré */
                _affFantome2.setBounds((int) _fantome2.getX() * (50 / Fantome.facteurPrecision) + AffichageLabyrinthe.offsetX + 15,
                                        (int) _fantome2.getY() * (50 / Fantome.facteurPrecision) + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);
                
                this.remove(_affFantome3);
                _affFantome3 = new AffichageFantome(_fantome3);
                /* On lui donne les nouvelles  coordonnées du personnage du joueur considéré */
                _affFantome3.setBounds((int) _fantome3.getX() * (50 / Fantome.facteurPrecision) + AffichageLabyrinthe.offsetX + 15,
                                        (int) _fantome3.getY() * (50 / Fantome.facteurPrecision) + AffichageLabyrinthe.offsetY + 15,
                                        20, 20);

                this.add(_affFantome1);
                this.add(_affFantome2);
                this.add(_affFantome3);
            
        }
    }
    
    public void repaintLabyrinthe() {
        repaint();
    }

    public Labyrinthe getLab() {
        return _lab;
    }

    public void setLab(Labyrinthe _lab) {
        this._lab = _lab;
    }
    
    public AffichageJoueur getAfficheJoueur() {
        return _afficheJoueur;
    }

    public void setAfficheJoueur(AffichageJoueur _afficheJoueur) {
        this._afficheJoueur = _afficheJoueur;
    }
    
    public AffichageFantome getAfficheFantome1() {
        return _affFantome1;
    }

    public void setAfficheFantome1(AffichageFantome afficheFantome) {
        this._affFantome1 = afficheFantome;
    }
    
        public AffichageFantome getAfficheFantome2() {
        return _affFantome2;
    }

    public void setAfficheFantome2(AffichageFantome afficheFantome) {
        this._affFantome2 = afficheFantome;
    }
    
        public AffichageFantome getAfficheFantome3() {
        return _affFantome3;
    }

    public void setAfficheFantome3(AffichageFantome afficheFantome) {
        this._affFantome3 = afficheFantome;
    }
    
        public InterruptionsClavier getControle() {
        return _controle;
    }

    public void setControle(InterruptionsClavier _controle) {
        this._controle = _controle;
    }
}
