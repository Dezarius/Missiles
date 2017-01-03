/*
 * © 2015 Jan Abelmann
 */

package main;

import gui.Resources;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;
import states.GameState;
import states.InGameMenuState;
import states.MenuState;


/**
 * Engine of the Game
 */
public class Engine extends StateBasedGame{
  
   //public static GameContainer gamec;
  
  /**
   * Creates a Window with the given Name
   * @param gamename d
   */
  public Engine(String gamename)
  {
    super(gamename);
  }
  
  @Override
  public void initStatesList(GameContainer gc) throws SlickException {
    //Some Framerate and logic stuff
    gc.setTargetFrameRate(60);
    gc.setAlwaysRender(true);
    gc.setVSync(true);
    gc.setShowFPS(true);
    
    //loads all Recourses
    new Resources();
    
    //adds all GameStates
    this.addState(new MenuState());
    this.addState(new GameState());
    this.addState(new InGameMenuState());
  }
}