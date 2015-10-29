import greenfoot.*;
import java.util.List;
/**
 * Write a description of class Bullet here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bullet extends SmoothMover
{
    private int direction, speed, robotX, robotY;
    int counter = 0;
    
    public Bullet(int dir, int X, int Y) { 
        direction = dir; 
        setRotation(dir);
        speed = 1; 
        robotX = X;
        robotY = Y;
    } 
    public void act() {
        if(((Basic_Machine)getWorld().getObjects(Basic_Machine.class).get(0)).returnRobotX() == getX() && ((Basic_Machine)getWorld().getObjects(Basic_Machine.class).get(0)).returnRobotY() == getY() && counter == 0) {
            setRotation(getRotation());
            counter++;
        }
        if (counter == 0) {
            turnTowards(((Basic_Machine)getWorld().getObjects(Basic_Machine.class).get(0)).returnRobotX(), ((Basic_Machine)getWorld().getObjects(Basic_Machine.class).get(0)).returnRobotY());
        }
        move(speed);
        if(getX() >= 640 || getX() == 0 || getY() >= 640 || getY() == 0) {
            getWorld().removeObject(this);
        }
        
    }    
}
