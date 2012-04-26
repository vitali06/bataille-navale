/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.scene.Scene;
import com.bataillenavale.scene.SceneModel;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class SceneModelGDX implements SceneModel{

    private Scene m_scene;
    private int m_count;
    private boolean m_init;
    
    public SceneModelGDX(){
        m_init = false;
    }

    @Override
    public void init(){
        m_count = 0;
        m_scene = new Splashsreen(false);
        m_scene.init();
    }
    
    @Override
    public void update(){
        m_scene.update();
        
        m_count++;
        if (m_count > 500){
            m_scene.destroy();
            m_scene = new Gamescene(true);
        }
    }

    @Override
    public void destroy() {
    }
}
