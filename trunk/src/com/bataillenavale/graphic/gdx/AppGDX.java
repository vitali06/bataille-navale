/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.scene.content.Splashscreen;

/**
 * ApplicationGDX Class
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class AppGDX implements ApplicationListener {

    /// Attributes
    private SpriteBatch m_spriteBatch;
    private Stage m_stage;
    private boolean m_fullscreen;
    private Scene m_scene;
    private Group m_group;
    private BitmapFont m_font;
    private boolean m_init;

    /**
     * Constructor
     * @param _fullScreen True if fullscreen
     */
    public AppGDX(boolean _fullScreen) {
        this.m_fullscreen = _fullScreen;
        this.m_init = false;
    }
    
    /**
     * @see ApplicationListener#create()
     */
    @Override
    public void create() {
        this.m_spriteBatch = new SpriteBatch();
        this.m_stage = new Stage(0, 0, true);
          
        this.m_font = new BitmapFont();
        System.out.println("Create AppGDX!!!\n");
        
        this.m_scene = new Splashscreen(false);
        
        this.m_group = new Group("GroupeActors");
        
        this.m_stage.addActor(m_group);
        
        this.m_scene.init();
        
        this.m_init = true;
    }

    /**
     * @see ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        this.m_stage.setViewport(width, height, true);
    }

    /**
     * @see ApplicationListener#render() 
     */
    @Override
    public void render() {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        this.m_stage.act(Gdx.graphics.getDeltaTime());
        
        if (this.m_scene.isInit()){
            this.m_stage.draw();
        }
        
        //Show FPS Windows
        this.m_spriteBatch.begin();
        if (this.m_scene.getFps()) {
            int fps = (int) (1f / Gdx.graphics.getDeltaTime());
            this.m_font.draw(this.m_spriteBatch, "fps: " + fps, 10, 20);
        }
        this.m_spriteBatch.end();
    }

    /**
     * @see ApplicationListener#pause() 
     */
    @Override
    public void pause() {
    }

    /**
     * @see ApplicationListener#resume() 
     */
    @Override
    public void resume() {
    }

    /**
     * @see ApplicationListener#dispose() 
     */
    @Override
    public void dispose() {
        this.m_stage.dispose();
    }
    
    /**
     * Add Actor to the scene
     * @param _actor 
     */
    public void addActor(Actor _actor){
        this.m_group.addActor(_actor);
    }
    
    /**
     * Delete Actor to the scene
     * @param _actor 
     */
    public void delActor(Actor _actor){
        this.m_group.removeActor(_actor);
    }
    
    /**
     * Delete all actors in the Group
     */
    public void delAllActors(){
        this.m_group.clear();
    }
    
    /**
     * Get the current Scene
     * @return The current Scene
     */
    public Scene getScene(){
        return this.m_scene;
    }
    
    /**
     * Set new current scene
     * @param _scene 
     */
    public void setScene(Scene _scene){
        if (this.m_scene != null){
            this.m_scene.destroy();
        }
//        if (m_group.getActors().size() > 0){
//            System.out.println("Toujours des actors");
//        }
//        else{
            System.out.println("\nScene vide ? " + this.m_scene.toString());
            this.m_scene = _scene;
            System.out.println("\nNouvelle Scene ? " + this.m_scene.toString());
            
            if (this.m_scene != null){
            this.m_scene.init();
            }
//        }
    }
    
    /**
     * Check if create is initialized
     * @return Boolean true if init
     */
    public boolean getInit(){
        return this.m_init;
    }
    
    /**
     * Get the current Group
     * @return The current Group
     */
    public Group getGroup(){
        return this.m_group;
    }
}
