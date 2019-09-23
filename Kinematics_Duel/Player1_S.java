import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines action of player 1 respawn
 * 
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 * @version 9/22/19
 */
public class Player1_S extends Actor
{
    /**
     * Move tank and play sounds depending on what key is hit
     * If "a" and x > 100, move left 4
     * If "d" and x < 1000 move right 4
     * If "w" and taunt does not equal 1 rotate tank counterclockwise, set taunt to 1, play sound
     * if "s" and taunt does not equal 2 rotate clockwise, set taunt to 2, play sound
     */
    
    int rotateRate = 30;
    int rotateIntegration = 0;
    
    int taunt = 0;
    
    public void act() 
    {
        if(Greenfoot.isKeyDown("a") && getX() >100) 
        {
            setLocation(getX() -4, getY());
        }
        if(Greenfoot.isKeyDown("d") && getX() < 1000) 
        {
            setLocation(getX() +4, getY());
        }
        if(Greenfoot.isKeyDown("w") && taunt != 1)
        {
            turn(-rotateRate);
            Greenfoot.playSound("kidlaugh.mp3");
            taunt = 1;
        }
        if(Greenfoot.isKeyDown("s") && taunt != 2)
        {
            turn(rotateRate);
            Greenfoot.playSound("missionfailed.mp3");
            taunt = 2;
        }
    }
    /**
     * Constructer, rotation tank
     */
    public Player1_S(int rotation)
    {
        setRotation(rotation);
    }
}
