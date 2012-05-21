/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.scene.content.Splashscreen;

/**
 * ScreenGDX Class
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class ScreenGDX implements Screen {
    
    /// Attributes
    private Scene m_scene;
    private Scene m_nextScene;
    private Group m_group;
    private Stage m_stage;
    private SpriteBatch m_spriteBatch;
    private BitmapFont m_font;
    
    /**
     * Constructor
     */
    public ScreenGDX(){
        System.out.println("Constructor ScreenGDX");
    }
    
    /**
     * @see Screen#render()
     */
    @Override
    public void render(float delta) {
        // System.out.println("Render ScreenGDX");
        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
        this.m_stage.act(Gdx.graphics.getDeltaTime());
        
        this.m_stage.draw();
        
        //Show FPS Windows
        this.m_spriteBatch.begin();
        if (this.m_scene.getFps()) {
            int fps = (int) (1f / Gdx.graphics.getDeltaTime());
            this.m_font.draw(this.m_spriteBatch, "fps: " + fps, 10, 20);
        }
        this.m_spriteBatch.end();
        
        if (m_scene.newScene()){
            setScene();
        }
    }

    /**
     * @see Screen#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        this.m_stage.setViewport(width, height, true);
    }

    /**
     * @see Screen#show()
     */
    @Override
    public void show() {
        this.m_spriteBatch = new SpriteBatch();
        
        this.m_stage = new Stage(Singleton.getGraphic().getDimensions().width, Singleton.getGraphic().getDimensions().height, true);
        System.out.println("Size Screen : " + Singleton.getGraphic().getDimensions().width + "x" + Singleton.getGraphic().getDimensions().height);
        this.m_font = new BitmapFont();
        this.m_scene = new Splashscreen(false);
        this.m_group = new Group("GroupeActors");
        
        this.m_stage.addActor(m_group);
        Gdx.input.setInputProcessor(m_stage);
        
        this.m_scene.init();
        System.out.println("Show ScreenGDX");
        
    }

    /**
     * @see Screen#hide()
     */
    @Override
    public void hide() {
    }

    /**
     * @see Screen#pause() 
     */
    @Override
    public void pause() {
    }

    /**
     * @see Screen#resume() 
     */
    @Override
    public void resume() {
    }

    /**
     * @see Screen#dispose() 
     */
    @Override
    public void dispose() {
    }
    
    /**
     * Get current scene
     * @return Current Scene
     */
    public Scene getScene(){
        return this.m_scene;
    }
    
    /**
     * Add Actor in group
     * @param actor Actor
     */
    public void addActor(Actor actor){
        this.m_group.addActor(actor);
    }
    
    /**
     * Set next scene after event and backup current scene
     * @param scene Next Scene
     */
    public void nextScene(Scene scene){
        this.m_nextScene = scene;
    }
    
    /**
     * Get Group Actors
     * @return Group Actors
     */
    public Group getGroup(){
        return this.m_group;
    }
    
    /**
     * Set new Scene
     */
    public void setScene(){
        System.out.println("Before Clean");
        if (this.m_scene != null){
            this.m_group.clear();
            this.m_scene.destroy();
        }
        
        this.m_scene = m_nextScene;
        
        if (this.m_scene != null){
            this.m_scene.init();
        }
    }
}
