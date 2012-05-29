/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.tools;

import com.badlogic.gdx.Gdx;
import com.bataillenavale.game.Singleton;

/**
 *
 * @author sittlerl
 */
public class Grid {
    
    /// Attibutes
    private int m_size;
    private String m_path;
    private String m_names;
    
    public Grid(int size){
        this.m_size = size;
        this.m_path = "data/items/SpriteCases.png";
        this.m_names = "Case";
        
        for (int i = 0; i < this.m_size; i++){
            for (int j = 0; j < this.m_size; j++){
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createSprite(this.m_names + i + j, this.m_path, posX, posY, 50, 50, 0, 0, 1);
                Singleton.getGraphic().setAlpha(this.m_names + i + j, 0.35f);
            }
        }
        System.out.println("Grille créée!");
    }
    
}
