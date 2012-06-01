/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.tools;

import com.badlogic.gdx.Gdx;
import com.bataillenavale.game.Singleton;

/**
 * Tool draw grids
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class Grid {

    /// Attibutes
    private int m_size;
    private String m_path;

    /**
     * Constructor
     *
     * @param size Number of colonnes and lines
     */
    public Grid(int size) {
        this.m_size = size;
        this.m_path = "data/items/SpriteCases.png";

        // The order of draw is very important

        drawCheckGrid();
        drawUseGrid();
        drawSelectGrid();
        drawGrid();

        // End drw
        System.out.println("Grilles créées!");
    }

    /**
     * Draw first grid position
     */
    private void drawGrid() {
        for (int i = 0; i < this.m_size; i++) {
            for (int j = 0; j < this.m_size; j++) {
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createShipsGrid("Case" + i + j, this.m_path, posX, posY, 50, 50, 0, 0);
                Singleton.getGraphic().setAlpha("Case" + i + j, 0.35f);
            }
        }
    }

    /**
     * Draw select grid (Hidden)
     */
    private void drawSelectGrid() {
        for (int i = 0; i < this.m_size; i++) {
            for (int j = 0; j < this.m_size; j++) {
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createShipsGrid("Select" + i + j, this.m_path, posX, posY, 50, 50, 50, 0);
                Singleton.getGraphic().setVisible("Select" + i + j, false);
                Singleton.getGraphic().setAlpha("Select" + i + j, 0.35f);
            }
        }
    }

    /**
     * Draw use grid (Hidden)
     */
    private void drawUseGrid() {
        for (int i = 0; i < this.m_size; i++) {
            for (int j = 0; j < this.m_size; j++) {
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createShipsGrid("Use" + i + j, this.m_path, posX, posY, 50, 50, 100, 0);
                Singleton.getGraphic().setVisible("Use" + i + j, false);
                Singleton.getGraphic().setAlpha("Use" + i + j, 0.5f);
            }
        }
    }

    /**
     * Draw check grid (Hidden)
     */
    private void drawCheckGrid() {
        for (int i = 0; i < this.m_size; i++) {
            for (int j = 0; j < this.m_size; j++) {
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createShipsGrid("Check" + i + j, this.m_path, posX, posY, 50, 50, 150, 0);
                Singleton.getGraphic().setVisible("Check" + i + j, false);
            }
        }
    }
}
