/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jeu;

/**
 *
 * @author Mathieu
 * 
 */

public class Coordonnees
{
    
    /**
     *
     */
    private double x  = 0.0;
    private double y  = 0.0;
    private int    id = 0;


    public Coordonnees()
    {
        x = y = 0.0;
        id = 0;
    }

    public Coordonnees(double x, double y)
    {
        this.x = x;
        this.y = y;
    }

    public Coordonnees(double x, double y, int id)
    {
        this.x  = x;
        this.y  = y;
        this.id = id;
    }

    public void setX(double x)
    {
        this.x = x;
    }

    public void setY(double y)
    {
        this.y = y;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public void setId(int id)
    {
        this.id = id;
    }

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