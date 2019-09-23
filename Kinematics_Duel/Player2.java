import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.Scanner; 
/**
 * Defines the actions of player 2 moving object
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 *      
 * @version 9/22/19
 */
public class Player2 extends Actor
{
    private static final int reloadFireball = 40;

    private int reloadFireballDelayCount;

    int angle = -getRotation();
    
    int rotateRate = 3;
    int rotateIntegration = 0;

    /**
     * Defines happens if key is clicked
     * If "left" is hit, x > 100, and no collision, move object left 4
     * If "right" is hit, x < 1000, move object right 4
     * If "up" is hit, and rotateIntegration >= -90, rotate counterclockwise
     * If "down" is hit, and rotateIntegration <= 0, rotate clockwise
     * If "shift" is hit, fire
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left") && getX() >100 && !collideCheck()) 
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

        if (Greenfoot.isKeyDown("shift"))
        {
            blam();
        }
        reloadFireballDelayCount++;
        freeze();
    } 
    /**
     * Set launch and rotation of tank
     */
    private void blam()
    {
        if (reloadFireballDelayCount >= reloadFireball)
        {
            Greenfoot.playSound("uppercut.wav");
            turn(4);
            rotateIntegration = rotateIntegration - 4;
            int angle = getRotation()+210; // adjust angle for image
            Fireball fb = new Fireball(new Vector(angle, 15));
            getWorld().addObject(fb, getX(), getY()-10);
            fb.setRotation(angle);
            fb.move(0); // clear the cannon barrel
            reloadFireballDelayCount = 0;
        }
    }
    /**
     * Check for collisions 
     */
    public boolean collideCheck()
    {
        Actor target1 = getOneIntersectingObject(Player1.class);
        if (target1 != null)
        {
           return true;
        }
        else
        {
            return false;
        }
    }
    /**
     * If collision is true, then freeze the tanks, create a Player1_S object, and ask for launch angle/velocity
     */
    public void freeze()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor hitreg = getOneIntersectingObject(kaboom.class);
        for(Player1 e : world.getObjects(Player1.class))
        {
            Player1 p1 = (Player1) world.getObjects(Player1.class).get(0);
            if (hitreg == null)
            {
                hitreg = getOneIntersectingObject(graze.class);
            }
            if (hitreg != null)
            {
               Player1_S ps = new Player1_S(p1.getRotation());
               getWorld().addObject(ps, p1.getX(), getY());
               
               int vo = Integer.parseInt(Greenfoot.ask("Blue down - choose an initial velocity (vo) in the equation d=vot-0.5gt^2 to shoot a final projectile.\nHint: try between 5-15!"));
               int theta = Integer.parseInt(Greenfoot.ask("Choose an angle (theta) in vocos(theta) and vosin(theta)."));
               
               theta = theta + 180;
               
               Greenfoot.playSound("uppercut.wav");
               finalfireball fb = new finalfireball(new Vector(theta, vo));
               getWorld().addObject(fb, getX(), getY()-10);
               fb.setRotation(angle);
            }
        }
    }
}
