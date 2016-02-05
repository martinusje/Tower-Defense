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
    //Text parsed from creator
    public String waveString;
    public Wave(String text)
    {
        //Run image update method
        updateImage(text);
        
        //Set wavestring as parsed parameter
        waveString = text;
    }
 
    //Set text
    public void updateImage(String text)
    {
        //Set text as parsed
        setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    //Retreive wave for game over screen    
    public int getWave() {
        //Set wave as integer
        int wave = Integer.parseInt(waveString);
        
        //Return wave integer
        return wave;
    }
    
    //Set wave 1 higher, set from 
    public void imageUp()
    {
        //Set wave as integer
        int wave = Integer.parseInt(waveString);
        
        //Set wave one higher
        wave++;
        
        //Update image to new wave
        setImage(new GreenfootImage(Integer.toString(wave), 26, Color.black, new Color(0, 0, 0, 0)));
        
        //Update wavestring
        waveString = Integer.toString(wave);
    }
}