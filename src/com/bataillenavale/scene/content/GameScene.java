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
        if (!this.m_init){
            //if (Singleton.getGraphic().getGame().getGroup().getActors().isEmpty()){
                System.out.println("Game Scene (init)");
                System.out.println("(Init) Init Graphic Game : " + Singleton.getGraphic().isInit());
                Singleton.getGraphic().createTextActor("NouveauTest", "Game Scene", 350, 200);
                this.m_init = true;
            //}
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if (this.m_init){
            //if ( this.i < 1){
            System.out.println("GameScene Update");
            // Singleton.getGraphic().createTextActor("Nouveau Test", "Game Scene", 350, 200);
            System.out.println("(Update) Graphic Game : " + Singleton.getGraphic().isInit());
            //}
            //this.i++;
            // System.out.println("GameScene Update " + this.i);
            
        }
    }

    /**
     * @see Scene#destroy()
     */
    @Override
    public void destroy() {
        Singleton.getGraphic().getGame().delAllActors();
    }

    /**
     * @see Scene#getFps()
     */
    @Override
    public boolean getFps() {
        return this.m_fps;
    }
    
    @Override
    public boolean isInit(){
        return this.m_init;
    }
}
