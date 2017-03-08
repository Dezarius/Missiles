package gui;

import main.Config;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Image;

/**
 * Created by Jan on 08.03.2017.
 */
public class Button {

    float scale;
    Image img;


    float xl,xr,yu,yd;


    public Button(float x, float y, Image img, float scale){
        this.img = img;
        this.scale = scale;

        this.xl = x;
        this.yu = y;
        this.xr = x + img.getWidth() * scale * Config.scale;
        this.yd = y + img.getHeight() * scale * Config.scale;
    }

    public void draw() {
        img.draw(xl,yu,scale * Config.scale);

    }

    public boolean isMouseInside() {
        int posX = Mouse.getX();
        int posY = Config.windowHeight - Mouse.getY();

        if(posX >= xl && posX <=xr && posY >= yu && posY <= yd) {
            return true;
        }
        return false;
    }


}
