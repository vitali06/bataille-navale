/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.items.gdx;

import com.bataillenavale.tools.Intervale;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author sittlerl, Mélissa
 */

//Ships Model
public class Ships {

    private String name;
    private int life;
    private static List<Ships> shipsList = new ArrayList<>();
    private Intervale intervale;

    public Ships(String name, int life) {
//        try {
//            loadConf("config/ShipsConfig.xml");
//        } catch (Exception ex) {
//            Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
//        }

        this.name = name;
        this.life = life;
        this.intervale = new Intervale();
        shipsList.add(this);
    }

//    private void setDragged(String name, boolean touch) {
//        Singleton.getGraphic().setTouchable(name, touch);
//    }
//
//    private void setPosition(String name) {
//        if (Singleton.getGraphic().getActors().containsKey(name)) {
//            float posX = (300 - Singleton.getGraphic().getActors().get(name).width) / 2;
//            Singleton.getGraphic().getActors().get(name).setPosition(posX, Singleton.getGraphic().getActors().get(name).y);
//        }
//    }

//    public float getPositionX(String name) {
//        return (Singleton.getGraphic().getActors().get(name)).x;
//    }
//
//    public float getPositionY(String name) {
//        return (Singleton.getGraphic().getActors().get(name)).y;
//    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the life
     */
    public int getLife() {
        return life;
    }

    /**
     * @param life the life to set
     */
    public void setLife(int life) {
        this.life = life;
    }

    /**
     * @return the shipsList
     */
    public static List<Ships> getShipsList() {
        return shipsList;
    }
    
    public Ships getShipsByName(String name)
    {
        for(Ships ships : this.getShipsList())
        {
            if(name.equals(ships.name))
            {
                return ships;
            }
        }
        
        return null;
    }

    /**
     * @return the intervale
     */
    public Intervale getIntervale() {
        return intervale;
    }

    /**
     * @param intervale the intervale to set
     */
    public void setIntervale(Intervale intervale) {
        this.intervale = intervale;
    }
    
    public boolean isSeek() {
        if (this.life == 0) {
            return true;
        }
        return false;
    }
}
