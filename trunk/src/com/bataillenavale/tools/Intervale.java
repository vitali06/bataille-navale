/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.tools;

/**
 *
 * @author Alexis
 */
import java.util.ArrayList;

public class Intervale {

    private ArrayList<Coordonnee> tab;

    public Intervale() {
        tab = new ArrayList<>();
    }

    public void add(Coordonnee c) {
        tab.add(c);
    }

    public Coordonnee get(int n) {
        return tab.get(n);
    }

    public ArrayList<Coordonnee> getTab() {
        return tab;
    }

    public int getTaille() {
        return tab.size();
    }

    public boolean contains(Coordonnee coordonnee) {
        for (Coordonnee c : tab) {
            if (c.equals(coordonnee)) {
                return true;
            }
        }
        return false;
    }
}
