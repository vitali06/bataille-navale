/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.tools;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.graphic.gdx.ActorGDX;
import java.util.Map.Entry;

/**
 *
 * @author sittlerl
 */
public class Cases {
    
    // Attributes
    private int m_posX;
    private int m_posY;
    private String m_mode;
    
    /**
     * 
     * @param x
     * @param y
     * @param mode 
     */
    public Cases(int x, int y, String mode){
        this.m_posX = x;
        this.m_posY = y;
        this.m_mode = mode;
        activeCase();
    }
    
    /**
     * 
     */
    private void activeCase(){
        for (Entry<String, ActorGDX> entry : Singleton.getGraphic().getActors().entrySet()){
            String name = entry.getKey();
            ActorGDX actor = entry.getValue();
            
            String tmp = name.substring(name.length() - 2);
            
            switch (this.m_mode) {
                case "Select":
                    selectCase(actor, tmp);
                    break;
                case "Use":
                    useCase(actor, tmp);
                    break;
                case "Check":
                    checkCase(actor, tmp);
                    break;
            }
        }
    }
    
    /**
     * 
     * @param a
     * @param tmp 
     */
    private void selectCase(ActorGDX a, String tmp){
        if (a.name.startsWith("Case") && hit(a)) {
            if (!Singleton.getGraphic().getVisible("Use" + tmp) && !Singleton.getGraphic().getVisible("Check" + tmp) && !Singleton.getGraphic().getVisible("Select" + tmp)) {
                Singleton.getGraphic().setVisible("Case" + tmp, false);
                Singleton.getGraphic().setVisible("Select" + tmp, true);
            }
        } else if (a.name.startsWith("Case") && !hit(a)) {
            if (!Singleton.getGraphic().getVisible("Use" + tmp) && !Singleton.getGraphic().getVisible("Check" + tmp)) {
                Singleton.getGraphic().setVisible(a.name, true);
                Singleton.getGraphic().setVisible("Select" + tmp, false);
            }
        }
    }
    
    /**
     * 
     * @param a
     * @param tmp 
     */
    private void useCase(ActorGDX a, String tmp){
        if (a.name.startsWith("Case") && hit(a)) {
            System.out.println("Use : " + a.name);
            if (!Singleton.getGraphic().getVisible("Use" + tmp) && !Singleton.getGraphic().getVisible("Check" + tmp)) {
                Singleton.getGraphic().setVisible("Case" + tmp, false);
                Singleton.getGraphic().setVisible("Select" + tmp, false);
                Singleton.getGraphic().setVisible("Use" + tmp, true);
            }
        }
    }
    
    /**
     * 
     * @param a
     * @param tmp 
     */
    private void checkCase(ActorGDX a, String tmp){
        if (a.name.startsWith("Case") && hit(a)) {
            if (!Singleton.getGraphic().getVisible("Use" + tmp) && !Singleton.getGraphic().getVisible("Check" + tmp)) {
                Singleton.getGraphic().setVisible("Case" + tmp, false);
                Singleton.getGraphic().setVisible("Select" + tmp, false);
                Singleton.getGraphic().setVisible("Check" + tmp, true);
            }
        }
    }
    
    /**
     * 
     * @param a
     * @return 
     */
    private boolean hit(ActorGDX a){
        return this.m_posX > a.x && this.m_posX < a.x + a.width && this.m_posY > a.y && this.m_posY < a.y + a.width ? true : false;
    }
}
