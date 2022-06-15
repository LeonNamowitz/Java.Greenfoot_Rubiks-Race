# Rubiks Race Project

~

## Requirements

Download and install [Greenfoot](https://www.greenfoot.org/download).


## Gameplay

Move tiles around until the middle part of the board matches the given solution.

-----------------------------------------------------------------------------------------------------------------------------------------

## TO-DO:

* improve win-state
  * stop win tiles from bein moveable
  * stop invis tiles from being clickable 
  *
* Make deterministic
* QoL: shift entire row if clicked
* Refactor everything to use indices instead of coordinates

* Far out ideas
  * AI ??
  * Count moves for highscore 



## Bugs / Code fixes:

* randomly removing a tile throws NullPointerException if it lands on empyty offset (GameBoard ln.165)
*
* Problem?: Tile movement speed depends on speed slider
  * Greenfoot.delay() depends on the slider as well
* Check access for all methods


## Snutt's way of doing things..

* creates 2D Array for the board indices
  * keeps track of empty tile index and current tile index
  * Checks if adjacent(tileIndex, emptyIndex) ==> see pushbullet image
  *   



-----------------------------------------------------------------------------------------------------------------------------------------

## License
[MIT](https://choosealicense.com/licenses/mit/)