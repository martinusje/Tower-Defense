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
    //BulletSpeed
    int speed;
    
    //BulletType, defined by shooting machine
    int type;
    
    //If already dead = 1, run first at act
    int IWantToDie = 0;
    
    //Use theOwner for following bullet
    Actor theOwner;
    
    public Bullet(int dir, int X, int Y, Actor theOwner, int type) { 
        this.type = type;
        //Bullet basic by robot 1
        if(type == 1) {
            speed = 10;
            setImage("Bullet_Basic.png");
        }
        //Bullet basic by robot 2
        if(type == 2) {
            speed = 10;
            setImage("Bullet_Basic.png");
        }
        //Rocket by robot 3
        if(type == 3) {
            speed = 10;
            setImage("Bullet_Strong.png");
        }
        //Sniper bullet by robot 4
        if(type == 4) {
            speed = 15;
            setImage("Bullet_Sniper.png");
        }
        
        //Set rotation
        setRotation(dir);
        
        //Declare the owner
        this.theOwner = theOwner;
    } 
    
    public int getType() {
        //Return type for robot
        return type;
    }
    
    public void ifFollowingBullet()
    {
        turnTowards(theOwner.getX(), theOwner.getY());
        return;
    }
    
    public void ifNotExplosiveNorFollowingBullet()
    {
        IWantToDie = 1;
    }
    
    public void ifExplosiveBullet() 
    {
        for (Robot a : (List<Robot>) getObjectsInRange(96,Robot.class)) {
            a.lifeDown();
            a.lifeDown();
        }
        getWorld().addObject(new Explosion(), getX(), getY());
        IWantToDie = 1;
    }
    
    public void act() {
        if(IWantToDie == 1) {
            getWorld().removeObject(this);
            return;
        }
        if(theOwner.getWorld() != null && type == 4) {
            ifFollowingBullet();
        }        
        if(getX() >= 640 || getX() == 0 || getY() >= 640 || getY() == 0) {
            ifNotExplosiveNorFollowingBullet();
        }
        if(isTouching(Robot.class) && type == 3) {
            ifExplosiveBullet();
        }
        move(speed);
    }    
}
