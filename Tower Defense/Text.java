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
    public Text(String text)
    {
        updateImage(text);
    }
 
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    
}