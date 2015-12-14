import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class levelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class levelSelect.
     * 
     */
    public Level2()
    {    
        super(768, 768, 1);

        getBackground().drawImage(new GreenfootImage("Background_2.png"), 0, 0);        
        getBackground().drawImage(new GreenfootImage("track_2.png"), 0, 0);
        
        getBackground().setColor(new Color(10,10,10,255));
        getBackground().drawRect(0, 0,  640, 640);
        
        for(int i = 0; i < 5; i++) {
            //setBackground(new GreenfootImage(2,2));
            getBackground().drawRect(640, i*128,  128, 128);
        } 
        
        addObject(new Text("Lives:", 26),30,680);
        addObject(new Lives("10"),80,680);  
        
        addObject(new Text("Wave:", 26),30,700);
        addObject(new Wave("1"),80,700);  
        
        addObject(new Text("Coins:", 26),30,720);  
        addObject(new Coins("20"),80,720);  
        
        int Ylocation = 64;
        for(int i = 1; i <= 5; i++) {
            addObject(new Machine(i), 704, Ylocation);
            addObject(new Machine(i), 704, Ylocation);
           
            addObject(new Text("cost:" + ((Machine)getObjects(Machine.class).get((i*2)-1)).getCost(), 26),704,Ylocation + 28);  
            Ylocation = Ylocation + 128;
        }
        
        setPaintOrder(Robot.class, Machine.class);
    }
    public void drawBase(int type, int X, int Y) {
        getBackground().drawImage(new GreenfootImage("Tower_Base.png"), X-16, Y-16);
    }
    
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
                        addObject(new Robot(robotTypeOne, waveStrength),80,640);
                        robotCounter++;
                    } else if(robotCounter < amountRobotTypeOne + amountRobotTypeTwo) {
                        addObject(new Robot(robotTypeTwo, waveStrength),80,640);
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
