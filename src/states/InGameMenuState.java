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
        Resources.getImage("sky").draw(0,0,Config.windowScale);
        //g.drawString("GAME!", Config.windowWidth/2-22, Config.windowHeight/2 -50);
        
        EntityManager.draw();
        Resources.getImage("menuOverlay").draw(0,0,Config.windowScale);
        if(Utilities.getTime() > 0) 
            Resources.timeFont().drawString(0, 0, Utilities.getTimer());
        
    }

    @Override
    public void update(GameContainer container, StateBasedGame game, int delta) throws SlickException {
        Keyboard.keyInput(container, game, delta);
    }
    
}
