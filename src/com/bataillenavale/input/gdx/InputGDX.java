/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.input.gdx;

import com.badlogic.gdx.Gdx;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.input.Input;
import java.util.Date;
import org.lwjgl.input.Mouse;

/**
 * InputGDX Class
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class InputGDX implements Input {

    /// Attributes
    private boolean m_init;
    private long lastPressedTime;
    private int lastKeyPressed;
    
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
        //lastPressedTime = new Date().getTime();
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

    /**
     * @see Input#isEnterPressed()
     */
    @Override
    public boolean isEnterPressed() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.ENTER)) {
            long now = new Date().getTime();            
            if (lastKeyPressed != com.badlogic.gdx.Input.Keys.ENTER) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.ENTER;
                lastPressedTime = now;
                Singleton.getSound().enterPressed();
                return true;
            }
            if (now - lastPressedTime > 200 && lastKeyPressed == com.badlogic.gdx.Input.Keys.ENTER) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.ENTER;
                lastPressedTime = now;
                Singleton.getSound().enterPressed();
                return true;
            }
        }
        return false;
    }
    
    /**
     * @see Input#isDownPressed()
     */
    @Override
    public boolean isDownPressed() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.DOWN)) {
            long now = new Date().getTime();
            if (lastKeyPressed != com.badlogic.gdx.Input.Keys.DOWN) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.DOWN;
                lastPressedTime = now;
                return true;
            }
            /*
             * If DOWN is the last button clicked 
             * And if the time since you clicked this button is greater than 0,2 seconds
             */
            else if (now - lastPressedTime > 100) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.DOWN;
                lastPressedTime = now;
                return true;
            }
        }
        return false;
    }
    
    /**
     * @see Input#isUpPressed()
     */
    @Override
    public boolean isUpPressed() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.UP)) {
            long now = new Date().getTime();
            if (lastKeyPressed != com.badlogic.gdx.Input.Keys.UP) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.UP;
                lastPressedTime = now;
                return true;
            }
            if (now - lastPressedTime > 200 && lastKeyPressed == com.badlogic.gdx.Input.Keys.UP) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.UP;
                lastPressedTime = now;
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isRightPressed() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.RIGHT)) {            
            long now = new Date().getTime();
            if (lastKeyPressed != com.badlogic.gdx.Input.Keys.RIGHT) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.RIGHT;
                lastPressedTime = now;                
                return true;
            }
            if (now - lastPressedTime > 200 && lastKeyPressed == com.badlogic.gdx.Input.Keys.RIGHT) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.RIGHT;
                lastPressedTime = now;                
                return true;
            }
        }
        return false;
    }
    
    @Override
    public boolean isLeftPressed() {
        if (Gdx.input.isKeyPressed(com.badlogic.gdx.Input.Keys.LEFT)) {
            long now = new Date().getTime();
            if (lastKeyPressed != com.badlogic.gdx.Input.Keys.LEFT) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.LEFT;
                lastPressedTime = now;
                return true;
            }
            if (now - lastPressedTime > 200 && lastKeyPressed == com.badlogic.gdx.Input.Keys.LEFT) {
                lastKeyPressed = com.badlogic.gdx.Input.Keys.LEFT;
                lastPressedTime = now;
                return true;
            }
        }
        return false;
    }
}
