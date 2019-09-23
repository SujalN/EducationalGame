import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Define the behvior of Midair explosions
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 *      
 * @version 9/22/19
 */
public class graze extends Actor
{
    /**
     * Call the hitreg function and set the transparancy to give an explosion
     * effect
     */
    public void act() 
    {
        
        hitreg();
        
        int alpha = getImage().getTransparency();
        if (alpha > 10)
        {
            getImage().setTransparency(alpha - 10);
        }
        else
        {
            getWorld().removeObject(this);
        }
        
    }    
    /**
     * If a midair explosion occurs where an a movable player(Player1 or Player2)
     * is present, then remove that object and also remove the other non, moving
     * player. 
     * If a midair explosion occurs near a respawn player(Player1_S or Player2_S,
     * then remove that player and do nothing
     */
    public void hitreg()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor target1 = getOneIntersectingObject(Player1.class);
        if (target1 != null)
        {
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target1);
           getWorld().removeObjects(getWorld().getObjects(Player2.class));
           //world.preparePlayer2_S();
        }
        Actor target2 = getOneIntersectingObject(Player2.class);
        if (target2 != null)
        {
           //Greenfoot.playSound("marioded.wav");
           world.removeObject(target2);
           getWorld().removeObjects(getWorld().getObjects(Player1.class));
           //world.preparePlayer1_S();
        }
        Actor target11 = getOneIntersectingObject(Player1_S.class);
        if (target11 != null)
        {
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target11);
           //world.preparePlayer1_S();
        }
        Actor target22 = getOneIntersectingObject(Player2_S.class);
        if (target22 != null)
        {
           Greenfoot.playSound("marioded.wav");
           world.removeObject(target22);
           //world.preparePlayer1_S();
        }
    }
}