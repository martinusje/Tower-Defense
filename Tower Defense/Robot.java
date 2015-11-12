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
    int x = 0, y = 0, counter = 0, counterCounter = 0, life = 10, speed = 4, speedCounterTrigger = 0, speedCounter = 0, stepCounter = 0;
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
        speed = 2;
        speedCounterTrigger = 1;
    }
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (counter == 2) {
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
                System.out.println(stepCounter);
                getWorld().removeObject(this);
                return;
            }
            counterCounter ++;
            counter = 0;
            stepCounter = stepCounter + speed;
        } else {
            counter++;
        }
        if(isTouching(Bullet.class)) {
            getWorld().removeObjects(getIntersectingObjects(Bullet.class));
            life --;
            if(life <= 0) {
                ((Coins)getWorld().getObjects(Coins.class).get(0)).imageUp();
                getWorld().removeObject(this);
                return;
            }
        } 
         if(isTouching(Weak_Bullet.class)) {
            getWorld().removeObjects(getIntersectingObjects(Weak_Bullet.class));
            life --;
            if(life <= 0) {
                ((Coins)getWorld().getObjects(Coins.class).get(0)).imageUp();
                getWorld().removeObject(this);
                return;
            }
        } 
        if(life == 0 || life < 0) {
            ((Coins)getWorld().getObjects(Coins.class).get(0)).imageUp();
            getWorld().removeObject(this);
            return;
        }   
        if(speedCounterTrigger == 1) {
            speedCounter++;
            if(speedCounter >= 100 && speed == 2 && Math.round(stepCounter/4) == stepCounter/4) {
                speed = 4;
                speedCounterTrigger = 0;
                speedCounter = 0;
            }
        }
    } 
}
