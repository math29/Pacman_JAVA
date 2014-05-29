package ihm;

import BDD.Connect;
import GestionPersonnages.GestionFantome;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Paint;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.awt.image.renderable.RenderableImage;
import java.io.File;
import java.io.IOException;
import java.text.AttributedCharacterIterator;
import java.util.ArrayList;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import jeu.DifficulteCarte;
import main.Jeu;

/**
 *
 * @author Mathieu
 */
public class FenetrePrincipale extends JFrame implements ActionListener{	// Extension de JFrame pour pouvoir cr�er notre fen�tre graphique
	
	/* d�finition du serialVersionUID en cas de s�rialization de la classe */
	private static final long serialVersionUID = 00L;
	
	/* Cr�ation d'un menu */
	private JMenuBar barreMenu;

        private JButton boutonStart;
        private JButton item_newGame;
        private JButton boutonGO;
        private JButton boutonOption;
        private JButton boutonRetour;
        private JButton exitBouton;
        private JButton boutonSkin1;
        private JButton boutonSkin2;
        private JButton boutonSkin3;
        private JButton boutonCouperSon;
        
        /*Gestion menu option*/
        private JComboBox choixCouleur;
        private JComboBox choixMusique;
        private JComboBox choixDifficulte;
        private int menu=1;
        private JButton boutonValider;
        private Color background=Color.blue;
        
        private Image img1;
        private Image img2;
        private Image img3;
        
        /*
        *   Boutons Fenetre de choix de MAP
        */
        private Bouton boutonMap1;
        private Bouton boutonMap2;
        private Bouton boutonMap3;
        private Bouton boutonChoixPerso;
        
        /*
        Fenetre de Fin de jeu
        
        */
        JOptionPane boiteDialogue;
        
        private AffichageLabyrinthe _affLab;
        private final Jeu _jeu;
        
        private String _score;
        
        private GestionFantome _gestionF;
	
    /**
     *
     * @param jeu
     * @param x
     */
    public FenetrePrincipale(Jeu jeu, int x){
            _jeu = jeu;
            
            /* Gestion de la fen�tre (titre, taille, position, op�ation fermeture */
            this.setTitle("Pacman POO");							// titre de la page
            this.setPreferredSize(jeu.getResolution());				// Dimensions de la page r�cup�r� � partir de la classe Jeu						// Localisation de la page sur l'�cran
            Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();		// Centrage de la fen�tre sur l'�cran
            setLocation((int)(screenSize.getWidth() / 2) - (int)Jeu.getInstance().getResolution().getWidth() / 2,
                    (int)(screenSize.getHeight() / 2) - (int)Jeu.getInstance().getResolution().getHeight() / 2);
            this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    // Gestion de la fermeture sur appuie de la croix rouge
	    ImageIcon icon = new ImageIcon("pacman basique transparant.gif");
            this.setIconImage(icon.getImage());
            
            affichePanel(x);
            
	  }
	
    /**
     *
     * @param x numéro du panel que l'on va afficher (1 : Fenetre d'accueil, 2 : Choix du Skin, 3 : Le jeu, 4 : Fenetre d'options, 5 : Fenetre choix de MAP, 6 : Fenetre de fin de jeu)
     */
    @SuppressWarnings("empty-statement")
        public void affichePanel(int x){
            switch(x){
            case 1 : 
                /*
                 * Lancement du panel du menu d'accueil
		 * Gestion des menu barre, boutons etc .. A mettre
		 * 
		 */
                this.setSize(800, 500);
                AffichageBackground pan = new AffichageBackground();
                this.setContentPane(pan);
                
                // On définit le layout à utiliser sur le content Pane
                this.setLayout(new BorderLayout());
                // Et le bouton start au sud
                boutonStart = new JButton("START");
                this.getContentPane().add(boutonStart,BorderLayout.SOUTH);
                
                boutonStart.addActionListener(this);

                
                this.setVisible(true);
                break;
            
            case 2 :
                /*
                 * Lancement du panel de Choix du skin
		 * Gestion des menu barre, boutons etc .. A mettre
		 * 
		 */
                this.getContentPane().removeAll();
                AffichageBackground choixSkinPan = new AffichageBackground();
                this.setContentPane(choixSkinPan);
                
                /*
                * Création des boutons pour les skins du pacman
                *
                */
                
                try {
                img1 = ImageIO.read(new File("pacmanWarriorTransparent.gif"));
                } catch (IOException ex) {
                    }
                boutonSkin1 = new BoutonSkin(img1);
                try {
                img2 = ImageIO.read(new File("pacman_ouvert.png"));
                } catch (IOException ex) {
                    }
                boutonSkin2 = new BoutonSkin(img2);
                
                try {
                img3 = ImageIO.read(new File("pacman_ouvert.png"));
                } catch (IOException ex) {
                    }
                boutonSkin3 = new BoutonSkin(img3);
                
                //boutonSkin1.addActionListener(this);
                //boutonSkin2.addActionListener(this);
                //boutonSkin3.addActionListener(this);
                
                JPanel boutonLesPersos = new JPanel();
                boutonLesPersos.setLayout(new GridLayout(1,3));
                boutonLesPersos.add(boutonSkin1);
                boutonLesPersos.add(boutonSkin2);
                boutonLesPersos.add(boutonSkin3);
                
                boutonGO = new JButton("GO !");
                boutonGO.addActionListener(this);
                boutonOption = new JButton("OPTIONS");
                boutonOption.addActionListener(this);
                
                // On définit le layout à utiliser sur le content pane
                // 4 lignes sur 1 colonne
                this.setLayout(new GridLayout(3,1));
                // On ajoute les boutons au content pane de la JFrame
                this.getContentPane().add(boutonLesPersos);
                this.getContentPane().add(boutonOption);
                this.getContentPane().add(boutonGO);
                this.setVisible(true);
                break;
                
            case 3 :
                /*
                 * Lancement du panel de nouvelle partie
		 * Gestion des menu barre, boutons etc .. A mettre
		 * 
		 */
		
		/* Gestion de la barre de Menu */
		
		// Instanciation d'une barre de Menu
		barreMenu = new JMenuBar();
		
		//Boutons New Game et Exit
		item_newGame = new JButton("New Game");
		exitBouton = new JButton("Exit");
                // Bouton couper le son
                boutonCouperSon = new JButton("Couper Son");
                
		// On les ajoute � la barre de Menu
		barreMenu.add(item_newGame);
                barreMenu.add(boutonCouperSon);
                //barreMenu.add(boutonOption);
		barreMenu.add(exitBouton);
		
		//On ajoute la barre de Menu � la JFrame
		this.setJMenuBar(barreMenu);
		
		/*  Fin de Barre de Menu */
		
		/* Gestion des controleurs de la barre de Menu */
		
                item_newGame.addActionListener(this);
                boutonCouperSon.addActionListener(this);
                exitBouton.addActionListener(this);
                
                //On d�finit le layout � utiliser sur le content pane
                this.setLayout(new BorderLayout());
	    
                /* Permettra de mettre le labyrinthe, joueurs etc.. sur l'ecran */
                /** On va maintenant disposer le plateau dans la fenętre principale **/
                /* On créer une nouvelle vue de Labyrinthe en récupérant les données du jeu, il ne s'affiche que si la partie a été lancé par l'utilisateur*/
                if(_jeu.isPartieEnCours())
                {
                    _affLab = new AffichageLabyrinthe(_jeu.getLab(), _jeu.getJoueur(), _jeu.getFantome1(), _jeu.getFantome2(), _jeu.getFantome3(), _jeu.getResolution(), background);
                    getContentPane().add(_affLab, BorderLayout.WEST);
                }

                /* On applique les diff�rents �l�ments que l'on a ajout� � la JFrame */
                pack();
            
                if(_jeu.isPartieEnCours()){
                    /* La vue du Labyrinthe dois avoir la main pour tout ce qui concerne les actions au clavier. */
                    _affLab.requestFocusInWindow();
                }
                
                this.setVisible(true);
                break;
            case 4 :
                /*
                 * Lancement du panel des Options
		 * Gestion des menu barre, boutons etc .. A mettre
		 * 
		 */
            	menu=4;
            	
                AffichageBackground affOptions = new AffichageBackground();
                this.setContentPane(affOptions);
                
                JLabel couleur = new JLabel("Couleur");	//Définition d'un label pour afficher le mot "Couleur"
                JPanel premiereCase = new JPanel();	//On dit que ça sera dans la première case
                premiereCase.add(couleur);	//Ajout du label a la première case
                String[] tab1={"Rose", "Rouge", "Bleu", "Vert"};	//Définition des différents choix possibles dans la liste déroulante
                choixCouleur = new JComboBox(tab1);	//Ajout des choix possibles à la liste
                choixCouleur.addActionListener(this);	//Il y aura des interruptions possibles
                choixCouleur.setPreferredSize(new Dimension(100, 20));	//Choix de la taille de la liste déroulante (longueur de la case)
                choixCouleur.setForeground(Color.black);	//Ecritures en noir
                premiereCase.add(choixCouleur);	//On ajoute la liste à la première case
                
                JLabel musique = new JLabel("Musique");
                JPanel deuxiemeCase = new JPanel();
                deuxiemeCase.add(musique);
                String[] tab2={"Musique 1", "Musique 2", "Musique 3"};
                choixMusique = new JComboBox(tab2);
                choixMusique.addActionListener(this);
                choixMusique.setPreferredSize(new Dimension(100, 20));
                choixMusique.setForeground(Color.black);
                deuxiemeCase.add(choixMusique);
                
                JLabel difficulte = new JLabel("Difficulté");
                JPanel troisiemeCase = new JPanel();
                troisiemeCase.add(difficulte);
                String[] tab3={"Moyen", "Lent", "Rapide"};
                choixDifficulte = new JComboBox(tab3);
                choixDifficulte.addActionListener(this);
                choixDifficulte.setPreferredSize(new Dimension(100, 20));
                choixDifficulte.setForeground(Color.black);
                troisiemeCase.add(choixDifficulte);
                
                this.setLayout(new GridLayout(4,1));	//Il y aura en tout 4 lignes et une colonne
                this.getContentPane().add(premiereCase);	//Ajout du choix des couleurs sur le premier emplacement
                this.getContentPane().add(deuxiemeCase);	//Ajout du choix des musiques sur le deuxième emplacement
                this.getContentPane().add(troisiemeCase);	//Ajout du choix des difficultés sur le troisième emplacement
                boutonValider = new JButton("Valider");	//Création du bouton "Valider
                this.getContentPane().add(boutonValider);	//Ajout de ce bouton sur le dernier emplacement
                boutonValider.addActionListener(this);	//Il y aura des interruptions sur ce bouton
                
                this.setVisible(true);
                break;
                
            case 5 :
                /*
                 * Lancement du panel du choix de MAP
		 * Gestion du layout, boutons etc .. A mettre
		 * 
		 */
                this.getContentPane().removeAll();
                AffichageBackground affMap = new AffichageBackground();
                this.setContentPane(affMap);
                boutonMap1 = new Bouton("MAP 1");
                boutonMap1.addActionListener(this);
                boutonMap2 = new Bouton("MAP 2");
                boutonMap2.addActionListener(this);
                boutonMap3 = new Bouton("MAP 3");
                boutonMap3.addActionListener(this);
                boutonChoixPerso = new Bouton("Choix Persos");
                boutonChoixPerso.addActionListener(this);
        
                this.setLayout(new GridLayout(4,1));
        
                this.getContentPane().add(boutonMap1);
                this.getContentPane().add(boutonMap2);
                this.getContentPane().add(boutonMap3);
                this.getContentPane().add(boutonChoixPerso);
                
                
                
                this.setVisible(true);
                
                break;
                
            case 6 :
                // Gestion page de fin de game
                boiteDialogue = new JOptionPane();
                String nom = (String)boiteDialogue.showInputDialog(null, "Veuillez entrer votre nom !", "Nouveau Score", JOptionPane.QUESTION_MESSAGE);
                
                Connect c = new Connect(_jeu ,nom);
                this.getContentPane().removeAll();
                this.barreMenu.setVisible(false);
                
                AffichageBackground affFinGame = new AffichageBackground();
                
                this.setContentPane(affFinGame);
                
                ArrayList <String> titre = c.getTitres();
                ArrayList <String> contenu = c.getContenu();
                // Les données du tableau
                Object[][] data = new Object [contenu.size()/2][2];
                

                for(int i=0; i< contenu.size()/2;i++){
                        data[i][0]=contenu.get(2*i);
                        data[i][1]=contenu.get(2*i+1);
                    }
                
                // Titres des colonnes
                String title [] = {titre.get(0), titre.get(1)};
                JTable tableau = new JTable(data, title);
                
                affFinGame.setLayout(new BorderLayout());
                // Et le bouton start au sud
                boutonStart = new JButton("RECOMMENCER !");
                affFinGame.add(boutonStart, BorderLayout.SOUTH);
                this.getContentPane().add(new JScrollPane(tableau),  BorderLayout.CENTER);
                boutonStart.addActionListener(this);
                //_jeu.startMusique("SF-clairon.wav");
                pack();
                this.setVisible(true);
                break;
            }
            
        }

    /**
     *
     * @return l'affichage du labyrinthe
     */
    public AffichageLabyrinthe getAffLab() {
        return _affLab;
    }

    /**
     *
     * @param _affLab
     */
    public void setAffLab(AffichageLabyrinthe _affLab) {
        this._affLab = _affLab;
    }
        
	/* Retourne le MenuBar utilis� */

    /**
     *
     * @return La bar de menu
     */
	public JMenuBar getmenuBar(){
		return barreMenu;
	}
	
    /**
     *
     * @param menubarre
     */
    public void setmenuBar(JMenuBar menubarre){
		barreMenu = menubarre;
	}
	
        @Override
        public void actionPerformed(ActionEvent arg0) {
 
            if(arg0.getSource() == boutonStart){
                affichePanel(5);
            }
            
            if(arg0.getSource() == boutonOption){
                if(_jeu.isPartieEnCours()){
                    _jeu.pause();
                }
                affichePanel(4);
                
            }

            if(menu==4 && choixCouleur.getSelectedItem()=="Vert"){
                System.out.println("Bouton Vert");
            }
            
            if(arg0.getSource() == boutonCouperSon){
                _jeu.stopMusique();
                
            }
            
            if(arg0.getSource() == item_newGame || arg0.getSource() == boutonGO){
                this.getContentPane().removeAll();
                this.repaint();
                // Lancement d'une nouvelle partie
                Jeu.getInstance().nouvellePartie();
            }
            if(arg0.getSource() == boutonValider){
                    affichePanel(2);
            }
            
            if(arg0.getSource() == exitBouton){
                _jeu.end();
            }
            
            if(arg0.getSource() == boutonChoixPerso){
                affichePanel(2);
            }
                    
            if(arg0.getSource() == boutonSkin1){
                _jeu.setSkinJoueur("pacmanWarriorTransparent.gif");
            }
            
            if(arg0.getSource() == boutonSkin2){
                _jeu.setSkinJoueur("pacmangirlv2 transparant.gif");
            }
            
            if(arg0.getSource() == boutonSkin3){
                _jeu.setSkinJoueur("pacman_ouvert.png");
            }
            
            if(arg0.getSource() == boutonMap1){
                JOptionPane jpo1 = new JOptionPane();
                ImageIcon img = new ImageIcon("MAPS/carte1.png");
                boutonMap2.setCouleur("jaune");
                boutonMap3.setCouleur("jaune");
                _jeu.setLevel(DifficulteCarte.Niveau.FACILE);
                jpo1.showMessageDialog(null, null, "MAP 1", JOptionPane.INFORMATION_MESSAGE, img);
            }
            
            if(arg0.getSource() == boutonMap2){
                JOptionPane jpo1 = new JOptionPane();
                ImageIcon img = new ImageIcon("MAPS/carte2.png");
                boutonMap1.setCouleur("jaune");
                boutonMap3.setCouleur("jaune");
                _jeu.setLevel(DifficulteCarte.Niveau.MOYEN);
                jpo1.showMessageDialog(null, null, "MAP 1", JOptionPane.INFORMATION_MESSAGE, img);
            }
            
            if(arg0.getSource() == boutonMap3){
                JOptionPane jpo1 = new JOptionPane();
                ImageIcon img = new ImageIcon("MAPS/carte3.png");
                boutonMap1.setCouleur("jaune");
                boutonMap2.setCouleur("jaune");
                _jeu.setLevel(DifficulteCarte.Niveau.DIFFICILE);
                jpo1.showMessageDialog(null, null, "MAP 1", JOptionPane.INFORMATION_MESSAGE, img);
            }
            
            if(menu==4 && choixCouleur.getSelectedItem()=="Rose"){
            	System.out.println("Rose");
            	background=Color.pink;
            }
            if(menu==4 && choixCouleur.getSelectedItem()=="Rouge"){
            	System.out.println("Rouge");
            	background=Color.red;
            }
            if(menu==4 && choixCouleur.getSelectedItem()=="Bleu"){
            	System.out.println("Bleu");
            	background=Color.blue;
            }
            if(menu==4 && choixCouleur.getSelectedItem()=="Vert"){
            	System.out.println("Vert");
            	background=Color.green;
            }
            if(menu==4 && choixMusique.getSelectedItem()=="Musique 1"){
            	System.out.println("Musique 1");
            	_jeu.setMusic("Nyan-Cat-ringtone-6-second-loop.wav.wav");
            }
            if(menu==4 && choixMusique.getSelectedItem()=="Musique 2"){
            	System.out.println("Musique 2");
            	_jeu.setMusic("Nyan-Cat-ringtone-6-second-loop.wav.wav");
            }
            if(menu==4 && choixMusique.getSelectedItem()=="Musique 3"){
            	System.out.println("Musique 3");
            	_jeu.setMusic("EFFECTS01.WAV");
            }
            if(menu==4 && choixDifficulte.getSelectedItem()=="Lent"){
            	System.out.println("Lent");
            	_jeu.setDifficulte(3000);
            }
            if(menu==4 && choixDifficulte.getSelectedItem()=="Moyen"){
            	System.out.println("Moyen");
            	_jeu.setDifficulte(300);
            }
            if(menu==4 && choixDifficulte.getSelectedItem()=="Rapide"){
            	System.out.println("Rapide");
            	_jeu.setDifficulte(30);
            }
        }
        
        public AffichageLabyrinthe getAfficheLabyrinthe(){
            return _affLab;
        }
	
        public void afficheScore(int score){
             _score=Integer.toString(score); 
        }
        
        public AffichageLabyrinthe getAffichageLabyrinthe(){
            return _affLab;
        }

    public void setGestionF(GestionFantome gestionF) {
        _gestionF = gestionF;
    }
}