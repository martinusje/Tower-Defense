import greenfoot.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.awt.Color;

/**
 * Write a description of class Basic_Machine here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Machine extends Actor
{
    int counter = 0, robotX, robotY, active = 0, type, range, shootingRate, bulletType, EMPCounter;
    
    public Machine(int type) {
        this.type = type;
        if(type == 1) {
            range = 200;
            shootingRate = 40;
            bulletType = 1;
            setImage("Arrow.png");
        }
        if(type == 2) {
            range = 100;
            shootingRate = 20;
            bulletType = 2;
            setImage("Arrow(red).png");
        }
        if(type == 3) {
            range = 100;
            shootingRate = 40;
            bulletType = 3;
            setImage("Arrow(pink).png");
        }
        if(type == 4) {
            range = 80;
            shootingRate = 125;
            setImage("Arrow(green).png");
        }
        if(type == 5) {
            range = 300;
            shootingRate = 125;
            bulletType = 4;
            setImage("Arrow(yellow).png");
        }
    }
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
        List<Robot> robotsInRange = getObjectsInRange(range, Robot.class);
        if(robotsInRange.size() != 0 && active == 1) {
            if(type != 4) {
                ArrayList counterArrayInRange = new ArrayList(robotsInRange.size());
                for(Robot a : (List<Robot>) robotsInRange) {
                    int counterCounter = a.getCounter();
                    counterArrayInRange.add(counterCounter);
                }
                
                Actor robotInRange = robotsInRange.get(counterArrayInRange.indexOf(Collections.max(counterArrayInRange)));
                robotX = robotInRange.getX();
                robotY = robotInRange.getY();
                
                turnTowards(robotInRange.getX(), robotInRange.getY());
                if(counter == shootingRate) {
                   getWorld().addObject(new Bullet(getRotation(), robotInRange.getX(), robotInRange.getY(), robotInRange, bulletType), getX(), getY());
                   counter = 0;
                } else {
                   counter ++;
                }
            } else {
                
                if(EMPCounter == 125) {
                    for (Robot a : (List<Robot>) robotsInRange) {
                        a.speedDown();
                    }
                    getWorld().addObject(new Explosion(), getX(), getY());
                    EMPCounter = 0;
                } else {
                    EMPCounter++;
                }
            }
        } else {
            counter = shootingRate;
            EMPCounter = 125;
        }
        
        if(Greenfoot.mouseDragged(this) && active == 0 ) {
            counter = 0;
            this.setLocation(getMouseX(), getMouseY());
            //getWorld().addObject(new Basic_Machine(), 704, 64);
        }
        
        if(Greenfoot.mouseClicked(this) && getWorld().getColorAt(getMouseX()+1, getMouseY()).getRed() != 0) {
            if(type == 1) {
                getWorld().addObject(new Machine(type), 704, 64);
            }
            if(type == 2) {
                getWorld().addObject(new Machine(type), 704, 192);
            }
            if(type == 3) {
                getWorld().addObject(new Machine(type), 704, 320);
            }
            if(type == 4) {
                getWorld().addObject(new Machine(type), 704, 448);
            }
            if(type == 5) {
                getWorld().addObject(new Machine(type), 704, 576);
            }
            if(getWorld().getColorAt(getMouseX(), getMouseY()).getRed() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getGreen() < 1 && getWorld().getColorAt(getMouseX(), getMouseY()).getBlue() < 1 || getMouseX() >= 640 || getMouseY() >= 640) {
                getWorld().removeObject(this);
            } else {
                active = 1;
            }
        }
    }    
}
