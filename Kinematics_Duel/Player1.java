import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player1 here.
 * 
 * @author (Ricky Chavez) 
 * @version (11/2/17)
 */
public class Player1 extends Actor
{
    private static final int reloadFireball = 50;

    private int reloadFireballDelayCount;

    int angle = getRotation()-30;
    
    int rotateRate = 2;
    int rotateIntegration = 0;

    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

       
        if(Greenfoot.isKeyDown("a") && getX() >100) 
        {
            setLocation(getX() -4, getY());
        }
        if(Greenfoot.isKeyDown("d") && getX() < 1000) 
        {
            setLocation(getX() +4, getY());
        }
        if(Greenfoot.isKeyDown("w") && rotateIntegration>=-90)
        {
            turn(-rotateRate);
            rotateIntegration = rotateIntegration - rotateRate;
        }
        if(Greenfoot.isKeyDown("s") && rotateIntegration<=0)
        {
            turn(rotateRate);
            rotateIntegration = rotateIntegration + rotateRate;
        }
        if (Greenfoot.isKeyDown("space"))      
        {
            fire();
        }
        reloadFireballDelayCount++;
        freeze();
    } 
    private void shoot()
    {
        int angle = getRotation(); // adjust angle for image
    }
    public int determineX()
    {
        return getX();
    }
    private void fire()
    {
        if (reloadFireballDelayCount >= reloadFireball)
        {
            Greenfoot.playSound("uppercut.wav");
            turn(-4);
            rotateIntegration = rotateIntegration - 4;
            int angle = getRotation()-25; // adjust angle for image
            Fireball fb = new Fireball(new Vector(angle, 15));
            getWorld().addObject(fb, getX(), getY()-10);
            fb.setRotation(angle);
            fb.move(0); // clear the cannon barrel
            reloadFireballDelayCount = 0;
        }
    }
    public void freeze()
    {
        MyWorld world = (MyWorld) getWorld();
        Actor hitreg = getOneIntersectingObject(kaboom.class);
        for(Player2 e : world.getObjects(Player2.class))
        {
            Player2 p2 = (Player2) world.getObjects(Player2.class).get(0);
            if (hitreg == null)
            {
                hitreg = getOneIntersectingObject(graze.class);
            }
            if (hitreg != null)
            {
               Player2_S ps = new Player2_S(p2.getRotation());
               getWorld().addObject(ps, p2.getX(), getY());
               
               while 
               
            }
        }
    }
}
