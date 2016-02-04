import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class levelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level extends World
{
    //Amount of waves
    int amountOfWaves = 1;
    
    //robotVariable placeholders
    int robotTypeOne = 2;        
    int amountRobotTypeOne = 10;
    int robotTypeTwo = 1;
    int amountRobotTypeTwo = 10;
    int amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;

    //Startpointcoördinates
    int startPointX = 80;
    int startPointY = 640;
    
    public Level(int levelSelector)
    {    
        super(768, 768, 1);
        
        if(levelSelector == 1){
            //Level 1
            //Set background image
            getBackground().drawImage(new GreenfootImage("grass.jpg"), 0, 0);        
            
            //Set track
            getBackground().drawImage(new GreenfootImage("Track_1.png"), 0, 0);
            
            //Amount of waves before only increasing waveStrength
            amountOfWaves = 2;
            
            //robotVariable placeholders
            robotTypeOne = 2;        
            amountRobotTypeOne = 10;
            robotTypeTwo = 1;
            amountRobotTypeTwo = 10;
            amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;
        
            //Startpointcoördinates
            startPointX = 80;
            startPointY = 640;
        }
        if(levelSelector == 2) {
            //Level 2
            //Set background image
            getBackground().drawImage(new GreenfootImage("grass.jpg"), 0, 0);        
            
            //Set track
            getBackground().drawImage(new GreenfootImage("Track_2.png"), 0, 0);
            
            //Amount of waves
            amountOfWaves = 1;
            
            //robotVariable placeholders
            robotTypeOne = 2;        
            amountRobotTypeOne = 10;
            robotTypeTwo = 1;
            amountRobotTypeTwo = 10;
            amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;
        
            //Startpointcoördinates
            startPointX = 80;
            startPointY = 640;
        }
        
        //Draw field rectangle
        getBackground().setColor(new Color(10,10,10,255));
        getBackground().drawRect(0, 0,  640, 640);
        
        //Draw squares for machines
        for(int i = 0; i < 5; i++) {
            //setBackground(new GreenfootImage(2,2));
            getBackground().drawRect(640, i*128,  128, 128);
        } 
        
        //Draw counters for lives, waves and coins
        addObject(new Text("Lives:", 26, 0),192,680);
        addObject(new Lives("10"),192,700);  
        
        addObject(new Text("Wave:", 26, 0),384,680);
        addObject(new Wave("1"),384,700);  
        
        addObject(new Text("Coins:", 26, 0),576,680);  
        addObject(new Coins("20"),576,700);  
        
        //Y location of machine placeholder
        int Ylocation = 64;
        
        //Loop for drawing machine placeholders + cost
        for(int i = 1; i <= 5; i++) {
            addObject(new Machine(i), 704, Ylocation);
            addObject(new Machine(i), 704, Ylocation);
           
            addObject(new Text("cost:" + ((Machine)getObjects(Machine.class).get((i*2)-1)).getCost(), 26, 0),704,Ylocation + 28);  
            Ylocation = Ylocation + 128;
        }
    }
    
    public void gameOver() 
    {
        Greenfoot.setWorld(new GameOver());
    }
        
    //Main counter
    int counter = 0;
    
    //Amount of robots that have passed
    int robotCounter = 0;
    
    //Amount of waves that have passed
    int waveCounter = 0;
    
    //Strength of wave
    double waveStrength;
    
    //Time between waves
    int timeBetweenWaves = 0;

    public void act() 
    {        
        //Set robotVariables by wave
        if (waveCounter == 0) 
        {
            robotTypeOne = 1;
            amountRobotTypeOne = 7;
            robotTypeTwo = 2;
            amountRobotTypeTwo = 5;
            amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;
            waveStrength = 1.5;
        }
        if (waveCounter == 1)
        {
            robotTypeOne = 1;
            amountRobotTypeOne = 10;
            robotTypeTwo = 2;
            amountRobotTypeTwo = 7;
            amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;
            waveStrength = 1.7;
        }
        if (waveCounter == 2)
        {
            robotTypeOne = 1;
            amountRobotTypeOne = 12;
            robotTypeTwo = 2;
            amountRobotTypeTwo = 10;
            amountOfRobots = amountRobotTypeOne + amountRobotTypeTwo;
            waveStrength = 1.8;
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
