/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bataillenavale.scene.Scene;

/**
 * GameGDX Class
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class GameGDX extends Game {

    private boolean m_fullScreen;
    private ScreenGDX m_screen;
    private boolean m_init;
    
    /**
     * Constructor
     * @param _fullScreen True if fullscreen
     */
    public GameGDX(boolean _fullScreen){
        this.m_fullScreen = _fullScreen;
        this.m_init = false;
        //System.out.println("Constructor GameGDX");
    }
    
    /**
     * @see  Game#create()
     */
    @Override
    public void create() {
        //System.out.println("Create GameGDX");
        this.m_screen = new ScreenGDX();
        this.setScreen(m_screen);
        this.m_init = true;
    }
    
    /**
     * Get if Game is initialized
     * @return True if Game is initialized
     */
    public boolean getInit(){
        return this.m_init;
    }
    
    /**
     * Get current scene in screen
     * @return Current scene
     */
    public Scene getScene(){
        return this.m_screen.getScene();
    }
    
    /**
     * Get Screen
     * @return Current Screen
     */
    @Override
    public ScreenGDX getScreen(){
        return this.m_screen;
    }
    
    /**
     * Add Actor in Screen by scene
     * @param actor New Actor
     */
    public void addActor(Actor actor){
        this.m_screen.addActor(actor);
    }
}
