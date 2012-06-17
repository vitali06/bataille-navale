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
    private int m_count;
    
    /**
     * Constructor
     * @param _fps True if show fps
     */
    public AboutScene(boolean _fps){
        this.m_fps = _fps;
        m_sizeGame = Singleton.getGraphic().getDimensions();
        this.m_init = false;
        this.m_newScene = false;
        this.m_count=0;
    }
    
    /**
     * @see Scene#init()
     */
    @Override
    public void init() {
        if (!this.m_init) {            
            Singleton.getGraphic().createTextFont("AboutScene", "{About Scene}", 270, 50, "Ascent");
            Singleton.getGraphic().setColorText("AboutScene", 1.f, 0.f, 0.f);
            Singleton.getGraphic().createTextFont("Equipe", "Equipe projet : Melissa WEISSMULLER, Alexis DORR, Laurent SITTLER", 30, 400, "Calibri");
            Singleton.getGraphic().createTextFont("Realisation", "Dans le cadre de notre premiere annee d'etude \"Ingenieur en Informatique\" en alternance a l'ITII", 30, 350, "Calibri");
            Singleton.getGraphic().createTextFont("Technique", "Application realisee en Java et avec la librairie libGDX", 30, 300, "Calibri");
            Singleton.getGraphic().createTextFont("BackMenu", "Pour retourner au menu : Appuyez sur Entree", 245, 100, "Calibri");            
            Singleton.getGraphic().setColorText("BackMenu", 1.f, 0.f, 0.f);
            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if (this.m_init) {
            this.m_count++;
            Singleton.getGraphic().setAlpha("BackMenu", this.m_count / 0.25f);
            if (Singleton.getInput().isEnterPressed()) {
                // Retour au menu principal
                this.m_init = false;
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
