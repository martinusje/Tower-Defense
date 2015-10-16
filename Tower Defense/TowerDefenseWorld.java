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
        super(192, 192, 4);
        getBackground().setColor(Color.black);
        GreenfootImage pic = new GreenfootImage(600, 400);
        pic.setColor(new Color(Greenfoot.getRandomNumber(255 + 1), Greenfoot.getRandomNumber(255 + 1), Greenfoot.getRandomNumber(255 + 1)));
        pic.fill();
        setBackground(pic);
        //getBackground().drawImage(new GreenfootImage("steelPlateBackground.jpg"), 0, 0);        
        getBackground().drawImage(new GreenfootImage("Track 2.png"), 0, 0);
        getBackground().drawRect(0, 0,  640, 640);
        
        for(int i = 0; i < 5; i++) {
            //setBackground(new GreenfootImage(2,2));
            getBackground().drawRect(640, i*128,  128, 128);
        } 
        
        addObject (new Level_1(),0,0);
        addObject (new Text("Lives:"),10,186);
        addObject (new Text("Wave:"),10,178);
        addObject (new Text("Coins:"),10,170);      
        addObject (new Basic_Machine(),28,28);

        
        setPaintOrder(Robot.class);
    }
    

}
