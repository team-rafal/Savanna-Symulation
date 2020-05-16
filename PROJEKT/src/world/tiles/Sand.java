package world.tiles;

import graphics.*;
import world.Tile;

/**
 * This class defines graphic representation of a sand and renders itself.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public class Sand extends Tile {

	public static final Sprite texture = new Sprite(0, 16, 16, 16, Spritesheet.def);

	/**
	 * Constructor defines tile's id.
	 */

	public Sand() {
		id = 1;
	}

	public void render(Screen s, int x, int y) {
		s.renderSprite(x * 16, y * 16, texture);

	}

}
