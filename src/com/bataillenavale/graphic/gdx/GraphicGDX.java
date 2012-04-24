/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.bataillenavale.graphic.Graphic;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class GraphicGDX implements Graphic{
    
    private AppGDX m_appGDX;
    private LwjglApplication m_application; 
    
    @Override
    public void update() {
        System.out.println("Graphic run");
    }
    
    public void init(LwjglApplicationConfiguration conf){
        m_appGDX = new AppGDX(conf.fullscreen);
        
        m_application = new LwjglApplication(m_appGDX, conf);
    }
    
    @Override
    public void init(int _width, int _height, String _title, boolean _fullScreen){
        LwjglApplicationConfiguration conf = new LwjglApplicationConfiguration();
        
        conf.width = _width;
        conf.height = _height;
        conf.title = _title;
        conf.fullscreen = _fullScreen;
        
        init(conf);
    }
}
