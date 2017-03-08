/*
 * © 2015 Jan Abelmann
 */

package main;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;


/**
 * Main Method
 */
public class Main{
  
  public static void main(String[] args){
    try{
        AppGameContainer app = new AppGameContainer(new Engine("Missiles"));
        
        app.setDisplayMode(Config.windowWidth, Config.windowHeight, false);
        app.start();
    }
    catch (SlickException ex){
      Logger.getLogger(Engine.class.getName()).log(Level.SEVERE, null, ex);
    }

  }
}