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
public class Missile {
    public float x,y,speed, angle, wantedangle;
    long desttime;
    Image img;
    private float MScale;
    private boolean despawning;
    
    Missile(float x, float y, long time1, float angle1, MissileEnum type) {
        this.x = x;
        this.y = y;
        if(type == MissileEnum.normal) {
            this.speed = Config.normalMissileSpeed * 0.31f * Config.scale;
        }
        else if(type == MissileEnum.speedy) {
            this.speed = Config.normalMissileSpeed * 0.38f * Config.scale;
        }
        else {
            this.speed = 0;
        }
        this.desttime = System.currentTimeMillis() + time1;
        this.angle = angle1;
        img = Resources.getImage(type.toString());
        img.setCenterOfRotation(16, 16);
        img.setRotation(angle);
        MScale = 1;
    }
    
    
    public void draw() {
        img.setCenterOfRotation(16 * Config.scale,16 * Config.scale);
        img.setRotation(angle);
        img.draw(x - Config.missileSize * Config.scale / 2,y-Config.missileSize * Config.scale / 2, Config.scale * MScale);
        if(despawning) {
            MScale /= 1.008f;
        }
    }
    
    public void changeAngle(int delta) {
        float xp = Config.windowWidth /2 -x;//EntityManager.player.getX() + 16 - (x - 16);
        float yp = Config.windowHeight /2 - y;//EntityManager.player.getY() + 16 - (y - 16);
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

    public void despawn() {
        despawning = true;
    }
    
    
    public void move(int delta) {
        if(despawning) {
            x += delta * 0.3f * Config.scale * Math.cos((90 + EntityManager.player.getAngle()) * Math.PI / 180) - delta * this.speed * Math.cos((90 + angle) * Math.PI / 180);
            y += delta * 0.3f * Config.scale * Math.sin((90 + EntityManager.player.getAngle()) * Math.PI / 180) - delta * this.speed * Math.sin((90 + angle) * Math.PI / 180);

            this.speed /= 1.018f;
        } else {
            changeAngle(delta);
            if (angle < 0) {
                angle = 360 + angle;
            }
            angle = angle % 360;

            x += delta * 0.3f * Config.scale * Math.cos((90 + EntityManager.player.getAngle()) * Math.PI / 180) - delta * this.speed * Math.cos((90 + angle) * Math.PI / 180);
            y += delta * 0.3f * Config.scale * Math.sin((90 + EntityManager.player.getAngle()) * Math.PI / 180) - delta * this.speed * Math.sin((90 + angle) * Math.PI / 180);
        }
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
    public float getSpeed() { return this.speed;}
}
