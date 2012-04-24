/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public interface Scene {
    
    public void init();
    
    public void update();
    
    public void destroy();
}
