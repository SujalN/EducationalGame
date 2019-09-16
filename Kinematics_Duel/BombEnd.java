import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BombEnd here.
 * 
 * @author (Ricky Chavez) 
 * @version (11/2/17)
 */
public class BombEnd extends Actor
{
    /**
     * Act - do whatever the BombEnd wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
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
}
