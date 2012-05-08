/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic;

import com.bataillenavale.graphic.gdx.ActorGDX;
import com.bataillenavale.graphic.gdx.AnimationGDX;
import com.bataillenavale.graphic.gdx.AppGDX;
import com.bataillenavale.graphic.gdx.TextGDX;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Interface Graphic
 * 
 * @author Alexis, Mélissa, Laurent
 */
public interface Graphic {
    
    /**
     * Get current Game render
     * @return AppGDX Game
     */
    public AppGDX getGame();
    
    /**
     * Update all actors
     */
    public abstract void update();
    
    /**
     * Initialize components of game
     * @param _width
     * @param _height
     * @param _title
     * @param _fullScreen 
     */
    public void init(int _width, int _height, String _title, boolean _fullScreen);
    
    /**
     * Create Simple Actor
     * @param _name
     * @param _path
     * @param _posX
     * @param _posY
     * @param _width
     * @param _height
     * @param spriteX
     * @param spriteY
     * @param _frame 
     */
    public void createSprite(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame);
    
    /**
     * Create animated Actor
     * @param _name
     * @param _path
     * @param _posX
     * @param _posY
     * @param _width
     * @param _height
     * @param spriteX
     * @param spriteY
     * @param _frame 
     */
    public void createAnimation(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame);
    
    /**
     * Create Text Actor
     * @param _name Actor name
     * @param _content Content text Actor
     * @param _posX
     * @param _posY 
     */
    public void createTextActor(String _name, String _content, float _posX, float _posY);
    
    /**
     * Load File XML for create multiple Actors
     * @param path
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException 
     */
    public void loadSprites(String path) throws ParserConfigurationException, IOException, SAXException;
    
    /**
     * Check if create game is initialized
     * @return True if initialized
     */
    public boolean isInit();
    
    /**
     * Set alpha Actor
     * @param name Actor name
     * @param alpha Alpha
     */
    public void setAlphaActor(String name, float alpha);
    
    /**
     * Set alpha Actor animated
     * @param name Actor name
     * @param alpha Alpha
     */
    public void setAlphaAnim(String name, float alpha);
    
    /**
     * Set alpha Actor Text
     * @param name
     * @param alpha 
     */
    public void setAlphaText(String name, float alpha);
    
    /**
     * Destroy Component
     */
    public void destroy();
    
    public HashMap<String, ActorGDX> getActors();
    
    public HashMap<String, AnimationGDX> getAnim();
    
    public HashMap<String, TextGDX> getText();
}
