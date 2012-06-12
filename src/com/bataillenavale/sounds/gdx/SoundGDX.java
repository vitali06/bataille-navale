/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.sounds.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;

/**
 * SoundGDX Class
 *
 * @author Alexis, Mélissa, Laurent
 */
public class SoundGDX implements com.bataillenavale.sounds.Sound {
    
    private Sound sound;    
    private float volume = 1f;

    /**
     * @see Sound#update()
     */
    @Override
    public void update() {
        // System.out.println("Sound run");
    }
    
    /**
     * @see Sound#play(String _file)
     */
    @Override
    public void play(String _file) {
        sound = Gdx.audio.newSound(Gdx.files.internal(_file));
        sound.play(volume);
    }

    /**
     * @see Sound#playNextMenu()
     */
    @Override
    public void changeMenu() {
        play("data/sounds/changeMenu.mp3");        
    }

    /**
     * @see Sound#playIntroductionScene()
     */
    @Override
    public void introductionScene() {
        play("data/sounds/introduction.mp3");        
    }

    /**
     * @see Sound#playEnterPressed()
     */
    @Override
    public void enterPressed() {
        play("data/sounds/enterPressed.mp3");        
    }
    
    @Override
    public void explosion() {
        play("data/sounds/explosion.mp3");        
    }
    
    @Override
    public void applauses() {
        play("data/sounds/applaudissement.mp3");        
    }
    
    @Override
    public void shooting() {
        play("data/sounds/missile.mp3");        
    }
    
    @Override
    public void splash() {
        play("data/sounds/splash.mp3");        
    }
    
    @Override
    public void loose() {
        play("data/sounds/hueeBig.mp3");        
    }
    
    /**
     * @see Sound#changeVolume(float volume)
     */
    @Override
    public void changeVolume(float volume)
    {
        this.volume = volume;
    }
    
}
