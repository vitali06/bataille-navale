/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.input.gdx;
import com.bataillenavale.input.Input;
import org.lwjgl.input.Mouse;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class InputGDX implements Input{

    @Override
    public void update() {
       System.out.println("Input run");
       
       if(Mouse.isCreated()){
           // Gestion de la souris
       }
    }
    
}
