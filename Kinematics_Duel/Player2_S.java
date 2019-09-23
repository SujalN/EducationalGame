import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Defines action of player 2 respawn
 * 
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 * @version 9/22/19
 */
public class Player2_S extends Actor
{
    /**
     * Move tank and play sounds depending on what key is hit
     * If "left" and x > 100, move left 4
     * If "right" and x < 1000 move right 4
     * If "up" and taunt does not equal 1 rotate tank counterclockwise, set taunt to 1, play sound
     * if "down" and taunt does not equal 2, rotate tank clockwise, set taunt to 2, play sound
     */
    
    int rotateRate = 30;
    int rotateIntegration = 0;
    
    int taunt = 0;
    
    public void act() 
    {
       if(Greenfoot.isKeyDown("left") && getX() >100) 
        {
            setLocation(getX() -4, getY());
        }
       if(Greenfoot.isKeyDown("right") && getX() < 1000) 
       {
           setLocation(getX() +4, getY());
       }
       if(Greenfoot.isKeyDown("up") && taunt != 1)
        {
            turn(rotateRate);
            Greenfoot.playSound("kidlaugh.mp3");
            taunt = 1;
        }
        if(Greenfoot.isKeyDown("down") && taunt != 2)
        {
            turn(-rotateRate);
            Greenfoot.playSound("missionfailed.mp3");
            taunt = 2;
        }
    }    
    /**
     * Constructer, rotation tank
    */
    public Player2_S(int rotation)
    {
        setRotation(rotation);
    }
}
