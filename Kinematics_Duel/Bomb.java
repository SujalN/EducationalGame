import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bomb here.
 * 
 * @author (Ricky Chavez) 
 * @version (11/2/17)
 */
public class Bomb extends SmoothMoverBomb
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        move();
        addToVelocity(MyWorld.GRAVITY);
        groundCheck();
    }    
    
    public Bomb() // default constructor: good for testing
    {
        this(new Vector(0, 2)); // calls Vector param in overloaded constructor 
    }
    
    public Bomb(Vector velocity)
    {
        super(velocity); // calls velocity in 1 superclass up
    }
    
    private void checkHitTarget() 
    {
        Actor target = getOneIntersectingObject(Target.class);
        if (target != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.addObject(new BombEnd(), target.getX(), target.getY());
            world.removeObject(target);
            world.removeObject(this);
        }
    }
    
    private void groundCheck()
    {
        Actor floor = getOneIntersectingObject(Floor.class);
        if (floor != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.addObject(new BombEnd(), floor.getX(), floor.getY());
            world.removeObject(this);
        }
        else
        {
            checkHitTarget();
        }
    }
}
