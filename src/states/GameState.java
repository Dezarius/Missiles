/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entitys.EntityManager;
import gui.Resources;
import input.Keyboard;
import main.Config;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Jan
 */
public class GameState extends BasicGameState {

    @Override
    public int getID() {
        return 1;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        Resources.getImage("airplane").setCenterOfRotation(16, 16);
        container.getGraphics().setAntiAlias(true);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(Resources.getImage("background"), 0, 0);
        //g.drawString("GAME!", Config.windowWidth/2-22, Config.windowHeight/2 -50);
        g.drawString(String.valueOf(EntityManager.cloads.size()), 0, 0);
        
        EntityManager.draw();
        g.drawString(String.valueOf(EntityManager.missile1.angle), 10, 30);
        g.drawString(String.valueOf(EntityManager.missile1.wantedangle), 10, 40);
        
    }

    public static boolean start = true;
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        EntityManager.cloads(delta);
        EntityManager.missiles(delta);
        
        if(start) {
            if(EntityManager.player.getAngle() < 182 && EntityManager.player.getAngle() > 178) {
                EntityManager.player.setAngle(180);
                start = false;
            }
            else if( EntityManager.player.getAngle() > 181) {
                EntityManager.player.addAngle(-0.28f * delta);
            }
            else if(EntityManager.player.getAngle() < 179) {
                EntityManager.player.addAngle(0.28f * delta);
            }
        }
        else {
            Keyboard.keyInput(container, game, delta);
        }
        
    }
}
