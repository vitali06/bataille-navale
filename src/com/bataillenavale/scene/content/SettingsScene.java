/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.math.Rectangle;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Scene of Settings
 *
 * @author Alexis, Mélissa, Laurent
 */
public class SettingsScene implements Scene {

    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    private Rectangle m_sizeGame;
    private boolean m_newScene;
    private int m_count;
    private int indexSelectedMenu;
    private int indexSelectedSoundMenu;
    private List<String> listMenu;
    private List<String> listMenuSound;
    private boolean mainMenuSelected;

    /**
     * Constructor
     *
     * @param _fps True if show fps
     */
    public SettingsScene(boolean _fps) {
        this.m_fps = _fps;
        m_sizeGame = Singleton.getGraphic().getDimensions();
        this.m_init = false;
        this.m_newScene = false;
        mainMenuSelected = true;
        indexSelectedMenu = 0;
        indexSelectedSoundMenu = 0;
        listMenu = new ArrayList<>();
        listMenuSound = new ArrayList<>();        
    }

    /**
     * @see Scene#init()
     */
    @Override
    public void init() {
        if (!this.m_init) {
//            System.out.println("Settings Scene (init)");
            try {
                Singleton.getGraphic().loadSprites("config/MainMenuSreen.xml");
            } catch (Exception ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }

            Singleton.getGraphic().createTextFont("Settings", "{Settings}", 30, 550, "Ascent");
            Singleton.getGraphic().createTextFont("Sound", "SOUND", 216, 450, "Calibrib");
            Singleton.getGraphic().createTextFont("OnSound", "ON", 375, 450, "Calibrib");
            Singleton.getGraphic().createTextFont("OffSound", "OFF", 450, 450, "Calibrib");
            Singleton.getGraphic().createTextFont("BackMainMenu", "BACK TO MENU", 130, 400, "Calibrib");            
            Singleton.getGraphic().setColorText("OnSound", 1.f, 0.f, 0.f);

            listMenu.add("Sound");
            listMenuSound.add("OnSound");
            listMenuSound.add("OffSound");
            listMenu.add("BackMainMenu");

            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if (this.m_init) {
            //System.out.println("SettingsScene Update");
            this.m_count++;

            if (mainMenuSelected) {
                Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), this.m_count / 0.25f);
            } else {
                if ("Sound".equals(listMenu.get(indexSelectedMenu))) {
                    Singleton.getGraphic().setAlpha(listMenuSound.get(indexSelectedSoundMenu), this.m_count / 0.25f);
                }
            }


            if (Singleton.getInput().isEnterPressed()) {
                if ("BackMainMenu".equals(listMenu.get(indexSelectedMenu))) {
                    /**
                     * Retour au menu principal
                     */
                    this.m_init = false;
                    Singleton.getGraphic().getGame().getScreen().nextScene(new MainMenuScene(false));
                    // System.out.println("Next Scene Main Menu Scene");
                    this.m_newScene = true;
                }

                if ("Sound".equals(listMenu.get(indexSelectedMenu))) {
                    if (mainMenuSelected) {
                        Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                        mainMenuSelected = false;
                    } else {
                        mainMenuSelected = true;
                        Singleton.getGraphic().setAlpha(listMenuSound.get(indexSelectedSoundMenu), 1f);                        
                        if ("OffSound".equals(listMenuSound.get(indexSelectedSoundMenu))) {
                            Singleton.getSound().changeVolume(0f);
                        } else {
                            Singleton.getSound().changeVolume(1f);
                        }
                    }
                }
            }

            if (Singleton.getInput().isDownPressed()) {
                if (indexSelectedMenu + 1 < listMenu.size() && mainMenuSelected) {
                    Singleton.getSound().changeMenu();
                    Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                    indexSelectedMenu++;
                    Singleton.getGraphic().setPositionActor("BandeauNoir", 0, Singleton.getGraphic().getText().get(listMenu.get(indexSelectedMenu)).y - 23);
                }
            }

            if (Singleton.getInput().isUpPressed()) {
                if (indexSelectedMenu - 1 >= 0 && mainMenuSelected) {
                    Singleton.getSound().changeMenu();
                    Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                    indexSelectedMenu--;
                    Singleton.getGraphic().setPositionActor("BandeauNoir", 0, Singleton.getGraphic().getText().get(listMenu.get(indexSelectedMenu)).y - 23);
                }
            }

            if (Singleton.getInput().isRightPressed()) {
                mainMenuSelected = false;
                if ("Sound".equals(listMenu.get(indexSelectedMenu)) && !mainMenuSelected) {
                    Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                    if (indexSelectedSoundMenu + 1 < listMenuSound.size()) {
                        Singleton.getSound().changeMenu();
                        Singleton.getGraphic().setAlpha(listMenuSound.get(indexSelectedSoundMenu), 1f);
                        Singleton.getGraphic().setColorText(listMenuSound.get(indexSelectedSoundMenu), 1.f, 1.f, 1.f);
                        indexSelectedSoundMenu++;
                        Singleton.getGraphic().setColorText(listMenuSound.get(indexSelectedSoundMenu), 1.f, 0.f, 0.f);

                    }
                }
            }

            if (Singleton.getInput().isLeftPressed()) {
                mainMenuSelected = false;
                if ("Sound".equals(listMenu.get(indexSelectedMenu)) && !mainMenuSelected) {
                    Singleton.getGraphic().setAlpha(listMenu.get(indexSelectedMenu), 1f);
                    if (indexSelectedSoundMenu - 1 >= 0) {
                        Singleton.getSound().changeMenu();
                        Singleton.getGraphic().setAlpha(listMenuSound.get(indexSelectedSoundMenu), 1f);
                        Singleton.getGraphic().setColorText(listMenuSound.get(indexSelectedSoundMenu), 1.f, 1.f, 1.f);
                        indexSelectedSoundMenu--;
                        Singleton.getGraphic().setColorText(listMenuSound.get(indexSelectedSoundMenu), 1.f, 0.f, 0.f);

                    }
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
        return false;
    }
}
