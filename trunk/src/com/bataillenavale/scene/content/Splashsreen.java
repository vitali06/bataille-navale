/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SplashSrceen Scene
 * @author Alexis, Mélissa, Laurent
 */
public class Splashsreen implements Scene{
    
    private boolean m_init;
    private int m_compteur;
    private boolean m_fps;
    
    public Splashsreen(boolean _fps){
        m_fps = _fps;
        m_init = false;
        m_compteur = 0;
    }
    
    @Override
    public void init() {
        if(!m_init){
            System.out.println("Splash Screen Scene (Init)");
            try {
                Singleton.getGraphic().loadSprites("config/SplashSreen.xml");
            } catch (Exception ex) {
                Logger.getLogger(Splashsreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            m_init = true;
        }
    }

    @Override
    public void update() {
        m_compteur++;
        if (m_compteur > 500){
            Singleton.getGraphic().getGame().setScene(new Gamescene(true));
        }
    }

    @Override
    public void destroy() {
        Singleton.getGraphic().getGame().delAllActors();
    }
    
    @Override
    public boolean getFps(){
        return m_fps;
    }
}
