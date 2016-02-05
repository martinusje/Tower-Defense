import greenfoot.*;

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends SmoothMover
{
    public Explosion()
    {
        //Explosion sound
        Greenfoot.playSound("boem!.wav");
    }
    
    int explosionCounter = 0;
    public void act() 
    {
       explosionCounter++;
       //EMP explosion animation 
       setImage(Integer.toString(explosionCounter) + ".png");
       //Explosion is finised remove explosion
       if(explosionCounter == 15) {
           getWorld().removeObject(this);
           return;
       }
    }    
}
