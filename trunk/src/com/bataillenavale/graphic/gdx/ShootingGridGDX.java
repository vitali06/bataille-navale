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
import com.bataillenavale.ai.Computer;
import com.bataillenavale.game.Singleton;
import com.bataillenavale.items.gdx.*;
import com.bataillenavale.tools.CasesShootingGrid;
import com.bataillenavale.tools.Coordonnee;
import com.bataillenavale.tools.Intervale;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private CasesShootingGrid cases;
    private static List<ShootingGridGDX> list = new ArrayList<>();
    private static Computer cpu;
    private static ShipsGridComputer ships_grid_cpu;
    private static int compteur_tir_ia = 0;
    private static int res_tir;
    private static boolean prem_touche = false;
    private static boolean navire_coule = false;

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
        list.add(this);
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
        if (Singleton.getGraphic().getText().containsKey("Manque")) {
            Singleton.getGraphic().getText().get("Manque").remove();
        }
        if (Singleton.getGraphic().getText().containsKey("Touch")) {
            Singleton.getGraphic().getText().get("Touch").remove();
        }
        if (Singleton.getGraphic().getText().containsKey("Coule")) {
            Singleton.getGraphic().getText().get("Coule").remove();
        }
        return true;
    }

    @Override
    public void touchUp(float x, float y, int pointer) {
        int colonne = Integer.parseInt(this.name.substring(this.name.length() - 2, this.name.length() - 1));
        int ligne = Integer.parseInt(this.name.substring(this.name.length() - 1));

        if (ShipsGridComputer.hasAShip(colonne, ligne)) {
            ShootingGrid.setToValue(colonne, ligne, 1);
            for (ShipsComputer ships : ShipsComputer.getShipsList()) {
                if (ships.getIntervale().contains(new Coordonnee(colonne, ligne))) {
                    ships.setLife(ships.getLife() - 1);
                    //System.out.println(ships.getName());

                    if (ships.isSeek()) {
                        Singleton.getGraphic().createTextFont("Coule", ships.getName() + " Coule", 20, 150, "Calibrib");
                        Singleton.getGraphic().setColorText("Coule", 1.f, 0.f, 0.f);
                        ShipsComputer.getShipsList().remove(ships);
                    } else {
                        Singleton.getGraphic().createTextFont("Touch", ships.getName() + " Touche", 20, 150, "Calibrib");
                        Singleton.getGraphic().setColorText("Touch", 1.f, 0.f, 0.f);
                    }

                    if (ShipsComputer.getShipsList().isEmpty()) {
                        Singleton.getSound().applauses();
                        Singleton.getGraphic().createTextFont("GAGNE", "VOUS AVEZ GAGNE!", 5, 400, "SimHei");
                        for (ShootingGridGDX s : ShootingGridGDX.list) {
                            s.setTouchable(false);
                        }
                    }
                    break;
                }
            }

            cases = new CasesShootingGrid((int) Gdx.input.getX(), (int) (Gdx.graphics.getHeight() - Gdx.input.getY()), "Check");

            //Ne pas pouvoir cliquer deux fois sur la même case
            Singleton.getGraphic().getShootingGrid().get("ShootingCheck" + colonne + ligne).setTouchable(false);
            list.remove(Singleton.getGraphic().getShootingGrid().get("ShootingCheck" + colonne + ligne));
            Singleton.getSound().explosion();

        } else {
            ShootingGrid.setToValue(ligne, colonne, 2);
            cases = new CasesShootingGrid((int) Gdx.input.getX(), (int) (Gdx.graphics.getHeight() - Gdx.input.getY()), "Use");
            Singleton.getSound().splash();
            Singleton.getGraphic().createTextFont("Manque", "Manque", 100, 150, "Calibrib");
            Singleton.getGraphic().getShootingGrid().get("ShootingUse" + colonne + ligne).setTouchable(false);
            list.remove(Singleton.getGraphic().getShootingGrid().get("ShootingUse" + colonne + ligne));
        }

        //Fin du joueur

        //Début de l'IA
        if(res_tir == 1 || prem_touche)
        {
            cpu.strategieChange(1);
        }
        else
        {
            if(compteur_tir_ia > 10)
            {
                cpu.setRayon_zone(1);
                cpu.strategieChange(res_tir);
            }
            else if(compteur_tir_ia > 20)
            {
                cpu.setRayon_zone(0);
                cpu.strategieChange(res_tir);
            }
            else
            {
                cpu.strategieChange(res_tir);
            }
        }
        Coordonnee c = cpu.Fire();
        compteur_tir_ia++;
        System.out.println("x : " + c.getX() + " y : " +c.getY());
        if(ShipsGrid.hasAShip(c.getX(), c.getY()))
        {
            res_tir = 1;
            cpu.updateMat(c, 1);
            if(!prem_touche)
            {
                cpu.setNavire_trouve(c);
                prem_touche = true;
            }
            System.out.println("Has a ship");
            for (Ships ships : Ships.getShipsList()) {
                if (ships.getIntervale().contains(new Coordonnee(c.getX(), c.getY()))) {
                    ships.setLife(ships.getLife() - 1);
                    if(ships.isSeek())
                    {
                        res_tir = 0;
                        prem_touche = false;
                        Ships.getShipsList().remove(ships);                       
                    }
                    System.out.println(ships.getName());
                    
                    if(Ships.getShipsList().isEmpty())
                    {
                        System.out.println("Joueur Perdu, IA Gagné");
                    }
                    
                    break;
                }
            }
        }
        else
        {
            cpu.updateMat(c, 2);
            res_tir = 0;
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

    public void setTouchable(boolean touchable) {
        this.touchable = touchable;
    }

    public static void createCpu() {
        cpu = Computer.getElement();
        ShootingGridGDX.fillGridComputer();
    }

    public static void fillGridComputer() {
        HashMap<String, Intervale> list_position_navire = new HashMap<>();
        list_position_navire = cpu.placerNavire();
        ShipsComputer ships;

//        cpu.placerNavire(5);
//        cpu.placerNavire(4);
//        cpu.placerNavire(3);
//        cpu.placerNavire(3);
//        cpu.placerNavire(2);
//        list_position_navire = cpu.getPosition_navire();
        for (Map.Entry<String, Intervale> entry : list_position_navire.entrySet()) {
            ShipsGridComputer.setToTrue(entry.getValue());
            ships = new ShipsComputer(entry.getKey(), entry.getValue().getTaille(), entry.getValue());
            //System.out.println(entry.getKey());
            //entry.getValue().outString();
        }

        //ShipsGridComputer.outString();
    }
}
