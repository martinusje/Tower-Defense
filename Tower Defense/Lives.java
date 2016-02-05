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
    //Text parsed from creator
    public String livesString;
    public Lives(String text)
    {
        //Run image update method
        updateImage(text);
        
        //Set wavestring as parsed parameter
        livesString = text;
    }
 
    //Set text
    public void updateImage(String text)
    {
        //Set text as parsed   
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    //Set life 1 down
    public void imageUp()
    {
        //Set lives as integer
        int lives = Integer.parseInt(livesString);
        
        //Set lives one lower
        lives--;
        
        //Update image to new lives
        setImage(new GreenfootImage(Integer.toString(lives), 26, Color.black, new Color(0, 0, 0, 0)));
        
        //Update livesString
        livesString = Integer.toString(lives);
        
        //If lives are 0, call gameOver method in world
        if(lives <= 0) {
            ((Level)getWorld()).gameOver();
        }
    }
}