/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.Scene;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * SplashSrceen Scene
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class Splashscreen implements Scene{
    
    /// Attributes
    private boolean m_init;
    private int m_compteur;
    private int m_fondu;
    private boolean m_fps;
    
    /**
     * Constructror
     * @param _fps True if show fps
     */
    public Splashscreen(boolean _fps){
        this.m_fps = _fps;
        this.m_init = false;
        this.m_compteur = 0;
        this.m_fondu = 0;
    }
    
    /**
     * @see Scene#init() 
     */
    @Override
    public void init() {
        if(!this.m_init){
            System.out.println("Splash Screen Scene (Init)");
            try {
                Singleton.getGraphic().loadSprites("config/SplashSreen.xml");
            } catch (Exception ex) {
                Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
            }
            Singleton.getGraphic().createTextActor("Test", "              Presente par\n\n         Laurent SITTLER\nMelissa WEISSMULLER\n             Alexis DORR", 320, 250);
            
            Singleton.getGraphic().setAlphaActor("Backgound Slpashsreen", 0);
            Singleton.getGraphic().setAlphaAnim("Animation", 0);
            Singleton.getGraphic().setAlphaText("Test", 0);
            
            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if(this.m_init){
            this.m_compteur++;
            
            if (this.m_compteur < 500){
                Singleton.getGraphic().setAlphaActor("Java", -this.m_compteur/2);
                Singleton.getGraphic().setAlphaActor("LibGDX", -this.m_compteur/2);
            }
            if (this.m_compteur > 500 && this.m_compteur < 900){
                this.m_fondu++;
                Singleton.getGraphic().setAlphaActor("Java", 0);
                Singleton.getGraphic().setAlphaActor("LibGDX", 0);
                Singleton.getGraphic().setAlphaActor("Backgound Slpashsreen", -this.m_fondu/2);
                Singleton.getGraphic().setAlphaAnim("Animation", -this.m_fondu/2);
                Singleton.getGraphic().setAlphaText("Test", -this.m_fondu/2);
            }
            if (this.m_compteur == 900){
                this.m_fondu = 0;
            }
            if (this.m_compteur > 900){
                this.m_fondu++;
                Singleton.getGraphic().setAlphaText("Test", this.m_fondu/2);
                Singleton.getGraphic().setAlphaActor("Backgound Slpashsreen", this.m_fondu/2);
            }
            if (this.m_compteur == 1400){
                // Avant il faut vérifier que tout les elements de la scene précedente soient détruits
                Singleton.getGraphic().getGame().setScene(new GameScene(true));
            }

        }
    }

    /**
     * @see Scene#destroy()
     */
    @Override
    public void destroy() {
        this.m_init = false;
        System.out.println("Avant suppression reste Actor : " + Singleton.getGraphic().getGame().getGroup().getActors().size());
        System.out.println("Avant suppression reste HashMap Actor : " + Singleton.getGraphic().getActors().size());
        System.out.println("Avant suppression reste HashMap Anim : " + Singleton.getGraphic().getAnim().size());
        System.out.println("Avant suppression reste HashMap Text : " + Singleton.getGraphic().getText().size());
        System.out.println("\nSuppression !\n");
//        for (Actor a : Singleton.getGraphic().getActors().values()){
//            Singleton.getGraphic().getGame().delActor(a);
//        }
//        for (Actor a : Singleton.getGraphic().getAnim().values()){
//            Singleton.getGraphic().getGame().delActor(a);
//        }
//        for (Actor a : Singleton.getGraphic().getText().values()){
//            Singleton.getGraphic().getGame().delActor(a);
//        }
        // Singleton.getGraphic().getGame().delAllActors();
        System.out.println("Après suppression reste Actor : " + Singleton.getGraphic().getGame().getGroup().getActors().size());
        Singleton.getGraphic().getActors().clear();
        System.out.println("Après suppression reste HashMap Actor : " + Singleton.getGraphic().getActors().size());
        Singleton.getGraphic().getAnim().clear();
        System.out.println("Après suppression reste HashMap Anim : " + Singleton.getGraphic().getAnim().size());
        Singleton.getGraphic().getText().clear();
        System.out.println("Après suppression reste HashMap Text : " + Singleton.getGraphic().getText().size());
    }
    
    /**
     * @see Scene#getFps() 
     */
    @Override
    public boolean getFps(){
        return this.m_fps;
    }
    
    /**
     * Transition for to show Actor
     * @param actor Actor name
     * @param count Number actions
     */
    public void showActor(String actor, int count){
    }
    
    /**
     * Transition for to hide Actor
     * @param actor Actor name
     * @param count Number actions
     */
    public void hideActor(String actor, int count){
    }

    @Override
    public boolean isInit() {
        return this.m_init;
    }
}
