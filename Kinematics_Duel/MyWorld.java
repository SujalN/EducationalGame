import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Initialize the world with the background, dimensions and the objects
 * @author Avi Patel
 * @author Josh Koh
 * @author Tariq Rahman
 * @author Sujal Nahata   
 * @version 9/22/19
 */
public class MyWorld extends World
{
    int gWidth = 32;
    int gHeight = 360;
    
    int setX[] = {200, 300, 400, 500};
    boolean gameover = false;
    
    public static final Vector GRAVITY = new Vector(0.0, 0.2);
    
    /**
     * Contstructer that intitializes objects for MyWorld
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
    /**
     * Create Player1 object and add to the world
     */
    public void preparePlayer1()
    {
        Player1 p1 = new Player1();
        addObject(p1, 200, 600);
    }
    /**
     * Create Player2 object and add to world
     */
    public void preparePlayer2()
    {
        Player2 p2 = new Player2();
        addObject(p2, 878, 600);
    }
    /**
     * Create DuelTitle object and add to world
     */
    public void prepareTitle()
    {
        DuelTitle title = new DuelTitle();
        addObject(title, 539, 186);
    }
}
