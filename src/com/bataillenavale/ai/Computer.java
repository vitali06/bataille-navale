/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;


public class Computer 
{
    private Matrice mat_tir;
    private int rayon_zone;
    private Intervale intervale;
    Strategie strategie;
    
    public Computer(int taille)
    {
        mat_tir = new Matrice(taille);
        rayon_zone = taille/2;
        strategie = new RechercheZone(mat_tir,rayon_zone);
    }
    
           
    
   
}
