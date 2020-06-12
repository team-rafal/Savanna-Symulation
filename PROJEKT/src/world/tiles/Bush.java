package world.tiles;


import graphics.Sprite;
import graphics.Spritesheet;
import world.Tile;

/**
 * This class defines graphic representation of a bush and renders itself.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */

public class Bush extends Tile {

	
	/**
	 * Constructor defines tile's id and graphic interpretation.
	 */
	
	public Bush() {
		id=2;
		texture = new Sprite(16,16,16,16,Spritesheet.def);
	}
	

}
