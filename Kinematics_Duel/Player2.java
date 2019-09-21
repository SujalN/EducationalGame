import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner; 
/**
 * Write a description of class Player2 here.
 * 
 * @author (Ricky Chavez) 
 * @version (11/2/17)
 */
public class Player2 extends Actor
{
    private static final int reloadFireball = 50;

    private int reloadJDAMDelayCount;
    private int reloadBombDelayCount;
    private int reloadFireballDelayCount;

    int angle = -getRotation();
    
    int rotateRate = 3;
    int rotateIntegration = 0;

    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
        if(Greenfoot.isKeyDown("up") && rotateIntegration>=-90)
        {
            turn(rotateRate);
            rotateIntegration = rotateIntegration - rotateRate;
        }
        if(Greenfoot.isKeyDown("down") && rotateIntegration<=0)
        {
            turn(-rotateRate);
            rotateIntegration = rotateIntegration + rotateRate;
        }

        if (Greenfoot.isKeyDown("enter"))
        {
            blam();
        }
        reloadFireballDelayCount++;
    } 
    private void blam()
    {
        if (reloadFireballDelayCount >= reloadFireball)
        {
            Greenfoot.playSound("uppercut.wav");
            int angle = getRotation()+210; // adjust angle for image
            Fireball fb = new Fireball(new Vector(angle, 15));
            getWorld().addObject(fb, getX(), getY()-10);
            fb.setRotation(angle);
            fb.move(0); // clear the cannon barrel
            reloadFireballDelayCount = 0;
        }
    }
}
