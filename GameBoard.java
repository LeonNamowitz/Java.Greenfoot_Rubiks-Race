import java.util.ArrayList;
import java.util.List;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Leon Namowitz 
 * @version 0.0.2
 */
public class GameBoard extends World
{
    // int steps = 0;
    // Actor currentTile;
    // For testing only
    GameTile gameTile1 = new GameTile();
    GameTile gameTile2 = new GameTile();
    GameTile gameTile3 = new GameTile();
    GameTile gameTile4 = new GameTile();
    GameTile gameTile5 = new GameTile();
    GameTile gameTile6 = new GameTile();
    GameTile gameTile7 = new GameTile();
    GameTile gameTile8 = new GameTile();
    GameTile gameTile9 = new GameTile();
    GameTile gameTile10 = new GameTile();
    GameTile gameTile11 = new GameTile();
    // For testing only

    List<Color> winColors = new ArrayList<Color>();
    int startX = 160;
    int startY = 160;


    /**
     * Constructor for GameBoard with grey background.
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

        // testSetup();
        // boardGenerator();
        winGenerator();
        
    }

    /**
     * Act Method. World logic.
     */
    public void act()
    {
        checkColors();
    }

    /**
     * Use getColorAt to check for a WIN ?!
     */
    public void checkColors()
    {
        int position = 1;


        // List objects = getObjectsAt(160, 160, GameTile.class);
        // Actor here = (Actor) objects.get(0);
        // Color current = here.getImage().getColor();
        // System.out.println(current);
    }

    /**
     * Creates the win scenario.
     * TO-DO: Clean up ugly use of variables !
     */
    public void winGenerator()
    {
        for (int i = startX + 60; i < (startX + 181); i += 60) {
            for (int j = startY + 60; j < (startY + 181); j += 60) {
                addObject(new GameTile(2), i, j);
            }
        }
    }

    /**
     * Generates a 5x5 field with random colors and 1 empty tile.
     * Starts at x=160, y=160 and ends at x=400, y=400 with an increment of 60.
     */
    public void boardGenerator()
    {
        for (int i = startX; i < 460; i += 60) {
            for (int j = startY; j < 460; j += 60) {
                addObject(new GameTile(), i, j);
            }
        }
        // Removes 1 object from board  
        // Currently buggy if it lands on empty offset in between !!!
        // List objects = getObjectsAt(Greenfoot.getRandomNumber(220)+170, Greenfoot.getRandomNumber(220)+170, GameTile.class);
        List objects = getObjectsAt(280, 220, GameTile.class);
        Actor start = (Actor) objects.get(0);
        removeObject(start);
        // Creates border around tiles
        // TO-DO: Change positions to variables !!!
        int outside = 4;    //Outside tiles are invis (4)
        for (int i = 100; i < 520; i += 60) {
            addObject(new GameTile(outside), i, 100);
        }
        for (int i = 100; i < 520; i += 60) {
            addObject(new GameTile(outside), i, 460);
        }
        for (int i = 160; i < 460; i += 60) {
            addObject(new GameTile(outside), 100, i);
        }
        for (int i = 160; i < 460; i += 60) {
            addObject(new GameTile(outside), 460, i);
        }
    }


    //For testing only
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

        addObject(gameTile10, initX, initY + GameTile.tileLength*2 + offset*2);
        addObject(gameTile11, initX + GameTile.tileLength + offset, initY + GameTile.tileLength*2 + offset*2);
 
    }

}
