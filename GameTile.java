import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameTile here.
 * 
 * @author Leon Namowitz 
 * @version (a version number or a date)
 */
public class GameTile extends Actor
{
    public static int tileLength = 50;
    boolean isMoving = false;
    int oldX;
    int oldY;


    public GameTile()
    {
        int tileIndex = 0;

        GreenfootImage tile = new GreenfootImage(tileLength, tileLength);
        // create a random color, with every color channel between 30 and 230
        int red = Greenfoot.getRandomNumber(200) + 30;
        int green = Greenfoot.getRandomNumber(200) + 30;
        int blue = Greenfoot.getRandomNumber(200) + 30;
        // int alpha = Greenfoot.getRandomNumber(190) + 60;
        int alpha = 255;
        
        tile.setColor(new Color(red, green, blue, alpha));
        tile.fillRect(0, 0, tileLength, tileLength);
        setImage(tile);
    }

    /**
     * Act - do whatever the GameTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        checkForClick();
        checkMove();
    }

    private void checkForClick()
    {
        if (Greenfoot.mouseClicked(this) ) { 
            // currentTile = Greenfoot.getMouseInfo().getActor();
            int oldX = this.getX();
            int oldY = this.getY();
            this.tileMove(true, oldX, oldY);
        } 
    }

    public void checkMove()
    {
        // Careful: if move amount is not a divisor of the offset, it won't stop !!!
        if (isMoving == true) {
            this.move(5);
        }
        if (this.getX() == oldX + 60)    {
            isMoving = false;
        }
    }

    public void tileMove(boolean moving, int posX, int posY)
    {
        isMoving = moving;
        oldX = posX;
        oldY = posY;
    }

}
