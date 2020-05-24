package world.tiles;


import graphics.Sprite;
import graphics.Spritesheet;
import world.Tile;


/**
 * This class defines a graphic representation of a water and renders itself.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa� Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public class Water extends Tile {
	
	
	/**
	 * Constructor defines tile's id and graphic interpretation. 
	 */
	
	public Water() {
		id=3;
		texture = new Sprite(32,16,16,16,Spritesheet.def);
	}
	
}
