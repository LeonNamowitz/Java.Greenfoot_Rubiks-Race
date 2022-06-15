import java.util.ArrayList;
import java.util.List;
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author Leon Namowitz 
 * @version 0.0.7
 */
public class GameBoard extends World
{
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
    List<Color> currentColors = new ArrayList<Color>();
    int startX = getWidth()/5;   // Change this to adjust board position.  
    int startY = getHeight()/5;
    boolean winSetupDone = false;
    boolean boardSetupDone = false;
    boolean startDelay = false;
    boolean stopGame = false;
    private int extend = 0;
    private int delay = 0;
    boolean hasTileMoved = false;

    /**
     * Constructor for GameBoard with grey background.
     * 
     */
    public GameBoard()
    {    
        // Create a new world with 600x600 cells with a cell size of 1x1 pixels.
        super(800, 400, 1); 
        GreenfootImage background = getBackground();
        background.setColor(new Color(100, 100, 100, 128));
        background.fillRect(0, 0, getWidth(), getHeight());
    }


    /**
     * Act Method. World logic.
     */
    public void act()
    {
        setupWin();
        setupBoard();
        checkWin();
        stopGame();
    }

    /**
     * Setup at the beginning of the game.
     * 
     */
    private void setupWin()
    {
        if (!winSetupDone)  {
            winGenerator();
            winColors = getColors();
            Greenfoot.delay(60);      
            GameTile.moveAllTiles(true);
            Greenfoot.delay(20);
    
            //@TODO: Somehow wait 40 act() cycles here before generating board.
            winSetupDone = true;
        }
    }

    private void setupBoard()
    {
        if (!boardSetupDone && winSetupDone && delay <= 44)   {
            delay++;
        }
        if (!boardSetupDone && winSetupDone && delay == 45)  {
            GameTile.moveAllTiles(false);
            boardGenerator();
            currentColors = getColors();
            // System.out.println(winColors);
            // System.out.println(currentColors);
            boardSetupDone = true;
        }
        // System.out.println(delay);
    }

    public void checkWin()  {
        if (hasTileMoved) {
            currentColors = getColors();
            if (winColors.equals(currentColors)) {
                stopGame = true;
            }
            hasTileMoved = false;
            // System.out.println("check");
        }
    }
    
    /**
     * Ends the game after 12 additional act() cycles so the tile can finish moving.
     */
    public void stopGame()
    {
        if (stopGame)  {
            extend++;
        }
        if (extend == 12)  {
            System.out.println("You won!");
            Greenfoot.stop();
        }
    }

    public void tileHasMoved(boolean state)
    {
        if (state)  {
            hasTileMoved = true;
        }
    }

    /**
     * Creates ArrayList of colors of the 9 tiles in the middle from top to bottom, left to right.
     * Exception for the empty tile.
     */
    public List<Color> getColors()
    {
        List<Color> currentColors = new ArrayList<Color>();
        for (int position = 0; position < 9;)  {
            for (int localX = startX + 60; localX < (startX + 181); localX += 60)    {
                for (int localY = startY + 60; localY < (startY + 181); localY  += 60)   {
                    List<GameTile> objects = getObjectsAt(localX, localY, GameTile.class);
                    if (objects.isEmpty() == false)  {
                        Actor here = (Actor) objects.get(0);
                        Color current = here.getImage().getColor();
                        currentColors.add(position, current);       
                    }
                    else    {
                        currentColors.add(position, Color.BLACK);       
                    }
                    position++;
                    // System.out.println(position);
                }
            }
        }
        return(currentColors);
    }

    public void moveSolution()  
    {

    }

    /**
     * Creates the win scenario.
     * @TODO Clean up ugly use of variables !
     */
    public void winGenerator()
    {
        for (int i = startX + 60; i < (startX + 181); i += 60) {
            for (int j = startY + 60; j < (startY + 181); j += 60) {
                addObject(new GameTile(), i, j);
            }
        }
        // Creates border around tiles
        // @TODO Change "60" to variable !
        int outside = 4;    //Outside tiles are invis (4)
        for (int i = startX + 60; i < (startX + 4*60); i += 60) {
            addObject(new GameTile(outside), i, startY);
        }
        for (int i = startX + 60; i < (startX + 4*60); i += 60) {
            addObject(new GameTile(outside), i, (startY + 4*60));
        }
        for (int i = startY; i < (startX + 3*60); i += 60) {
            addObject(new GameTile(outside), startX, i);
        }
        for (int i = startY; i < (startX + 3*60); i += 60) {
            addObject(new GameTile(outside), (startX + 4*60), i);
        }
    }

    /**
     * Generates a 5x5 field with random colors and 1 empty tile.
     * Starts at x=160, y=160 and ends at x=400, y=400 with an increment of 60. //@TODO refactor to be dependent on variables
     */
    public void boardGenerator()
    {
        for (int i = startX; i < (startX + 5*60); i += 60) {
            for (int j = startY; j < (startY + 5*60); j += 60) {
                addObject(new GameTile(), i, j);
            }
        }
        // Removes 1 object from board  
        // Currently buggy if it lands on empty offset in between !!!
        // List objects = getObjectsAt(Greenfoot.getRandomNumber(220)+170, Greenfoot.getRandomNumber(220)+170, GameTile.class);
        List<GameTile> objects = getObjectsAt(getWidth()/2, getHeight()/2, GameTile.class);
        Actor start = (Actor) objects.get(0);
        removeObject(start);

        // Creates border around tiles
        // @TODO Change "60" to variable !
        int outside = 4;    //Outside tiles are invis (4)
        for (int i = startX - 60; i < (startX + 6*60); i += 60) {
            addObject(new GameTile(outside), i, startY - 60);
        }
        for (int i = startX - 60; i < (startX + 6*60); i += 60) {
            addObject(new GameTile(outside), i, (startY + 6*60));
        }
        for (int i = startY; i < (startX + 3*60); i += 60) {
            addObject(new GameTile(outside), startX - 60, i);
        }
        for (int i = startY; i < (startX + 3*60); i += 60) {
            addObject(new GameTile(outside), (startX + 5*60), i);
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
