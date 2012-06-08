/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import com.bataillenavale.tools.Coordonnee;
import com.bataillenavale.tools.Intervale;
import java.util.ArrayList;

public class Computer 
{
    private Matrice mat_tir;
    private int rayon_zone;
    private Intervale intervale;
    Strategie strategie;
    Computer elem;
    Coordonnee tir_precedent;
    
    private Computer(int taille)
    {
        mat_tir = new Matrice(taille);
        rayon_zone = taille/2;
    }
    
    public Computer getElement()
    {
        if(elem == null)
        {
            elem = new Computer(9);
        }
        else
        {
            
        }
        return elem;
    }
    
    public Coordonnee Fire()
    {
        Coordonnee tir;
        tir = strategie.execute();
        mat_tir.Feu(tir);
        tir_precedent = tir;
        return tir;
    }
    
    public void strategieChange(int etat_recherche, int res_tir)
    {
        if(etat_recherche == 1)
        {
            strategie = new NavireTouche(mat_tir, res_tir, tir_precedent);
        }
        else
        {
            if(rayon_zone < 1)
            {
                strategie = new IntervaleMax(mat_tir);
            }
            else
            {
                strategie = new RechercheZone(mat_tir, rayon_zone);
            }
        }
    }
    
    public ArrayList<Intervale> Placer_navire()
    {
        ArrayList<Intervale> position_navire = new ArrayList();
        return position_navire;    
    }

    public Matrice getMat_tir() 
    {
        return mat_tir;
    }

    public void setMat_tir(Matrice mat_tir) 
    {
        this.mat_tir = mat_tir;
    }

    public int getRayon_zone() 
    {
        return rayon_zone;
    }

    public void setRayon_zone(int rayon_zone) 
    {
        this.rayon_zone = rayon_zone;
    }

    public Intervale getIntervale() 
    {
        return intervale;
    }

    public void setIntervale(Intervale intervale) 
    {
        this.intervale = intervale;
    }
    
   
}
