import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (Sujal Nahata) 
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
        super(1078, 672, 1); 
        preparePlayer1();
        preparePlayer2();
    }
    public void preparePlayer1()
    {
        addObject(new Player1(), 200, 600);
    }
    public void preparePlayer2()
    {
        addObject(new Player2(), 878, 600);
    }
}
