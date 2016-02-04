import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class scoreField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Text extends Actor
{
    public Text(String text, int textSize, int blackorwhite)
    {
        updateImage(text, textSize, blackorwhite);
    }
 
    public void updateImage(String text, int textSize, int blackorwhite)
    {
        if(blackorwhite == 0) {
            setImage(new GreenfootImage(text, textSize, Color.black, new Color(0, 0, 0, 0)));
        } else {
            setImage(new GreenfootImage(text, textSize, Color.white, new Color(0, 0, 0, 0)));
        }
    }
}