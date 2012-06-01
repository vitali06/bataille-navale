package com.bataillenavale.tools;

/**
 *
 * @author Mélissa WEISSMULLER
 */

//Model

public class ShipsGrid {
    
    //Grille de placement des navires
    //Au départ aucun navire sur la grille, donc on initialise à false

    private boolean[][] grid = {
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
    
    public ShipsGrid() {
        
    }

    public boolean hasAShip(int ligne, int colonne) {
        return grid[ligne][colonne];
    }

    public void setToTrue(int ligne, int colonne) {
        grid[ligne][colonne] = true;
    }
    
    
    public void outString() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.println("i : " + i + "j : " + j + " " + grid[i][j]);
            }
        }
    }
}
