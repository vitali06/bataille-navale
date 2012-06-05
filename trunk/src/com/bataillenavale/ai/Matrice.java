/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import com.bataillenavale.tools.Coordonnee;

public class Matrice 
{
    private boolean matrice[][];
    private int taille;
    
    public Matrice(int _taille)
    {
        taille = _taille;
        matrice = new boolean[taille][taille];
        for(int i = 0; i<taille; i++)
        {
            for(int j = 0; j<taille; j++)
            {
                matrice[i][j] = false;
            }
        }
    }
    
    public void Feu (Coordonnee c)
    {
        matrice[c.getX()][c.getY()] = true;
    }
    
    public boolean estTire(Coordonnee c)
    {
        return matrice[c.getX()][c.getY()];
    }

    /**
     * @return the taille
     */
    public int getTaille() {
        return taille;
    }

    /**
     * @param taille the taille to set
     */
    public void setTaille(int taille) {
        this.taille = taille;
    }
}
