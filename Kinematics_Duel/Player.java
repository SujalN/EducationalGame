import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (Ricky Chavez) 
 * @version (11/2/17)
 */
public class Player extends Actor
{
    private static final int reloadJDAM = 20;
    private static final int reloadBomb = 20;
    private static final int reloadFireball = 20;

    private int reloadJDAMDelayCount;
    private int reloadBombDelayCount;
    private int reloadFireballDelayCount;

    int angle = getRotation();

    /**
     * Act - do whatever the Cannon wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if(Greenfoot.isKeyDown("left") && getX() >30) 
        {
            setLocation(getX() -2, getY());
        }
        if(Greenfoot.isKeyDown("right") && getX() < 80) 
        {
            setLocation(getX() +2, getY());
        }
        if(Greenfoot.isKeyDown("up"))
        {
            turn(-2);
        }
        if(Greenfoot.isKeyDown("down"))
        {
            turn(2);
        }
        
        if ("v".equals(Greenfoot.getKey()))
        {
            shoot();
        }

        if (Greenfoot.isKeyDown("c"))      
        {
            fire();
        }

        if (Greenfoot.isKeyDown("z"))
        {
            bomb();
        }

        if (Greenfoot.isKeyDown("x"))
        {
            blam();
        }

        reloadJDAMDelayCount++;
        reloadBombDelayCount++;
        reloadFireballDelayCount++;
    }  

    public Player()
    {
        reloadJDAMDelayCount = 5;
    }

    private void shoot()
    {
        int angle = getRotation(); // adjust angle for image
        Ball ball = new Ball(new Vector(angle, 10));
        getWorld().addObject(ball, getX(), getY());
        ball.setRotation(angle);
        ball.move(35); // clear the cannon barrel
    }

    private void fire()
    {
        if(reloadJDAMDelayCount >= reloadJDAM)
        {
            Greenfoot.playSound("fire.wav");
            int angle = getRotation(); 
            JDAM munition = new JDAM(new Vector(angle, 12)); // using overloaded constructor
            getWorld().addObject(munition, getX(), getY());
            munition.setRotation(angle);
            //munition.move(15); 
            reloadJDAMDelayCount = 0;
        }
    }

    private void bomb()
    {
        if (reloadBombDelayCount >= reloadBomb)
        {
            Greenfoot.playSound("launch.wav");
            Bomb bomb = new Bomb(new Vector(getRotation(), 11));
            getWorld().addObject(bomb, getX(), getY());
            bomb.setRotation(getRotation());
            reloadBombDelayCount = 0;

        }
    }

    private void blam()
    {
        if (reloadFireballDelayCount >= reloadFireball)
        {
            Greenfoot.playSound("fire.wav");
            int angle = getRotation(); // adjust angle for image
            Fireball fb = new Fireball(new Vector(angle, 12));
            getWorld().addObject(fb, getX(), getY());
            fb.setRotation(angle);
            fb.move(0); // clear the cannon barrel
            reloadFireballDelayCount = 0;
        }
    }
}
