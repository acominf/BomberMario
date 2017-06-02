import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;  
/**
 * Write a description of class P1Leben here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Leben extends Visualizacion
{
    // Wenn Variable und der Player gegeben sind wird Lebenscounter eingefügt. Ben.Arne. Flo
    int var, player, counter;
    boolean blinken;
    public Leben(int v, int p, int remove, int c, int howmuch) 
    {
        var = v;
        player = p;
        counter = c;
        if(howmuch == 2) var--;
        
        if (remove == 0) blinken = true; 
        if (player == 1) 
        {
            if (var == 3) setImage("leben3re.png");
            else if (var == 2) setImage("leben2re.png");
            else if (var == 1) setImage("leben1re.png");
            else if (var == 0) setImage("playerTransperent.png");
        }
        else if (player == 2)
        {
            if (var == 3) setImage("leben3li.png");
            else if (var == 2) setImage("leben2li.png");
            else if (var == 1) setImage("leben1li.png");
            else if (var == 0) setImage("playerTransperent.png");
        }
        /**
        GreenfootImage img = new GreenfootImage (300, 30);
        img.setColor(Color.RED);
        img.drawString ("Spieler " + player + ": " + var + " Leben", 10, 20);
        setImage(img);
         */
    } 
    
    public int getCounter()
    {
        return counter;
    }
    
    public void act()
    {
        blinken();
    }

    public void blinken()
    {
        
        if (blinken == true)
        {
            if (player == 1 && var == 2)
            {   
                if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
                {
                    setImage("leben2re.png");
                }
                else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
                {
                    setImage("leben3re.png");
                }
                if (counter == 100) 
                {
                    setImage("leben2re.png");
                    blinken = false;
                    counter = 0;
                }
                counter++;
            }
            else if (player == 1 && var == 1)
            {   
                if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
                {
                    setImage("leben1re.png");
                }
                else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
                {
                    setImage("leben2re.png");
                }
                if (counter == 100) 
                {
                    setImage("leben1re.png");
                    blinken = false;
                    counter = 0;
                }
                counter++;
            }
            else if (player == 1 && var == 0)
            {   
                if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
                {
                    setImage("playerTransperent.png");
                }
                else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
                {
                    setImage("leben1re.png");
                }
                if (counter == 100) 
                {
                    setImage("playerTransperent.png");
                    blinken = false;
                    counter = 0;
                }
                counter++;
            }
            if (player == 2 && var == 2)
            {   
                if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
                {
                    setImage("leben2li.png");
                }
                else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
                {
                    setImage("leben3li.png");
                }
                if (counter == 100) 
                {
                    setImage("leben2li.png");
                    blinken = false;
                    counter = 0;
                }
                counter++;
            }
            else if (player == 2 && var == 1)
            {   
                if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
                {
                    setImage("leben1li.png");
                }
                else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
                {
                    setImage("leben2li.png");
                }
                if (counter == 100) 
                {
                    setImage("leben1li.png");
                    blinken = false;
                    counter = 0;
                }
                counter++;
            }
            else if (player == 2 && var == 0)
            {   
                if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
                {
                    setImage("playerTransperent.png");
                }
                else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
                {
                    setImage("leben1li.png");
                }
                if (counter == 100) 
                {
                    setImage("playerTransperent.png");
                    blinken = false;
                    counter = 0;
                }
                counter++;
            }
        }
    }
}
