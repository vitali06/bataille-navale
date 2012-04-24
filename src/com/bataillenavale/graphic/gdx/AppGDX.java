/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class AppGDX implements ApplicationListener {

    private SpriteBatch m_spriteBatch;
    private boolean m_fullscreen;

    public AppGDX(boolean _fullScreen) {
        m_fullscreen = _fullScreen;
    }

    
    @Override
    public void create() {
        m_spriteBatch = new SpriteBatch();
    }

    @Override
    public void resize(int width, int height) {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void render() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void pause() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void resume() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void dispose() {
        // throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
