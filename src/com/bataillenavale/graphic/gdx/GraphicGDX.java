/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
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
public class GraphicGDX implements Graphic{
    
    /// Attributes
    private AppGDX m_appGDX;
    private LwjglApplication m_application;
    private boolean  m_init = false;
    private HashMap<String, ActorGDX> m_listActors;
    private HashMap<String, AnimationGDX> m_listAnim;
    private HashMap<String, TextGDX> m_listText;
    
    /**
     * Constructor
     */
    public GraphicGDX(){
        super();
    }
    
    /**
     * @see Graphic#update()
     */
    @Override
    public void update() {
        if (this.m_appGDX.getInit()){
            this.m_appGDX.getScene().update();
        }
    }
    
    /**
     * Initialize game
     * @param conf Configuration of graphic
     */
    private void init(LwjglApplicationConfiguration conf){
        this.m_listActors = new HashMap<>();
        this.m_listAnim = new HashMap<>();
        this.m_listText = new HashMap<>();
        this.m_appGDX = new AppGDX(conf.fullscreen);
        this.m_application = new LwjglApplication(this.m_appGDX, conf);
        // System.out.print("Create Run termined!!!!");
    }
    
    /**
     * @see Graphic#init(int, int, java.lang.String, boolean)
     */
    @Override
    public void init(int _width, int _height, String _title, boolean _fullScreen){
        LwjglApplicationConfiguration conf = new LwjglApplicationConfiguration();
        
        conf.width = _width;
        conf.height = _height;
        conf.title = _title;
        conf.fullscreen = _fullScreen;
        
        init(conf);
        System.out.println("Graphic is initiliaze!!!");
        this.m_init = true;
    }

    /**
     * @see Graphic#createSprite(java.lang.String, java.lang.String, float, float, int, int, int, int, int)
     */
    @Override
    public void createSprite(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame) {
        ActorGDX actor = new ActorGDX(_name, _path, _posX, _posY, _width, _height, spriteX, spriteY, _frame);
        this.m_listActors.put(_name, actor);
        this.m_appGDX.addActor(actor);
    }
    
    /**
     * @see Graphic#createAnimation(java.lang.String, java.lang.String, float, float, int, int, int, int, int)
     */
    @Override
    public void createAnimation(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame){
        AnimationGDX anim = new AnimationGDX(_name, _path, _posX, _posY, _width, _height, spriteX, spriteY, _frame);
        this.m_listAnim.put(_name, anim);
        this.m_appGDX.addActor(anim);
    }
    
    /**
     * @see Graphic#createTextActor(java.lang.String, java.lang.String, float, float)
     */
    @Override
    public void createTextActor(String _name, String _content, float _posX, float _posY){
        TextGDX text = new TextGDX(_name, _content, _posX, _posY);
        this.m_listText.put(_name, text);
        this.m_appGDX.addActor(text);
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
                
                if (frame > 1){
                    createAnimation(name, imgPath, posX, posY, width, height, spriteX, spriteY, frame);
                }
                else{
                    createSprite(name, imgPath, posX, posY, width, height, spriteX, spriteY, frame);
                }
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
    public AppGDX getGame() {
        return this.m_appGDX;
    }
    
    /**
     * @see Graphic#destroy()
     */
    @Override
    public void destroy(){
        this.m_application.exit();
    }
    
    /**
     * @see Graphic#setAlphaActor(java.lang.String, float)
     */
    @Override
    public void setAlphaActor(String name, float alpha){
        if (this.m_listActors.containsKey(name)){
            this.m_listActors.get(name).setAlpha(alpha);
        }
    }
    
    /**
     * @see Graphic#setAlphaAnim(java.lang.String, float) 
     */
    @Override
    public void setAlphaAnim(String name, float alpha){
        if (this.m_listAnim.containsKey(name)){
            this.m_listAnim.get(name).setAlpha(alpha);
        }
    }
    
    /**
     * @see Graphic#setAlphaText(java.lang.String, float)
     */
    @Override
    public void setAlphaText(String name, float alpha){
        if (this.m_listText.containsKey(name)){
            this.m_listText.get(name).setAlpha(alpha);
        }
    }
    
    @Override
    public HashMap<String, ActorGDX> getActors(){
        return this.m_listActors;
    }
    
    @Override
    public HashMap<String, AnimationGDX> getAnim(){
        return this.m_listAnim;
    }
    
    @Override
    public HashMap<String, TextGDX> getText(){
        return this.m_listText;
    }
}
