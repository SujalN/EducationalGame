import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ball here.
 * 
 * @author (Noel Noguez) 
 * @version (11/2/17)
 */
public class Ball extends SmoothMoverBall
{

    public Ball()
    {
        this(new Vector(0, 4));
    }

    public Ball(Vector velocity)
    {
        super(velocity);
    }

    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }

    /**
     * Act - do whatever the Cannonball wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        addToVelocity(MyWorld.GRAVITY);
        move();
        checkHitBalloon();
        

    }
    
    public void atEdge()
    {
        if (isAtEdge())
        {
            Greenfoot.stop();
        }
    }

    private void checkHitBalloon() 
    {
        // To react to only one type (like Enemy) change Actor to that type
        Actor balloon = getOneIntersectingObject(Balloon.class);
        if (balloon != null)
        {
            MyWorld world = (MyWorld) getWorld();
            
            world.removeObject(balloon);
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
