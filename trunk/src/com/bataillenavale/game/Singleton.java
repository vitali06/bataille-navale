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
import com.bataillenavale.scene.SceneModel;
import com.bataillenavale.scene.content.SceneModelGDX;
import com.bataillenavale.sounds.Sound;
import com.bataillenavale.sounds.gdx.SoundGDX;

/**
 * Singleton factory
 * @author Alexis, Mélissa, Laurent
 */
public class Singleton {
    
    private static Graphic m_graphic = null;
    private static Input m_input = null;
    private static Items m_items = null;
    private static Sound m_sound = null;
    private static AIInterface m_ai = null;
    private static Network m_network = null;
    private static SceneModel m_sceneModel = null;
    
    /**
     * @return 
     */
    public static Graphic getGraphic(){
        if (m_graphic == null){
            m_graphic = new GraphicGDX();
        }
        return m_graphic;
    }
    
    /**
     * @return 
     */
    public static Input getInput(){
        if (m_input == null){
            m_input = new InputGDX();
        }
        return m_input;
    }
    
    /**
     * @return 
     */
    public static Items getItems(){
        if (m_items == null){
            m_items = new ItemsGDX();
        }
        return m_items;
    }
    
    /**
     * @return 
     */
    public static Sound getSound(){
        if (m_sound == null){
            m_sound = new SoundGDX();
        }
        return m_sound;
    }
    
    /**
     * @return 
     */
    public static AIInterface getAI(){
        if (m_ai == null){
            m_ai = new IntelligenceArtificielle();
        }
        return m_ai;
    }
    
    /**
     * @return Network
     */
    public static Network getNetwork(){
        if (m_network == null){
            m_network = new NetworkGDX();
        }
        return m_network;
    }
    
    /**
     * 
     * @return SceneModel
     */
    public static SceneModel getSceneModel(){
        if (m_sceneModel == null){
            m_sceneModel = new SceneModelGDX();
        }
        return m_sceneModel;
    }
}
