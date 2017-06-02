import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;  
/**
 * Write a description of class SpeedShow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RadiusShow extends Visualizacion
{
    int player, var;
    /**
     * 
     */

    public RadiusShow(int v, int p)
    {
        player = p;
        var = v;

        GreenfootImage img = new GreenfootImage (70, 30);
        //img.setColor(Color.RED);
        img.drawString ("Radius: " + var, 10, 20);
        setImage(img);
    }
}
