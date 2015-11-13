import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends SmoothMover
{
    int explosionCounter = 0;
    public void act() 
    {
       explosionCounter++;
       setImage(Integer.toString(explosionCounter) + ".png");
       if(explosionCounter == 15) {
           getWorld().removeObject(this);
           return;
       }
    }    
}
