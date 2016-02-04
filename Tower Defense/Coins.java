import greenfoot.*;
import java.awt.Color;

/**
 * Write a description of class scoreField here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class Coins extends Actor
{
    
    public String coinString;
    public int coins;
    
    public Coins(String coin)
    {
        //Call image updater
        updateImage(coin);
        
        //Set amount of coins
        coinString = coin;
        coins = Integer.parseInt(coinString);
    }
 
    public void updateImage(String coins)
    {
        //Set image
        setImage(new GreenfootImage(coins, 26, Color.black, new Color(0, 0, 0, 0)));
    }
    
    public int getCoins() {
        //Return coins when buying machine
        return coins;
    }
    
    public void coinsUp(int killBonus) 
    {
        //Coins up if kill
        coins = Integer.parseInt(coinString);
        coins = coins + killBonus;
        setImage(new GreenfootImage(Integer.toString(coins), 26, Color.black, new Color(0, 0, 0, 0)));
        coinString = Integer.toString(coins);
    }
    
    public void coinsDown(int cost)
    {
        //Coins down if buy
        coins = Integer.parseInt(coinString);
        coins = coins - cost;
        setImage(new GreenfootImage(Integer.toString(coins), 26, Color.black, new Color(0, 0, 0, 0)));
        coinString = Integer.toString(coins);
    }
}