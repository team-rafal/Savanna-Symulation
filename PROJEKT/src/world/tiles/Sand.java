package world.tiles;

import graphics.*;
import world.Tile;

/**
 * This class defines graphic representation of a sand and renders itself.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */

public class Sand extends Tile {
	
	 
	/**
	 * Constructor defines tile's id and graphic interpretation.
	 */
	
	public Sand() {
		id  = 1;
		texture = new Sprite(0,16,16,16,Spritesheet.def);
	}
	
	
}
