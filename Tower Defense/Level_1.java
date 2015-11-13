import greenfoot.*;

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends Actor
{
    int counter = 0, robotCounter = 0;
    
    public void act() 
    {
        if(counter == 40) {
            if(robotCounter < 10) {
                getWorld().addObject(new Robot(1),80,640);
                robotCounter++;
            } 
            if(robotCounter >= 10 && robotCounter < 20) {
                getWorld().addObject(new Robot(2),80,640);
                robotCounter++;
            }
            counter = 0;
        } else {
            counter++;
        }
        
    }    
}
