import greenfoot.*;

/**
 * Write a description of class Level_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level_1 extends Actor
{
    int counter = 0, robotCounter = 0, waveCounter = 1, i = 0, j = 0, amountOfRobots = 0, timeBetweenWaves = 50;
    double waveStrength;
    int robotTypeOne = 2;        
    int amountRobotTypeOne = 10;
    int robotTypeTwo = 1;
    int amountRobotTypeTwo = 10;
    
    public void act() 
    {
        if (waveCounter == 0) 
        {
            i = 1;
            j = 2;
            amountOfRobots = 10;
            waveStrength = 1;
        }
        if (waveCounter == 1)
        {
            robotTypeOne = 1;
            amountRobotTypeOne = 10;
            robotTypeTwo = 2;
            amountRobotTypeTwo = 10;
            i = 2;
            j = 1;
            amountOfRobots = 15;
            waveStrength = 1.5;
        }
        
        if(counter == 40) {
            if(waveCounter == 1) {
                if(robotCounter < amountOfRobots) {
                    if(robotCounter < amountRobotTypeOne) {
                        getWorld().addObject(new Robot(robotTypeOne, waveStrength),80,640);
                        robotCounter++;
                    } else if(robotCounter < amountRobotTypeOne + amountRobotTypeTwo) {
                        getWorld().addObject(new Robot(robotTypeTwo, waveStrength),80,640);
                        robotCounter++;
                    }
                }
            }
            counter = 0;
        } else {
            counter++;
        }
        
    }    
}
