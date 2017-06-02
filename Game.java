import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Game extends World
{
    
   
    private Player1 thePlayer1;
    private Leben theAnzeige1;
    Enemigo heEnemigo1,theEnemigo2,theEnemigo3;
    
    private SpeedShow theSpeed1;
    
    private BombsShow theBombs1;
    
    private RadiusShow theRadius1;
   
    int x1, y1, counter1 = 0, zeitpunkt, Verletzung1, Anzeigecounter1 = 0;
    int bombs1, radius1, speed1;
    int p1Leben; 
    int[][] Objekte = new int[15][15];
    int enemigo=3;
    
    public Player1 getPlayer(){
        return thePlayer1;
    }

    public Game(int z, int[][] o, int V1, int V2, int c1, int c2, int pl1, int pl2, int b1, int b2, int r1, int r2, int s1, int s2, int x1z, int y1z, int x2z, int y2z)
    {    
        super(1050, 900, 1); 
        setPaintOrder(GameOver.class); //
        
        zeitpunkt = z;
        Objekte = o;
        Anzeigecounter1 = c1;
        
        Verletzung1 = V1;
        
        p1Leben = pl1;
        
        bombs1 = b1;
        
        radius1 = r1;
        
        speed1 = s1;
        
        x1 = x1z;
       
        y1 = y1z;
        

        prepare();
        wall();
        
    }

    public void act()
    {
        
        if (p1Leben > 0)
        {
            thePlayer1.information1Game(); 
        }
        
        if (counter1 > 0) counter1--;
      
        
        anzeige();

       
        if(Verletzung1 == 1)
        {
            reduceLife(1, Anzeigecounter1, 1);
            Verletzung1 = 0;
        }
        else if(Verletzung1 == 2)
        {
            reduceLife(1, Anzeigecounter1, 2);
            Verletzung1 = 0;
        }
        
       
    }

    private void prepare()
    {
        

        thePlayer1 = new Player1(0, counter1, bombs1, radius1, speed1);        
        addObject(thePlayer1, 180, 130);


        
       if(zeitpunkt == 0)
        {
                        Division aufteilung = new Division();
            addObject(aufteilung, 0, 0);
            
        }
        else
        {
            for(int i = 0; i < 15; i++)
            {
                for(int j = 0; j < 15; j++)
                {
                    if(Objekte[i][j] == 1)
                    {
                        Fragil wood = new Fragil();
                        addObject(wood, 175+i*50,  125+j*50); 
                    }
                    else if(Objekte[i][j] == 2)
                    {
                        ExtraBombe extrabombe = new ExtraBombe();
                        addObject(extrabombe,175+i*50, 125+j*50); 
                    }
                    else if(Objekte[i][j] == 3)
                    {
                        //NuevaVida vida = new NuevaVida();
                        //addObject(vida, 175+i*50, 125+j*50); 
                    }
                    else if(Objekte[i][j] == 5)
                    {
                        Speed speed = new Speed();
                        addObject(speed, 175+i*50, 125+j*50); 
                    }
                    else if(Objekte[i][j] == 6)
                    {
                        Fuerza f = new Fuerza();
                        addObject(f, 175+i*50, 125+j*50); 
                    }
                    else if(Objekte[i][j] > 70)
                    {
                        switch(Objekte[i][j]){
                                case 71:
                                    Enemigo theEnemigo1 = new enemigo1(); 
                                    addObject(theEnemigo1,175+i*50, 125+j*50);
                                break;
                                case 72:
                                    Enemigo theEnemigo2 = new enemigo2(); 
                                    addObject(theEnemigo2,175+i*50, 125+j*50);
                                break;
                                case 73:
                                    Enemigo theEnemigo3 = new enemigo3(); 
                                   addObject(theEnemigo3,175+i*50, 125+j*50);
                                break;
                        }
                    }
                }
            }
        }

        
        theAnzeige1 = new Leben (p1Leben, 1, 0, Anzeigecounter1, 0);
        addObject(theAnzeige1, 858, 30);
        

        
        theSpeed1 = new SpeedShow (speed1, 1);
        addObject(theSpeed1, 990, 120);
        
       
        theRadius1 = new RadiusShow (radius1, 1);
        addObject(theRadius1, 990, 160);
        
        
        theBombs1 = new BombsShow (bombs1, 1);
        addObject(theBombs1, 990, 200);      
        
    }
    public Player1 getPlayer1()
    {
        return thePlayer1;
    }    
    public void enemigoMenos(){
        enemigo--;
        if(enemigo==0){
        theAnzeige1 = new Leben (p1Leben, 1, 0, 0, 0);
            addObject(theAnzeige1, 858, 30);
            thePlayer1.verletzen();
            p1Leben=0;
            if (p1Leben == 0)
            {
                GameOver gameOver = new GameOver(2); // 
                addObject(gameOver, 525, 450); 
            }}
    }
    public void saveInformation1(int x, int y, int b, int s, int r) 
    {
        x1 = x;
        y1 = y;
        bombs1 = b;
        speed1 = s;
        radius1 = r;
    }

    

    public void anzeige()
    {
        removeObject(theSpeed1);
        theSpeed1 = new SpeedShow (speed1, 1);
        addObject(theSpeed1, 990, 120);
        

        removeObject(theBombs1);
        theBombs1 = new BombsShow (bombs1, 1);
        addObject(theBombs1, 990, 160);
        

        removeObject(theRadius1);
        theRadius1 = new RadiusShow (radius1, 1);
        addObject(theRadius1, 990, 200);
        
    }

    /*public void chaos()// 
    {
        Greenfoot.setWorld(new Chaos(this, x1,  y1, p1Leben, Objekte, bombs1, radius1, speed1)); 
    }*/ 

    public void addLife(int player)
    {
               if (player == 1 && p1Leben < 3) 
        {
            p1Leben++; 
            removeObject(theAnzeige1);
            
            theAnzeige1 = new Leben (p1Leben, player, 1, 0, 0);
            addObject(theAnzeige1, 858, 30);
        }
        
       
    }

    public void reduceLife(int player, int c, int howmuch)
    {
                if (player == 1 && counter1 == 0) //
        {
            p1Leben--; 
            if(howmuch == 2) p1Leben--;
            removeObject(theAnzeige1);
            
            theAnzeige1 = new Leben (p1Leben, player, 0, c, howmuch);
            addObject(theAnzeige1, 858, 30);
            thePlayer1.verletzen();
            if (p1Leben == 0)
            {
                GameOver gameOver = new GameOver(2); // 
                addObject(gameOver, 525, 450); 
            }
            
            counter1 = 20;
        }        
        
    }
    
    
    
    public void saveObjects(int[][] o)
    {
        Objekte = o;
    }

    public void changeObjects(int x, int y, int n)
    {
        Objekte[x][y] = n;
    }

    private void wall()
    {
        
       for (int i = 125; i<926; i = i+50)
        {
            Solido construido = new Solido();
            addObject(construido, i, 75);
        }
        
        for (int i = 125; i<926; i = i+50)
        {
            Solido construido = new Solido();
            addObject(construido, i, 875);
        }
        
        for (int j = 75; j<826; j=j+50)
        {
            Solido construido = new Solido();
            addObject(construido, 125, j);
        }
        
        for (int j = 75; j<826; j=j+50)
        {
            Solido construido = new Solido();
            addObject(construido, 925, j);
        }
       
        for (int j = 175; j<776; j=j+100)
        {
            for (int i = 225; i<826; i=i+100)
            {
                Solido construido = new Solido();
                addObject(construido, i, j);
            }
        }
    }
}
