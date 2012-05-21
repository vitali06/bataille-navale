/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main Menu Scene
 *
 * @author Alexis, Mélissa, Laurent
 */
public class MainMenuScene implements Scene {

    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    private boolean m_newScene;
    private int m_count;    
    private int indexSelectedMenu = 0;
    private List<String> listMenu = new ArrayList<>();

    /**
     * Constructor
     *
     * @param _fps True if show fps
     */
    public MainMenuScene(boolean _fps) {
        this.m_fps = _fps;
        this.m_count = 0;
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
            try {
                Singleton.getGraphic().loadSprites("config/MainMenuScreen.xml");
            } catch (Exception ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Singleton.getGraphic().createTextFont("Main Menu", "{Main Menu}", 30, 550, "Ascent");
            Singleton.getGraphic().createTextFont("Game", "GAME", 230, 450, "Calibrib");
            Singleton.getGraphic().createTextFont("Settings", "SETTINGS", 195, 400, "Calibrib");
            Singleton.getGraphic().createTextFont("About", "ABOUT", 220, 350, "Calibrib");

            listMenu.add("Game");
            listMenu.add("Settings");
            listMenu.add("About");           
            
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

            Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), this.m_count / 0.25f);

            if (Singleton.getInput().isEnterPressed()) {                
                if ("Game".equals(listMenu.get(indexSelectedMenu))) {
                    this.m_init = false;
                    Singleton.getGraphic().getGame().getScreen().nextScene(new GameScene(true));
                    this.m_newScene = true;
                }
                if ("Settings".equals(listMenu.get(indexSelectedMenu))) {
                    this.m_init = false;
                    Singleton.getGraphic().getGame().getScreen().nextScene(new SettingsScene(false));
                    this.m_newScene = true;
                }
                if ("About".equals(listMenu.get(indexSelectedMenu))) {
                    this.m_init = false;
                    Singleton.getGraphic().getGame().getScreen().nextScene(new AboutScene(false));
                    this.m_newScene = true;
                }                
            }

            if (Singleton.getInput().isDownPressed()) {                
                if (indexSelectedMenu + 1 < listMenu.size()) {
                    Singleton.getSound().changeMenu();
                    Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                    indexSelectedMenu++;
                    Singleton.getGraphic().setPositionActor("BandeauNoir", 0, Singleton.getGraphic().getText().get(listMenu.get(indexSelectedMenu)).y - 23);                                                                    
                }                
            }

            if (Singleton.getInput().isUpPressed()) {                
                if (indexSelectedMenu - 1 >= 0) {
                    Singleton.getSound().changeMenu();
                    Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                    indexSelectedMenu--;
                    Singleton.getGraphic().setPositionActor("BandeauNoir", 0, Singleton.getGraphic().getText().get(listMenu.get(indexSelectedMenu)).y - 23);                            
                }
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
     * @see Scene#newScene()
     */
    @Override
    public boolean newScene() {
        return this.m_newScene;
    }
}
