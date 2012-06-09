/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.math.Rectangle;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;

/**
 * AboutScene
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class AboutScene implements Scene {
    
    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    private Rectangle m_sizeGame;
    private boolean m_newScene;
    
    /**
     * Constructor
     * @param _fps True if show fps
     */
    public AboutScene(boolean _fps){
        this.m_fps = _fps;
        m_sizeGame = Singleton.getGraphic().getDimensions();
        this.m_init = false;
        this.m_newScene = false;
    }
    
    /**
     * @see Scene#init()
     */
    @Override
    public void init() {
        if (!this.m_init) {            
            Singleton.getGraphic().createTextFont("AboutScene", "{About Scene}", 270, 50, "Ascent");
            Singleton.getGraphic().setColorText("AboutScene", 1.f, 0.f, 0.f);
            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if (this.m_init){
            //System.out.println("AboutScene Update");
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
        return this.m_newScene;
    }
}
