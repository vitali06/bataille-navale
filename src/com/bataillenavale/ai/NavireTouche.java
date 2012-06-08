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
    int horizontale_verticale;
    Coordonnee tir_precedent;

    public NavireTouche(Matrice m, int r, Coordonnee tir_prec)
    {
        mat = m;
        resultat_tir_pre = r;
        tir_precedent = tir_prec;
    }
    
    @Override
    public Coordonnee execute() 
    {
        Coordonnee c = new Coordonnee();
        
        return c;
    }
    
}
