import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class levelSelect here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{

    /**
     * Constructor for objects of class levelSelect.
     * 
     */
    public Level2()
    {    
        super(768, 768, 1);

        getBackground().drawImage(new GreenfootImage("Background_2.png"), 0, 0);        
        getBackground().drawImage(new GreenfootImage("track_2.png"), 0, 0);
        
        getBackground().setColor(new Color(10,10,10,255));
        getBackground().drawRect(0, 0,  640, 640);
        
        for(int i = 0; i < 5; i++) {
            //setBackground(new GreenfootImage(2,2));
            getBackground().drawRect(640, i*128,  128, 128);
        } 
        
        addObject(new Level_1(),0,0);
        
        addObject(new Text("Lives:", 26),30,680);
        addObject(new Lives("10"),80,680);  
        
        addObject(new Text("Wave:", 26),30,700);
        addObject(new Wave("1"),80,700);  
        
        addObject(new Text("Coins:", 26),30,720);  
        addObject(new Coins("20"),80,720);  
        
        int Ylocation = 64;
        for(int i = 1; i <= 5; i++) {
            addObject(new Machine(i), 704, Ylocation);
            addObject(new Machine(i), 704, Ylocation);
           
            addObject(new Text("cost:" + ((Machine)getObjects(Machine.class).get((i*2)-1)).getCost(), 26),704,Ylocation + 28);  
            Ylocation = Ylocation + 128;
        }
        
        setPaintOrder(Robot.class, Machine.class);
    }
    public void drawBase(int type, int X, int Y) {
        getBackground().drawImage(new GreenfootImage("Tower_Base.png"), X-16, Y-16);
    }
}
