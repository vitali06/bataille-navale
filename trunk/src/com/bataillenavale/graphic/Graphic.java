/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic;

import com.badlogic.gdx.math.Rectangle;
import com.bataillenavale.graphic.gdx.*;
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
    public GameGDX getGame();
    
    /**
     * Update all actors
     */
    public abstract void update();
    
    /**
     * Initialize components of game
     * @param _width Width Size Windows
     * @param _height Height Size Windows
     * @param _title Title Windows
     * @param _fullScreen True if FullScreen
     */
    public void init(int _width, int _height, String _title, boolean _fullScreen);
    
    /**
     * Get Dimensions Windows Game
     * @return Rectangle
     */
    public Rectangle getDimensions();
    
    /**
     * Create Simple Actor
     * @param _name Name Actor
     * @param _path Path texture
     * @param _posX Position X Screen
     * @param _posY Position Y Screen
     * @param _width Width TextureRegion
     * @param _height Height TextureRegion
     * @param spriteX Position X Sprite
     * @param spriteY Position Y Sprite
     * @param _frame Number Frame (1)
     */
    public void createSprite(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame);
    
    /**
     * Create animated Actor
     * @param _name Name Actor
     * @param _path Path texture
     * @param _posX Position X Screen
     * @param _posY Position Y Screen
     * @param _width Width TextureRegion
     * @param _height Height TextureRegion
     * @param spriteX Position X Sprite
     * @param spriteY Position Y Sprite
     * @param _frame Number Frame (>1)
     */
    public void createAnimation(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame);
    
    /**
     * Create Text Actor
     * @param _name Actor name
     * @param _content Content text Actor
     * @param _posX Position X Screen
     * @param _posY Position Y Screen
     */
    public void createTextActor(String _name, String _content, float _posX, float _posY);
    
    /**
     * Text Actor with Font
     * @param _name Actor name
     * @param _content Content text Actor
     * @param _posX Position X Screen
     * @param _posY Position Y Screen
     * @param _font Font style
     */
    public void createTextFont(String _name, String _content, float _posX, float _posY, String _font);
    
    public void createShipsGrid(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY);
    
    public void createShips(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY, int _life);
    
    /**
     * Set Color Text Actor
     * @param name Actor name
     * @param r Red Color
     * @param g Green Color
     * @param b Blue Color
     */
    public void setColorText(String name, float r, float g, float b);
    
    /**
     * Set position actor
     * @param name Actor Name
     * @param posX Position X Screen
     * @param posY Position Y Screen
     */
    public void setPositionActor(String name, float posX, float posY);
    
    /**
     * Set if Actor is touchable
     * @param name Actor Name
     * @param touch True if touchable
     */
    public void setTouchable(String name, boolean touch);
    
    /**
     * Set Actor visibility
     * @param name Actor Name 
     * @param visible True if visible
     */
    public void setVisible(String name, boolean visible);
    
    /**
     * Get Actor visibility
     * @param name Actor name
     * @return True if actor visible
     */
    public boolean getVisible(String name);
    
    /**
     * Load File XML for create multiple Actors
     * @param path
     * @throws ParserConfigurationException
     * @throws IOException
     * @throws SAXException 
     */
    public void loadSprites(String path) throws ParserConfigurationException, IOException, SAXException;
    
    public void loadShips(String path) throws ParserConfigurationException, IOException, SAXException;
    
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
    public void setAlpha(String name, float alpha);
    
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
    
    public HashMap<String, ShipsGridGDX> getShipsGrid();
    
    public HashMap<String, ShipsGDX> getShips();
}
