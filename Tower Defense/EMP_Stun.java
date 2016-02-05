import greenfoot.*;

/**
 * Write a description of class EMP_Stun here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EMP_Stun extends SmoothMover
{
    int EMP_Stun = 1;
    int maxCounter = 0;
    public void act() 
    {
        //
        if(maxCounter == 6 ) {
            EMP_Stun--;
            setImage("EMP_Stun_" + Integer.toString(EMP_Stun*2) + ".png"); 
        } else {            
            setImage("EMP_Stun_" + Integer.toString(EMP_Stun*2) + ".png");
            EMP_Stun++;
            maxCounter++;
        }
        //
        if(maxCounter == 6 && EMP_Stun == 1) {
            getWorld().removeObject(this);
            return;
        }
    }    
}
