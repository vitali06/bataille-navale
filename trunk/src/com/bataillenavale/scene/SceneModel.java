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
public interface SceneModel {
    public void init();
    public void update();
    public Scene getScene();
    public void destroy();
}
