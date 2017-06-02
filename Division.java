import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Aufteilung here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Division extends Actor
{
    /**
     * Act - do whatever the Aufteilung wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    int ene=0;
    int[][] Objekte = new int[15][15];
    public void act() 
    {
        wood();
        Game gameWorld = (Game) getWorld();
        gameWorld.saveObjects(Objekte);
        getWorld().removeObject(this);
    }   

    public void wood()
    {
        int c = 0;
        
        while(c < 100)
        {
            int x = Greenfoot.getRandomNumber(850) + 100;
            int y = Greenfoot.getRandomNumber(850) + 50;
            int a,s;

            
            int k,i,j;
            k = x/100;
            i = x - k*100;
            if(i < 50)
            {
                i = 25 + k*100;
            }
            else
            {
                i = 75 + k*100;
            }
            k = y/100;
            j = y - k*100;
            if(j < 50)
            {
                j = 25 + k*100;
            }
            else
            {
                j = 75 + k*100;
            }
            
            
            Actor plazierbar = getOneObjectAtOffset(i, j, Bloque.class);

            if (i <= 250 && j <= 200 || i >= 800 && j >= 750)
            {
            }else if (plazierbar == null)
            {
               int asds = Greenfoot.getRandomNumber(3);
  
                a = (i-175)/50;
                s = (j-125)/50;
                 if(asds==1){
                            switch(ene){
                                case 1:
                                    Enemigo theEnemigo1 = new enemigo1(); 
                                    getWorld().addObject(theEnemigo1, i, j);
                                    Objekte[a][s]=71;
                                break;
                                case 2:
                                    Enemigo theEnemigo2 = new enemigo2(); 
                                    getWorld().addObject(theEnemigo2, i ,j);
                                    Objekte[a][s]=72;
                                break;
                                case 3:
                                    Enemigo theEnemigo3 = new enemigo3(); 
                                   getWorld().addObject(theEnemigo3,  i ,j);
                                   Objekte[a][s]=73;
                                break;
                    }
                            
                            
                            ene++;
                        }else{
                        
                    Fragil wood = new Fragil();
                    getWorld().addObject(wood, i, j); 
                    c++;
                    a = (i-175)/50;
                    s = (j-125)/50;
                    Objekte[a][s] = 1;
                        
                        
                 }
                
                
                
                

            }
        }
    }
}
