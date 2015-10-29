import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TowerDefenseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TowerDefenseWorld extends World
{

    /**
     * Constructor for objects of class TowerDefenseWorld.
     * 
     */
    public TowerDefenseWorld()
    {    
        super(768, 768, 1);

        getBackground().drawImage(new GreenfootImage("Background.png"), 0, 0);        
        getBackground().drawImage(new GreenfootImage("track_2.png"), 0, 0);
        
        getBackground().setColor(new Color(10,10,10,255));
        getBackground().drawRect(0, 0,  640, 640);
        
        for(int i = 0; i < 5; i++) {
            //setBackground(new GreenfootImage(2,2));
            getBackground().drawRect(640, i*128,  128, 128);
        } 
        
        addObject (new Level_1(),0,0);
        addObject (new Text("Lives:"),30,720);
        addObject (new Text("Wave:"),30,700);
        addObject (new Text("Coins:"),30,680);      
        addObject (new Basic_Machine(),704,64);

        setPaintOrder(Robot.class);
    }
    

}
