import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SmoothMoverBall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class SmoothMoverBall extends Actor
{
    private Vector velocity;
    
    private double exactX;
    private double exactY;
    
    /**
     * Default constructor.
     */
    public SmoothMoverBall()
    {
        this(new Vector());
    }
    
    /**
     * Create new Mover initialised with given velocity.
     */
    public SmoothMoverBall(Vector velocity)
    {
        this.velocity = velocity;
    }
    
    /**
     * Move in the direction of the velocity vector. This simulates movement in one 
     * time unit (dt==1).
     */
    public void move() 
    {
        exactX = exactX + velocity.getX();
        exactY = exactY + velocity.getY();
        super.setLocation((int) exactX, (int) exactY);
    }

    /**
     * Set the location using exact (double) co-ordinates.
     */
    public void setLocation(double x, double y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation((int) x, (int) y);
    }
    
    /**
     * Set the location of this actor. Redefinition of the standard Greenfoot 
     * method to make sure the exact co-ordinates are updated in sync.
     */
    public void setLocation(int x, int y) 
    {
        exactX = x;
        exactY = y;
        super.setLocation(x, y);
    }

    /**
     * Return the exact x co-ordinate (as a double).
     */
    public double getExactX() 
    {
        return exactX;
    }

    /**
     * Return the exact y co-ordinate (as a double).
     */
    public double getExactY() 
    {
        return exactY;
    }

    /**
     * Modify velocity by adding another velocity vector.
     */
    public void addToVelocity(Vector boost) 
    {
        velocity.add(boost);
    }
    
    /**
     * Accelerate the speed of this mover by the given factor. (Factors less than 1 will
     * decelerate.) The direction remains unchanged.
     */
    public void accelerate(double factor)
    {
        velocity.scale(factor);
        if (velocity.getLength() < 50) 
        {
            velocity.setNeutral();
        }
    }
    
    /**
     * Return the speed of this actor.
     */
    public double getSpeed()
    {
        return velocity.getLength();
    }
    
    /**
     * Revert velocity horizontally.
     */
    public void invertHorizontalVelocity()
    {
        velocity.revertHorizontal();
    }
    
    /**
     * Revert velocity vertically.
     */
    public void invertVerticalVelocity()
    {
        velocity.revertVertical();
    }
}

