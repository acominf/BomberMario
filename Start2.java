import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Start here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Start2 extends Actor
{
    int mx = 0, my = 0, mc = 0;
    /**
     * Act - do whatever the Start wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if (startButton() == true)
        {
            Greenfoot.setWorld(new Game(0,null,0,0,0,0,3,3,1,1,1,1,2,2,873,823,174,126)); 
            getWorld().removeObject(this);  
        }
    }    

    public boolean startButton()
    {
        
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse!=null)
        {  
            mx = mouse.getX();  
            my = mouse.getY();  
            mc = mouse.getClickCount(); 
        }  
        if (mx > 400 && mx < 600 && my > 105 && my < 165 && mc >= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}