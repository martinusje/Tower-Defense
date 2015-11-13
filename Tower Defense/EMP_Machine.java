import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

/**
 * Write a description of class FW_Machine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class EMP_Machine extends Actor
{
    int counter = 0, active = 0, EMPCounter = 0;
    
    public int getMouseX() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int mouseX = mouse.getX();
        mouseX = 32 * Math.round(mouseX/32) + 16;
        return mouseX;
    }
    public int getMouseY() {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        int mouseY = mouse.getY();
        mouseY = 32 * Math.round(mouseY/32) + 16;
        return mouseY;
    }
    public void act() 
    {  
            List<Robot> robotsInRange = getObjectsInRange(80, Robot.class);
            if(robotsInRange.size() != 0 && active == 1) {
                EMPCounter++;
                if(EMPCounter == 125) {
                    for (Robot a : (List<Robot>) robotsInRange) {
                        a.speedDown();
                    }
                    getWorld().addObject(new Explosion(), getX(), getY());
                    EMPCounter = 0;
                }
            }
            
            if(Greenfoot.mouseDragged(this) && active == 0 ) {
                counter = 0;
                this.setLocation(getMouseX(), getMouseY());
                //getWorld().addObject(new Basic_Machine(), 704, 64);
            }
            
            if(Greenfoot.mouseClicked(this) && getWorld().getColorAt(getMouseX()+1, getMouseY()).getRed() != 0) {
                if(getWorld().getColorAt(getMouseX(), getMouseY()).getRed() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getGreen() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getBlue() < 1 || getMouseX() >= 640 || getMouseY() >= 640) {
                    getWorld().addObject(new EMP_Machine(), 704, 448);
                    getWorld().removeObject(this);
                } else {
                    active = 1;
                    getWorld().addObject(new EMP_Machine(), 704, 448);
                }
            }
    }    
}
