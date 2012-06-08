/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.math.Rectangle;
import com.bataillenavale.graphic.Graphic;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * GraphicGDX Class
 *
 * @author Alexis, Mélissa, Laurent
 */
public class GraphicGDX implements Graphic {

    /// Attributes
    private GameGDX m_gameGDX;
    private LwjglApplication m_application;
    private Rectangle m_gameDimensions;
    private boolean m_init = false;
    private HashMap<String, ActorGDX> m_listActors;
    private HashMap<String, AnimationGDX> m_listAnim;
    private HashMap<String, TextGDX> m_listText;
    private HashMap<String, ShipsGridGDX> m_listShipsGrid;
    private HashMap<String, ShipsGDX> m_listShips;
    private HashMap<String, ShootingGridGDX> m_listShootingGrid;

    /**
     * Constructor
     */
    public GraphicGDX() {
        super();
        this.m_gameDimensions = new Rectangle();
    }

    /**
     * @see Graphic#update()
     */
    @Override
    public void update() {
        if (this.m_gameGDX.getInit()) {
            this.m_gameGDX.getScene().update();
        }
    }

    /**
     * Initialize game
     *
     * @param conf Configuration of graphic
     */
    private void init(LwjglApplicationConfiguration conf) {
        this.m_listActors = new HashMap<>();
        this.m_listAnim = new HashMap<>();
        this.m_listText = new HashMap<>();
        this.m_listShipsGrid = new HashMap<>();
        this.m_listShips = new HashMap<>();
        this.m_listShootingGrid = new HashMap<>();
        this.m_gameGDX = new GameGDX(conf.fullscreen);
        this.m_application = new LwjglApplication(this.m_gameGDX, conf);
        // System.out.print("Create Run termined!!!!");
    }

    /**
     * @see Graphic#init(int, int, java.lang.String, boolean)
     */
    @Override
    public void init(int _width, int _height, String _title, boolean _fullScreen) {
        LwjglApplicationConfiguration conf = new LwjglApplicationConfiguration();

        conf.width = _width;
        this.m_gameDimensions.setWidth(_width);
        conf.height = _height;
        this.m_gameDimensions.setHeight(_height);
        conf.title = _title;
        conf.fullscreen = _fullScreen;

        init(conf);
        //System.out.println("Graphic is initiliaze!!!");
        this.m_init = true;
    }

    /**
     * @see Graphic#getDimensions()
     */
    @Override
    public Rectangle getDimensions() {
        return this.m_gameDimensions;
    }

    /**
     * @see Graphic#createSprite(java.lang.String, java.lang.String, float,
     * float, int, int, int, int, int)
     */
    @Override
    public void createSprite(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame) {
        ActorGDX actor = new ActorGDX(_name, _path, _posX, _posY, _width, _height, spriteX, spriteY, _frame);
        this.m_listActors.put(_name, actor);
        this.m_gameGDX.addActor(actor);
    }

    /**
     * @see Graphic#createAnimation(java.lang.String, java.lang.String, float,
     * float, int, int, int, int, int)
     */
    @Override
    public void createAnimation(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame) {
        AnimationGDX anim = new AnimationGDX(_name, _path, _posX, _posY, _width, _height, spriteX, spriteY, _frame);
        this.m_listAnim.put(_name, anim);
        this.m_gameGDX.addActor(anim);
    }

    /**
     * @see Graphic#createTextActor(java.lang.String, java.lang.String, float,
     * float)
     */
    @Override
    public void createTextActor(String _name, String _content, float _posX, float _posY) {
        TextGDX text = new TextGDX(_name, _content, _posX, _posY);
        this.m_listText.put(_name, text);
        this.m_gameGDX.addActor(text);
    }

    /**
     * @see Graphic#createTextFont(java.lang.String, java.lang.String, float,
     * float, java.lang.String)
     */
    @Override
    public void createTextFont(String _name, String _content, float _posX, float _posY, String _font) {
        TextGDX text = new TextGDX(_name, _content, _posX, _posY, _font);
        this.m_listText.put(_name, text);
        this.m_gameGDX.addActor(text);
    }

    @Override
    public void createShipsGrid(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY) {
        ShipsGridGDX shipsGrid = new ShipsGridGDX(_name, _path, _posX, _posY, _width, _height, _spriteX, _spriteY);
        this.m_listShipsGrid.put(_name, shipsGrid);
        this.m_gameGDX.addActor(shipsGrid);
    }

    @Override
    public void createShips(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY, int _life) {
        ShipsGDX ships = new ShipsGDX(_name, _path, _posX, _posY, _width, _height, _spriteX, _spriteY, _life);
        this.m_listShips.put(_name, ships);
        this.m_gameGDX.addActor(ships);
    }

    @Override
    public void createShootingGrid(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY) {
        ShootingGridGDX shootingGrid = new ShootingGridGDX(_name, _path, _posX, _posY, _width, _height, _spriteX, _spriteY);
        this.m_listShootingGrid.put(_name, shootingGrid);
        this.m_gameGDX.addActor(shootingGrid);
    }

    /**
     * @see Graphic#setPositionActor(java.lang.String, float, float)
     */
    @Override
    public void setPositionActor(String name, float posX, float posY) {
        if (this.m_listText.containsKey(name)) {
            this.m_listText.get(name).setPosition(posX, posY);
        } else if (this.m_listActors.containsKey(name)) {
            this.m_listActors.get(name).setPosition(posX, posY);
        } else if (this.m_listAnim.containsKey(name)) {
            this.m_listAnim.get(name).setPosition(posX, posY);
        }
    }

    /**
     * @see Graphic#setTouchable(java.lang.String, boolean)
     */
    @Override
    public void setTouchable(String name, boolean touch) {
        if (this.m_listActors.containsKey(name)) {
            this.m_listActors.get(name).setTouchable(touch);
        }
    }

    /**
     * @see Graphic#setVisible(java.lang.String, boolean)
     */
    @Override
    public void setVisible(String name, boolean visible) {
        if (this.m_listActors.containsKey(name)) {
            this.m_listActors.get(name).setVisible(visible);
        } else if (this.m_listShipsGrid.containsKey(name)) {
            this.m_listShipsGrid.get(name).setVisible(visible);
        } else if (this.m_listShootingGrid.containsKey(name)) {
            this.m_listShootingGrid.get(name).setVisible(visible);
        } else if (this.m_listText.containsKey(name)) {
            this.m_listText.get(name).setVisible(visible);
        }
    }

    /**
     * @see Graphic#getVisible(java.lang.String)
     */
    @Override
    public boolean getVisible(String name) {
        if (this.m_listActors.containsKey(name)) {
            return this.m_listActors.get(name).getVisible();
        } else if (this.m_listShipsGrid.containsKey(name)) {
            return this.m_listShipsGrid.get(name).getVisible();
        } else if (this.m_listShootingGrid.containsKey(name)) {
            return this.m_listShootingGrid.get(name).getVisible();
        } else if (this.m_listText.containsKey(name)) {
            return this.m_listText.get(name).getVisible();
        } else {
            return false;
        }
    }

    /**
     * @see Graphic#setAlpha(java.lang.String, float)
     */
    @Override
    public void setAlpha(String name, float alpha) {
        if (this.m_listText.containsKey(name)) {
            this.m_listText.get(name).setAlpha(alpha);
        } else if (this.m_listActors.containsKey(name)) {
            this.m_listActors.get(name).setAlpha(alpha);
        } else if (this.m_listAnim.containsKey(name)) {
            this.m_listAnim.get(name).setAlpha(alpha);
        } else if (this.m_listShipsGrid.containsKey(name)) {
            this.m_listShipsGrid.get(name).setAlpha(alpha);
        } else if (this.m_listShootingGrid.containsKey(name)) {
            this.m_listShootingGrid.get(name).setAlpha(alpha);
        }
    }

    /**
     * @see Graphic#loadSprites(java.lang.String)
     */
    @Override
    public void loadSprites(String path) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(path);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        Element elem = doc.getDocumentElement();
        NodeList child = elem.getChildNodes();

        for (int i = 0; i < child.getLength(); i++) {
            Node n = child.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                String name = e.getAttribute("name");
                String imgPath = e.getAttribute("path");
                int posX = Integer.parseInt(e.getAttribute("posX"));
                int posY = Integer.parseInt(e.getAttribute("posY"));
                int width = Integer.parseInt(e.getAttribute("width"));
                int height = Integer.parseInt(e.getAttribute("height"));
                int spriteX = Integer.parseInt(e.getAttribute("spriteX"));
                int spriteY = Integer.parseInt(e.getAttribute("spriteY"));
                int frame = Integer.parseInt(e.getAttribute("frame"));

                if (frame > 1) {
                    createAnimation(name, imgPath, posX, posY, width, height, spriteX, spriteY, frame);
                } else {
                    createSprite(name, imgPath, posX, posY, width, height, spriteX, spriteY, frame);
                }
            }
        }
    }

    @Override
    public void loadShips(String path) throws ParserConfigurationException, IOException, SAXException {
        File file = new File(path);
        DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
        Document doc = builder.parse(file);
        doc.getDocumentElement().normalize();

        Element elem = doc.getDocumentElement();
        NodeList child = elem.getChildNodes();

        for (int i = 0; i < child.getLength(); i++) {
            Node n = child.item(i);
            if (n.getNodeType() == Node.ELEMENT_NODE) {
                Element e = (Element) n;
                String _name = e.getAttribute("name");
                String _path = e.getAttribute("path");
                int _width = Integer.parseInt(e.getAttribute("width"));
                int _height = Integer.parseInt(e.getAttribute("height"));
                int _posX = Integer.parseInt(e.getAttribute("posX"));
                int _posY = Integer.parseInt(e.getAttribute("posY"));
                int _spriteX = Integer.parseInt(e.getAttribute("spriteX"));
                int _spriteY = Integer.parseInt(e.getAttribute("spriteY"));
                int hp = Integer.parseInt(e.getAttribute("hp"));

                this.createShips(_name, _path, _posX, _posY, _width, _height, _spriteX, _spriteY, hp);

                //setDragged(_name, touch);
                //setPosition(_name);
            }
        }
    }

    /**
     * @see Graphic#isInit()
     */
    @Override
    public boolean isInit() {
        return this.m_init;
    }

    /**
     * @see Graphic#getGame()
     */
    @Override
    public GameGDX getGame() {
        return this.m_gameGDX;
    }

    /**
     * @see Graphic#destroy()
     */
    @Override
    public void destroy() {
        this.m_application.exit();
    }

    /**
     * @see Graphic#setColorText(java.lang.String, float, float, float)
     */
    @Override
    public void setColorText(String name, float r, float g, float b) {
        if (this.m_listText.containsKey(name)) {
            this.m_listText.get(name).setColor(r, g, b);
        }
    }

    /**
     * @see Graphic#getActors()
     */
    @Override
    public HashMap<String, ActorGDX> getActors() {
        return this.m_listActors;
    }

    /**
     * @see Graphic#getAnim()
     */
    @Override
    public HashMap<String, AnimationGDX> getAnim() {
        return this.m_listAnim;
    }

    /**
     * @see Graphic#getText()
     */
    @Override
    public HashMap<String, TextGDX> getText() {
        return this.m_listText;
    }

    @Override
    public HashMap<String, ShipsGridGDX> getShipsGrid() {
        return this.m_listShipsGrid;
    }

    @Override
    public HashMap<String, ShipsGDX> getShips() {
        return this.m_listShips;
    }

    @Override
    public HashMap<String, ShootingGridGDX> getShootingGrid() {
        return this.m_listShootingGrid;
    }
}
