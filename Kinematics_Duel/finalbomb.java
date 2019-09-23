import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * finalbomb defines actions of the last explosion that follows launching
 * firebal with velocity equation
 * 
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 * @version 9/22/19
 */

public class finalbomb extends Actor
{
    /**
     * Calls hitreg and defines transparency for collison effect
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
    /**
     * If the respawn object is hit, then sound is played and object is 
     * removed
     */
    public void hitreg()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor target11 = getOneIntersectingObject(Player1_S.class);
        if (target11 != null)
        {
           hit = true;
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target11);
          
        }
        Actor target22 = getOneIntersectingObject(Player2_S.class);
        if (target22 != null)
        {
           hit = true;
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target22);
          
        }
    }
}
