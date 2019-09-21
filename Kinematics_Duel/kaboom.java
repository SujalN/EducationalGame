import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class kaboom here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class kaboom extends Actor
{
    /**
     * Act - do whatever the kaboom wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
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
            getWorld().removeObject(this);
        }
    }    
    public void hitreg()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor target1 = getOneIntersectingObject(Player1.class);
        if (target1 != null)
        {
            Greenfoot.playSound("marioded.wav");
            world.removeObject(target1);
           world.preparePlayer1_S();
        }
        Actor target2 = getOneIntersectingObject(Player2.class);
        if (target2 != null)
        {
            Greenfoot.playSound("marioded.wav");
            world.removeObject(target2);
            world.preparePlayer2_S();
        }
    }
}
