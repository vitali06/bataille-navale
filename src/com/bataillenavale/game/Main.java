/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.game;

import com.bataillenavale.scene.content.SceneModelGDX;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main Class
 * @author Alexis, Mélissa, Laurent
 */
public class Main {

    /**
     * Main entry point
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Singleton.getGraphic().init(800, 600, "Bataille Navale - Game", false);
        
        while(!Singleton.getGraphic().isInit()){
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        while(true){
           try {
                Singleton.getGraphic().update();
                Singleton.getInput().update();
                Singleton.getItems().update();
                Singleton.getSound().update();
                Singleton.getAI().update();
                Singleton.getNetwork().update();
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
