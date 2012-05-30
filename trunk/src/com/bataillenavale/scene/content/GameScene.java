/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.items.gdx.Ships;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.tools.Cases;
import com.bataillenavale.tools.Grid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Scene of Game
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class GameScene implements Scene {
    
    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    private Rectangle m_sizeGame;
    
    /**
     * Constructor
     * @param _fps True if show fps
     */
    public GameScene(boolean _fps){
        this.m_fps = _fps;
        m_sizeGame = Singleton.getGraphic().getDimensions();
        this.m_init = false;
    }
    
    /**
     * @see Scene#init()
     */
    @Override
    public void init() {
        if (!this.m_init) {
            System.out.println("Game Scene (init)");
            // Map standard
             int posX = ((Gdx.graphics.getWidth() - 300 - 450) / 2) + 300;
             int posY = ((Gdx.graphics.getHeight() - 450) / 2);
             Singleton.getGraphic().createSprite("Map01", "data/Maps/Map01.png", posX, posY, 450, 450, 0, 0, 1);
            // Grille de positionnement
            Grid grille = new Grid(9);
            try {
                Singleton.getGraphic().loadSprites("config/PrepareGameScene.xml");
            } catch (ParserConfigurationException | IOException | SAXException ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Ships t_ships = new Ships();
            Singleton.getGraphic().createTextFont("PGame", "{Game}", 70, 550, "Ascent");
            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if (this.m_init){
            //System.out.println("GameScene Update");
            Cases test = new Cases((int)Gdx.input.getX(), (int)(Gdx.graphics.getHeight() - Gdx.input.getY()), "Select");
        }
    }

    /**
     * @see Scene#destroy()
     */
    @Override
    public void destroy() {
        this.m_init = false;
        Singleton.getGraphic().getActors().clear();
        Singleton.getGraphic().getAnim().clear();
        Singleton.getGraphic().getText().clear();
    }

    /**
     * @see Scene#getFps()
     */
    @Override
    public boolean getFps() {
        return this.m_fps;
    }
    
    /**
     * @see Scene#isInit()
     */
    @Override
    public boolean isInit(){
        return this.m_init;
    }

    /**
     * @see Scene#newScene()
     */
    @Override
    public boolean newScene() {
        return false;
    }
}
