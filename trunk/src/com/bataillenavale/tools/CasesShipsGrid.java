/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.tools;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.graphic.gdx.ShipsGridGDX;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

/**
 * Tool manage Cases grid
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class CasesShipsGrid {

    // Attributes
    private String m_mode;
    private int m_aWidth;
    private int m_aHeight;
    private HashMap<Integer, Integer> m_positions = new HashMap<>();
    private List<ShipsGridGDX> m_actors = new LinkedList<>();
    private boolean m_active;
    private int m_backupX;
    private int m_backupY;

    /**
     * Fisrt Constructor for unqiue Case Actor
     * @param x
     * @param y
     * @param mode
     */
    public CasesShipsGrid(int x, int y, String mode) {
        this.m_positions.put(x, y);
        this.m_mode = mode;
        this.m_active = false;
        this.m_backupX = 0;
        this.m_backupY = 0;
        activeCase();
    }

    /**
     * Second Constructor for Multi Cases Actor
     * @param x Position Cursor X
     * @param y Position Cursor Y
     * @param width Width Actor (Ship)
     * @param height Height actor (Ship)
     */
    public CasesShipsGrid(int x, int y, int width, int height) {
        this.m_positions.put(x, y);
        this.m_aWidth = width;
        this.m_aHeight = height;
        this.m_active = false;
        this.m_mode = "Select";
        this.m_backupX = 0;
        this.m_backupY = 0;
        multiSelect(x, y);
    }

    /**
     * Backup all Case type in List and redirect to type run
     */
    private void activeCase() {
        for (Entry<String, ShipsGridGDX> entry : Singleton.getGraphic().getShipsGrid().entrySet()) {
            if (entry.getValue().name.startsWith("Case") || entry.getValue().name.startsWith("Select") || entry.getValue().name.startsWith("Use") || entry.getValue().name.startsWith("Check")) {
                this.m_actors.add(entry.getValue());
            }
        }
        switch (this.m_mode) {
            case "Select":
                selectCase(this.m_actors);
                break;
            case "Use":
                useCase(this.m_actors);
                break;
            case "Check":
                checkCase(this.m_actors);
                break;
        }
    }

    /**
     * Type select case (temporary)
     * @param a List of Actor Cases
     */
    private void selectCase(List<ShipsGridGDX> a) {
        for (ShipsGridGDX item : a) {
            if (item.name.startsWith("Case") && hit(item)) {
                this.m_active = true;
                if (!Singleton.getGraphic().getVisible("Use" + item.name.substring(item.name.length() - 2)) && !Singleton.getGraphic().getVisible("Check" + item.name.substring(item.name.length() - 2)) && !Singleton.getGraphic().getVisible("Select" + item.name.substring(item.name.length() - 2))) {
                    Singleton.getGraphic().setVisible("Case" + item.name.substring(item.name.length() - 2), false);
                    System.out.println(item.name.substring(item.name.length() - 2));
                    Singleton.getGraphic().setVisible("Select" + item.name.substring(item.name.length() - 2), true);
                }
            } else if (item.name.startsWith("Case") && !hit(item)) {
                if (!Singleton.getGraphic().getVisible("Use" + item.name.substring(item.name.length() - 2)) && !Singleton.getGraphic().getVisible("Check" + item.name.substring(item.name.length() - 2))) {
                    Singleton.getGraphic().setVisible(item.name, true);
                    Singleton.getGraphic().setVisible("Select" + item.name.substring(item.name.length() - 2), false);
                }
            }
        }
    }

    /**
     * Backup all positions Actor
     * @param x Cursor X
     * @param y Cursor Y
     */
    private void multiSelect(int x, int y) {
        if (this.m_aWidth > 50) {
            int t_cpt = this.m_aWidth / 50;
            for (int i = 0; i < t_cpt; i++) {
                this.m_positions.put(x + (50 * i), y + 50 / 2);
            }
        }
        activeCase();
    }

    /**
     * Case touched (not temporary)
     * @param a List of Actor Case
     */
    private void useCase(List<ShipsGridGDX> a) {
        for (ShipsGridGDX item : a) {
            if (item.name.startsWith("Case") && hit(item)) {                
                if (!Singleton.getGraphic().getVisible("Use" + item.name.substring(item.name.length() - 2)) && !Singleton.getGraphic().getVisible("Check" + item.name.substring(item.name.length() - 2))) {
                    Singleton.getGraphic().setVisible("Case" + item.name.substring(item.name.length() - 2), false);
                    Singleton.getGraphic().setVisible("Select" + item.name.substring(item.name.length() - 2), false);
                    Singleton.getGraphic().setVisible("Use" + item.name.substring(item.name.length() - 2), true);
                }
            }
        }
    }

    /**
     * Case touched and fire (not temporrary)
     * @param a List of Actor Case
     */
    private void checkCase(List<ShipsGridGDX> a) {
        for (ShipsGridGDX item : a) {
            if (item.name.startsWith("Case") && hit(item)) {
                if (!Singleton.getGraphic().getVisible("Use" + item.name.substring(item.name.length() - 2)) && !Singleton.getGraphic().getVisible("Check" + item.name.substring(item.name.length() - 2))) {
                    Singleton.getGraphic().setVisible("Case" + item.name.substring(item.name.length() - 2), false);
                    Singleton.getGraphic().setVisible("Select" + item.name.substring(item.name.length() - 2), false);
                    Singleton.getGraphic().setVisible("Check" + item.name.substring(item.name.length() - 2), true);
                }
            }
        }
    }

    /**
     * Hit case
     * @param a Actor test hit
     * @return True if HIT
     */
    private boolean hit(ShipsGridGDX a) {
        boolean result = false;
        for (Entry<Integer, Integer> entry : this.m_positions.entrySet()) {
            if (entry.getKey() > a.x && entry.getKey() < a.x + a.width && entry.getValue() > a.y && entry.getValue() < a.y + a.width) {
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Get if Actor actived
     * @return True if actor actived
     */
    public boolean getActive() {
        return this.m_active;
    }

    /**
     * Get posistion X first actor
     * @return Position X
     */
    public int getX() {
        ShipsGridGDX result = null;
        int i = 0;
        for (ShipsGridGDX item : this.m_actors) {
            if (item.name.startsWith("Case")) {
                if (i < 1) {
                    result = item;
                    i++;
                } else if (result.x > item.x && hit(item)) {
                    result = item;
                }
            }
        }
        int x = (int) result.x;
        // If horizontal excess
        if ((lastCase().x + lastCase().width) < (result.x + this.m_aWidth)) {
            x = (int) (x - ((result.x + this.m_aWidth) - (lastCase().x + lastCase().width)));
        }
        return x;
    }

    /**
     * Get posistionY first actor
     * @return Position Y
     */
    public int getY() {
        int y = 0;
        for (ShipsGridGDX a : this.m_actors){
            if (hit(a)){
                y = (int)a.y;
            }
        }
        return y;
    }

    /**
     * Set new position (drag)
     * @param x New position X
     * @param y New position Y
     */
    public void setPos(int x, int y) {
        this.m_positions.clear();
        this.m_positions.put(x, y);
        multiSelect(x, y);
    }

    /**
     * Save first position
     * @param x First position X
     * @param y First position Y
     */
    public void setBackup(int x, int y) {
        this.m_backupX = x;
        this.m_backupY = y;
    }

    /**
     * Get position before Drag or Move
     * @return Position saved (Before drag or move)
     */
    public HashMap<Integer, Integer> getBackup() {
        HashMap<Integer, Integer> result = new HashMap<>();
        result.put(this.m_backupX, this.m_backupY);
        return result;
    }
    
    /**
     * Get last case top/right
     * @return Actor case
     */
    private ShipsGridGDX lastCase() {
        ShipsGridGDX result = null;
        int i = 0;
        for (ShipsGridGDX item : this.m_actors) {
            if (item.name.startsWith("Case")) {
                if (i < 1) {
                    result = item;
                    i++;
                } else if (result.x <= item.x && result.y <= item.y) {
                    result = item;
                }
            }
        }
        System.out.println("Last Case : " + result.name + " = " + result.x + "x" + result.y);
        return result;
    }
}
