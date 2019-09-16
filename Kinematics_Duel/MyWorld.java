import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Ricky Chavez) 
 * @version (11/2/17)
 */
public class MyWorld extends World
{
    int gWidth = 32;
    int gHeight = 360;
    
    int setX[] = {200, 300, 400, 500};
    
    public static final Vector GRAVITY = new Vector(0.0, 0.2);
    
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        
        prepareFloor();
        preparePlayer();
        prepareBalloon();
        prepareNope();
        prepareBase();
        prepareIgloo();
    }
    
    public void prepareFloor()
    {
        for (int i = 0; i < 19; i++)
        {
            int x = i * gWidth + 16;
            int y = gHeight + 16;
            addObject(new Floor(), x, y);
        }
    }
    
    public void preparePlayer()
    {
        addObject(new Player(), 32, 325);
    }
    
    public void prepareBalloon()
    {
        addObject(new Balloon(), Greenfoot.getRandomNumber(400) + 200, Greenfoot.getRandomNumber(327));
    }
    
    public void prepareNope()
    {
        addObject(new Nope(), Greenfoot.getRandomNumber(400) + 200, 323);
    }
    
    public void prepareBase()
    {
        for (int i = 0; i < 4; i++)
        {
            addObject(new Target(), setX[i], 340);
        }
    }
    
    public void prepareIgloo()
    {
        addObject(new Igloo(), Greenfoot.getRandomNumber(400) + 200, 323);
    }
}
