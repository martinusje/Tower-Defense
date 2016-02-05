import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver(int waves)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(768,768, 1); 
        
        //Set background image
        getBackground().drawImage(new GreenfootImage("Background_Menu_Black.png"), 0, 0);
        
        //Header text
        addObject(new Text("Game Over!", 80, 1), 384, 200);
        
        //Wave score
        addObject(new Text("You made it to wave " + waves + "!", 40, 1), 384, 400);
        
        //Buttons
        addObject(new button("Back to start", 1, 1), 384, 600);
    }
    public void act() {
        //If clicked one of the levels text button
        if(Greenfoot.mouseClicked(getObjects(button.class).get(0)) || Greenfoot.isKeyDown("1")) {
            Greenfoot.setWorld(new LevelSelect());
        }
    }
}
