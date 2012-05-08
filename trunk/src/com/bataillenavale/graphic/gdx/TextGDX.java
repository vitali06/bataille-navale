/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

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
    
    public TextGDX(String _name, String _content, float _posX, float _posY){
        super(_name);
        this.m_content = _content;
        this.m_font = null;
        this.m_font = new BitmapFont();
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
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see Actor#touchUp(float, float, int) 
     */
    @Override
    public void touchUp(float x, float y, int pointer) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @see Actor#touchDragged(float, float, int) 
     */
    @Override
    public void touchDragged(float x, float y, int pointer) {
        throw new UnsupportedOperationException("Not supported yet.");
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
        this.m_font.setColor(1, 1, 1, _alpha);
    }
}
