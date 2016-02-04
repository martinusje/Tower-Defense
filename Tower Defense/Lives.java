import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class scoreField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Lives extends Actor
{
    public String livesString;
    public Lives(String text)
    {
        updateImage(text);
        livesString = text;
    }
 
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    public void imageUp()
    {
        int lives = Integer.parseInt(livesString);
        lives--;
        setImage(new GreenfootImage(Integer.toString(lives), 26, Color.black, new Color(0, 0, 0, 0)));
        livesString = Integer.toString(lives);
        if(lives <= 0) {
            ((Level)getWorld()).gameOver();
            
        }
    }
}