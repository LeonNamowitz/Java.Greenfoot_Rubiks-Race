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
    boolean hasBeenClicked = false;
    int oldX;
    int oldY;
    String direction;


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
            oldX = this.getX();
            oldY = this.getY();
            hasBeenClicked = true;
            direction = checkDirection();
            System.out.println(direction);
        } 
    }

    public void checkMove()
    {
        // Careful: if move amount is not a divisor of the offset, it won't stop !!!
        if (hasBeenClicked == true && direction == "right") {
            this.setRotation(0);
            this.move(5);
            if (this.getX() == oldX + 60)    {
                hasBeenClicked = false;
            }
        }
        if (hasBeenClicked == true && direction == "down") {
            this.setRotation(90);
            this.move(5);
            if (this.getY() == oldY + 60)    {
                hasBeenClicked = false;
            }
        }
        if (hasBeenClicked == true && direction == "left") {
            this.setRotation(180);
            this.move(5);
            if (this.getX() == oldX - 60)    {
                hasBeenClicked = false;
            }
        }
        if (hasBeenClicked == true && direction == "up") {
            this.setRotation(270);
            this.move(5);
            if (this.getY() == oldX - 60)    {
                hasBeenClicked = false;
            }
        }
    }

    public String checkDirection()
    {
        if (getOneObjectAtOffset(60, 0, GameTile.class) == null)    {
            return "right";
        }
        if (getOneObjectAtOffset(-60, 0, GameTile.class) == null)    {
            return "left";
        }
        if (getOneObjectAtOffset(0, 60, GameTile.class) == null)    {
            return "down";
        }
        if (getOneObjectAtOffset(0, -60, GameTile.class) == null)    {
            return "up";
        }
        else    {
            return "null";
        }
    }

}
