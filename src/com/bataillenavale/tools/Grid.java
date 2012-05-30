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
    
    public Grid(int size){
        this.m_size = size;
        this.m_path = "data/items/SpriteCases.png";
        
        // Check grid hidden (Check)
        for (int i = 0; i < this.m_size; i++){
            for (int j = 0; j < this.m_size; j++){
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createSprite("Check" + i + j, this.m_path, posX, posY, 50, 50, 150, 0, 1);
                Singleton.getGraphic().setVisible("Check" + i + j, false);
            }
        }
        
        // Use grid hidden (Use)
        for (int i = 0; i < this.m_size; i++){
            for (int j = 0; j < this.m_size; j++){
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createSprite("Use" + i + j, this.m_path, posX, posY, 50, 50, 100, 0, 1);
                Singleton.getGraphic().setVisible("Use" + i + j, false);
                Singleton.getGraphic().setAlpha("Use" + i + j, 0.5f);
            }
        }
        
        // Select grid hidden (Select)
        for (int i = 0; i < this.m_size; i++){
            for (int j = 0; j < this.m_size; j++){
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createSprite("Select" + i + j, this.m_path, posX, posY, 50, 50, 50, 0, 1);
                Singleton.getGraphic().setVisible("Select" + i + j, false);
                Singleton.getGraphic().setAlpha("Select" + i + j, 0.35f);
            }
        }
        
        // Basic grid visible (Case)
        for (int i = 0; i < this.m_size; i++){
            for (int j = 0; j < this.m_size; j++){
                int posX = ((Gdx.graphics.getWidth() - 300 - 50 * this.m_size) / 2) + 300 + 50 * i;
                int posY = ((Gdx.graphics.getHeight() - 50 * this.m_size) / 2) + 50 * j;
                Singleton.getGraphic().createSprite("Case" + i + j, this.m_path, posX, posY, 50, 50, 0, 0, 1);
                Singleton.getGraphic().setAlpha("Case" + i + j, 0.35f);
            }
        }
        System.out.println("Grilles créées!");
    }
    
}
