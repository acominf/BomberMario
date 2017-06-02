 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends Actor
{
    int mx = 0, my = 0, mc = 0;
    /**
     * Act - do whatever the GameOver wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public GameOver(int player)
    {
        int spieler = player;

        if (spieler == 1)
        {
            setImage("GameOver1.jpg");
        }
        if (spieler == 2)
        {
            setImage("GameOver2.jpg");
        }
    }

    public void act() 
    {
        getWorld().removeObjects(getWorld().getObjects(Players.class));

        if (restart() == true)
        {
            Greenfoot.setWorld(new Game(0,null,0,0,0,0,3,3,1,1,1,1,2,2,873,823,174,126)); // neue Welt (Game) wird aufgerufen. Flo
            getWorld().removeObject(this);  
        }
    }    

    public boolean restart()
    {
        MouseInfo mouse = Greenfoot.getMouseInfo(); 
        if (mouse!=null)
        {  
            mx = mouse.getX();  
            my = mouse.getY(); 
            mc = mouse.getClickCount();  
        }  
        
        if (mx > 340 && mx < 720 && my > 600 && my < 755 && mc >= 1)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}