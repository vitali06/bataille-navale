/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bataillenavale.graphic.gdx;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.bataillenavale.tools.Cases;
import com.bataillenavale.tools.ShipsGrid;
import java.io.File;

/**
 *
 * @author Mélissa
 */

//Controller ShipsGrid

public class ShipsGridGDX extends Actor {
    
    private Color m_color;
    private TextureRegion m_region;
    private String m_absolutePath;
    private Texture m_texture;
    private ShipsGrid m_shipsGrid;
    
    public ShipsGridGDX()
    {
        m_shipsGrid = new ShipsGrid();
    }

    public ShipsGridGDX(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY) {
        super(_name);
        
        this.m_absolutePath = new File(_path).getAbsolutePath();
        FileHandle t_file = Gdx.files.absolute(this.m_absolutePath);
        this.m_texture = new Texture(t_file);
        this.m_region = new TextureRegion(this.m_texture, _spriteX, _spriteY, _width, _height);
        
        this.x = _posX;
        this.y = _posY;
        this.width = _width;
        this.height = _height;
        
        m_color = new Color(1,1,1,1);
        m_shipsGrid = new ShipsGrid();
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.setColor(this.m_color.r, this.m_color.g, this.m_color.b, this.m_color.a);
        batch.draw(this.m_region, x, y);
    }
    
    public void setAlpha(float _alpha){
        this.m_color.a = _alpha;
    }

    public void setPosition(float x, float y){
        this.x = x;
        this.y = y;
    }
    
    public float getPositionX() {
        return this.x;
    }
    
    public float getPositionY() {
        return this.y;
    }
    
    @Override
    public boolean touchDown(float x, float y, int pointer) {
        System.out.println("ShipsGridGDX : " + this.name);
        return true;
    }

    @Override
    public void touchUp(float x, float y, int pointer) {
        // Test Cases Colors
        //Cases reuh = new Cases((int)Gdx.input.getX(), (int)(Gdx.graphics.getHeight() - Gdx.input.getY()), "Use");
    }

    @Override
    public void touchDragged(float x, float y, int pointer) {
    }

    @Override
    public Actor hit(float x, float y) {
        return x > 0 && x < this.width && y > 0 && y < this.height ? this : null;
    }

    /**
     * Set Actor visibility
     *
     * @param visible True if visible
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    /**
     * Get Actor visibility
     *
     * @return True if Actor is visible
     */
    public boolean getVisible() {
        return this.visible;
    }

//    public void fillGrid() {
//        //Pour chaque navire, on compare sa position x et y avec la position de la grille
//        
//        //Si x et y se trouve sur un x et y de la grille
//        //Alors le navire se trouve sur cette case
//        
//        for (Map.Entry<String, ShipsGDX> entry : Singleton.getGraphic().getShips().entrySet()) {
//            for (Map.Entry<String, ShipsGridGDX> e : Singleton.getGraphic().getShipsGrid().entrySet()) {
//                if (entry.getValue().x < e.getValue().getPositionX() + e.getValue().width
//                        && entry.getValue().x > e.getValue().getPositionX()
//                        && entry.getValue().y < e.getValue().getPositionY() + e.getValue().height
//                        && entry.getValue().y > e.getValue().getPositionY()
//                        && e.getKey().startsWith("Case")) {
////                    System.out.println(true);
////                    System.out.println("x navire : " + entry.getKey() + " " + entry.getValue().x);
////                    System.out.println("y navire : " + entry.getKey() + " " + entry.getValue().y);
////                    System.out.println("x grid : " + e.getKey() + " " + e.getValue().x);
////                    System.out.println("y grid : " + e.getKey() + " " + e.getValue().y);
//                    Ships ships = entry.getValue().getShips(); 
//                    System.out.println(ships.getName());
//                    int colonne = Integer.parseInt(e.getKey().substring(4, 5));                    
//                    int ligne = Integer.parseInt(e.getKey().substring(5));
//                    //System.out.println("Colonne : " + colonne);
//                    //System.out.println("Ligne : " + ligne);
//                    for(int i = 0; i<ships.getLife(); i++)
//                    {
//                        this.m_shipsGrid.setToTrue(ligne, colonne);
//                        //System.out.println("Colonne : " + colonne);
//                        colonne++;
//                    }                    
//                }
//
//            }
//        }
//        
//        System.out.println("ShipsGrid : ");
//        m_shipsGrid.outString();
//    }
}
