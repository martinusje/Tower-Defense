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
    int direction, speed, robotX, robotY, counter = 0, explosionCounter = 0, type;
    Actor theOwner;
    public Bullet(int dir, int X, int Y, Actor theOwner, int type) { 
        this.type = type;
        if(type == 1) {
            speed = 10;
        }
        if(type == 2) {
            speed = 10;
        }
        if(type == 3) {
            speed = 10;
        }
        if(type == 4) {
            speed = 15;
        }
        setRotation(dir);
        robotX = X;
        robotY = Y;
        this.theOwner = theOwner;
    } 
    public int getType() {
        return type;
    }
    public void act() {
        if(theOwner.getX() == getX() && theOwner.getY() == getY() && counter == 0) {
            setRotation(getRotation());
            counter++;
        }
        if(counter == 0) {
            if (type != 4) {
                turnTowards(robotX, robotY);
            } else {
                turnTowards(theOwner.getX(), theOwner.getY());
            }
        }        
        if(getX() >= 640 || getX() == 0 || getY() >= 640 || getY() == 0) {
            getWorld().removeObject(this);
            return;
        }
        if(isTouching(Robot.class) && type == 3) {
            for (Robot a : (List<Robot>) getObjectsInRange(96,Robot.class)) {
                a.lifeDown();
                a.lifeDown();
            }
            getWorld().addObject(new Explosion(), getX(), getY());
            explosionCounter = 0;
            getWorld().removeObject(this);
            return;
        }
        move(speed);
    }    
}
