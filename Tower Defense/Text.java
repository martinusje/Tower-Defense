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
    public Text(String text, int textSize)
    {
        updateImage(text, textSize);
        
    }
 
    public void updateImage(String text, int textSize)
    {
        setImage(new GreenfootImage(text, textSize, Color.black, new Color(0, 0, 0, 0)));
    }
}