import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * The Explosion caused by dropping a JDAM bomb
 * 
 * @author Reuben Gan 
 * @version 10/30/17
 */
public class EndJDAM extends Actor
{
    public GreenfootImage image1, image2, image3, image4, image5, image6;

    public EndJDAM()
    {
        Greenfoot.playSound("explosion.wav");
        image1 = new GreenfootImage("Ex1.png");
        image2 = new GreenfootImage("Ex2.png");
        image3 = new GreenfootImage("Ex3.png");
        image4 = new GreenfootImage("Ex4.png");
        image5 = new GreenfootImage("Ex5.png");
        image6 = new GreenfootImage("ExFinal.png");
        setImage(image1);
    }

    /**
     * Act - do whatever the EndJDAM wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (getImage() == image1) 
        {
            setImage(image2);
        }
        
        else if (getImage() == image2)
        {
            setImage(image3);
        }

        else if (getImage() == image3)
        {
            setImage(image4);
        }

        else if (getImage() == image4)
        {
            setImage(image5);
        }

        else
        {
            setImage(image6);
        }

        int alpha = getImage().getTransparency();
        if (alpha > 4)
        {
            getImage().setTransparency(alpha - 4);
        }
        else
        {
            getWorld().removeObject(this);
        }
    }    
}
