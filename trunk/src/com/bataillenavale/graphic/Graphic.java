/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic;

/**
 * Interface Windows
 * @author Alexis, Mélissa, Laurent
 */
public interface Graphic {
    public abstract void update();
    public void init(int _width, int _height, String _title, boolean _fullScreen);
}
