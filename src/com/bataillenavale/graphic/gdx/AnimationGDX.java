/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.io.File;

/**
 * Actors Animated in the Scene
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class AnimationGDX extends Actor {
    
    /// Attributes
    private TextureRegion[] m_region;
    private TextureRegion currentFrame;
    private String m_absolutePath;
    private Texture m_texture;
    private int m_frame;
    private Animation walkAnimation;
    private float stateTime;
    private Color m_color;

    /**
     * Constructor
     * @param _name Name Actor
     * @param _path Path file texture
     * @param _posX Position X in the Windows
     * @param _posY Position Y in the Windows
     * @param _width Width of texture region
     * @param _height Height og the texture region
     * @param spriteX Position X in the texture
     * @param spriteY Position Y in the texture
     * @param _frame Number of frame
     */
    public AnimationGDX(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame){
        super(_name);
        this.m_frame = _frame;
        this.m_absolutePath = new File(_path).getAbsolutePath();
        FileHandle t_file = Gdx.files.absolute(this.m_absolutePath);
        this.m_texture = new Texture(t_file);
        TextureRegion[][] tmp = TextureRegion.split(this.m_texture, _width / this.m_frame, _height);
        this.m_region = new TextureRegion[this.m_frame];
        
        int index = 0;
        for (int j = 0; j < this.m_frame; j++) {
            this.m_region[index++] = tmp[0][j];
        }
        // Fréquence de slide des splits
        this.walkAnimation = new Animation(0.250f, this.m_region);
        
        this.stateTime = 0f;
        this.m_color = new Color(1, 1, 1, 1);
        this.x = _posX;
        this.y = _posY;
        this.width = _width;
        this.height = _height;
    }
    
    /**
     * @see Actor#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
     */
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.setColor(this.m_color.r, this.m_color.g, this.m_color.b, this.m_color.a);
        this.stateTime += Gdx.graphics.getDeltaTime();
        this.currentFrame = this.walkAnimation.getKeyFrame(this.stateTime, true);
        batch.draw(this.currentFrame, this.x, this.y);
    }

    /**
     * Set alpha current Actor
     * @param _alpha Alpha
     */
    public void setAlpha(float _alpha){
        this.m_color.a = _alpha;
    }
      
    /**
     * @see Actor#touchDown(float, float, int)
     */
    @Override
    public boolean touchDown(float x, float y, int pointer) {
        return true;
    }

    /**
     * @see Actor#touchUp(float, float, int) 
     */
    @Override
    public void touchUp(float x, float y, int pointer) {
    }

    /**
     * @see Actor#touchDragged(float, float, int) 
     */
    @Override
    public void touchDragged(float x, float y, int pointer) {
    }

    /**
     * @see Actor#hit(float, float)
     */
    @Override
    public Actor hit(float x, float y) {
        return x > 0 && x < this.width && y > 0 && y < this.height ? this : null;
    }
    
    /**
     * Set position current Actor
     * @param x Position X
     * @param y Position Y
     */
    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
}
