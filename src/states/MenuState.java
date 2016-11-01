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
import main.Utilities;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

/**
 *
 * @author Jan
 */
public class MenuState extends BasicGameState {
    
    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer container, StateBasedGame game) throws SlickException {
        //Resources.getSound("music").loop(1.0f,0.5f);
    }

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        g.drawImage(Resources.getImage("background"), 0, 0);
        //g.drawString("MENU!", Config.windowWidth/2-22, Config.windowHeight/2 -50);
        EntityManager.draw();
        //g.drawString(String.valueOf(EntityManager.cloads.size()), 0, 0);
        g.drawImage(Resources.getImage("title"), 0, 0);
        if(Utilities.getTime() > 0) 
            Resources.timeFont().drawString(0, 0, Utilities.getTimer());
    }

 
    
    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Keyboard.keyInput(container, game, delta);
        EntityManager.cloads(delta);
        if(GameState.init == false) {
            GameState.init = true;
            GameState.startTime = 0;
            EntityManager.clear();
        }
        
    }
    
}
