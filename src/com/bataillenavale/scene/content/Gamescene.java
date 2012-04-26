/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.scene.Scene;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class Gamescene implements Scene {
    
    private boolean m_init;
    private boolean m_fps;
    
    public Gamescene(boolean _fps){
        m_fps = _fps;
        m_init = false;
    }
    
    @Override
    public void init() {
        System.out.println("Game Scene");
        m_init = true;
    }

    @Override
    public void update() {
        // Contenu de la scène de jeux
    }

    @Override
    public void destroy() {
    }

    @Override
    public boolean getFps() {
        return m_fps;
    }
}
