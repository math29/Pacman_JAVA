package jeu;

/**
 * Classe qui, comme son nom l'indique, va nous servir de coordonnees pour pour placer géographiquement nos éléments dans le labyrinthe
 * @author Mathieu
 * 
 */
public class Coordonnees
{
    private double x;
    private double y;
    private int    id;

    /**
     * Constructeur ou l'on initialise les différents élements
     */
    public Coordonnees()
    {
        this.id = 0;
        this.y = 0.0;
        this.x = 0.0;
        x = y = 0.0;
        id = 0;
    }

    /**
     * Autre constructeur où l'on précise le x et le y que l'on initialise alors a la valeur souhaitée
     * @param x
     * @param y
     */
    public Coordonnees(double x, double y)
    {
        this.id = 0;
        this.y = 0.0;
        this.x = 0.0;
        this.x = x;
        this.y = y;
    }

    /**
     * Autre constructeur ou l'on précise les x, et y ET l'id qui nous réutiliserons plus tard
     * @param x
     * @param y
     * @param id
     */
    public Coordonnees(double x, double y, int id)
    {
        this.id = 0;
        this.y = 0.0;
        this.x = 0.0;
        this.x  = x;
        this.y  = y;
        this.id = id;
    }

    /**
     * set la coordonnees x 
     * @param x
     */
    public void setX(double x)
    {
        this.x = x;
    }

    /**
     * set la coordonnees y
     * @param y
     */
    public void setY(double y)
    {
        this.y = y;
    }

    /**
     * Retourne X
     * @return
     */
    public double getX()
    {
        return x;
    }

    /**
     * Retourne Y
     * @return
     */
    public double getY()
    {
        return y;
    }

    /**
     * Permet de mettre un ID
     * @param id
     */
    public void setId(int id)
    {
        this.id = id;
    }

    /** 
     * Retourne l'ID
     * @return
     */
    public int getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "id : " + id + " | position x=" + x + " y=" + y;
    }


}