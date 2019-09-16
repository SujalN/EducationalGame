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
        checkCollision();
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
    private void checkCollision()
    {
        if (isTouching(Floor.class) || isAtEdge())
        {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
         }
        else
        {
            checkHitTarget();
        }
    }
    
    /**
     * 
     */
    private void checkHitTarget() 
    {
         // To react to only one type (like Enemy) change Actor to that type
         Actor target = getOneIntersectingObject(Target.class);
         if (target != null)
         {
             MyWorld world = (MyWorld) getWorld();
             world.addObject(new Fire(), target.getX(), target.getY());
             world.removeObject(target);
             world.removeObject(this);
             return; // in case of multiple if statements
         }
         
         Actor igloo = getOneIntersectingObject(Igloo.class);
         if (igloo != null)
         {
             MyWorld world = (MyWorld) getWorld();
             world.addObject(new Fire(), igloo.getX(), igloo.getY());
             world.removeObject(igloo);
             world.removeObject(this);
             return; // in case of multiple if statements
         }
     }
}
