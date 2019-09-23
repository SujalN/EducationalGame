import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * finalfireball is the fireball object launched from player2
 * Defines the motion of the finalfireball launched from player 2
 * 
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata
 * @version 9/22/19
 */
public class finalfireball extends SmoothMover
{
    private static final int GROUND_HEIGHT = 360 - 6;
    boolean collision = false;
    boolean mid = false;
    long prevTime = 0;
    long curTime = 0;
    /**
     * Checks for collision midair. If there is a collision midair, the 
     * object is removed. if there is no collision midair, then finalfireball
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
     * Constructer, creates a new vector of motion for the finalfireball object 
     * with an initial direction of 0(east) and a length of 6.
     */
    public finalfireball()
    {
        this(new Vector(0, 6));
    }
    
    /**
     * Constructer, sets the velocity of the finalfireball by refering to the parent
     * SmoothMover Class
     */
    public finalfireball(Vector velocity)
    {
        super(velocity);
    }
    
    /**
     * Set the intiial location of finalfireball
     */
    @Override protected void addedToWorld(World world)
    {
        setLocation(getX(), getY());
    }
    /**
     * Checks for collision. If collision in mid air, finalfirebball removed, "fire.wav" played
     * and graze object added at the same location. If collision on ground, "fire.wav" is
     * also played but kaboom object is added at the same location. finalfireball also removed.
     */
    private void checkCollision()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor midair = getOneIntersectingObject(Fireball.class);
        if (getY()>601)
        {
            Greenfoot.playSound("fire.wav");
            collision = true;
            world.addObject(new finalbomb(),this.getX(), this.getY());
            world.removeObject(this);

        }
    }
}
