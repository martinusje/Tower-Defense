import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends SmoothMover
{
    int x = 0, y = 0, counter = 0, counterCounter = 0, speed = 4, speedCounterTrigger = 0, speedCounter = 0, type, IWantToDie = 0; 
    double stepCounter = 0, life;
    public Robot(int robotType, double waveStrength) { 
        //Basic robot
        if(robotType == 1) {
            speed = 4;
            life = 10 * waveStrength;
            setImage("Robot_Basic.png");
        }
        //Slow robot
        if(robotType == 2) {
            speed = 2;
            life = 20*waveStrength;
            setImage("Robot_Slow.png");
        }
        if(robotType == 3) {
            speed = 3;
            life = 14*waveStrength;
            setImage("Robot_Strong.png");
        }
    }
    
    public void removeObjectFuction()
    {
        getWorld().removeObject(this);
    }
    
    public double getCounter() 
    {
        return stepCounter;
    }
    
    public void lifeDown()
    {
        life--;
    } 
  
    public void speedDown() 
    {
        if(speedCounterTrigger == 0) {
            speed = speed/2;
        }
        speedCounterTrigger = 1;
    }
    
    public void walk()
    {
        Color Black = new Color(0,0,0,255);   
        //Movement  
        if(getWorld().getColorAt(getX()+1, getY()).getRed() < 1 && getWorld().getColorAt(getX()+1, getY()).getGreen() < 1 && getWorld().getColorAt(getX()+1, getY()).getBlue() < 1 && x !=-1)      
        {      
            //Check if path is right 
            setLocation(getX() + speed,getY()); 
            //Set rotation to right
            setRotation(90);
            y = 0;
            x = 1;
        }      
        else if(getWorld().getColorAt(getX()-1, getY()).getRed() < 1 && getWorld().getColorAt(getX()-1, getY()).getGreen() < 1 && getWorld().getColorAt(getX()-1, getY()).getBlue() < 1&& x !=1)      
        {      
            //Check if path is left
            setLocation(getX() - speed, getY());  
            //Set rotation to left
            setRotation(270);            
            y = 0;
            x = -1;
        } 
        else if(getWorld().getColorAt(getX(), getY()+1).getRed() < 1 && getWorld().getColorAt(getX(), getY()+1).getGreen() < 1 && getWorld().getColorAt(getX(), getY()+1).getBlue() < 1 && y != -1)      
        {      
            //Check if path is down
            setLocation(getX(), getY() + speed);    
            //Set rotation to down
            setRotation(180);            
            x = 0;
            y = 1;
        }
        else if(getWorld().getColorAt(getX(), getY()-1).getRed() < 1 && getWorld().getColorAt(getX(), getY()-1).getGreen() < 1 && getWorld().getColorAt(getX(), getY()-1).getBlue() < 1 && y !=1)      
        {   
            //Check if path is up
            setLocation(getX(), getY() - speed);   
            //Set rotation to up
            setRotation(0);            
            x = 0;
            y = -1;
        }
        if(getWorld().getColorAt(getX(), getY()).getRed() < 1 && getWorld().getColorAt(getX(), getY()).getGreen() < 1 && getWorld().getColorAt(getX(), getY()).getBlue() < 1)            
        {
             
        }
        else {
            
            ((Lives)getWorld().getObjects(Lives.class).get(0)).imageUp();
            IWantToDie = 1;
        }
        counterCounter ++;
        stepCounter = stepCounter + speed;
    }
    
    public void dealingWithDamage()
    {
        Bullet theBullet = (Bullet)getOneIntersectingObject(Bullet.class);
        type = theBullet.getType();
        //Basic bullet
        if(type == 1) {
            life = life - 10;
        }
        //Weak bullet
        if(type == 2) {
            life --;
        }
        //Emp stun
        if(type == 3) {
            
        }
        //Area damage bullet
        if(type == 4) {
            life = life - 7;
        }
        //Long range bullet 
        if(type != 3) {
            getWorld().removeObjects(getIntersectingObjects(Bullet.class));
        }
    }
    
    public void dealingWithDeadness() {
        ((Coins)getWorld().getObjects(Coins.class).get(0)).coinsUp(1);
        IWantToDie = 1;
    }
    
    public void dealingWithSlowness()
    {
        speedCounter++;
        if(speedCounter >= 100 && speed == 2 && Math.round(stepCounter/4) == stepCounter/4) {
            speed = 4;
            speedCounterTrigger = 0;
            speedCounter = 0;
        }
    }
    
    public void act() 
    {
        if(IWantToDie == 1) {
            getWorld().removeObject(this);
            return;
        }
        if(counter == 2) {
            walk();
            counter = 0;
        } else {
            counter++;
        }
        if(isTouching(Bullet.class)) {
            dealingWithDamage();
        } 
        if(life <= 0) {
            dealingWithDeadness();
        }   
        if(speedCounterTrigger == 1) {
            dealingWithSlowness();
        }
    } 
}
