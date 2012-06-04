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
import com.bataillenavale.items.gdx.ShipsGrid;
import com.bataillenavale.tools.CasesShootingGrid;
import com.bataillenavale.items.gdx.ShootingGrid;
import java.io.File;

/**
 *
 * @author Mélissa
 */
//Controller ShipsGrid
public class ShootingGridGDX extends Actor {

    private Color m_color;
    private TextureRegion m_region;
    private String m_absolutePath;
    private Texture m_texture;
    //private ShootingGrid m_shootingGrid;

//    public ShootingGridGDX() {
//        m_shootingGrid = new ShootingGrid();
//    }

    public ShootingGridGDX(String _name, String _path, float _posX, float _posY, int _width, int _height, int _spriteX, int _spriteY) {
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
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.setColor(this.m_color.r, this.m_color.g, this.m_color.b, this.m_color.a);
        batch.draw(this.m_region, x, y);
    }

    public void setAlpha(float _alpha) {
        this.m_color.a = _alpha;
    }

    public void setPosition(float x, float y) {
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
        System.out.println("ShootingGridGDX : " + this.name);
        return true;
    }

    @Override
    public void touchUp(float x, float y, int pointer) {
        // Test Cases Colors
        int colonne = Integer.parseInt(this.name.substring(this.name.length()-2, this.name.length()-1));
        int ligne = Integer.parseInt(this.name.substring(this.name.length()-1));
        System.out.println(colonne);
        System.out.println(ligne);
        
        if (ShipsGrid.hasAShip(ligne, colonne)) {
            ShootingGrid.setToValue(ligne,colonne,1);
            CasesShootingGrid cases = new CasesShootingGrid((int)Gdx.input.getX(), (int)(Gdx.graphics.getHeight() - Gdx.input.getY()), "Check");
        } else {
            ShootingGrid.setToValue(ligne,colonne,2);
            CasesShootingGrid cases = new CasesShootingGrid((int)Gdx.input.getX(), (int)(Gdx.graphics.getHeight() - Gdx.input.getY()), "Use");
        }         
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

//    public ShootingGrid getShipsGrid() {
//        return this.m_shootingGrid;
//    }
}
