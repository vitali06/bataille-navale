/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.Gdx;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.graphic.gdx.ShipsGridGDX;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.tools.DrawShipsGrid;
import com.bataillenavale.tools.DrawShootingGrid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Mélissa
 */
public class GameScene implements Scene {

    private boolean m_fps;
    private boolean m_init;
    private boolean m_newScene;

    public GameScene(boolean fps) {
        this.m_fps = fps;
        this.m_init = false;
        this.m_newScene = false;
    }

    @Override
    public void init() {
                if (!this.m_init) {
            System.out.println("Game Scene (init)");
            // Map standard
            int posX = ((Gdx.graphics.getWidth() - 300 - 450) / 2) + 300;
            int posY = ((Gdx.graphics.getHeight() - 450) / 2);
            Singleton.getGraphic().createSprite("Map01", "data/Maps/Map01.png", posX, posY, 450, 450, 0, 0, 1);
            // Grille de positionnement
            DrawShootingGrid grille = new DrawShootingGrid(9);
            try {
                Singleton.getGraphic().loadSprites("config/PrepareGameScene.xml");
                
            } catch (ParserConfigurationException | IOException | SAXException ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Ships t_ships = new Ships();
            Singleton.getGraphic().createTextFont("Game", "{Game}", 70, 550, "Ascent");
            //Singleton.getGraphic().setColorText("Porte Avions", 1.f, 0.f, 0.f);
            this.m_init = true;
        }
    }

    @Override
    public void update() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public boolean getFps() {
        return this.m_fps;
    }

    @Override
    public boolean isInit() {
        return this.m_init;
    }

    @Override
    public boolean newScene() {
        return this.m_newScene;        
    }
}
