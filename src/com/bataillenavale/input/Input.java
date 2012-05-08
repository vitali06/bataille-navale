/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.input;

/**
 * Input Interface
 * 
 * @author Alexis, Mélissa, Laurent
 */
public interface Input {
    
    /**
     * Initialize input components
     */
    public void init();
    
    /**
     * Update input components
     */
    public abstract void update();
    
    /**
     * Destroy input components
     */
    public abstract void destroy();
}
