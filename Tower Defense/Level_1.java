import greenfoot.*;

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends Actor
{
    int counter = 0, robotCounter = 0, waveCounter = 0, i = 0, j = 0, amountOfRobots = 0;
    
    public void act() 
    {
        if (waveCounter == 0) 
        {
            i = 1;
            j = 2;
            amountOfRobots = 10;
        }
        if (waveCounter == 1)
        {
            i = 2;
            j = 1;
            amountOfRobots = 15;
        }
        
        if(counter == 40) {
            if(robotCounter < amountOfRobots) {
                getWorld().addObject(new Robot(i),80,640);
                robotCounter++;
            } 
            if(robotCounter >= amountOfRobots && robotCounter < amountOfRobots * 2) {
                getWorld().addObject(new Robot(j),80,640);
                robotCounter++;
            }
            if (robotCounter >= 20)
            {
                robotCounter++;
            }
            if (robotCounter == 30) 
            {
                waveCounter = 1; 
                robotCounter = 0;
            }
            counter = 0;
        } else {
            counter++;
        }
        
    }    
}
