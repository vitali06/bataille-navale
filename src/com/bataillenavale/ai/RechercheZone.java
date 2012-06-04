/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import java.util.Random;

public class RechercheZone implements Strategie 
{
    private Matrice mat;
    private int rayon;
    
    public RechercheZone(Matrice _mat, int _rayon)
    {
        mat = _mat;
        rayon = _rayon;
    }
    
    public Coordonnee rechercheTir()
    {
        Coordonnee c = new Coordonnee();
        boolean pointTrouve = false;
        int x;
        int y;
        while(pointTrouve == false)
        {
            Random r = new Random();
            x = r.nextInt(10);
            y = r.nextInt(10);
            c.setX(x);
            c.setY(y);
            if(getMat().estTire(c) == false)
            {
                pointTrouve = true;
            }
        }
        return c;   
    }
    
    public boolean testZone(Coordonnee c)
    {
       boolean m = true;
       int x = debut(c.getX());
       int y = debut(c.getY());
       
       for(int i = 0; i<=rayon +rayon && (y < mat.getTaille() && y <= c.getY() + rayon) && m; i++)
       {
         for(int j = 0; j<=rayon + rayon && (x < mat.getTaille() && x <= c.getX() + rayon) && m; j++)
         {
           Coordonnee tmp = new Coordonnee(x, y);
           if(mat.estTire(tmp))
           {
             m = false;
           }
           else
           {
             x = x+1;
           }
         }
         x = debut(c.getX());
         y = y +1;
       }
       return m;
    }
    public int debut(int x)
    {
        int res;
       if(x - rayon < 0)
       {
           res= 0;
       }
       else
       {
           res = x - rayon;
       }
       return res;
    }

    @Override
    public Coordonnee execute() 
    { 
       Coordonnee c = rechercheTir();
       if(!testZone(c))
       {
           c = null;
       }
       return c;
    }

    public Matrice getMat() 
    {
        return mat;
    }

    public void setMat(Matrice mat) 
    {
        this.mat = mat;
    }


    public int getRayon() 
    {
        return rayon;
    }


    public void setRayon(int rayon) 
    {
        this.rayon = rayon;
    }
    
}
