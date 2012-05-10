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
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class Splashscreen implements Scene{
    
    /// Attributes
    private boolean m_init;
    private int m_compteur;
    private int m_fondu;
    private boolean m_fps;
    private boolean m_newScene;
    
    /**
     * Constructror
     * @param _fps True if show fps
     */
    public Splashscreen(boolean _fps){
        this.m_fps = _fps;
        this.m_init = false;
        this.m_compteur = 0;
        this.m_fondu = 0;
        this.m_newScene = false;
    }
    
    /**
     * @see Scene#init() 
     */
    @Override
    public void init() {
        if(!this.m_init){
            System.out.println("Splash Screen Scene (Init)");
            try {
                Singleton.getGraphic().loadSprites("config/SplashSreen.xml");
            } catch (Exception ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Singleton.getGraphic().createTextFont("Test", "         Presented by\n\n      Laurent SITTLER\nMelissa WEISSMULLER\n         Alexis DORR", 320, 220, "Calibri");
            Singleton.getGraphic().setAlphaActor("Backgound Slpashsreen", 0);
            Singleton.getGraphic().setAlphaAnim("Animation", 0);
            Singleton.getGraphic().setAlphaText("Test", 0);
            
            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if(this.m_init){
            this.m_compteur++;
            
            if (this.m_compteur < 500){
                Singleton.getGraphic().setAlphaActor("Java", -this.m_compteur/2);
                Singleton.getGraphic().setAlphaActor("LibGDX", -this.m_compteur/2);
            }
            if (this.m_compteur > 
                    500 && this.m_compteur < 900){
                this.m_fondu++;
                Singleton.getGraphic().setAlphaActor("Java", 0);
                Singleton.getGraphic().setAlphaActor("LibGDX", 0);
                Singleton.getGraphic().setAlphaActor("Backgound Slpashsreen", -this.m_fondu/2);
                Singleton.getGraphic().setAlphaAnim("Animation", -this.m_fondu/2);
                Singleton.getGraphic().setAlphaText("Test", -this.m_fondu/2);
            }
            if (this.m_compteur == 900){
                this.m_fondu = 0;
            }
            if (this.m_compteur > 900){
                this.m_fondu++;
                Singleton.getGraphic().setAlphaText("Test", this.m_fondu/2);
                Singleton.getGraphic().setAlphaActor("Backgound Slpashsreen", this.m_fondu/2);
            }
            // Changement de scene
            if (this.m_compteur == 1400){
                this.m_init = false;
                // Singleton.getGraphic().getGame().getScreen().nextScene(new GameScene(true));
                Singleton.getGraphic().getGame().getScreen().nextScene(new MainMenuScene(false));
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
        // System.out.println("Après suppression reste HashMap Actor : " + Singleton.getGraphic().getActors().size());
        Singleton.getGraphic().getAnim().clear();
        // System.out.println("Après suppression reste HashMap Anim : " + Singleton.getGraphic().getAnim().size());
        Singleton.getGraphic().getText().clear();
        // System.out.println("Après suppression reste HashMap Text : " + Singleton.getGraphic().getText().size());
    }
    
    /**
     * @see Scene#getFps() 
     */
    @Override
    public boolean getFps(){
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
     * @see Scene#newScene()
     */
    @Override
    public boolean newScene(){
        return this.m_newScene;
    }
}
