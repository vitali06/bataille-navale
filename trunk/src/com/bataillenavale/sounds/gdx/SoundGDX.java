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
        sound.play();
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
}
