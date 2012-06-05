/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import com.bataillenavale.tools.Intervale;
import com.bataillenavale.tools.Coordonnee;
import java.util.ArrayList;
import java.util.Random;

public class IntervaleMax implements Strategie 
{
    private Matrice mat;
    private ArrayList<Intervale> liste_intermax;
    int taillemax;
    
    public IntervaleMax(Matrice _mat)
    {
        mat = _mat;
        liste_intermax = new ArrayList<Intervale>();
        taillemax = 0;
    }
    
    public void interHorizontal()
    {
         for(int i = 0; i < mat.getTaille() ;i++)
       {
         Intervale inter = new Intervale();
         for(int j = 0; j < mat.getTaille() ;j++)
         {
             Coordonnee c= new Coordonnee(i,j);
             if(mat.estTire(c) || j == mat.getTaille() -1)
             {
                 if(inter.getTaille() == taillemax)
                 {
                     liste_intermax.add(inter);
                 }
                 else if(inter.getTaille() > taillemax)
                 {
                     liste_intermax.clear();
                     liste_intermax.add(inter);
                     taillemax = inter.getTaille();
                 }
                 inter = new Intervale();
             }
             else
             {
                 inter.add(c);
             }
         }
       }
    }
    
    public void interVerticale()
    {
         for(int i = 0; i < mat.getTaille() ;i++)
       {
         Intervale inter = new Intervale();
         for(int j = 0; j < mat.getTaille() ;j++)
         {
             Coordonnee c= new Coordonnee(j,i);
             if(mat.estTire(c) || j == mat.getTaille() -1)
             {
                 if(inter.getTaille() == taillemax)
                 {
                     liste_intermax.add(inter);
                 }
                 else if(inter.getTaille() > taillemax)
                 {
                     liste_intermax.clear();
                     liste_intermax.add(inter);
                     taillemax = inter.getTaille();
                 }
                 inter = new Intervale();
             }
             else
             {
                 inter.add(c);
             }
         }
       }
    }

    @Override
    public Coordonnee execute() 
    {
        Coordonnee c = new Coordonnee();
        interHorizontal();
        interVerticale();
        Random r= new Random();
        int n = r.nextInt(liste_intermax.size());
        if(n == liste_intermax.size())
        {
            n = n -1;
        }
        Intervale tmp = liste_intermax.get(n);
        c = tmp.get(tmp.getTaille() / 2);
        return c;
    }
    
}
