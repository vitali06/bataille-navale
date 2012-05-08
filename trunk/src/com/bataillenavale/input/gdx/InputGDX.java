/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.input.gdx;

import com.bataillenavale.input.Input;
import org.lwjgl.input.Mouse;

/**
 * InputGDX Class
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class InputGDX implements Input{

    /// Attributes
    private boolean m_init;
    
    /**
     * Constructor
     */
    public InputGDX(){
        this.m_init = false;
    }
    
    /**
     * @see Input#init() 
     */
    @Override
    public void init() {
        this.m_init = true;
    }
    
    /**
     * @see Input#update() 
     */
    @Override
    public void update() {
       // System.out.println("Input run");
       
       if(Mouse.isCreated()){
           // Gestion de la souris
       }
    }

    /**
     * @see Input#destroy()
     */
    @Override
    public void destroy() {
        
    }
}
