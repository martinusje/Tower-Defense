import greenfoot.*;

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends Actor
{
    int counter = 0;
    int robotCounter = 0;
    
    public void act() 
    {
        if (counter == 80) {
            if (robotCounter < 10) {
                getWorld().addObject(new Robot(),19,160);
                robotCounter++;
            } 
            
            counter = 0;
            
        } else {
            counter++;
        }
    }    
}
