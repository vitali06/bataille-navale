/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import com.bataillenavale.tools.Coordonnee;

public class NavireTouche implements Strategie
{
    Matrice mat;
    int resultat_tir_pre;

    public NavireTouche(Matrice m, int r)
    {
        mat = m;
        resultat_tir_pre = r;
    }
    
    @Override
    public Coordonnee execute() 
    {
        Coordonnee c = new Coordonnee();
        return c;
    }
    
}
