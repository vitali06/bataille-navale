/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

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
            //System.out.println("Splash Screen Scene (Init)");
            try {
                Singleton.getGraphic().loadSprites("config/SplashScreen.xml");
            } catch (ParserConfigurationException | IOException | SAXException ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Singleton.getGraphic().createTextFont("Test", "Presented by : Laurent SITTLER, Melissa WEISSMULLER, Alexis DORR", 150, 20, "Calibri");
            Singleton.getGraphic().createTextFont("Press", "Press ENTER", 270, 270, "SimHei");
            Singleton.getGraphic().setAlpha("Backgound Slpashsreen", 0);
            Singleton.getGraphic().setAlpha("Enter", 0);
            Singleton.getGraphic().setAlpha("Bandeau", 0);
            Singleton.getGraphic().setAlpha("Press", 0);
            
            Singleton.getSound().introductionScene();
            
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

            if (this.m_compteur > 300 && this.m_compteur < 750){
                Singleton.getGraphic().setAlpha("Java", 0);
                Singleton.getGraphic().setAlpha("LibGDX", 0);
                Singleton.getGraphic().setAlpha("Test", 0);
                Singleton.getGraphic().setAlpha("Backgound Slpashsreen", 1);
                Singleton.getGraphic().setAlpha("Bandeau", 1);
                Singleton.getGraphic().setAlpha("Enter", 1);
                Singleton.getGraphic().setAlpha("Press", 1);
            }
            // Changement de scene
            if (Singleton.getInput().isEnterPressed()) {
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
