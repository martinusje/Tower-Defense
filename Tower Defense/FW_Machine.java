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
public class FW_Machine extends Actor
{
    /**
     * Act - do whatever the FW_Machine wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public int returnRobotX()
    {
        return robotX;
    }
    public int returnRobotY()
    {
        return robotY;
    }
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
        List<Robot> robots = getWorld().getObjects(Robot.class);
            if(robots.size() >= 1) {
                ArrayList counterArray = new ArrayList(robots.size());
                    for (Robot a : (List<Robot>) robots) {
                        int counterCounter = a.getCounter();
                        counterArray.add(counterCounter);
                    }
                Actor robot = robots.get(counterArray.indexOf(Collections.max(counterArray)));
                robotX = robot.getX();
                robotY = robot.getY();
            }
               
            List<Robot> robotsInRange = getObjectsInRange(200, Robot.class);
            if(robotsInRange.size() != 0 && active == 1) {
                ArrayList counterArrayInRange = new ArrayList(robotsInRange.size());
                for (Robot a : (List<Robot>) robotsInRange) {
                    int counterCounter = a.getCounter();
                    counterArrayInRange.add(counterCounter);
                }
                
                Actor robotInRange = robotsInRange.get(counterArrayInRange.indexOf(Collections.max(counterArrayInRange)));
                turnTowards(robotInRange.getX(), robotInRange.getY());
                if(counter == 20) {
                   getWorld().addObject(new Bullet(getRotation(), robotInRange.getX(), robotInRange.getY()), getX(), getY());
                   counter = 0;
                } else {
                   counter ++;
                }
            }
            
            if(Greenfoot.mouseDragged(this) && active == 0 ) {
                counter = 0;
                this.setLocation(getMouseX(), getMouseY());
                //getWorld().addObject(new Basic_Machine(), 704, 64);
            }
            
            if(Greenfoot.mouseClicked(this) && getWorld().getColorAt(getMouseX()+1, getMouseY()).getRed() != 0) {
                if(getWorld().getColorAt(getMouseX(), getMouseY()).getRed() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getGreen() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getBlue() < 1 || getMouseX() >= 640 || getMouseY() >= 640) {
                    getWorld().addObject(new Basic_Machine(), 704, 64);
                    getWorld().removeObject(this);
                } else {
                    active = 1;
                    getWorld().addObject(new Basic_Machine(), 704, 64);
                }
            }
    }    
}
