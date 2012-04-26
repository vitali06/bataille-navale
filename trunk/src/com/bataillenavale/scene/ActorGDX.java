/*
 * Bataille Navale
 * http://code.google.com/p/bataille-navale/
 * Alexis Dörr - Mélissa Weissmuller - Laurent Sittler
 */
package com.bataillenavale.scene;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import java.io.File;

/**
 * 
 * @author Alexis, Mélissa, Laurent
 */
public class ActorGDX extends Actor {
    
    private TextureRegion m_region;
    private String m_absolutePath;
    private Texture m_texture;

    public ActorGDX(String _name, String _path, float _posX, float _posY, int _width, int _height, int spriteX, int spriteY, int _frame) {
        super(_name);
        
        m_absolutePath = new File(_path).getAbsolutePath();
        
        FileHandle t_file = Gdx.files.absolute(m_absolutePath);

        m_texture = new Texture(t_file);
        m_region = new TextureRegion(m_texture, spriteX, spriteY, _width, _height);
        
        System.out.println("ActorGDX path : \"" + _name + ", size : " + m_texture.getWidth() + "x" + m_texture.getHeight());
        
        this.x = _posX;
        this.y = _posY;
        this.width = _width;
        this.height = _height;
    }

    @Override
    public void draw(SpriteBatch batch, float parentAlpha) {
        batch.setColor(1, 1, 1, 1);
        System.out.println("ICI SET ALPHA");
        batch.draw(m_region, x, y);
    }

    @Override
    public boolean touchDown(float x, float y, int pointer) {
        return true;
    }

    @Override
    public void touchUp(float x, float y, int pointer) {
    }

    @Override
    public void touchDragged(float x, float y, int pointer) {
    }

    @Override
    public Actor hit(float x, float y) {
        return x > 0 && x < width && y > 0 && y < height ? this : null;
    }
}
