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
        // int red = Greenfoot.getRandomNumber(200) + 30;
        // int green = Greenfoot.getRandomNumber(200) + 30;
        // int blue = Greenfoot.getRandomNumber(200) + 30;
        // int alpha = 255;
        Color color = selectColor();
        tile.setColor(color);
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
            Actor current = this;
            direction = checkDirection(current);
            // System.out.println(direction);
        } 
    }
    
    // Careful: if move amount is not a divisor of the offset, it won't stop !!!
    public void checkMove()
    {
        if (this.getY() == 160)   {
            if (hasBeenClicked == true && direction == "down") {
                this.setRotation(90);
                this.move(5);
                if (this.getY() == oldY + 60)    {
                    hasBeenClicked = false;
                }
            }
        }
        if (this.getY() == 400)    {
            if (hasBeenClicked == true && direction == "up") {
                this.setRotation(270);
                this.move(5);
                if (this.getY() == oldY - 60)    {
                    hasBeenClicked = false;
                }
            }
        }
        if (this.getX() == 160)    {
            if (hasBeenClicked == true && direction == "right") {
                this.setRotation(0);
                this.move(5);
                if (this.getX() == oldX + 60)    {
                    hasBeenClicked = false;
                }
            }
        }
        if (this.getX() == 400)    {
            if (hasBeenClicked == true && direction == "left") {
                this.setRotation(180);
                this.move(5);
                if (this.getX() == oldX - 60)    {
                    hasBeenClicked = false;
                }
            }
        }
    }
    

    public String checkDirection(Actor current)
    {
        System.out.println(checkRow(current));
        System.out.println(checkColumn(current));

        if (checkRow(current) == 1 && checkColumn(current) == 1)    {
            if (getOneObjectAtOffset(0, 60, GameTile.class) == null)    {
                return "down";
            }
            if (getOneObjectAtOffset(60, 0, GameTile.class) == null)    {
                return "right";
            }
        }
        else if (checkRow(current) == 1 && checkColumn(current) == 5) {
            if (getOneObjectAtOffset(0, 60, GameTile.class) == null)    {
                return "down";
            }
            if (getOneObjectAtOffset(-60, 0, GameTile.class) == null)    {
                return "left";
            }
        }
        else if (checkRow(current) == 5 && checkColumn(current) == 1) {
            if (getOneObjectAtOffset(0, -60, GameTile.class) == null)    {
                return "up";
            }
            if (getOneObjectAtOffset(60, 0, GameTile.class) == null)    {
                return "right";
            }
        }
        else if (checkRow(current) == 5 && checkColumn(current) == 5) {
            if (getOneObjectAtOffset(0, -60, GameTile.class) == null)    {
                return "up";
            }
            if (getOneObjectAtOffset(-60, 0, GameTile.class) == null)    {
                return "left";
            }
        }
        else if (checkRow(current) == 1)    {
            if (getOneObjectAtOffset(0, 60, GameTile.class) == null)    {
                return "down";
            }
        }
        else if (checkRow(current) == 5)    {
            if (getOneObjectAtOffset(0, -60, GameTile.class) == null)    {
                return "up";
            }
        }
        else if (checkColumn(current) == 1) {
            if (getOneObjectAtOffset(60, 0, GameTile.class) == null)    {
                return "right";
            }
        }
        else if (checkColumn(current) == 5) {
            if (getOneObjectAtOffset(-60, 0, GameTile.class) == null)    {
                return "left";
            }
        }
        
        return "null";
    }
    
    public int checkRow(Actor current)
    {
        if (current.getX() == 160) {
            return 1;
        }
        if (current.getX() == 220) {
            return 2;
        }
        if (current.getX() == 280) {
            return 3;
        }
        if (current.getX() == 340) {
            return 4;
        }
        if (current.getX() == 400) {
            return 5;
        }
        else    {
            return 0;
        }
    }

    public int checkColumn(Actor current)
    {
        if (current.getY() == 160) {
            return 1;
        }
        if (current.getY() == 220) {
            return 2;
        }
        if (current.getY() == 280) {
            return 3;
        }
        if (current.getY() == 340) {
            return 4;
        }
        if (current.getY() == 400) {
            return 5;
        }
        else    {
            return 0;
        }
    }

    public Color selectColor()
    {
        int choice = Greenfoot.getRandomNumber(4);
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
        else    {
            return Color.BLACK;
        }
    }

}
