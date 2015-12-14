import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class button extends Actor
{
    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public button(String text)
    {
        updateImage(text);
    }
 
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }   
}
