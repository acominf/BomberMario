import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class Player1 here.
 * 
 * @version (a version number or a date)
 */
public class Player1 extends Players
{
    private int bombs = 1, radius = 1, speed = 2, x, y, z = 0;
    public int chaos, counter;
    boolean blinken = false;
    public boolean getblinken(){
        return blinken;
    }
    public Player1(int world, int c, int b, int r, int s)
    {
        
        chaos = world;
        
        counter = c;
        bombs = b;
        radius = r;
        speed = s;
        
        
        if (chaos == 1)
        {
            bombs = 3;
            radius = 4;
            speed = 4;
        }
    }

    public void act()
    {
        
        if (chaos == 1) 
            movementChaos();
        else
       
            movementNormal();
            
        newBomb();
        
        if(chaos != 1) 
            upgrade();
            
        blinken(); 
    }

    /**
     * legt eine Bombe, sobald Leertaste (space) gedrückt wird und bombs größer null ist.
     */
    public void newBomb()
    {
                if(z > 0)
        {
            z--;
        }

        if (Greenfoot.isKeyDown("a") && (bombs > 0) && z == 0)
        {
            
            int k,x,y;
            k = getX()/100;
            x = getX()- k*100;
            if(x < 50)
            {
                x = 25 + k*100;
            }
            else
            {
                x = 75 + k*100;
            }
            k = getY()/100;
            y = getY()- k*100;
            if(y < 50)
            {
                y = 25 + k*100;
            }
            else
            {
                y = 75 + k*100;
            }

            
            Bomb bomb = new Bomb(radius, 1, chaos);

            getWorld().addObject( bomb, x, y );
            bombs--; 

            z = ((41/134)*(speed^3)) - ((263/134)*(speed^2)) - (4*speed) + (2573/67);
        }
    }

    public void verletzen()
    {
        
        blinken = true;
        if (radius % 2 != 0)  radius++;
        radius = radius/2;
        if (speed % 2 != 0)  speed++;
        speed = speed/2 +1;
        if(speed < 2) speed = 2;
        if (bombs % 2 != 0)  bombs++;
        bombs = bombs/2;
    }

    
    public void bombsPlus()
    {
        bombs++;
    }

    public void information1Game()
    {
        Game gameWorld = (Game) getWorld(); 
        gameWorld.saveInformation1(getX(), getY(), bombs, speed, radius); //
    }

    public void upgrade()
    {
        Actor Speed = getOneObjectAtOffset(0, 0, Speed.class);
        Game gameWorld = (Game) getWorld();
        if (Speed != null) 
        { 
 
            if(speed < 5)
            {
                speed++;
            }
            getWorld().removeObject(Speed);
            int k = (getX()-175)/50;
            int l = (getY()-125)/50;
            if(k < 0) k = 0;
            if(k > 14) k = 14;
            if(l < 0) l = 0;
            if(l > 14) l = 14;
            gameWorld.changeObjects(k, l, 0);
        } 

        
        Actor Radius = getOneObjectAtOffset(0, 0, Fuerza.class);
        if (Radius != null) 
        { 
            
            if(radius < 15)
            {
                radius++;
            }
            getWorld().removeObject(Radius);
            int k = (getX()-175)/50;
            int l = (getY()-125)/50;
            if(k < 0) k = 0;
            if(k > 14) k = 14;
            if(l < 0) l = 0;
            if(l > 14) l = 14;
            gameWorld.changeObjects(k, l, 0);
        }

        
        Actor ExtraBombe = getOneObjectAtOffset(0, 0, ExtraBombe.class);
        if (ExtraBombe != null) 
        { 
            if(bombs < 15)
            {
                bombs++;
            }
            getWorld().removeObject(ExtraBombe);
            int k = (getX()-175)/50;
            int l = (getY()-125)/50;
            if(k < 0) k = 0;
            if(k > 14) k = 14;
            if(l < 0) l = 0;
            if(l > 14) l = 14;
            gameWorld.changeObjects(k, l, 0);
        }

       
        
        Actor NewLeben = getOneObjectAtOffset(0, 0, MasVida.class);
        if (NewLeben != null) 
        {
            gameWorld.addLife(1);
            getWorld().removeObject(NewLeben);
            int k = (getX()-175)/50;
            int l = (getY()-125)/50;
            if(k < 0) k = 0;
            if(k > 14) k = 14;
            if(l < 0) l = 0;
            if(l > 14) l = 14;
            gameWorld.changeObjects(k, l, 0);
        } 
    }
    
    public void blinken()
    {
        
        if (blinken == true)
        {
            if (counter == 10 || counter == 20 || counter == 30 || counter == 40 || counter == 50 || counter == 60 || counter == 70 || counter == 80 || counter == 90)
            {
                setImage("mariobros50x50.png");
            }
            else if (counter == 5 || counter == 15 || counter == 25 || counter == 35 || counter == 45 || counter == 55 || counter == 65 || counter == 75 || counter == 85 || counter == 95)
            {
                setImage("playerTransperent.png");
            }
            if (counter == 100) 
            {
                setImage("mariobros50x50.png");
                blinken = false;
                counter = 0;
            }
            counter++;
        }
    }

    /**
     * sorgt für die Bewegung des Players.
     */
    public void movementNormal()
    {
        
        Actor ObenRechts = getOneObjectAtOffset(11, -20, Bloque.class);
        Actor ObenLinks = getOneObjectAtOffset(-11, -20, Bloque.class);
        Actor UntenRechts = getOneObjectAtOffset(11, 20, Bloque.class);
        Actor UntenLinks = getOneObjectAtOffset(-11, 20, Bloque.class);
        Actor LinksOben = getOneObjectAtOffset(-20, -11, Bloque.class);
        Actor LinksUnten = getOneObjectAtOffset(-20, 11, Bloque.class);
        Actor RechtsOben = getOneObjectAtOffset(20, -11, Bloque.class);
        Actor RechtsUnten = getOneObjectAtOffset(20, 11, Bloque.class);
        
        
        Actor BombeObenRechts = getOneObjectAtOffset(11, -35, Bomb.class);
        Actor BombeObenLinks = getOneObjectAtOffset(-11, -35, Bomb.class);
        Actor BombeUntenRechts = getOneObjectAtOffset(11, 35, Bomb.class);
        Actor BombeUntenLinks = getOneObjectAtOffset(-11, 35, Bomb.class);
        Actor BombeLinksOben = getOneObjectAtOffset(-35, -11, Bomb.class);
        Actor BombeLinksUnten = getOneObjectAtOffset(-35, 11, Bomb.class);
        Actor BombeRechtsOben = getOneObjectAtOffset(35, -11, Bomb.class);
        Actor BombeRechtsUnten = getOneObjectAtOffset(35, 11, Bomb.class);
        Actor BombeMitte = getOneObjectAtOffset(0, 0, Bomb.class);
        
        if (Greenfoot.isKeyDown("up") && ObenRechts == null && ObenLinks == null &&  ((BombeObenRechts == null && BombeObenLinks == null) == false && (BombeMitte == null) == true) == false)//falls über einem kein Block ist. Lenni
        {
            setRotation(269);
            move(speed);

            
            if(RechtsOben != null)
            {
                setLocation(getX()-1,getY());
            }
            else if(LinksOben != null)
            {
                setLocation(getX()+1,getY());
            }
            else if(BombeRechtsOben != null) 
            {
                setLocation(getX()-1,getY());
            }
            else if(BombeLinksOben != null )
            {
                setLocation(getX()+1,getY());
            }
            setRotation(0); 
        }
        else if (Greenfoot.isKeyDown("down") && UntenRechts == null && UntenLinks == null && ((BombeUntenRechts == null && BombeUntenLinks == null) == false && (BombeMitte == null) == true) == false)
        {
            setRotation(89);
            move(speed);

            if(RechtsUnten != null)
            {
                setLocation(getX()-1,getY());
            }
            else if(LinksUnten != null)
            {
                setLocation(getX()+1,getY());
            }
             else if(BombeRechtsUnten != null) 
            {
                setLocation(getX()-1,getY());
            }
            else if(BombeLinksUnten != null)
            {
                setLocation(getX()+1,getY());
            }
            setRotation(0);
        }
       else if (Greenfoot.isKeyDown("left") && LinksOben == null && LinksUnten == null && ((BombeLinksOben == null && BombeLinksUnten == null) == false && (BombeMitte == null) == true) == false)
        {
            setRotation(179);
            move(speed);
            if(ObenLinks != null)
            {
                setLocation(getX(),getY()+1);
            }
            else if(UntenLinks != null)
            {
                setLocation(getX(),getY()-1);
            }
              else if(BombeObenLinks != null) 
            {
                setLocation(getX(),getY()+1);
            }
            else if(BombeUntenLinks != null)
            {
                setLocation(getX(),getY()-1);
            }
            setRotation(0);
        }
        else if (Greenfoot.isKeyDown("right") && RechtsOben == null && RechtsUnten == null && ((BombeRechtsOben == null && BombeRechtsUnten == null) == false && (BombeMitte == null) == true) == false)
        {
            setRotation(0);
            move(speed);
            if(ObenRechts != null)
            {
                setLocation(getX(),getY()+1);
            }
            else if(UntenRechts != null)
            {
                setLocation(getX(),getY()-1);
            }
             else if(BombeObenRechts != null)             {
                setLocation(getX(),getY()+1);
            }
            else if(BombeUntenRechts != null)
            {
                setLocation(getX(),getY()-1);
            }
        }
    }

    /**
     * sorgt für die Bewegung des Players. Auch diagonal möglich, da wir uns in "Chaos" befinden. Flo
     */
    public void movementChaos()
    {
        
        Actor ObenRechts = getOneObjectAtOffset(11, -20, Bloque.class);
        Actor ObenLinks = getOneObjectAtOffset(-11, -20, Bloque.class);
        Actor UntenRechts = getOneObjectAtOffset(11, 20, Bloque.class);
        Actor UntenLinks = getOneObjectAtOffset(-11, 20, Bloque.class);
        Actor LinksOben = getOneObjectAtOffset(-20, -11, Bloque.class);
        Actor LinksUnten = getOneObjectAtOffset(-20, 11, Bloque.class);
        Actor RechtsOben = getOneObjectAtOffset(20, -11, Bloque.class);
        Actor RechtsUnten = getOneObjectAtOffset(20, 11, Bloque.class);

        if (Greenfoot.isKeyDown("up") && ObenRechts == null && ObenLinks == null)
        {
            setRotation(269);
            move(speed);

            
            if(RechtsOben != null)
            {
                setLocation(getX()-1,getY());
            }
            else if(LinksOben != null)
            {
                setLocation(getX()+1,getY());
            }
           setRotation(0);
        }
        if (Greenfoot.isKeyDown("down") && UntenRechts == null && UntenLinks == null)
        {
            setRotation(89);
            move(speed);

            if(RechtsUnten != null)
            {
                setLocation(getX()-1,getY());
            }
            else if(LinksUnten != null)
            {
                setLocation(getX()+1,getY());
            }
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("left") && LinksOben == null && LinksUnten == null)
        {
            setRotation(179);
            move(speed);
            if(ObenLinks != null)
            {
                setLocation(getX(),getY()+1);
            }
            else if(UntenLinks != null)
            {
                setLocation(getX(),getY()-1);
            }
            setRotation(0);
        }
        if (Greenfoot.isKeyDown("right") && RechtsOben == null && RechtsUnten == null)
        {
            setRotation(0);
            move(speed);
            if(ObenRechts != null)
            {
                setLocation(getX(),getY()+1);
            }
            else if(UntenRechts != null)
            {
                setLocation(getX(),getY()-1);
            }
            setRotation(0);
        }
    }
    
    void enemigosMuertos()
    {
        
    }
}
