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
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.io.File;

/**
 * Actors in the Scene
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class ActorGDX extends Actor {
    
    /// Attributes
    private TextureRegion m_region;
    private String m_absolutePath;
    private Texture m_texture;
    private int m_frame;
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
    public ActorGDX(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame) {
        super(_name);
        this.m_frame = _frame;
        this.m_absolutePath = new File(_path).getAbsolutePath();
        FileHandle t_file = Gdx.files.absolute(this.m_absolutePath);
        this.m_texture = new Texture(t_file);
        this.m_region = new TextureRegion(this.m_texture, spriteX, spriteY, _width, _height);
        
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
        batch.draw(this.m_region, x, y);
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
}
