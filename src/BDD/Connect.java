package BDD;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import jeu.DifficulteCarte;
import main.Jeu;

/**
 * Classe qui gère les échanges avec la BDD des scores
 * @author Mathieu
 */
public class Connect {
    
    private ArrayList <String> titres;
    private ArrayList <String> contenu;
    private String bdd;
    
    /**
     * Constructeur de cette classe a partir du jeu et du nom de la BDD a atteindre
     * @param j
     * @param n
     */
    public Connect(Jeu j, String n){
        try{
            Class.forName("org.postgresql.Driver");
            System.out.println("Driver OK");
            
            String url = "jdbc:postgresql://localhost:5432/scores";
            String user = "postgres";
            String passwd = "spipol43ok";
            
            Connection conn = DriverManager.getConnection(url, user, passwd);
            System.out.println("Connexion établie");
            
            if(j.getLevel()==DifficulteCarte.Niveau.FACILE){
                bdd = "listescores";
            }else if(j.getLevel()==DifficulteCarte.Niveau.MOYEN){
                bdd = "listescores2";
            }else if(j.getLevel()==DifficulteCarte.Niveau.DIFFICILE){
                bdd = "listescores3";
            }
            
            Statement state2;
            try (Statement state = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE)) {
                int executeUpdate = state.executeUpdate("INSERT INTO "+bdd+" (joueur, score) VALUES('"+n+"','"+j.getJoueur().getScore()+"')");
                state2 = conn.createStatement();
                // Récupération des métadata
                try ( // L'objet ResultSet contient le résultat de la requête SQL
                        ResultSet result = state2.executeQuery("SELECT * FROM "+bdd+" ORDER BY score DESC")) {
                    // Récupération des métadata
                    ResultSetMetaData resultMeta = result.getMetaData();
                    titres = new ArrayList <>();
                    // Ici le nom des colonnes
                    for(int i=1; i<= resultMeta.getColumnCount();i++){
                        titres.add(resultMeta.getColumnName(i).toUpperCase());
                    }   contenu = new ArrayList <>();
                    String c;
                    while(result.next()){
                        for (int i=1; i<=resultMeta.getColumnCount(); i++){
                            c = result.getObject(i).toString();
                            contenu.add(c);
                        }
                        
                    }
                }
            }
            state2.close();
        }catch(ClassNotFoundException | SQLException e){
        }
    }
    
    /**
     * Retourne les titres de la BDD 
     * @return
     */
    public ArrayList <String> getTitres(){
        return titres;
    }
    
    /**
     * Retourne le contenu de la BDD
     * @return
     */
    public ArrayList <String> getContenu(){
        return contenu;
    }
}
