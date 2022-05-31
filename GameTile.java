import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Colored Game Tiles that move to a free spot on click.
 * Colors: 0=red, 1=green, 2=blue, 3=yellow, 4=transparent
 * 
 * @author Leon Namowitz 
 * @version 0.0.6
 */
public class GameTile extends Actor
{
    public static int tileLength = 50;
    boolean hasBeenClicked = false;
    int oldX;
    int oldY;
    String direction;

    // Deprecated..just for testing
    public GameTile()
    {
        GreenfootImage tile = new GreenfootImage(tileLength, tileLength);
        int choice = Greenfoot.getRandomNumber(4);
        Color color = selectColor(choice);
        tile.setColor(color);
        tile.fillRect(0, 0, tileLength, tileLength);
        setImage(tile);
    }

    public GameTile(int choice)
    {
        GreenfootImage tile = new GreenfootImage(tileLength, tileLength);
        Color color = selectColor(choice);
        tile.setColor(color);
        tile.fillRect(0, 0, tileLength, tileLength);
        setImage(tile);
    }

    /**
     * Waits for a mouse inputs;the clicked object then moves to an empty adjacent tile.
     */
    public void act()
    {
        waitForClick();
        checkMove();
    }

    /**
     * Waits for a mouse inputs and saves the location of the object at that position.
     */
    private void waitForClick()
    {
        if (Greenfoot.mouseClicked(this) ) { 
            // currentTile = Greenfoot.getMouseInfo().getActor();
            oldX = this.getX();
            oldY = this.getY();
            hasBeenClicked = true;
            direction = checkDirection();
            // System.out.println(direction);
        } 
    }

    /**
     * Moves towards the empty direction and stops at a full tile offset.
     * 12 act() cycles to complete move
     */
    public void checkMove()
    {
        GameBoard gameBoard = (GameBoard)getWorld();

        // Careful: if move amount is not a divisor of the offset, it won't stop !!!
        if (hasBeenClicked == true && direction == "right") {
            this.setRotation(0);
            this.move(5);
            if (this.getX() == oldX + 60)    {
                hasBeenClicked = false;
                gameBoard.tileHasMoved(true);
            }
        }
        if (hasBeenClicked == true && direction == "down") {
            this.setRotation(90);
            this.move(5);
            if (this.getY() == oldY + 60)    {
                hasBeenClicked = false;
                gameBoard.tileHasMoved(true);
            }
        }
        if (hasBeenClicked == true && direction == "left") {
            this.setRotation(180);
            this.move(5);
            if (this.getX() == oldX - 60)    {
                hasBeenClicked = false;
                gameBoard.tileHasMoved(true);
            }
        }
        if (hasBeenClicked == true && direction == "up") {
            this.setRotation(270);
            this.move(5);
            if (this.getY() == oldY - 60)    {
                hasBeenClicked = false;
                gameBoard.tileHasMoved(true);
            }
        }
    }

    /**
     * Checks at a full tile offset for a GameTile object.
     * @return Returns the direction of an adjacent empty tile.
     */
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

    /**
     * Color Selector
     * @param Input the choice of the Color that should be returned.
     * @return Returns a custom color object.
     */
    public Color selectColor(int choice)
    {
        if (choice == 0)    {
            Color red = new Color(255, 0, 0);
            return red;
        }
        if (choice == 1)    {
            Color green = new Color(0, 255, 0);
            return green;
        }
        if (choice == 2)    {
            Color blue = new Color(0, 0, 255);
            return blue;
        }
        if (choice == 3)    {
            Color yellow = new Color(255, 255, 0);
            return yellow;
        }
        if (choice == 4)    {
            Color invis = new Color(0, 0, 0, 0);
            return invis;
        }
        else    {
            return Color.BLACK;
        }
    }
}
