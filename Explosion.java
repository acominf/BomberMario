 

import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Explosion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Explosion extends Efecto
{
    /**
     * Act - do whatever the Explosion wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int h;
    int radius, chaos;
    
    
    public Explosion(int r, int c)
    {
        radius = r;
        chaos = c;
    }
    
    public void act() 
    {
        h++;
        radius();
        
        getWorld().addObject(new AlcanceLlama(chaos), getX(), getY()); // Spieler wird auch entfernt, wenn er auf dem Platz der Bombe stehen bleibt. Flo
        if (h == 1) 
        {
            getWorld().removeObject(this);
            return;
        }

    }    

    public void radius()
    
    {
        for(int i = 1; i <= radius; i++)
        
        {
            Actor Unzerstörbar = getOneObjectAtOffset(0, -50*i, Construido.class);
            Actor Zerstörbar = getOneObjectAtOffset(0, -50*i, DestruidoB.class);
            
            if(Unzerstörbar != null) 
            {
                i = radius +1;
            }
            else if(Zerstörbar != null)
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX(), getY()-50*i);
                i = radius +1;
            }
            else
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX(), getY()-50*i);
            }
        }
        for(int i = 1; i <= radius; i++)
        
        {
            Actor Unzerstörbar = getOneObjectAtOffset(0, 50*i, Construido.class);
            Actor Zerstörbar = getOneObjectAtOffset(0, 50*i, DestruidoB.class);
            
            if(Unzerstörbar != null) 
            {
                i = radius +1;
            }
            else if(Zerstörbar != null)
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX(), getY()+50*i);
                i = radius +1;
            }
            else
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX(), getY()+50*i);
            }
        }
        for(int i = 1; i <= radius; i++)
        
        {
            Actor Unzerstörbar = getOneObjectAtOffset(-50*i, 0, Construido.class);
            Actor Zerstörbar = getOneObjectAtOffset(-50*i, 0, DestruidoB.class);
            
            if(Unzerstörbar != null) 
            {
                i = radius +1;
            }
            else if(Zerstörbar != null)
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX()-50*i, getY());
                i = radius +1;
            }
            else
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX()-50*i, getY());
            }
        }
        for(int i = 1; i <= radius; i++)
        
        {
            Actor Unzerstörbar = getOneObjectAtOffset(50*i, 0, Construido.class);
            Actor Zerstörbar = getOneObjectAtOffset(50*i, 0, DestruidoB.class);
            
            if(Unzerstörbar != null) 
            {
                i = radius +1;
            }
            else if(Zerstörbar != null)
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX()+50*i, getY());
                i = radius +1;
            }
            else
            {
                getWorld().addObject(new AlcanceLlama(chaos), getX()+50*i, getY());
            }
        }
    }
}