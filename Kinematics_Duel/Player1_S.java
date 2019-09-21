import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1_S here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player1_S extends Actor
{
    /**
     * Act - do whatever the Player1_S wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
    public Player1_S(int rotation)
    {
        setRotation(rotation);
    }
}
