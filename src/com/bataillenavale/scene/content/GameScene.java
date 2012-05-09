/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;

/**
 * Scene of Game
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class GameScene implements Scene {
    
    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    
    /**
     * Constructor
     * @param _fps True if show fps
     */
    public GameScene(boolean _fps){
        this.m_fps = _fps;
        this.m_init = false;
    }
    
    /**
     * @see Scene#init()
     */
    @Override
    public void init() {
        if (!this.m_init) {
            System.out.println("Game Scene (init)");
            Singleton.getGraphic().createTextActor("NouveauTest", "Game Scene", 350, 200);
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
