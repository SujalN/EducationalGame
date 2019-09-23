import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * fireball is the fireball object launched from player1
 * Defines the motion of the Fireball launched from player 1
 * 
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 * @version 9/22/19
 */
public class Fireball extends SmoothMover
{
    private static final int GROUND_HEIGHT = 360 - 6;
    boolean collision = false;
    boolean mid = false;
    long prevTime = 0;
    long curTime = 0;
    /**
     * Checks for collision midair. If there is a collision midair, the 
     * object is removed. if there is no collision midair, then Fireball
     * keeps motion until it dectects one.
     */
    public void act() 
    {
        if (collision == false){
            addToVelocity(MyWorld.GRAVITY);
            move();
            turn(15);
            checkCollision();
        }
        if (mid == true) {
            MyWorld world = (MyWorld) getWorld();
            world.removeObject(this);
        }
    }    
    
    /**
     * Constructer, creates a new vector of motion for the fireball object 
     * with an initial direction of 0(east) and a length of 6.
     */
    public Fireball()
    {
        this(new Vector(0, 6));
    }
    
    /**
     * Constructer, sets the velocity of the Fireball by refering to the parent
     * SmoothMover Class
     */
    public Fireball(Vector velocity)
    {
        super(velocity);
    }
    
    /**
     * Set the intiial location of fireball
     */
    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }
    /**
     * Checks for collision. If collision in mid air, cannonball removed, "fire.wav" played
     * and graze object added at the same location. If collision on ground, "fire.wav" is
     * also played but kaboom object is added at the same location. 
     */
    private void checkCollision()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor midair = getOneIntersectingObject(Fireball.class);
        if (midair != null && mid == false)
        {
            mid = true;
            Greenfoot.playSound("fire.wav");
            world.addObject(new graze(),this.getX(), this.getY());
            
        }
        if (getY()>601)
        {
            Greenfoot.playSound("fire.wav");
            collision = true;
            world.addObject(new kaboom(),this.getX(), this.getY());
            world.removeObject(this);

        }
    }
}
