/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.Gdx;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.items.gdx.Ships;
import com.bataillenavale.items.gdx.ShipsComputer;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.tools.DrawShootingGrid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 *
 * @author Mélissa
 */
public class GameScene implements Scene {

    private boolean m_fps;
    private boolean m_init;
    private boolean m_newScene;
    private int m_count;

    public GameScene(boolean fps) {
        this.m_fps = fps;
        this.m_init = false;
        this.m_newScene = false;
        this.m_count = 0;
    }

    @Override
    public void init() {
        if (!this.m_init) {
            
            // Map standard
            int posX = ((Gdx.graphics.getWidth() - 300 - 450) / 2) + 300;
            int posY = ((Gdx.graphics.getHeight() - 450) / 2);
            Singleton.getGraphic().createSprite("Map01", "data/Maps/Map01.png", posX, posY, 450, 450, 0, 0, 1);
            
            // Grille de positionnement
            DrawShootingGrid grille = new DrawShootingGrid(9);
            try {
                Singleton.getGraphic().loadSprites("config/PrepareGameScene.xml");

            } catch (ParserConfigurationException | IOException | SAXException ex) {
                Logger.getLogger(GameScene.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            Singleton.getGraphic().createTextFont("Game", "{Game}", 60, 550, "Ascent");
            Singleton.getGraphic().createTextFont("Porte-Avions", "Porte-avions : 5 vies", 60, 300, "Calibri");
            Singleton.getGraphic().createTextFont("Cuirasse", "Cuirasse : 4 vies", 60, 250, "Calibri");
            Singleton.getGraphic().createTextFont("Sous-Marin", "Sous-Marin : 3 vies", 60, 200, "Calibri");            
            Singleton.getGraphic().createTextFont("Contre-Torpilleur", "Contre-Torpilleur : 3 vies", 60, 150, "Calibri");
            Singleton.getGraphic().createTextFont("Lance-Torpilles", "Lance-Torpilles : 2 vies", 60, 100, "Calibri");
            Singleton.getGraphic().createTextFont("BackMenu", "Pour retourner au menu : Appuyez sur Entree", 400, 50, "Calibri");
            Singleton.getGraphic().getText().get("BackMenu").setVisible(false);
            this.m_init = true;
        }
    }

    @Override
    public void update() {
        if (this.m_init) {
            if (Ships.getShipsList().isEmpty()
                    || ShipsComputer.getShipsList().isEmpty()) {
                this.m_count++;                
                Singleton.getGraphic().setAlpha("BackMenu", this.m_count / 0.25f);
                if (Singleton.getInput().isEnterPressed()) {
                    // Retour au menu principal
                    this.m_init = false;
                    Singleton.getGraphic().getGame().getScreen().nextScene(new MainMenuScene(false));
                    this.m_newScene = true;
                }
            }
        }
    }

    @Override
    public void destroy() {
    }

    @Override
    public boolean getFps() {
        return this.m_fps;
    }

    @Override
    public boolean isInit() {
        return this.m_init;
    }

    @Override
    public boolean newScene() {
        return this.m_newScene;
    }
}
