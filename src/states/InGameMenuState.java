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
public class InGameMenuState extends BasicGameState {

    @Override
    public int getID() {
        return 2;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(Resources.getImage("background"), 0, 0);
        //g.drawString("GAME!", Config.windowWidth/2-22, Config.windowHeight/2 -50);
        
        EntityManager.draw();
        g.drawImage(Resources.getImage("mapOverlay"), 0, 0);
        g.drawString(String.valueOf(EntityManager.cloads.size()), 0, 0);
        
        g.drawString(String.valueOf(EntityManager.missile1.angle), 10, 30);
        g.drawString(String.valueOf(EntityManager.missile1.wantedangle), 10, 40);
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Keyboard.keyInput(container, game, delta);
    }
    
}
