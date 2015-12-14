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
        addObject(new Text("Tower Defense!", 50), 384, 200);
        addObject(new button("Level 1"), 384, 384);
        addObject(new button("Level 2"), 384, 420);
        Greenfoot.start();
    }
    
    public void act() {
        if(Greenfoot.mouseClicked(getObjects(button.class).get(0)) || Greenfoot.isKeyDown("1")) {
            Greenfoot.setWorld(new Level1());
        }
        if(Greenfoot.mouseClicked(getObjects(button.class).get(1)) || Greenfoot.isKeyDown("2")) {
            Greenfoot.setWorld(new Level2());
        }
    }
    

}
