/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.sounds;

/**
 * Sound Interface
 *
 * @author Alexis, Mélissa, Laurent
 */
public interface Sound {

    /**
     * Update components
     */
    public abstract void update();

    /**
     * Play a sound 
     * @param _file Path of the file which is played
     */
    public void play(String _file);

    /**
     * Sound played when user click on arrows in the menuScene
     */
    public void changeMenu();

    /**
     * Sound played at the beginning of the game
     */
    public void introductionScene();

    /**
     * Sound played when the key ENTER is pressed
     */
    public void enterPressed();
    
    public void explosion();
    
    public void applauses();
    
    public void shooting();
    
    public void splash();
    
    /**
     * change the volume of the sounds which are played
     * @param volume volume of the sounds which are played 
     */    
    public void changeVolume(float volume);
}
