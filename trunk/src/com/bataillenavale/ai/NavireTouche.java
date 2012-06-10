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

    public NavireTouche(Matrice m, Coordonnee _navire_trouve) {
        mat = m;
        navire_trouve = _navire_trouve;
    }

    @Override
    public Coordonnee execute() {
        Coordonnee c = new Coordonnee();
        boolean choix = false;
        boolean tir_manque = false;
        int h_g = 1;
        int h_d = 1;
        int v_h = 1;
        int v_b = 1;
        while (!choix) 
        {
            //Recherche Horizontale gauche
            while (!choix && !tir_manque) 
            {
                if (navire_trouve.getX() - h_g >= 0) 
                {
                    if (mat.estTire(new Coordonnee(navire_trouve.getX() - h_g, navire_trouve.getY())) == 0) 
                    {
                        if (navire_trouve.getX() - h_g < 0) 
                        {
                            c.setX(0);
                        } else {
                            c.setX(navire_trouve.getX() - h_g);
                        }
                        c.setY(navire_trouve.getY());
                        choix = true;
                    } 
                    else if (mat.estTire(new Coordonnee(navire_trouve.getX() - h_g, navire_trouve.getY())) == 1) 
                    {
                        tir_manque = true;
                    } else if (mat.estTire(new Coordonnee(navire_trouve.getX() - h_g, navire_trouve.getY())) == 2) 
                    {
                        h_g = h_g++;
                    }
                }
                else
                {
                    tir_manque = true;
                }
            }
            
                tir_manque = false;

                //Recherche Horizontale droite
                while (!choix && !tir_manque) 
                {
                    if(navire_trouve.getX() + h_d <= mat.getTaille() - 1)
                    {
                        if (mat.estTire(new Coordonnee(navire_trouve.getX() + h_d, navire_trouve.getY())) == 0) 
                        {
                            if (navire_trouve.getX() + h_d > mat.getTaille() - 1) 
                            {
                                c.setX(0);
                            } 
                            else 
                            {
                                c.setX(navire_trouve.getX() + h_d);
                            }
                            c.setY(navire_trouve.getY());
                            choix = true;
                        } 
                        else if (mat.estTire(new Coordonnee(navire_trouve.getX() + h_d, navire_trouve.getY())) == 1) 
                        {
                            tir_manque = true;
                        } 
                        else if (mat.estTire(new Coordonnee(navire_trouve.getX() + h_d, navire_trouve.getY())) == 2) 
                        {
                            h_d = h_d++;
                        }
                    }
                    else
                    {
                        tir_manque = true;
                    }
                }
                tir_manque = false;

                // Recherche Verticale haut
                while (!choix && !tir_manque) 
                {
                    if(navire_trouve.getY() - v_h >=0)
                    {
                        if (mat.estTire(new Coordonnee(navire_trouve.getX(), navire_trouve.getY() - v_h)) == 0) 
                        {
                            c.setX(navire_trouve.getX());
                            if (navire_trouve.getY() - v_h < 0) 
                            {
                                c.setY(0);
                            } 
                            else 
                            {
                                c.setY(navire_trouve.getY() - v_h);
                            }
                            choix = true;
                        }
                        else if (mat.estTire(new Coordonnee(navire_trouve.getX(), navire_trouve.getY() - v_h)) == 1) 
                        {
                            tir_manque = true;
                        }
                        else if (mat.estTire(new Coordonnee(navire_trouve.getX(), navire_trouve.getY() - v_h)) == 2) 
                        {
                            v_h = v_h++;
                        }
                    }
                    else
                    {
                        tir_manque = true;
                    }
                }
                tir_manque = false;

                //Recherche Verticale bas
                while (!choix && !tir_manque) 
                {
                    if(navire_trouve.getY() + v_b <= mat.getTaille() - 1)
                    {
                        if (mat.estTire(new Coordonnee(navire_trouve.getX(), navire_trouve.getY() + v_b)) == 0) 
                        {
                            c.setX(navire_trouve.getX());
                            if (navire_trouve.getY() + v_b < mat.getTaille() - 1) 
                            {
                                c.setY(mat.getTaille());
                            } 
                            else 
                            {
                                c.setY(navire_trouve.getY() + v_b);
                            }
                            choix = true;
                        } 
                        else if (mat.estTire(new Coordonnee(navire_trouve.getX(), navire_trouve.getY() + v_b)) == 1) 
                        {
                            tir_manque = true;
                        } 
                        else if (mat.estTire(new Coordonnee(navire_trouve.getX(), navire_trouve.getY() + v_b)) == 2) 
                        {
                            v_b = v_b++;
                        }
                    }
                    else
                    {
                        tir_manque = true;
                    }
                }
            }
            return c;
        }

    }
