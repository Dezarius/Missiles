/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entitys;

import java.util.ArrayList;
import java.util.List;
import main.Config;
import states.GameState;

/**
 *
 * @author janabelmann
 */
public class EntityManager {
    
    public static Player player = new Player();
    
    public static List clouds = new ArrayList();
    
    public static List missiles = new ArrayList();
    
    
    public static void draw() {
        for(Object o : clouds) {
            Cloud c = (Cloud) o;
            c.draw();
        }
        player.draw();
        for(Object o : missiles) {
            Missile m = (Missile) o;
            m.draw();
        }
    }
    
    public static void clear() {
        missiles = new ArrayList();
    }
    
    public static void missiles(int delta) {
        List removeList = new ArrayList();
        for(Object o : missiles) {
            boolean isAdded = false;
            Missile m = (Missile) o;
            if(m.getX()> Config.windowWidth/2 - 12 && m.getX()< Config.windowWidth/2  + 12&& m.getY() > Config.windowHeight/2 - 12&& m.getY() < Config.windowHeight/2 + 12 ) {
                //System.out.println("Getroffen!");
                removeList.add(o);
                isAdded = true;
            }
            
            for(Object obj : missiles) {
                Missile mis = (Missile) obj;
                if(mis != m) {
                    if(mis.getX()+16 > m.getX()+9 && mis.getX()+16 < m.getX() + 23 && mis.getY()+16 > m.getY()+9 && mis.getY()+16 < m.getY() +23) {
                        removeList.add(obj);
                        if(!isAdded) {
                            removeList.add(o);
                            isAdded = true;
                        }
                    }
                }
            }
            if(System.currentTimeMillis() < m.getDestTime()) {
                m.move(delta);
            }
            else {
                if(!isAdded)
                    removeList.add(o);
            }
        }
        for(Object o : removeList) {
            missiles.remove(o);
        }
        
        if(missiles.size() <= (System.currentTimeMillis() - GameState.startTime) / 1 && GameState.startTime != 0)
            spawnMissile("normal");
    }
    
    
    public static void cloads(int delta) {
        List removeList = new ArrayList();
        for(Object o : clouds) {
            Cloud c = (Cloud) o;
            if(c.getX() < - 3000 || c.getX() > 5000 || c.getY() < -3000 || c.getY() > 5000) {
                removeList.add(c);
            }
            else {
                c.move(delta);
            }
        }
        for(Object o : removeList) {
            clouds.remove(o);
        }
        
        float xp = (float) Math.random() * 1000;
        float yp = (float) Math.random() * 1000 ;
        float xm = (float) Math.random() * (-1000);
        float ym = (float) Math.random() * (-1000);
        boolean c1 = true;
        boolean c2 = true;
        boolean c3 = true;
        boolean c4 = true;
        for(Object o : clouds) {
            Cloud c = (Cloud) o;
            if(((xp > -100 && xp < 720) && (yp > -100 && yp < 720)) || c.getX() - xp < 300 && c.getX() - xp > -300 && c.getY() - yp < 300 && c.getY() -yp > -300)
                c1 = false;
            if(c.getX() - xp < 300 && c.getX() - xp > -300 && c.getY() - ym < 300 && c.getY() -ym > -300)
                c2 = false;
            if(c.getX() - xm < 300 && c.getX() - xm > -300 && c.getY() - yp < 300 && c.getY() -yp > -300)
                c3 = false;
            if(c.getX() - xm < 300 && c.getX() - xm > -300 && c.getY() - ym < 300 && c.getY() -ym > -300)
                c4 = false;
        }  
        if(c1) {
            clouds.add(new Cloud(xp,yp));
        }
        if(c2) {
            clouds.add(new Cloud(xp,ym));
        }
        if(c3) {
            clouds.add(new Cloud(xm,yp));
        }
        if(c4) {
            clouds.add(new Cloud(xm,ym));
        }
    }
    
    
    static boolean test = true;
    public static void spawnMissile(String type) {
        float speed = 0;
        if(type.equals("normal")) {
            speed = Config.normalMissileSpeed;
        }
        int random = (int) (Math.random() * 4);
        while(random == player.getDirection()) {
            random = (int) (Math.random() * 4);
        }
        switch (random) {
            case 0:
                missiles.add(new Missile((float) Math.random() * 700, -300,10000,speed,player.getAngle(),type));
                break;
            case 1:
                missiles.add(new Missile(900,(float) Math.random() * 700,10000,speed,player.getAngle(),type));
                break;
            case 2:
                missiles.add(new Missile((float) Math.random() * 700, 900,10000,speed,player.getAngle(),type));
                break;
            case 3:
                missiles.add(new Missile(-300,(float) Math.random() * 700,10000,speed,player.getAngle(),type));
                break;
            default:
                break;
        }
           
        
    }
}

 