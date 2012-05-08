/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene;

/**
 * Scene Interface
 * 
 * @author Alexis, Mélissa, Laurent
 */
public interface Scene {
    
    /**
     * Initialize components
     */
    public void init();
    
    /**
     * Update components
     */
    public void update();
    
    /**
     * Destroy components
     */
    public void destroy();
    
    /**
     * Get if show fps Windows
     * @return True if show fps
     */
    public boolean getFps();
    
    public boolean isInit();
}
