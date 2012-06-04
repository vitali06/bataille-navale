/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.items.gdx;

/**
 *
 * @author Mélissa
 */
public class ShootingGrid {

    //Le code 0 signifie que les cases n'ont pas encore été tiré
    private static int[][] grid = {
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0},
        {0, 0, 0, 0, 0, 0, 0, 0, 0}
    };

    public ShootingGrid() {
    }
    
    //Value = 1 s'il y a une navire sur cette case
    //Value = 2 s'il n'y pas de navire sur cette case
    public static void setToValue(int ligne, int colonne, int value) {
        grid[ligne][colonne] = value;
    }
}
