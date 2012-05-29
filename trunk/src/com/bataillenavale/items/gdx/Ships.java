/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.items.gdx;

import com.bataillenavale.game.Singleton;
import com.bataillenavale.scene.content.Splashscreen;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @author sittlerl
 */
public class Ships {
    
    public Ships() {
        try {
            loadConf("config/ShipsConfig.xml");
        } catch (Exception ex) {
            Logger.getLogger(Splashscreen.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void loadConf(String path) throws ParserConfigurationException, IOException, SAXException {
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
                boolean touch = Boolean.parseBoolean(e.getAttribute("touch"));
                int hp = Integer.parseInt(e.getAttribute("hp"));
                
                setDragged(name, touch);
                setPosition(name);
            }
        }
    }
    
    private void setDragged(String name, boolean touch){
        Singleton.getGraphic().setTouchable(name, touch);
    }
    
    private void setPosition(String name){
        if (Singleton.getGraphic().getActors().containsKey(name)){
            float posX = (300 - Singleton.getGraphic().getActors().get(name).width) / 2;
            Singleton.getGraphic().getActors().get(name).setPosition(posX, Singleton.getGraphic().getActors().get(name).y);
        }
    }
}
