import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Eplosion here.
 * 
 * @author (Bryan Ortiz) 
 * @version (11/2/17)
 */
public class Fire extends Actor
{
    private GreenfootImage image1, image2, image3, image4, image5, image6, image7, image8, image9, image10, image11, image12 ;
    
    /**
     * Act - do whatever the Eplosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        int alpha = getImage().getTransparency();
        if (alpha > 10)
        {
         getImage().setTransparency(alpha - 15);
        }
         else
        {
          getWorld().removeObject(this);
        }
        setImages();
    }    
    
    /**
     * 
     */
    public Fire()
    {
       Greenfoot.playSound("explosion.wav");
       
     image1 = new GreenfootImage("1.gif");
     image2 = new GreenfootImage("2.gif");
     image3 = new GreenfootImage("3.gif");
     image4 = new GreenfootImage("4.gif");
     image5 = new GreenfootImage("5.gif");
     image6 = new GreenfootImage("6.gif");
     image7 = new GreenfootImage("7.gif");
     image8 = new GreenfootImage("8.gif");
     image9 = new GreenfootImage("9.gif");
     image10 = new GreenfootImage("10.gif");
     image11 = new GreenfootImage("11.gif");
     image12 = new GreenfootImage("12.gif");
    }
    
    /**
     * 
     */
    private void setImages()
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
       else if (getImage() == image5)
       {
        setImage(image6);   
       }
      else if (getImage() == image6)
      {
       setImage(image7);   
      }
       else if (getImage() == image7)
      {
       setImage(image8);    
      }
      else if (getImage() == image8)
      {
          setImage(image9);
      }
      else if (getImage() == image9)
      {
        setImage(image10);
      }
      else if (getImage() == image10)
      {
          setImage(image11);
        }
        else if (getImage() == image11)
        {
            setImage(image12);
        }
      else 
      {
       setImage(image1);   
      }
    }
}
