/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

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
    
    /**
     * Constructor
     * @param _fps True if show fps 
     */
    public MainMenuScene(boolean _fps){
        this.m_fps = _fps;
        this.m_init = false;
    }
    
    /**
     * @see Scene#init() 
     */
    @Override
    public void init() {
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
    }

    /**
     * @see Scene#destroy()
     */
    @Override
    public void destroy() {
    }

    /**
     * @see Scene#getFps()
     */
    @Override
    public boolean getFps() {
        return this.m_fps;
    }

    @Override
    public boolean isInit() {
        return this.m_init;
    }    
}
