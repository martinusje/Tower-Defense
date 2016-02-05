import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class button extends Actor
{
    /**
     * Act - do whatever the button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    //Buttontype, 1 == with text, 2 == with image
    int buttonType;
    public button(String text, int buttonType, int blackorwhite)
    {
        //Set buttontype from parameter
        this.buttonType = buttonType;
        
        //Run updateimage method, comes from updatable image types (coins, etc.)
        updateImage(text, blackorwhite);
    }
 
    public void updateImage(String text, int blackorwhite)
    {
        //If text button
        if (buttonType == 1){
            //If black text
            if(blackorwhite == 0) {
                //Set text
                setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
            }
            //If white text
            if(blackorwhite == 1) {
                //Set text
                setImage(new GreenfootImage(text, 26, Color.white, new Color(0, 0, 0, 0)));
            }
        }
        //If imagebutton
        if (buttonType == 2){
            //Get emtpy button, image is set in method caller
            setImage(new GreenfootImage("Empty_Button.png"));
        }
    }       
}
