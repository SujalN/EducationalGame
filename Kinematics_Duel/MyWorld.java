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
    boolean gameover = false;
    
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
        prepareTitle();
        //playmusic();
    }
    public void preparePlayer1()
    {
        Player1 p1 = new Player1();
        addObject(p1, 200, 600);
    }
    public void preparePlayer2()
    {
        Player2 p2 = new Player2();
        addObject(p2, 878, 600);
    }
    public void prepareTitle()
    {
        DuelTitle title = new DuelTitle();
        addObject(title, 539, 186);
    }
}
