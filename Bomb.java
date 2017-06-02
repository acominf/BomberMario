import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Bomb here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bomb extends Armas
{
    /**
     * Act - do whatever the Bomb wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int z, radius, besitzer, chaos;

    
    public Bomb(int r, int b, int c)
    {
        radius = r;
        besitzer = b;
        chaos = c;
    }

    public void act() 
    {
        if (chaos == 0)
        {
            z++;
            
            
            Actor feuer = getOneObjectAtOffset(0, 0, AlcanceLlama.class);
            if(feuer != null && z < 95) 
            {
                z = 95;
            }
            
            if (z == 95) 
            {
                
                getWorld().addObject(new Explosion(radius, chaos), getX(), getY());
                if(besitzer == 1)
                {
                    Game gameWorld = (Game) getWorld(); 
                    Player1 player1 = gameWorld.getPlayer1();
                    player1.bombsPlus();//
                }
                
            }

            if (z == 100) 
            {
                getWorld().removeObject(this);
            }

        } 
        else
        {
            z++;
            
            
            Actor feuer = getOneObjectAtOffset(0, 0, AlcanceLlama.class);
            if(feuer != null && z < 95) 
            {
                z = 95;
            }
            

            if (z == 100) 
            {
                getWorld().removeObject(this);
            }

        }
    }
}