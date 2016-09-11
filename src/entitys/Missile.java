/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import gui.Resources;
import org.newdawn.slick.Image;

/**
 *
 * @author janabelmann
 */
public class Missile {
    public float x,y,speed, angle, wantedangle;
    long desttime;
    Image img;
    
    Missile(float x1, float y1, long time1, float speed1, float angle1) {
        this.x = x1;
        this.y = y1;
        this.speed = speed1 * 0.31f;
        this.desttime = System.currentTimeMillis() + time1;
        this.angle = angle1;
        img = Resources.getImage("missile");
        img.setCenterOfRotation(16, 16);
        img.setRotation(angle);
    }
    
    
    public void draw() {
        img.setRotation(angle);
        img.draw(x,y);
    }
    
    public void angle(int delta) {
        float xp = EntityManager.player.getX() - x;
        float yp = EntityManager.player.getY() - y;
        wantedangle = (float) ((float) (180/Math.PI) * Math.acos( (xp*0+yp*(-1))/(Math.sqrt(xp*xp+yp*yp) * Math.sqrt(1))));
        if(EntityManager.player.getX() < x) {
            wantedangle = 360 - wantedangle;
        }
        if(wantedangle >= angle) {
            if(wantedangle >= angle + 180 ) {
                angle -= 0.2f * delta;
            } else {
                angle += 0.2f * delta;
            }
        } else {
           if(angle > wantedangle + 180) {
               angle += 0.2f * delta; 
           } else {
               angle -= 0.2f * delta;
           }
           
        }
    }
    
    
    
    
    public void move(int delta) {
        angle(delta);
        if(angle < 0) {
            angle = 360 + angle;
        }
        angle = angle % 360;
        
        
        
        
        x += delta * 0.3f * Math.cos((90 + EntityManager.player.getAngle()) * Math.PI / 180) - delta * this.speed * Math.cos((90 + angle) * Math.PI / 180);
        y += delta * 0.3f * Math.sin((90 + EntityManager.player.getAngle()) * Math.PI / 180) - delta * this.speed * Math.sin((90 + angle) * Math.PI / 180);
    }
    
    public long getDestTime() {
        return this.desttime;
    }
    
    public float getX() {
        return this.x;
    }
    public float getY() {
        return this.y;
    }
    
}
