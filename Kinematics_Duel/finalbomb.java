import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class finalbomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class finalbomb extends Actor
{
    /**
     * Act - do whatever the kaboom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    boolean hit = false;
    
    public void act() 
    {
        int alpha = getImage().getTransparency();
        hitreg();
        if (alpha > 10)
        {
            getImage().setTransparency(alpha - 10);
        }
        else
        {
            if (hit == true);
            else
            {
                Greenfoot.playSound("fail.wav");
            }
            getWorld().removeObject(this);
            MyWorld world = (MyWorld) getWorld();
        }
    }    
    public void hitreg()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor target11 = getOneIntersectingObject(Player1_S.class);
        if (target11 != null)
        {
           hit = true;
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target11);
           //world.preparePlayer1_S();
        }
        Actor target22 = getOneIntersectingObject(Player2_S.class);
        if (target22 != null)
        {
           hit = true;
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target22);
           //world.preparePlayer1_S();
        }
    }
}
