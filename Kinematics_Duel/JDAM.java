import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A very precise JDAM bomb 
 * 
 * @author Reuben Gan 
 * @version 10/30/17
 */
public class JDAM extends SmoothMoverJDAM
{
    public JDAM() // default constructor: good for testing
    {
        this(new Vector(0, 2)); // calls Vector param in overloaded constructor 
    }

    public JDAM(Vector velocity)
    {
        super(velocity); // calls velocity in 1 superclass up
    }

    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }	

    /**
     * Act - do whatever the JDAM wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        addToVelocity(MyWorld.GRAVITY);
        move();

        if (isTouching(Floor.class))
        {
            MyWorld world = (MyWorld) getWorld();
            world.addObject(new EndJDAM(), getX(), getY());
            world.removeObject(this);
        }

        else 
        {
            checkHitTarget();
        }

    }

    private void checkHitTarget() 
    {
        // To react to only one type (like Enemy) change Actor to that type
        Actor nopes = getOneIntersectingObject(Nope.class); // Assume cannonball only hits 1 target at a time
        if (nopes != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.addObject(new EndJDAM(), nopes.getX(), nopes.getY()); // target must be still in the world
            world.removeObject(nopes);
            world.removeObject(this);
            return; // in case of multiple if statements
        }

        Actor Ground = getOneIntersectingObject(Floor.class); // Assume cannonball only hits 1 target at a time
        if (Ground != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.addObject(new EndJDAM(), Ground.getX(), Ground.getY()); // target must be still in the world
            world.removeObject(Ground);
            world.removeObject(this);
            return; // in case of multiple if statements
        }
        
        Actor target = getOneIntersectingObject(Target.class);
        if (target != null)
        {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(target);
            world.removeObject(this);
        }
    }
}    

