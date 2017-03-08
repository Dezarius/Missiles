/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package states;

import entitys.EntityManager;
import gui.*;
import gui.Button;
import input.Keyboard;
import main.Config;
import main.Utilities;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

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

    //Menubuttons
    gui.Button button_story = new Button(Config.windowWidth/2 - 92 * Config.scale,Config.windowHeight / 2 + 20 * Config.scale , Resources.getImage("button_story"),0.6f);
    gui.Button button_endless = new Button(Config.windowWidth/2 - 92 * Config.scale,Config.windowHeight / 2 + 65 * Config.scale , Resources.getImage("button_endless"),0.6f);
    gui.Button button_options = new Button(Config.windowWidth/2 - 92 * Config.scale,Config.windowHeight / 2 + 110 * Config.scale , Resources.getImage("button_options"),0.6f);

    @Override
    public void render(GameContainer container, StateBasedGame game, Graphics g) throws SlickException {
        Resources.getImage("sky").draw(0,0,Config.windowScale);
        g.drawImage(Resources.getImage("sky"), 0, 0);
        EntityManager.draw();
        //g.drawString(String.valueOf(EntityManager.cloads.size()), 0, 0);
        Resources.getImage("title").draw(Config.windowWidth/2 - 350*Config.scale,Config.windowHeight/2 - 350* Config.scale, Config.scale);
        if(Utilities.getTime() > 0) 
            Resources.timeFont().drawString(0, 0, Utilities.getTimer());

        //Menubuttons
        button_story.draw();
        button_endless.draw();
        button_options.draw();

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

        if(button_story.isMouseInside()) {
            System.out.println("Story");
        }
        if(button_endless.isMouseInside() && Mouse.isButtonDown(0)) {
            game.enterState(1);
        }
    }
    
}
