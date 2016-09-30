/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import static entitys.EntityManager.missiles;
import gui.Resources;
import main.Config;

/**
 *
 * @author janabelmann
 */
public class Player {
    float x,y;
    float angle;
    int direction;
    
    
    Player() {
        x = Config.windowWidth / 2;
        y = Config.windowHeight / 2;
        angle = 90;
    }
    
    public void draw() {
        Resources.getImage("airplane").drawCentered(x, y);
        Resources.getImage("airplane").setRotation(angle);
    }
    
    public void addAngle(float a) {
        angle += a;
        angle = angle % 360;
        if(angle < 0) {
            angle = 360 - angle;
        }
    }
    
    public float getAngle() {
        return angle;
    }
    
    public void setAngle(float a) {
        angle = a;
        angle = angle % 360;
    }

    public float getX() {
        return x;
    }
    
    public float getY() {
        return y;
    }
    
    public void update() {
            if(angle < 45f || angle > 315) {
                direction = 0; 
            } else if(angle > 45f && angle < 135) {
                direction = 1;             
            } else if(angle > 135 && angle < 225) {
                direction = 2;             
            } else if(angle > 225 && angle < 315) {
                direction = 3;              
            }
    }
    
    public int getDirection() {
        return direction;
    }
    
}
