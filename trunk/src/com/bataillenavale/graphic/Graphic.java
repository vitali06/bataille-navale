/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic;

import com.badlogic.gdx.math.Rectangle;
import com.bataillenavale.graphic.gdx.ActorGDX;
import com.bataillenavale.graphic.gdx.AnimationGDX;
import com.bataillenavale.graphic.gdx.GameGDX;
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
    // public AppGDX getGame();
    public GameGDX getGame();
    
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
     * Get Dimensions Windows Game
     * @return Rectangle
     */
    public Rectangle getDimensions();
    
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
     * Set Color Text Actor
     * @param name Actor name
     * @param r Red Color
     * @param g Green Color
     * @param b Blue Color
     */
    public void setColorText(String name, float r, float g, float b);
    
    /**
     * Text Actor with Font
     * @param _name
     * @param _content
     * @param _posX
     * @param _posY
     * @param _font Font style
     */
    public void createTextFont(String _name, String _content, float _posX, float _posY, String _font);
    
    public void setPositionActor(String name, float posX, float posY);
    
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
    
    /**
     * Get HashMap Element ActorGDX
     * @return HashMap ActorGDX
     */
    public HashMap<String, ActorGDX> getActors();
    
    /**
     * Get HashMap Element AnimationGDX
     * @return HashMap AnimationGDX
     */
    public HashMap<String, AnimationGDX> getAnim();
    
    /**
     * Get HashMap Element TextGDX
     * @return HashMap TextGDX
     */
    public HashMap<String, TextGDX> getText();
}
