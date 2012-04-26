/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic;

import com.bataillenavale.graphic.gdx.AppGDX;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Interface Windows
 * @author Alexis, Mélissa, Laurent
 */
public interface Graphic {
    
    public abstract void update();
    
    public void init(int _width, int _height, String _title, boolean _fullScreen);
    
    public void create(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame);
    
    public void loadSprites(String path) throws ParserConfigurationException, IOException, SAXException;
    
    public boolean isInit();
    
    public AppGDX getGame();
    
}
