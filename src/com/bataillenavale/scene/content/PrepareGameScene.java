/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene.content;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.actions.RotateTo;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.graphic.gdx.ShipsGDX;
import com.bataillenavale.graphic.gdx.ShipsGridGDX;
import com.bataillenavale.scene.Scene;
import com.bataillenavale.tools.DrawShipsGrid;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;

/**
 * Scene of Game
 *
 * @author Alexis, Mélissa, Laurent
 */
public class PrepareGameScene implements Scene {

    /// Attributes
    private boolean m_init;
    private boolean m_fps;
    private Rectangle m_sizeGame;
    private boolean m_newScene;

    /**
     * Constructor
     *
     * @param _fps True if show fps
     */
    public PrepareGameScene(boolean _fps) {
        this.m_fps = _fps;
        m_sizeGame = Singleton.getGraphic().getDimensions();
        this.m_init = false;
        this.m_newScene = false;
    }

    /**
     * @see Scene#init()
     */
    @Override
    public void init() {
        if (!this.m_init) {
            //System.out.println("Prepare Game Scene (init)");
            // Map standard
            int posX = ((Gdx.graphics.getWidth() - 300 - 450) / 2) + 300;
            int posY = ((Gdx.graphics.getHeight() - 450) / 2);
            Singleton.getGraphic().createSprite("Map01", "data/Maps/Map01.png", posX, posY, 450, 450, 0, 0, 1);
            // Grille de positionnement
            DrawShipsGrid grille = new DrawShipsGrid(9);
            try {
                Singleton.getGraphic().loadSprites("config/PrepareGameScene.xml");
                Singleton.getGraphic().loadShips("config/ShipsConfig.xml");

            } catch (ParserConfigurationException | IOException | SAXException ex) {
                Logger.getLogger(PrepareGameScene.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Ships t_ships = new Ships();
            Singleton.getGraphic().createTextFont("PGame", "{Game}", 60, 550, "Ascent");
            //Singleton.getGraphic().setColorText("Porte Avions", 1.f, 0.f, 0.f);
            this.m_init = true;
        }
    }

    /**
     * @see Scene#update()
     */
    @Override
    public void update() {
        if (this.m_init) {
            if (Singleton.getInput().isEnterPressed()) {
                ShipsGridGDX.fillGrid();
                this.m_init = false;
                Singleton.getGraphic().getGame().getScreen().nextScene(new GameScene(false));
                this.m_newScene = true;
            }

            if (Singleton.getInput().isSpacePressed()) {
                ShipsGDX.getSelected().doRotation();                
                ShipsGDX.getSelected().x = Gdx.input.getX();                
            }
        }
    }

    /**
     * @see Scene#destroy()
     */
    @Override
    public void destroy() {
        this.m_init = false;
        Singleton.getGraphic().getActors().clear();
        Singleton.getGraphic().getAnim().clear();
        Singleton.getGraphic().getText().clear();
    }

    /**
     * @see Scene#getFps()
     */
    @Override
    public boolean getFps() {
        return this.m_fps;
    }

    /**
     * @see Scene#isInit()
     */
    @Override
    public boolean isInit() {
        return this.m_init;
    }

    /**
     * @see Scene#newScene()
     */
    @Override
    public boolean newScene() {
        return this.m_newScene;
    }
}
