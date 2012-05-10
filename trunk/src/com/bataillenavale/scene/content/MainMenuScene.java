/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.Gdx;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;

/**
 * Main Menu Scene
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class MainMenuScene implements Scene{

    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    private boolean m_newScene;
    
    /**
     * Constructor
     * @param _fps True if show fps 
     */
    public MainMenuScene(boolean _fps){
        this.m_fps = _fps;
        this.m_init = false;
        this.m_newScene = false;
    }
    
    /**
     * @see Scene#init() 
     */
    @Override
    public void init() {
        if (!this.m_init) {
            System.out.println("Main Menu Scene (init)");
            Singleton.getGraphic().createTextFont("Main Menu", "{Main Menu Scene}", 220, 50, "Ascent");
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
            if (Gdx.input.isTouched()){
                this.m_init = false;
                Singleton.getGraphic().getGame().getScreen().nextScene(new GameScene(true));
                this.m_newScene = true;
            }
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
    public boolean isInit() {
        return this.m_init;
    }

    /**
     * @see  Scene#newScene()
     */
    @Override
    public boolean newScene() {
        return this.m_newScene;
    }
}
