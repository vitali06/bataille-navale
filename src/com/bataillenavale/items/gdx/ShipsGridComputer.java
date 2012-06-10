package com.bataillenavale.items.gdx;

import com.bataillenavale.tools.Intervale;

/**
 *
 * @author Alexis Dörr
 */
//Model
public class ShipsGridComputer {

    //Grille de placement des navires
    //Au départ aucun navire sur la grille, donc on initialise à false
    private static boolean[][] grid = {
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false},
        {false, false, false, false, false, false, false, false, false}
    };

    public ShipsGridComputer() {
    }

    public static boolean hasAShip(int ligne, int colonne) {
        return grid[ligne][colonne];
    }

    public static void setToTrue(int ligne, int colonne) {
        grid[ligne][colonne] = true;
    }

    public static void setToTrue(Intervale inter) {
        for (int i = 0; i < inter.getTaille(); i++) {            
            grid[inter.get(i).getX()][inter.get(i).getY()] = true;
        }
    }

    public static void outString() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.println("i : " + i + ", j : " + j + " " + grid[i][j]);
            }
        }
    }
}
