import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Write a description of class Basic_Machine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Basic_Machine extends Actor
{
    int counter = 0, robotX, robotY, active = 0;
    
    public int returnRobotX()
    {
        return robotX;
    }
    public int returnRobotY()
    {
        return robotY;
    }
    public void act() 
    {
            if(Greenfoot.mouseDragged(this) && active == 0) {
                counter = 0;
                MouseInfo mouse = Greenfoot.getMouseInfo();
                this.setLocation(mouse.getX(), mouse.getY());
            }
            
            if(Greenfoot.mouseClicked(this)) {
                active = 1;
                getWorld().addObject(new Basic_Machine(), 704, 64);
            }
           
        
            List<Robot> robots = getObjectsInRange(200, Robot.class);
            if(robots.size() != 0 && active == 1) {
                ArrayList counterArray = new ArrayList(robots.size());
                for (Robot a : (List<Robot>) robots) {
                    int counterCounter = a.getCounter();
                    counterArray.add(counterCounter);
                }
                
                Actor robot = robots.get(counterArray.indexOf(Collections.max(counterArray)));
                turnTowards(robot.getX(), robot.getY());
                robotX = robot.getX();
                robotY = robot.getY();
                if(counter == 20) {
                   getWorld().addObject(new Bullet(getRotation(), robot.getX(), robot.getY()), getX(), getY());
                   //((Robot)robot).lifeDown();
                   counter = 0;
                } else {
                   counter ++;
                }
            }
          
    }    
}
