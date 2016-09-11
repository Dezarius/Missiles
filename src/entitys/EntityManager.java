/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author janabelmann
 */
public class EntityManager {
    
    public static Player player = new Player();
    
    public static List cloads = new ArrayList();
    
    public static List missiles = new ArrayList();
    public static Missile missile1 = new Missile(500,500,10000,0.4f, player.getAngle());
    
    
    public static void draw() {
        for(Object o : cloads) {
            Cload c = (Cload) o;
            c.draw();
        }
        player.draw();
        missile1.draw();
    }
    
    public static void missiles(int delta) {
        missile1.move(delta);
    }
    
    public static void cloads(int delta) {
        List removeList = new ArrayList();
        for(Object o : cloads) {
            Cload c = (Cload) o;
            if(c.getX() < - 3000 || c.getX() > 5000 || c.getY() < -3000 || c.getY() > 5000) {
                removeList.add(c);
            }
            else {
                c.move(delta);
            }
        }
        for(Object o : removeList) {
            cloads.remove(o);
        }
        
        float xp = (float) Math.random() * 1000;
        float yp = (float) Math.random() * 1000 ;
        float xm = (float) Math.random() * (-1000);
        float ym = (float) Math.random() * (-1000);
        boolean c1 = true;
        boolean c2 = true;
        boolean c3 = true;
        boolean c4 = true;
        for(Object o : cloads) {
            Cload c = (Cload) o;
            if(((xp > 0 && xp < 720) && (yp > 0 && yp < 720)) || c.getX() - xp < 300 && c.getX() - xp > -300 && c.getY() - yp < 300 && c.getY() -yp > -300)
                c1 = false;
            if(c.getX() - xp < 300 && c.getX() - xp > -300 && c.getY() - ym < 300 && c.getY() -ym > -300)
                c2 = false;
            if(c.getX() - xm < 300 && c.getX() - xm > -300 && c.getY() - yp < 300 && c.getY() -yp > -300)
                c3 = false;
            if(c.getX() - xm < 300 && c.getX() - xm > -300 && c.getY() - ym < 300 && c.getY() -ym > -300)
                c4 = false;
        }  
        if(c1) {
            cloads.add(new Cload(xp,yp));
        }
        if(c2) {
            cloads.add(new Cload(xp,ym));
        }
        if(c3) {
            cloads.add(new Cload(xm,yp));
        }
        if(c4) {
            cloads.add(new Cload(xm,ym));
        }
    }
    
}