package world;

import graphics.Screen;
import world.tiles.*;

/**
 * This class returns and renders certain tile.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public class Tile {

	public int id;

	/**
	 * Method returns a tile.
	 * 
	 * @param id - id of a different tile
	 * @return certain tile
	 */

	public static Tile getTile(int id) {
		if (id == 1)
			return new Sand();
		if (id == 2)
			return new Bush();
		else
			return new Water();
	}
	
	/**
	* Method returns id of a specific tile.
	* 
	* @param m - map, where animals can move
	* @param x - x parameter of a tile
	* @param y - y parameter of a tile
	*
	* @return - id of a specific tile
	*/
	
	public static int getId(Map m, int x, int y) {
		return m.tiles[x][y].id;
	}

	/**
	 * Method renders tile.
	 * 
	 * @param s - space, where image can appear
	 * @param x - x parameter where tile should appear
	 * @param y - y parameter where tile should appear
	 */

	public void render(Screen s, int x, int y) {
	}

}
