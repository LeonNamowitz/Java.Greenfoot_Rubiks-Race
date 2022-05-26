import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Leon Namowitz 
 * @version 0.0.1
 */
public class GameBoard extends World
{
    int steps = 0;
    Actor currentTile;
    GameTile gameTile1 = new GameTile();
    GameTile gameTile2 = new GameTile();
    GameTile gameTile3 = new GameTile();
    GameTile gameTile4 = new GameTile();
    GameTile gameTile5 = new GameTile();
    GameTile gameTile6 = new GameTile();
    GameTile gameTile7 = new GameTile();
    GameTile gameTile8 = new GameTile();
    GameTile gameTile9 = new GameTile();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public GameBoard()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 600, 1); 
        GreenfootImage background = getBackground();
        background.setColor(new Color(100, 100, 100, 128));
        background.fillRect(0, 0, getWidth(), getHeight());
        // setBackground(background);

        testSetup();
        
    }

    /**
     * Act Method. World logic.
     */
    public void act()
    {
        checkForClick();
        // tileMove();
    }
    
    
    private void checkForClick()
    {
        if (Greenfoot.mouseClicked(gameTile2) ) { 
            // currentTile = Greenfoot.getMouseInfo().getActor();
            int oldX = gameTile2.getX();
            int oldY = gameTile2.getY();
            gameTile2.tileMove(true, oldX, oldY);
        } 
    }




    public void move()
    {

    }

    public void testSetup()
    {
        int initX = 160;
        int initY = 160;
        int offset = 10;



        addObject(gameTile1, initX, initY);
        addObject(gameTile2, initX + GameTile.tileLength + offset, initY);
        addObject(gameTile3, initX + GameTile.tileLength*2 + offset*2, initY);
        addObject(gameTile4, initX + GameTile.tileLength*3 + offset*3, initY);
        addObject(gameTile5, initX + GameTile.tileLength*4 + offset*4, initY);

        addObject(gameTile6, initX, initY + GameTile.tileLength + offset);
        addObject(gameTile7, initX + GameTile.tileLength*2 + offset*2, initY + GameTile.tileLength + offset);
        addObject(gameTile8, initX + GameTile.tileLength*3 + offset*3, initY + GameTile.tileLength + offset);
        addObject(gameTile9, initX + GameTile.tileLength*4 + offset*4, initY + GameTile.tileLength + offset);
 
    }

}
