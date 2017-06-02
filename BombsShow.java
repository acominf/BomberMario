import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.awt.*;  
/**
 * Write a description of class SpeedShow here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BombsShow extends Visualizacion
{
    int player, var;
    /**
     * Act - do whatever the SpeedShow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */

    public BombsShow(int v, int p)
    {
        player = p;
        var = v;

        GreenfootImage img = new GreenfootImage (90, 30);
        //img.setColor(Color.RED);
        img.drawString ("Bomben: " + var, 10, 20);
        setImage(img);
    }
}
