/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import com.bataillenavale.tools.Coordonnee;

public class NavireTouche implements Strategie {

    Matrice mat;
    int horizontale_verticale;
    Coordonnee navire_trouve;
    int decalage = 0;

    public NavireTouche(Matrice m, Coordonnee _navire_trouve,int d, int h_v) {
        mat = m;
        navire_trouve = _navire_trouve;
        decalage = d;
        horizontale_verticale = h_v;
    }

    @Override
    public Coordonnee execute() 
    {
        Coordonnee c = new Coordonnee();
        boolean choix = false;
        boolean tir_manque = false;
        if(horizontale_verticale == 1)
        {
            c.setX(navire_trouve.getX() - decalage);
            c.setY(navire_trouve.getY());
        }
        else if(horizontale_verticale == 2)
        {
            c.setX(navire_trouve.getX() + decalage);
            c.setY(navire_trouve.getY());
        }
        else if(horizontale_verticale == 3)
        {
            c.setX(navire_trouve.getX());
            c.setY(navire_trouve.getY() - decalage);
        }
        else
        {
            c.setX(navire_trouve.getX());
            c.setY(navire_trouve.getY() + decalage);
        }

        return c;

          }

    }
