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

    /// Attributes
    private Scene m_scene;
    private boolean m_init;
    
    /**
     * Constructor
     */
    public SceneModelGDX(){
        m_init = false;
    }

    /**
     * @see SceneModel#init()
     */
    @Override
    public void init(){
        m_scene = new Splashscreen(false);
        m_scene.init();
        this.m_init = true;
    }
    
    /**
     * @see SceneModel#update()
     */
    @Override
    public void update(){
        if (this.m_init){
            m_scene.update();
        }
    }

    /**
     * @see SceneModel#destroy()
     */
    @Override
    public void destroy() {
    }

    @Override
    public Scene getScene() {
        return this.m_scene;
    }
}
