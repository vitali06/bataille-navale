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
import com.bataillenavale.tools.Cases;
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
    private Color m_color;
    private boolean m_touch;

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
        this.m_absolutePath = new File(_path).getAbsolutePath();
        FileHandle t_file = Gdx.files.absolute(this.m_absolutePath);
        this.m_texture = new Texture(t_file);
        this.m_region = new TextureRegion(this.m_texture, spriteX, spriteY, _width, _height);
        
        this.m_color = new Color(1, 1, 1, 1);
        this.x = _posX;
        this.y = _posY;
        this.width = _width;
        this.height = _height;
        this.m_touch = false;
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
        // System.out.println(this.name);
        // Test Cases Colors
        // Cases reuh = new Cases((int)Gdx.input.getX(), (int)(Gdx.graphics.getHeight() - Gdx.input.getY()), "Use");
    }

    /**
     * @see Actor#touchDragged(float, float, int)
     */
    @Override
    public void touchDragged(float x, float y, int pointer) {
        if (this.m_touch){
            this.x = Gdx.input.getX() - this.width / 2;
            this.y = Gdx.graphics.getHeight() - Gdx.input.getY() - this.height / 2;
        }
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
    /**
     * Set Actor touchable
     * @param touch True touchable
     */
    public void setTouchable(boolean touch){
        this.m_touch = touch;
    }
    
    /**
     * Set Actor visibility
     * @param visible True if visible
     */
    public void setVisible(boolean visible){
        this.visible = visible;
    }
    
    /**
     * Get Actor visibility
     * @return True if Actor is visible
     */
    public boolean getVisible(){
        return this.visible;
    }
}
