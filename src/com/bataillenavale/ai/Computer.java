/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.ai;

import com.bataillenavale.tools.Coordonnee;
import com.bataillenavale.tools.Intervale;
import java.util.HashMap;

public class Computer {

    private Matrice mat_tir;
    private int rayon_zone;
    private Intervale intervale;
    private Strategie strategie;
    private static Computer elem;
    private Coordonnee navire_trouve;
    //private ArrayList<Intervale> position_navire;
    private HashMap<String,Intervale> position_navire;

    private Computer(int taille) {
        mat_tir = new Matrice(taille);
        rayon_zone = 2;
        position_navire = new HashMap<>();
        intervale = new Intervale();
    }

    public static Computer getElement() {
        if (elem == null) {
            elem = new Computer(9);
        } else {
        }
        return elem;
    }

    public Coordonnee Fire() {
        Coordonnee tir;
        tir = strategie.execute();
        return tir;
    }

    public void updateMat(Coordonnee c, int res_tir) {
        mat_tir.Feu(c, res_tir);
    }

    public void strategieChange(int etat_recherche) {
        if (etat_recherche == 1) {
            strategie = new NavireTouche(mat_tir, getNavire_trouve());
        } else {
            if (rayon_zone < 1) {
                strategie = new IntervaleMax(mat_tir);
            } else {
                strategie = new RechercheZone(mat_tir, rayon_zone);
            }
        }
    }

    public HashMap<String,Intervale> placerNavire() {
        Coordonnee c;
        
        //Coordonnee pour le Lance-Torpilles (2 vies)
        intervale = new Intervale();
        c = new Coordonnee();
        c.setX(0);
        c.setY(0);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(1);
        c.setY(0);
        intervale.add(c);
        position_navire.put("Lance-Torpilles", intervale);


        //Coordonnee pour le Contre-Torpilleur (3 vies)
        intervale = new Intervale();
        c = new Coordonnee();
        c.setX(2);
        c.setY(2);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(3);
        c.setY(2);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(4);
        c.setY(2);
        intervale.add(c);
        position_navire.put("Contre-Torpilleur", intervale);

        //Coordonnee pour le Sous-Marin (3 vies)
        intervale = new Intervale();
        c = new Coordonnee();
        c.setX(5);
        c.setY(5);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(6);
        c.setY(5);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(7);
        c.setY(5);
        intervale.add(c);
        position_navire.put("Sous-Marin", intervale);

        //Coordonnee pour le Cuirasse (4 vies)
        intervale = new Intervale();
        c = new Coordonnee();
        c.setX(5);
        c.setY(1);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(6);
        c.setY(1);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(7);
        c.setY(1);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(8);
        c.setY(1);
        intervale.add(c);
        position_navire.put("Cuirasse", intervale);

        //Coordonnee pour le Porte-Avions (5 vies)
        intervale = new Intervale();
        c = new Coordonnee();
        c.setX(0);
        c.setY(8);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(1);
        c.setY(8);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(2);
        c.setY(8);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(3);
        c.setY(8);
        intervale.add(c);
        c = new Coordonnee();
        c.setX(4);
        c.setY(8);
        intervale.add(c);
        position_navire.put("Porte-Avions", intervale);
        
        return position_navire;



        //Random horizontal = new Random();
//        Random coordonnee = new Random();
//        int x;
//        int y;
//        boolean choix;
//        boolean contains = false;
//        int life = _life;
//        int i;
//        Intervale inter = new Intervale();
//        Coordonnee c;
//        
//        choix = false;
//        while (!choix) {
//            x = coordonnee.nextInt(mat_tir.getTaille() - life);
//            y = coordonnee.nextInt(mat_tir.getTaille() - 1);
//            for (i = 0; i < life; i++) {
//                c = new Coordonnee(x + i, y);
//                inter.add(c);
//            }
//            for(Intervale intervale : position_navire)
//            {
//                if(intervale.containsIntervale(inter))
//                {
//                    contains=true;
//                    break;
//                }
//            }
//            
//            if (contains == false) {
//                choix = true;
//                position_navire.add(inter);
//            }
//        }
    }

    public Matrice getMat_tir() {
        return mat_tir;
    }

    public void setMat_tir(Matrice mat_tir) {
        this.mat_tir = mat_tir;
    }

    public int getRayon_zone() {
        return rayon_zone;
    }

    public void setRayon_zone(int rayon_zone) {
        this.rayon_zone = rayon_zone;
    }

    public Intervale getIntervale() {
        return intervale;
    }

    public void setIntervale(Intervale intervale) {
        this.intervale = intervale;
    }

    /**
     * @return the position_navire
     */
    public HashMap<String,Intervale> getPosition_navire() {
        return position_navire;
    }

    /**
     * @return the navire_trouve
     */
    public Coordonnee getNavire_trouve() {
        return navire_trouve;
    }

    /**
     * @param navire_trouve the navire_trouve to set
     */
    public void setNavire_trouve(Coordonnee navire_trouve) {
        this.navire_trouve = navire_trouve;
    }
}
