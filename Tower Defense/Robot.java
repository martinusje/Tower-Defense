import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class Robot here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Robot extends Actor
{
    int x = 0;
    int y = 0;
    int counter = 0;
    int counterCounter = 0;
    int life = 10;
    public int getCounter() 
    {
        return counterCounter;
    }
    public void lifeDown()
    {
        
    } 
    /**
     * Act - do whatever the Robot wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (counter == 3) {
            Color Black = new Color(0,0,0,255);    
            if(getWorld().getColorAt(getX()+1, getY()).getRed() < 1 && getWorld().getColorAt(getX()+1, getY()).getGreen() < 1 && getWorld().getColorAt(getX()+1, getY()).getBlue() < 1 && x !=-1)      
            {      
                setLocation(getX() + 1,getY()); 
                setRotation(90);
                y = 0;
                x = 1;
            }      
            else if(getWorld().getColorAt(getX()-1, getY()).getRed() < 1 && getWorld().getColorAt(getX()-1, getY()).getGreen() < 1 && getWorld().getColorAt(getX()-1, getY()).getBlue() < 1&& x !=1)      
            {      
                setLocation(getX()-1, getY());  
                setRotation(270);            
                y = 0;
                x = -1;
            } 

            else if(getWorld().getColorAt(getX(), getY()+1).getRed() < 1 && getWorld().getColorAt(getX(), getY()+1).getGreen() < 1 && getWorld().getColorAt(getX(), getY()+1).getBlue() < 1 && y != -1)      
            {      
                setLocation(getX(), getY()+1);    
                setRotation(180);            
                x = 0;
                y = 1;
            }
            else if(getWorld().getColorAt(getX(), getY()-1).getRed() < 1 && getWorld().getColorAt(getX(), getY()-1).getGreen() < 1 && getWorld().getColorAt(getX(), getY()-1).getBlue() < 1 && y !=1)      
            {      
                setLocation(getX(), getY()-1);   
                setRotation(0);            
                x = 0;
                y = -1;
            }
            else {
                getWorld().removeObject(this);
            }
            counterCounter ++;
            counter = 0;
        } else {
            counter++;
        }
        if(isTouching(Bullet.class)) {
            getWorld().removeObjects(getIntersectingObjects(Bullet.class));
            life --;
            if(life <= 0) {
                getWorld().removeObject(this);
            }
        } 
    } 
    
    
}
