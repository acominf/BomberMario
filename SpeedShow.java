import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;  
/**
 * Write a description of class SpeedShow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class SpeedShow extends Visualizacion
{
    int player, var;
    /**
     * Act - do whatever the SpeedShow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public SpeedShow(int v, int p)
    {
        player = p;
        var = v - 1;

        GreenfootImage img = new GreenfootImage (70, 30);
        //img.setColor(Color.RED);
        img.drawString ("Speed: " + var, 10, 20);
        setImage(img);
    }
}
