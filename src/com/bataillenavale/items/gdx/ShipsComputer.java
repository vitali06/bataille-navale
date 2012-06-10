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
 * @author Alexis DÖRR
 */
public class ShipsComputer {

    private String name;
    private int life;
    private static List<ShipsComputer> shipsComputerList = new ArrayList<>();
    private Intervale intervale;

    public ShipsComputer(String _name, int _life, Intervale _intervale) {
//        try {
//            loadConf("config/ShipsConfig.xml");
//        } catch (Exception ex) {
//            Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
//        }

        this.name = _name;
        this.life = _life;
        this.intervale = _intervale;
        shipsComputerList.add(this);
    }

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
    public static List<ShipsComputer> getShipsList() {
        return shipsComputerList;
    }

    public ShipsComputer getShipsByName(String name) {
        for (ShipsComputer ships : this.getShipsList()) {
            if (name.equals(ships.name)) {
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
