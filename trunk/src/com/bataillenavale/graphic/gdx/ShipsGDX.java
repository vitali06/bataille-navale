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
import com.bataillenavale.items.gdx.Ships;
import com.bataillenavale.tools.CasesShipsGrid;
import java.io.File;
import java.util.Map;

/**
 *
 * @author Mélissa
 */
//Controller Ships 
public class ShipsGDX extends Actor {

    /**
     * @return the selected
     */
    public static ShipsGDX getSelected() {
        return selected;
    }

    /**
     * @param aSelected the selected to set
     */
    public static void setSelected(ShipsGDX aSelected) {
        selected = aSelected;
    }

    private Color m_color;
    private TextureRegion m_region;
    private String m_absolutePath;
    private Texture m_texture;
    private Ships ships;
    private CasesShipsGrid m_pos;
    private boolean horizontal;
    private static ShipsGDX selected;
    
    public ShipsGDX() {
    }
    
    public ShipsGDX(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY, int life) {
        super(_name);

        this.m_absolutePath = new File(_path).getAbsolutePath();
        FileHandle t_file = Gdx.files.absolute(this.m_absolutePath);
        this.m_texture = new Texture(t_file);
        this.m_region = new TextureRegion(this.m_texture, _spriteX, _spriteY, _width, _height);

        this.x = _posX;
        this.y = _posY;
        this.width = _width;
        this.height = _height;

        m_color = new Color(1, 1, 1, 1);
        this.horizontal = true;
        
        ships = new Ships(name, life);
        ShipsGDX.selected = null;
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {        
        batch.setColor(this.m_color.r, this.m_color.g, this.m_color.b, this.m_color.a);
        batch.draw(this.m_region, x, y, 0, 0, this.width, this.height, 1f, 1f, this.rotation);
        //batch.draw(this.m_region, x, y);        
    }

    @Override
    public boolean touchDown(float x, float y, int pointer) {
        ShipsGDX.setSelected(this);
        this.m_pos = new CasesShipsGrid((int) this.x, (int) this.y, (int) this.width, (int) this.height);
        this.m_pos.setBackup((int) this.x, (int) this.y);        
        return true;
    }

    @Override
    public void touchUp(float x, float y, int pointer) {
        if (this.m_pos.getActive() && this.m_pos.getX() != 0 && this.m_pos.getY() != 0) {
            this.x = this.m_pos.getX();
            this.y = this.m_pos.getY();
        } else {
            for (Map.Entry<Integer, Integer> entry : this.m_pos.getBackup().entrySet()) {
                this.x = entry.getKey();
                this.y = entry.getValue();
            }
        }
    }

    @Override
    public void touchDragged(float x, float y, int pointer) {
        this.x = Gdx.input.getX() - this.width / 2;
        this.y = Gdx.graphics.getHeight() - Gdx.input.getY() - this.height / 2;
        this.m_pos.setPos((int) this.x, (int) this.y);
    }

    @Override
    public Actor hit(float x, float y) {
        return x > 0 && x < this.width && y > 0 && y < this.height ? this : null;
    }
    
    public float getPositionX() {
        return this.x;
    }
    
    public float getPositionY() {
        return this.y;
    }

    /**
     * @return the ships
     */
    public Ships getShips() {
        return ships;
    }

    /**
     * @param ships the ships to set
     */
    public void setShips(Ships ships) {
        this.ships = ships;
    }

    /**
     * @return the horizontal
     */
    public boolean isHorizontal() {
        return horizontal;
    }

    /**
     * @param horizontal the horizontal to set
     */
    public void setHorizontal(boolean horizontal) {        
        this.horizontal = horizontal;
        
    }
    
    public void doRotation() {
        this.rotation = (this.rotation - 90) % 180;        
        this.setHorizontal(!this.isHorizontal());
    }

}
