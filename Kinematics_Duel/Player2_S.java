import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player2_S here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player2_S extends Actor
{
    /**
     * Act - do whatever the Player2_S wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
    public Player2_S(int rotation)
    {
        setRotation(rotation);
    }
}
