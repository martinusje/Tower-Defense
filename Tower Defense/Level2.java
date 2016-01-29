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

        //Set background image
        getBackground().drawImage(new GreenfootImage("Background_2.png"), 0, 0);        
        
        //Set track
        getBackground().drawImage(new GreenfootImage("Track_2.png"), 0, 0);
        
        //Draw field rectangle
        getBackground().setColor(new Color(10,10,10,255));
        getBackground().drawRect(0, 0,  640, 640);
        
        //Draw squares for machines
        for(int i = 0; i < 5; i++) {
            //setBackground(new GreenfootImage(2,2));
            getBackground().drawRect(640, i*128,  128, 128);
        } 
        
        //Draw counters for lives, waves and coins
        addObject(new Text("Lives:", 26),40,680);
        addObject(new Lives("10"),80,680);  
        
        addObject(new Text("Wave:", 26),40,700);
        addObject(new Wave("1"),80,700);  
        
        addObject(new Text("Coins:", 26),40,720);  
        addObject(new Coins("20"),80,720);  
        
        //Y location of machine placeholder
        int Ylocation = 64;
        
        //Loop for drawing machine placeholders + cost
        for(int i = 1; i <= 5; i++) {
            addObject(new Machine(i), 704, Ylocation);
            addObject(new Machine(i), 704, Ylocation);
           
            addObject(new Text("cost:" + ((Machine)getObjects(Machine.class).get((i*2)-1)).getCost(), 26),704,Ylocation + 28);  
            Ylocation = Ylocation + 128;
        }
    }
    
    //Main counter
    int counter = 0;
    
    //Amount of robots that have passed
    int robotCounter = 0; 
    
    //Amount of waves that have passed
    int waveCounter = 0;
    
    //Strength of wave
    double waveStrength;
    
    //Amount of waves
    int amountOfWaves = 1;
    
    //Time between waves
    int timeBetweenWaves = 0;
    
    //robotVariable placeholders
    int robotTypeOne = 2;        
    int amountRobotTypeOne = 10;
    int robotTypeTwo = 1;
    int amountRobotTypeTwo = 10;
    int amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;

    //Startpointcoördinates
    int startPointX = 80;
    int startPointY = 640;
    
     public void act() 
    {
        //Set robotVariables by wave
        if (waveCounter == 0) 
        {
            robotTypeOne = 1;
            amountRobotTypeOne = 10;
            robotTypeTwo = 2;
            amountRobotTypeTwo = 7;
            amountOfRobots = 15;
            waveStrength = 1.5;
        }
        if (waveCounter == 1)
        {
            robotTypeOne = 1;
            amountRobotTypeOne = 13;
            robotTypeTwo = 2;
            amountRobotTypeTwo = 10;
            amountOfRobots = 15;
            waveStrength = 1.5;
        }
        
        //Main counter        
        if(counter == 40) {
            //Check if robots reaches amountOfRobots set for this wave
            if(robotCounter < amountOfRobots) {
                //Draw RobotTypeOne first and then RobotTypeTwo
                if(robotCounter < amountRobotTypeOne) {
                    addObject(new Robot(robotTypeOne, waveStrength),startPointX,startPointY);
                    robotCounter++;
                } else if(robotCounter < amountRobotTypeOne + amountRobotTypeTwo) {
                    addObject(new Robot(robotTypeTwo, waveStrength),startPointX,startPointY);
                    robotCounter++;
                }
            } else {
                //If end of robots for wave is reached
                if(timeBetweenWaves >= 40) {
                    //Reset robotCounter
                    robotCounter = 0;
                    
                    //If wave exceeds amount of waves
                    if(waveCounter > amountOfRobots){
                        waveStrength = waveStrength + 0.1;
                    } else {
                        waveCounter++;
                    }
                    
                    //Update waveCounter
                    ((Wave)getObjects(Wave.class).get(0)).imageUp();
                    
                    timeBetweenWaves = 0;
                } else {
                    timeBetweenWaves++;
                }
            }
            counter = 0;
        } else {
            counter++;
        }
    }    
}
