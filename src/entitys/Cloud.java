/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import gui.Resources;
import main.Config;
import org.newdawn.slick.Image;

/**
 *
 * @author janabelmann
 */
public class Cloud {
    float x,y;
    Image img;


    Cloud(float x1, float y1) {
        this.x = x1;
        this.y = y1;
        img = Resources.getImage("wolke");
    }
    
    public void draw() {
        img.draw(x, y, Config.scale);

    }
    
    public void move(int delta) {
        x += delta * 0.3f * Config.scale * Math.cos((90 + EntityManager.player.getAngle()) * Math.PI / 180);
        y += delta * 0.3f * Config.scale * Math.sin((90 + EntityManager.player.getAngle()) * Math.PI / 180);
    }
    
    public float getX() {
        return this.x;
    }
    
    public float getY() {
        return this.y;
    }
}
