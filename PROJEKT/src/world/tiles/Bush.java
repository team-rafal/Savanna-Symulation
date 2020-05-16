package world.tiles;

import graphics.Screen;
import graphics.Sprite;
import graphics.Spritesheet;
import world.Tile;

/**
 * This class defines graphic representation of a bush and renders itself.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public class Bush extends Tile {

	public static final Sprite texture = new Sprite(16, 16, 16, 16, Spritesheet.def);

	/**
	 * Constructor defines tile's id.
	 */

	public Bush() {
		id = 2;
	}

	public void render(Screen s, int x, int y) {
		s.renderSprite(x * 16, y * 16, texture);

	}

}
