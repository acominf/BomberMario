import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Ausweitung here.
 * 
 */
public class AlcanceLlama extends Efecto
{
    int f, chaos;
    boolean player1hit = false, player2hit = false;
    int cEnemigos=3;

    public AlcanceLlama (int c)
    {
        chaos = c;
     
        //setPaintOrder(GameOver.class);
    }

    public void act() 
    
    {
        
        
        //setPaintOrder(GameOver.class);
        
        f++;
        detectObjects();
        if(f == 20) 
        {
            getWorld().removeObject(this);
            return;
        }   
    }    
  
    public void detectObjects()
    
    {
                {
            Actor player1 = getOneObjectAtOffset(0, 0, Player1.class);
            Actor player1_1 = getOneObjectAtOffset(20, 20, Player1.class);
            Actor player1_2 = getOneObjectAtOffset(-20, -20, Player1.class);
            Actor player1_3 = getOneObjectAtOffset(25, 0, Player1.class);
            Actor player1_4 = getOneObjectAtOffset(0, 25, Player1.class);
            Actor player1_5 = getOneObjectAtOffset(-25, 0, Player1.class);
            Actor player1_6 = getOneObjectAtOffset(0, -25, Player1.class);
            Actor player1_7 = getOneObjectAtOffset(-20, 20, Player1.class);
            Actor player1_8 = getOneObjectAtOffset(20, -20, Player1.class);

            if((player1 != null || player1_1 != null || player1_2 != null || player1_3 != null || player1_4 != null || player1_5 != null || player1_6 != null || player1_7 != null || player1_8 != null) && player1hit == false && chaos == 0) 
            {
                Game gameWorld = (Game) getWorld();
                gameWorld.reduceLife(1, 0, 1);  
                player1hit = true;
            }
            Actor actor = getOneIntersectingObject(Enemigo.class);
            if (actor != null) {
                getWorld().removeObject(actor);
                 Game gameWorld = (Game) getWorld();
                gameWorld.enemigoMenos();
            }
            
            Actor block = getOneObjectAtOffset(0, 0, DestruidoB.class);
            if(block != null) 
            {
                getWorld().removeObject(block);
                detectUpgrades();
                
                if (Greenfoot.getRandomNumber(100) < 40)
                {
                    int u = Greenfoot.getRandomNumber(3);
                    Game gameWorld = (Game) getWorld();
                    int k = (getX()-175)/50;
                    int l = (getY()-125)/50;
                    if(k < 0) k = 0;
                    if(k > 14) k = 14;
                    if(l < 0) l = 0;
                    if(l > 14) l = 14;
                    gameWorld.changeObjects(k, l, 0);
                    if (u == 2)
                    {
                        Speed speed = new Speed();
                        getWorld().addObject(speed, getX(), getY()); 
                        k = (getX()-175)/50;
                        l = (getY()-125)/50;
                        if(k < 0) k = 0;
                        if(k > 14) k = 14;
                        if(l < 0) l = 0;
                        if(l > 14) l = 14;
                        gameWorld.changeObjects(k, l, 5);
                    }   
                    else if (u == 1)
                    {
                        Fuerza f = new Fuerza();
                        getWorld().addObject(f, getX(), getY()); 
                        k = (getX()-175)/50;
                        l = (getY()-125)/50;
                        if(k < 0) k = 0;
                        if(k > 14) k = 14;
                        if(l < 0) l = 0;
                        if(l > 14) l = 14;
                        gameWorld.changeObjects(k, l, 6);
                    }
                    else if (u == 0)
                    {
                        ExtraBombe extrabombe = new ExtraBombe();
                        getWorld().addObject(extrabombe, getX(), getY()); 
                        k = (getX()-175)/50;
                        l = (getY()-125)/50;
                        if(k < 0) k = 0;
                        if(k > 14) k = 14;
                        if(l < 0) l = 0;
                        if(l > 14) l = 14;
                        gameWorld.changeObjects(k, l, 2);
                    }
                }
                else if (Greenfoot.getRandomNumber(100) < 10)
                {
                    int v = Greenfoot.getRandomNumber(10);
                    Game gameWorld = (Game) getWorld();
                    if (v > 0)
                    {
                        NuevaVida leben = new NuevaVida();
                        getWorld().addObject(leben, getX(), getY()); 
                        int k = (getX()-175)/50;
                        int l = (getY()-125)/50;
                        if(k < 0) k = 0;
                        if(k > 14) k = 14;
                        if(l < 0) l = 0;
                        if(l > 14) l = 14;
                        gameWorld.changeObjects(k, l, 3);
                    }   
                    /**else
                    {
                        Easteregg easteregg = new Easteregg();
                        getWorld().addObject(easteregg, getX(), getY()); 
                        int k = (getX()-175)/50;
                        int l = (getY()-125)/50;
                        if(k < 0) k = 0;
                        if(k > 14) k = 14;
                        if(l < 0) l = 0;
                        if(l > 14) l = 14;
                        gameWorld.changeObjects(k, l, 4);
                    }*/
                }
            }
        }

        
    }

    private void detectUpgrades()
    {
        
        Actor upgrades = getOneObjectAtOffset(0, 0, Objetos.class);
        Game gameWorld = (Game) getWorld();
        if(upgrades != null) 
        {
            getWorld().removeObject(upgrades);
            int k = (getX()-175)/50;
            int l = (getY()-125)/50;
            if(k < 0) k = 0;
            if(k > 14) k = 14;
            if(l < 0) l = 0;
            if(l > 14) l = 14;
            gameWorld.changeObjects(k, l, 0);
        }
    }
}
