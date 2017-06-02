import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 
public class Game extends World
{
    //intern festlegen was thePlayer überhaupt ist. Lenni 
    private Player2 thePlayer2;
    private Player1 thePlayer1;
    private Leben theAnzeige1;
    private Leben theAnzeige2;
    private SpeedShow theSpeed1;
    private SpeedShow theSpeed2;
    private BombsShow theBombs1;
    private BombsShow theBombs2;
    private RadiusShow theRadius1;
    private RadiusShow theRadius2;
    int x1, x2, y1, y2, counter1 = 0, counter2 = 0, zeitpunkt, Verletzung1, Verletzung2, Anzeigecounter1 = 0, Anzeigecounter2 = 0;
    int bombs1, bombs2, radius1, radius2, speed1, speed2;
    int p1Leben = 3, p2Leben = 3; // jeder Spieler hat 3 Leben. Flo
    int[][] Objekte = new int[15][15];
    /**
     * Constructor for objects of class Game.
     * 
     
    public Game(int z, int[][] o, int V1, int V2, int c1, int c2)
    {    
        super(1050, 900, 1); 
        setPaintOrder(GameOver.class); // GameOver Bild wird immer als oberstes angezeigt. Flo
        
        zeitpunkt = z;
        Objekte = o;
        Anzeigecounter1 = c1;
        Anzeigecounter2 = c2;
        Verletzung1 = V1;
        Verletzung2 = 2;
        
        prepare();
        wall();
    }

    public void act()
    {
        // korregiert Bug, dass Game auf Spieler zugreift, obwohl dieser nicht in der Welt ist. Flo
        if (p1Leben > 0 && p2Leben > 0)
        {
            thePlayer1.information1Game();
            thePlayer2.information2Game();
        }
        if (counter1 > 0) counter1--;
        if (counter2 > 0) counter2--;
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
        
         if(Verletzung2 == 1)
        {
            reduceLife(2, Anzeigecounter2, 1);
            Verletzung2 = 0;
        }
        else if(Verletzung2 == 2)
        {
            reduceLife(2, Anzeigecounter2, 2);
            Verletzung2 = 0;
        }
    }

    private void prepare()
    {
        // Spieler hinzufügen
        thePlayer2 = new Player2(0);//einen bestimmten Player2 erstellen. Lenni
        addObject(thePlayer2, 174, 126);

        thePlayer1 = new Player1(0); // einen bestimmten Player1 erstellen. Lenni
        addObject(thePlayer1, 873, 823);

        //thePlayer2.setLocation(174, 126);
        if(zeitpunkt == 0)
        {
           Aufteilung aufteilung = new Aufteilung();
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
                        Wood wood = new Wood();
                        addObject(wood, 175+i*50,  125+j*50); 
                    }
                }
            }
        }

        // eine bestimmte Lebensanzeige hinzufügen. Flo
        theAnzeige1 = new Leben (3, 1, 0, 0, 0);
        addObject(theAnzeige1, 858, 30);
        theAnzeige2 = new Leben (3, 2, 0, 0, 0);
        addObject(theAnzeige2, 194, 30);

        // eine bestimmte Speedanzeige hinzufügen. Flo
        theSpeed1 = new SpeedShow (1, 1);
        addObject(theSpeed1, 990, 120);
        theSpeed2 = new SpeedShow (1, 2);
        addObject(theSpeed2, 50, 120);
        // eine bestimmte Radiusanzeige hinzufügen. Flo
        theRadius1 = new RadiusShow (1, 1);
        addObject(theRadius1, 990, 160);
        theRadius2 = new RadiusShow (1, 2);
        addObject(theRadius2, 50, 160);
        // eine bestimmte Bombsanzeige hinzufügen. Flo
        theBombs1 = new BombsShow (1, 1);
        addObject(theBombs1, 990, 200);
        theBombs2 = new BombsShow (1, 2);
        addObject(theBombs2, 50, 200);
    }

    //gibt eine Referenz zu Player2 zurück. Lenni
    public Player2 getPlayer2()
    {
        return thePlayer2;
    }

    //gibt eine Referenz zu Player1 zurück. Lenni
    public Player1 getPlayer1()
    {
        return thePlayer1;
    }    

    public void saveInformation1(int x, int y, int b, int s, int r) // Informationen von Player empfangen. Lenni
    {
        x1 = x;
        y1 = y;
        bombs1 = b;
        speed1 = s - 1;
        radius1 = r;
    }

    public void saveInformation2(int x, int y, int b, int s, int r) // Informationen von Player empfangen. Lenni
    {
        x2 = x;
        y2 = y;
        bombs2 = b;
        speed2 = s - 1;
        radius2 = r;
    }

    public void anzeige()
    {
        removeObject(theSpeed1);
        theSpeed1 = new SpeedShow (speed1, 1);
        addObject(theSpeed1, 990, 120);
        removeObject(theSpeed2);
        theSpeed2 = new SpeedShow (speed2, 2);
        addObject(theSpeed2, 50, 120);

        removeObject(theBombs1);
        theBombs1 = new BombsShow (bombs1, 1);
        addObject(theBombs1, 990, 160);
        removeObject(theBombs2);
        theBombs2 = new BombsShow (bombs2, 2);
        addObject(theBombs2, 50, 160);

        removeObject(theRadius1);
        theRadius1 = new RadiusShow (radius1, 1);
        addObject(theRadius1, 990, 200);
        removeObject(theRadius2);
        theRadius2 = new RadiusShow (radius2, 2);
        addObject(theRadius2, 50, 200);
    }

    public void chaos()
    {
        Greenfoot.setWorld(new Chaos(this, x1, x2, y1, y2, p1Leben, p2Leben, Objekte)); // Übergehen in Chaos Welt. Lenni & Flo
    } 

    public void addLife(int player)
    {
        // Leben hinzufügen, wenn Player über ein Power-Up läuft und dieses einsammelt. Flo
        if (player == 1 && p1Leben < 3) 
        {
            p1Leben++; 
            removeObject(theAnzeige1);
            // Lebensanzeige hinzufügen. Flo
            theAnzeige1 = new Leben (p1Leben, player, 1, 0, 0);
            addObject(theAnzeige1, 858, 30);
        }
        else if (player == 2 && p2Leben < 3) 
        {
            p2Leben++; 
            removeObject(theAnzeige2);
            // Lebensanzeige hinzufügen. Flo
            theAnzeige2 = new Leben (p2Leben, player, 1, 0, 0);
            addObject(theAnzeige2, 194, 30);
        }
    }

    public void reduceLife(int player, int c, int howmuch)
    {
        // Lebensanzeige: Game speichert Leben der Spieler und kümmert sich um die komplette Lebensanzeige. Flo.Ben.Arne
        if (player == 1 && counter1 == 0) //Wenn zwei Bomben einen Spieler geleizeitig treffen, wird diesem nur ein Leben abgezogen. Flo
        {
            p1Leben--; // Leben abziehen. Flo.Ben.Arne
            removeObject(theAnzeige1);
            // Lebensanzeige hinzufügen. Flo
            theAnzeige1 = new Leben (p1Leben, player, 0, c, howmuch);
            addObject(theAnzeige1, 858, 30);
            thePlayer1.verletzen();
            if (p1Leben == 0)
            {
                GameOver gameOver = new GameOver(2); // übermittelt, welcher Spieler gewonnen hat. Flo.Ben.Arne
                addObject(gameOver, 525, 450); // fügt GameOver Screen hinzu. Flo
            }
            counter1 = 20;
        }        
        else if (player == 2 && counter2 == 0) 
        {
            p2Leben--; // Leben abziehen. Flo.Ben.Arne
            removeObject(theAnzeige2);
            // Lebensanzeige hinzufügen. Flo.Ben.Arne
            theAnzeige2 = new Leben (p2Leben, player, 0, c, howmuch);
            addObject(theAnzeige2, 194, 30); 
            thePlayer2.verletzen();
            if (p2Leben == 0)
            {
                GameOver gameOver = new GameOver(1); // übermittelt, welcher Spieler gewonnen hat. Flo.Ben.Arne
                addObject(gameOver, 525, 450); // fügt GameOver Screen hinzu. Flo
            }
            counter2 = 20;
        }
    }

    public void saveObjects(int[][] o)
    {
        Objekte = o;
    }
    
    private void wall()
    {
        // erstellt die obere Reihe der Mauer. Flo
        for (int i = 125; i<926; i = i+50)
        {
            Stein stein = new Stein();
            addObject(stein, i, 75);
        }
        // erstellt die untere Reihe der Mauer. Flo
        for (int i = 125; i<926; i = i+50)
        {
            Stein stein = new Stein();
            addObject(stein, i, 875);
        }
        // erstellt die linke Reihe der Mauer. Flo
        for (int j = 75; j<826; j=j+50)
        {
            Stein stein = new Stein();
            addObject(stein, 125, j);
        }
        // erstellt die rechte Reihe der Mauer. Flo
        for (int j = 75; j<826; j=j+50)
        {
            Stein stein = new Stein();
            addObject(stein, 925, j);
        }
        // erstellt die innere Unterteilung. Lenni
        for (int j = 175; j<776; j=j+100)
        {
            for (int i = 225; i<826; i=i+100)
            {
                Stein stein = new Stein();
                addObject(stein, i, j);
            }
        }
    }
}
