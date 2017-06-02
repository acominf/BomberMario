import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class enemigo3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class enemigo3 extends Enemigo
{
    /**
     * Act - do whatever the enemigo3 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
         int velocidad = 2;
    int direccion=0;

    public enemigo3(){
        direccion=Greenfoot.getRandomNumber(4);
    }
    public void act() 
    {
        tocaJugador();
        movementNormal();
    }  
    public void tocaJugador(){
            Actor player1 = getOneObjectAtOffset(0, 0, Player1.class);
            Actor player1_1 = getOneObjectAtOffset(20, 20, Player1.class);
            Actor player1_2 = getOneObjectAtOffset(-20, -20, Player1.class);
            Actor player1_3 = getOneObjectAtOffset(25, 0, Player1.class);
            Actor player1_4 = getOneObjectAtOffset(0, 25, Player1.class);
            Actor player1_5 = getOneObjectAtOffset(-25, 0, Player1.class);
            Actor player1_6 = getOneObjectAtOffset(0, -25, Player1.class);
            Actor player1_7 = getOneObjectAtOffset(-20, 20, Player1.class);
            Actor player1_8 = getOneObjectAtOffset(20, -20, Player1.class);
            
            Game juego = (Game) getWorld();
            Player1 g = juego.getPlayer();

            if((player1 != null || player1_1 != null || player1_2 != null || player1_3 != null || player1_4 != null || player1_5 != null || player1_6 != null || player1_7 != null || player1_8 != null) && g.getblinken()==false) 
            {
                Game gameWorld = (Game) getWorld();
                gameWorld.reduceLife(1, 0, 1);  
            }
    }
     public void selectDirection(){        
        switch(direccion){
            case 0:
               if(Greenfoot.getRandomNumber(3)==1)
                    direccion= 1;
                else
                     direccion= 3;
            break;
            case 1:
                if(Greenfoot.getRandomNumber(3)==1)
                    direccion= 2;
                else
                     direccion= 0;
            break;
            case 2:
                   if(Greenfoot.getRandomNumber(3)==1)
                    direccion= 3;
                else
                     direccion= 1;
            break;
            case 3:
                if(Greenfoot.getRandomNumber(3)==1)
                    direccion= 0;
                else
                     direccion= 2;
            break;
        }
    }
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
        
        if (direccion==0 && ObenRechts == null && ObenLinks == null &&  ((BombeObenRechts == null && BombeObenLinks == null) == false && (BombeMitte == null) == true) == false)//falls über einem kein Block ist. Lenni
        {
            setRotation(269);
            move(velocidad);

            
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
        else if (direccion==1 && UntenRechts == null && UntenLinks == null && ((BombeUntenRechts == null && BombeUntenLinks == null) == false && (BombeMitte == null) == true) == false)
        {
            setRotation(89);
            move(velocidad);

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
        else if (direccion==2 && LinksOben == null && LinksUnten == null && ((BombeLinksOben == null && BombeLinksUnten == null) == false && (BombeMitte == null) == true) == false)
        {
            setRotation(179);
            move(velocidad);
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
        else if (direccion==3 && RechtsOben == null && RechtsUnten == null && ((BombeRechtsOben == null && BombeRechtsUnten == null) == false && (BombeMitte == null) == true) == false)
        {
            setRotation(0);
            move(velocidad);
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
        }else{
            selectDirection();
        }
        
            Actor caja = getOneIntersectingObject(Fragil.class);
            if (caja != null) {
                getWorld().removeObject(caja);
            }
    }       
}
