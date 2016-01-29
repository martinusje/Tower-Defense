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
    int buttonTypeJWZ;
    public button(String text, int buttonType)
    {
        buttonTypeJWZ = buttonType;
        updateImage(text);
    }
 
    public void updateImage(String text)
    {
        if (buttonTypeJWZ == 1){
            setImage(new GreenfootImage(text, 26, Color.black, new Color(0, 0, 0, 0)));
        }
        if (buttonTypeJWZ == 2){
            setImage(new GreenfootImage("Empty_Button.png"));
        }
    }       
}
