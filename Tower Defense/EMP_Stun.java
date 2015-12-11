import greenfoot.*;

/**
 * Write a description of class EMP_Stun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EMP_Stun extends SmoothMover
{
    int EMP_Stun = 2;
    public void act() 
    {
        EMP_Stun++;
        setImage(Integer.toString(EMP_Stun) + ".png");
        if(EMP_Stun == 36) {
            getWorld().removeObject(this);
            return;
        }
    }    
}
