import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

/**
 * Write a description of class Basic_Machine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Machine extends Actor
{
    //Main counter
    int counter = 0;
    
    //Coördinates of oldest robot in range, defined hereafter
    int robotX;
    int robotY;
    
    //0 if being draged, 1 if set
    int active = 0;
    
    //Type of machine
    int type;
    
    //Range of robot
    int range;
    
    //The rate of shooting
    int shootingRate;
    
    //Type of bullet it shoots
    int bulletType;
    
    //Emp shooting counter
    int EMPCounter;
    
    //Emp animation counter
    int EMP_Counter;
    
    //Int to select right animated image
    int I;
    
    //Cost of robot
    int cost;

    public Machine(int type) {
        this.type = type;
        //Basic tower 
        if(type == 1) {
            range = 200;
            shootingRate = 40;
            bulletType = 1;
            setImage("Tower_Basic.png");
            cost = 5;
        }
        //Fast tower
        if(type == 2) {
            range = 100;
            shootingRate = 15;
            bulletType = 2;
            setImage("Tower_Fast.png");
            cost = 7;
        }
        //EMP tower
        if(type == 3) {
            range = 100;
            shootingRate = 40;
            bulletType = 3;
            setImage("Tower_Strong.png");
            cost = 15;
        }
        //Area damage tower 
        if(type == 4) {
            range = 80;
            shootingRate = 125;
            setImage("Tower_EMP_1.png");
            cost = 5;
        }
        //Long range Tower
        if(type == 5) {
            range = 300;
            shootingRate = 125;
            bulletType = 4;
            setImage("Tower_Sniper.png");
            cost = 10;
        }
        
        //Set counter to corresponding shootingRate
        counter = shootingRate;
        EMPCounter = shootingRate;
    }

    public int returnRobotX()
    {
        //Return robot X for bullet
        return robotX;
    }

    public int returnRobotY()
    {
        //Return robot Y for bullet
        return robotY;
    }
    
    public int getCost()
    {
        //Return cost to display in level
        return cost;
    }

    public int getMouseX() {
        //Return Mouse X-coördinate for placing machine
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int mouseX = mouse.getX();
        mouseX = 32 * Math.round(mouseX/32) + 16;
        return mouseX;
    }

    public int getMouseY() {
        //Return Mouse Y-coördinate for placing machine
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int mouseY = mouse.getY();
        mouseY = 32 * Math.round(mouseY/32) + 16;
        return mouseY;
    }
    
    public void pointAndShoot() {
        //Make list of all robots in range
        List<Robot> robotsInRange = getObjectsInRange(range, Robot.class);
        
        //If robots are in ragne
        if(robotsInRange.size() != 0) {
            //If not emp
            if(type != 4) {
                //Make list with length of robots that are in range
                ArrayList counterArrayInRange = new ArrayList(robotsInRange.size());
                
                //Get each robots steps (age) and add it to the ounterArray
                for(Robot a : (List<Robot>) robotsInRange) {
                    double counterCounter = a.getCounter();
                    counterArrayInRange.add(counterCounter);
                }

                //Get actor who has the highest age
                Actor robotInRange = robotsInRange.get(counterArrayInRange.indexOf(Collections.max(counterArrayInRange)));
                //Get it's coördinates
                robotX = robotInRange.getX();
                robotY = robotInRange.getY();

                //Turn the robot in range with the oldest age
                turnTowards(robotInRange.getX(), robotInRange.getY());
                
                //If the counter exceeds the shootingRate, shoot and reset counter
                if(counter >= shootingRate) {
                    getWorld().addObject(new Bullet(getRotation(), robotInRange.getX(), robotInRange.getY(), robotInRange, bulletType), getX(), getY());
                    counter = 0;
                }
            } else {
                //If EMP machine
                if(EMPCounter >= shootingRate) {
                    //Call speeddown for robots in range
                    for (Robot a : (List<Robot>) robotsInRange) {
                        a.speedDown();
                    }
                    
                    //Show emp animation
                    getWorld().addObject(new EMP_Stun(), getX(), getY());
                    EMPCounter = 0;
                }
            }
        } 
        //Counter plus 1, emp counter or normal counter
        if(type != 4) {
            counter ++;
        } else {
            EMPCounter ++;
        }
        //If type 4, make animating emp machine
        if(type == 4) {
            if(EMP_Counter == 6){
                if(I == 3){
                    I = 0;
                }
                setImage("Tower_EMP_"+ Integer.toString(I+1) + ".png");                  
                I ++;
                EMP_Counter = 0;
            }
            EMP_Counter ++;
        }
    }
    
    //If draging machine    
    public void dragAndSetMachine() {
        //If is dragging, set the location
        if(Greenfoot.mouseDragged(this) && (((Coins)getWorld().getObjects(Coins.class).get(0)).getCoins()-cost) >= 0) {
            counter = 0;
            this.setLocation(getMouseX(), getMouseY());
        }
        
        //If released
        if(Greenfoot.mouseClicked(null)) {
            //Set machine on placeholder place
            getWorld().addObject(new Machine(type), 704, 64+((type-1)*128));
            
            //If out of the playing range, remove
            if(getMouseX() >= 640 || getMouseY() >= 640 || getIntersectingObjects(Machine.class).size() > 0) {
                getWorld().removeObject(this);
                return;
            } else {
                //If set on track, remove 
                if(getWorld().getColorAt(getMouseX(), getMouseY()).getRed() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getGreen() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getBlue() < 1) {
                    getWorld().removeObject(this);
                    return;
                } else {
                    //If enough coins, set
                    if((((Coins)getWorld().getObjects(Coins.class).get(0)).getCoins()-cost) >= 0){
                        active = 1;
                        ((Coins)getWorld().getObjects(Coins.class).get(0)).coinsDown(cost);
                    } else {
                        //If not enough coins, remove
                        getWorld().removeObject(this);
                        return;
                    }
                }
            }
        }
    }

    public void act() 
    {              
        //If set, activate
        if(active == 1) {
            pointAndShoot();
        }
        
        //If dragging, run dragAndSetMachine method
        if(active == 0) {
            dragAndSetMachine();
        }
    }    
}
