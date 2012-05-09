/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.game;

import com.bataillenavale.ai.AIInterface;
import com.bataillenavale.ai.IntelligenceArtificielle;
import com.bataillenavale.graphic.Graphic;
import com.bataillenavale.graphic.gdx.GraphicGDX;
import com.bataillenavale.input.Input;
import com.bataillenavale.input.gdx.InputGDX;
import com.bataillenavale.items.Items;
import com.bataillenavale.items.gdx.ItemsGDX;
import com.bataillenavale.network.Network;
import com.bataillenavale.network.gdx.NetworkGDX;
import com.bataillenavale.sounds.Sound;
import com.bataillenavale.sounds.gdx.SoundGDX;

/**
 * Singleton factory
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class Singleton {
    
    /// Attributes
    private static Graphic m_graphic = null;
    private static Input m_input = null;
    private static Items m_items = null;
    private static Sound m_sound = null;
    private static AIInterface m_ai = null;
    private static Network m_network = null;
    
    /**
     * @return the Graphic component singleton
     */
    public static Graphic getGraphic(){
        if (m_graphic == null){
            m_graphic = new GraphicGDX();
        }
        return m_graphic;
    }
    
    /**
     * @return the Input component singleton
     */
    public static Input getInput(){
        if (m_input == null){
            m_input = new InputGDX();
        }
        return m_input;
    }
    
    /**
     * @return the Items components singleton
     */
    public static Items getItems(){
        if (m_items == null){
            m_items = new ItemsGDX();
        }
        return m_items;
    }
    
    /**
     * @return the Sound component singleton
     */
    public static Sound getSound(){
        if (m_sound == null){
            m_sound = new SoundGDX();
        }
        return m_sound;
    }
    
    /**
     * @return the Artificial Intelligence component singleton
     */
    public static AIInterface getAI(){
        if (m_ai == null){
            m_ai = new IntelligenceArtificielle();
        }
        return m_ai;
    }
    
    /**
     * @return the Network component singleton
     */
    public static Network getNetwork(){
        if (m_network == null){
            m_network = new NetworkGDX();
        }
        return m_network;
    }
}
