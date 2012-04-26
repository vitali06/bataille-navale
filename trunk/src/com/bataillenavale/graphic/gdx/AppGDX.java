/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.scene.content.Splashsreen;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class AppGDX implements ApplicationListener {

    private SpriteBatch m_spriteBatch;
    private Stage m_stage;
    private boolean m_fullscreen;
    private Scene m_scene;
    private Group m_group;
    private BitmapFont m_font;
    private boolean m_init;


    public AppGDX(boolean _fullScreen) {
        m_fullscreen = _fullScreen;
        m_init = false;
    }
    
    @Override
    public void create() {
        m_spriteBatch = new SpriteBatch();
        m_stage = new Stage(0, 0, true);
        
        m_font = new BitmapFont();
        System.out.println("Create AppGDX!!!\n");
        
        m_scene = new Splashsreen(false);
        
        m_group = new Group("GroupeActors");
        
        m_stage.addActor(m_group);
        
        m_scene.init();
        
        m_init = true;
    }

    @Override
    public void resize(int width, int height) {
        m_stage.setViewport(width, height, true);
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        m_stage.act(Gdx.graphics.getDeltaTime());
        m_stage.draw();

        //Show FPS Windows
        m_spriteBatch.begin();
        if (m_scene.getFps()) {
            int fps = (int) (1f / Gdx.graphics.getDeltaTime());
            m_font.draw(m_spriteBatch, "fps: " + fps, 10, 20);
        }
        m_spriteBatch.end();
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void dispose() {
        m_stage.dispose();
    }
    
    /**
     * Add Actor to the scene
     * @param _actor 
     */
    public void addActor(Actor _actor){
        m_group.addActor(_actor);
    }
    
    /**
     * Delete Actor to the scene
     * @param _actor 
     */
    public void delActor(Actor _actor){
        m_group.removeActor(_actor);
    }
    
    public void delAllActors(){
        m_group.clear();
    }
    
    public Scene getScene(){
        return m_scene;
    }
    
    public void setScene(Scene _scene){
        m_scene.destroy();
        m_scene = _scene;
        m_scene.init();
    }
    
    public boolean getInit(){
        return m_init;
    }
    
    public Group getGroup(){
        return m_group;
    }
}
