import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class TowerDefenseWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LevelSelect extends World
{

    /**
     * Constructor for objects of class TowerDefenseWorld.
     * 
     */
    public LevelSelect()
    {    
        super(768, 768, 1);
        
        //Set background
        getBackground().drawImage(new GreenfootImage("Background_Menu.png"), 0, 0);
        
        //Header text
        addObject(new Text("Tower Defense!", 50), 384, 200);
        
        //Level clicker
        addObject(new button("Level 1"), 300, 384);
        getBackground().drawImage(new GreenfootImage("Track_1_lvlselect.png"), 234, 400);
        addObject(new button("Level 2"), 460, 384);
        getBackground().drawImage(new GreenfootImage("Track_2_lvlselect.png"), 396, 400);
        
        //Start without clicking start
        Greenfoot.start();
    }
    
    public void act() {
        //If clicked one of the levels
        if(Greenfoot.mouseClicked(getObjects(button.class).get(0)) || Greenfoot.mouseClicked(getObjects(button.class).get(0))|| Greenfoot.isKeyDown("1")) {
            Greenfoot.setWorld(new Level(1));
        }
        if(Greenfoot.mouseClicked(getObjects(button.class).get(1)) || Greenfoot.isKeyDown("2")) {
            Greenfoot.setWorld(new Level(2));
        }
    }
    

}
