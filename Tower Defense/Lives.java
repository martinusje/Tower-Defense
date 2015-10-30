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
    public String scoreString;
    public Lives(String text)
    {
        updateImage(text);
        scoreString = text;
    }
 
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    public void imageUp()
    {
        int score = Integer.parseInt(scoreString);
        score++;
        setImage(new GreenfootImage(Integer.toString(score), 26, Color.black, new Color(0, 0, 0, 0)));
        scoreString = Integer.toString(score);
    }
}