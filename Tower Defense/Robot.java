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
    int x = 0, y = 0, counter = 0, counterCounter = 0, life = 10, speed = 4, speedCounterTrigger = 0, speedCounter = 0, type; 
    double stepCounter = 0;
    public Robot(int robotType) { 
        if(robotType == 1) {
            speed = 4;
            life = 10;
            setImage("Basic_Robot.png");
        }
        if(robotType == 2) {
            speed = 2;
            life = 20;
            setImage("Basic_Robot_Slow.png");
        }
    }
    
    public int getCounter() 
    {
        return counterCounter;
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
        if(getWorld().getColorAt(getX()+1, getY()).getRed() < 1 && getWorld().getColorAt(getX()+1, getY()).getGreen() < 1 && getWorld().getColorAt(getX()+1, getY()).getBlue() < 1 && x !=-1)      
        {      
            setLocation(getX() + speed,getY()); 
            setRotation(90);
            y = 0;
            x = 1;
        }      
        else if(getWorld().getColorAt(getX()-1, getY()).getRed() < 1 && getWorld().getColorAt(getX()-1, getY()).getGreen() < 1 && getWorld().getColorAt(getX()-1, getY()).getBlue() < 1&& x !=1)      
        {      
            setLocation(getX() - speed, getY());  
            setRotation(270);            
            y = 0;
            x = -1;
        } 

        else if(getWorld().getColorAt(getX(), getY()+1).getRed() < 1 && getWorld().getColorAt(getX(), getY()+1).getGreen() < 1 && getWorld().getColorAt(getX(), getY()+1).getBlue() < 1 && y != -1)      
        {      
            setLocation(getX(), getY() + speed);    
            setRotation(180);            
            x = 0;
            y = 1;
        }
        else if(getWorld().getColorAt(getX(), getY()-1).getRed() < 1 && getWorld().getColorAt(getX(), getY()-1).getGreen() < 1 && getWorld().getColorAt(getX(), getY()-1).getBlue() < 1 && y !=1)      
        {      
            setLocation(getX(), getY() - speed);   
            setRotation(0);            
            x = 0;
            y = -1;
        }
        if(getWorld().getColorAt(getX(), getY()).getRed() < 1 && getWorld().getColorAt(getX(), getY()).getGreen() < 1 && getWorld().getColorAt(getX(), getY()).getBlue() < 1)            
        {}
        else {
            ((Lives)getWorld().getObjects(Lives.class).get(0)).imageUp();
            getWorld().removeObject(this);
            return;
        }
        counterCounter ++;
        stepCounter = stepCounter + speed;
    }
    
    public void dealingWithDamage()
    {
        Bullet theBullet = (Bullet)getOneIntersectingObject(Bullet.class);
        type = theBullet.getType();
        
        if(type == 1) {
            life = life - 2;
        }
        if(type == 2) {
            life --;
        }
        if(type == 3) {
            
        }
        if(type == 4) {
            life = life - 5;
        }
        if(type != 3) {
            getWorld().removeObjects(getIntersectingObjects(Bullet.class));
        }
    }
    
    public void dealingWithDeadness() {
        ((Coins)getWorld().getObjects(Coins.class).get(0)).coinsUp(1);
        getWorld().removeObject(this);
        return;
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
