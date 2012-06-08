/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

/**
 * TextGDX Class
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class TextGDX extends Actor{

    /// Attributes
    private BitmapFont m_font;
    private String m_content;

    /**
     * Constructor without Font
     * @param _name Name Actor
     * @param _content Content text
     * @param _posX Position X Screen
     * @param _posY Position Y Screen
     */
    public TextGDX(String _name, String _content, float _posX, float _posY){
        super(_name);
        this.m_content = _content;
        this.m_font = null;
        this.m_font = new BitmapFont();
        this.x = _posX;
        this.y = _posY;
    }
    
    /**
     * Constructeur with Font
     * @param _name Name Actor
     * @param _content Content text
     * @param _posX Position X Screen
     * @param _posY Position Y Screen
     * @param _font Font Style
     */
    public TextGDX(String _name, String _content, float _posX, float _posY, String _font){
        super(_name);
        this.m_content = _content;
        this.m_font = null;
        this.m_font = new BitmapFont(Gdx.files.internal("data/Fonts/" + _font + "/" + _font + ".fnt"),
         Gdx.files.internal("data/Fonts/" + _font + "/" + _font + ".png"), false);
        this.x = _posX;
        this.y = _posY;
    }
    
    /**
     * @see Actor#draw(com.badlogic.gdx.graphics.g2d.SpriteBatch, float)
     */
    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        this.m_font.drawMultiLine(batch, this.m_content, x, y);
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
     * Set new Content text Actor
     * @param _content 
     */
    public void setContent(String _content){
        this.m_content = _content;
    }
    
    /**
     * Get content text
     * @return Content Actor
     */
    public String getContent(){
        return this.m_content;
    }
    
    /**
     * Set alpha current Actor
     * @param _alpha Alpha
     */
    public void setAlpha(float _alpha){
        this.m_font.setColor(this.m_font.getColor().r , this.m_font.getColor().g, this.m_font.getColor().b, _alpha);
    }
    
    /**
     * Set Color current Actor
     * @param r Red Color
     * @param g Green Color
     * @param b Blue Color
     */
    public void setColor(float r, float g, float b){
        this.m_font.setColor(r, g, b, this.m_font.getColor().a);
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
     * Set Actor visibility
     *
     * @param visible True if visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Get Actor visibility
     *
     * @return True if Actor is visible
     */
    public boolean getVisible() {
        return this.visible;
    }
    
    public void destroy() {
        this.remove();
    }
}
