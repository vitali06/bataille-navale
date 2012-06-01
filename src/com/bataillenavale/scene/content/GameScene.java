/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.scene.Scene;

/**
 *
 * @author Mélissa
 */
public class GameScene implements Scene {

    private boolean m_fps;
    private boolean m_init;
    private boolean m_newScene;

    public GameScene(boolean fps) {
        this.m_fps = fps;
        this.m_init = false;
        this.m_newScene = false;
    }

    @Override
    public void init() {
        if (!this.m_init) {
            System.out.println("Game Scene");
        }
    }

    @Override
    public void update() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public boolean getFps() {
        return this.m_fps;
    }

    @Override
    public boolean isInit() {
        return this.m_init;
    }

    @Override
    public boolean newScene() {
        return this.m_newScene;        
    }
}
