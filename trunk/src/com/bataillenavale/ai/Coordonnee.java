/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.ai;

/**
 *
 * @author Nanahara
 */
public class Coordonnee 
{
    private int x;
    private int y;

    public Coordonnee()
    {
        
    }
    public Coordonnee(int a, int b)
    {
        x = a;
        y = b;
    }

    public int getX() 
    {
        return x;
    }


    public void setX(int x) 
    {
        this.x = x;
    }


    public int getY() 
    {
        return y;
    }

    public void setY(int y) 
    {
        this.y = y;
    }
    
    @Override
    public boolean equals(Object c)
    {
        Coordonnee co = (Coordonnee) c;
        if(co.getX() == this.getX() && co.getY() == this.getY())
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
