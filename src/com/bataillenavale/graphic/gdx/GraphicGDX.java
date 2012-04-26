/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.bataillenavale.graphic.Graphic;
import com.bataillenavale.scene.ActorGDX;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class GraphicGDX implements Graphic{
    
    private AppGDX m_appGDX;
    private LwjglApplication m_application;
    private boolean  m_init = false;
    
    public GraphicGDX(){
        super();
    }
    
    @Override
    public void update() {
        if (m_appGDX.getInit()){
            // System.out.println("Graphic run");
            m_appGDX.getScene().update();
        }
    }
    
    public void init(LwjglApplicationConfiguration conf){
        m_appGDX = new AppGDX(conf.fullscreen);
        m_application = new LwjglApplication(m_appGDX, conf);
        System.out.print("Create Run termined!!!!");
    }
    
    @Override
    public void init(int _width, int _height, String _title, boolean _fullScreen){
        LwjglApplicationConfiguration conf = new LwjglApplicationConfiguration();
        
        conf.width = _width;
        conf.height = _height;
        conf.title = _title;
        conf.fullscreen = _fullScreen;
        
        init(conf);
        System.out.println("Graphic is initiliaze!!!");
        m_init = true;
    }

    @Override
    public void create(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame) {
        ActorGDX actor = new ActorGDX(_name, _path, _posX, _posY, _width, _height, spriteX, spriteY, _frame);
        m_appGDX.addActor(actor);
    }

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
                
                // System.out.println("XML : " + name + ", " + imgPath + ", Position : " + posX + "x" + posY + ", Size : " + width + "x" + height + ", Frame : " + frame);
                
                create(name, imgPath, posX, posY, width, height, spriteX, spriteY, frame);
            }
        }
    }

    @Override
    public boolean isInit() {
        return m_init;
    }

    @Override
    public AppGDX getGame() {
        return m_appGDX;
    }
}
