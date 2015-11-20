import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class scoreField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Wave extends Actor
{
    public String waveString;
    public Wave(String text)
    {
        updateImage(text);
        waveString = text;
    }
 
    public void updateImage(String text)
    {
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    public void imageUp()
    {
        int wave = Integer.parseInt(waveString);
        wave++;
        setImage(new GreenfootImage(Integer.toString(wave), 26, Color.black, new Color(0, 0, 0, 0)));
        waveString = Integer.toString(wave);
    }
}