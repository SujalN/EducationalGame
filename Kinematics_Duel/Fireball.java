import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Cannonball here.
 * 
 * @author (Bryan Ortiz) 
 * @version (11/2/17)
 */
public class Fireball extends SmoothMover
{
    private static final int GROUND_HEIGHT = 360 - 6;
    
    /**
     * Act - do whatever the Cannonball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(MyWorld.GRAVITY);
        move();
    }    
    
    /**
     * 
     */
    public Fireball()
    {
        this(new Vector(0, 6));
    }
    
    /**
     * 
     */
    public Fireball(Vector velocity)
    {
        super(velocity);
    }
    
    /**
     * 
     */
    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }
    
    /**
     * 
     */
    //private void checkCollision()
    //{
    //    if ()
    //    {
    //        MyWorld world = (MyWorld) getWorld();
    //        world.removeObject(this);
    //     }
    //    else
    //    {
    //        checkHitTarget();
    //    }
    //}
}
