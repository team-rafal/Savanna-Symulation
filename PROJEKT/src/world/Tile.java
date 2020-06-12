package world;


import graphics.Screen;
import graphics.Sprite;
import world.tiles.*;

/**
 * This class returns and renders certain tile.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */

public class Tile {

	public int id;
	
	protected Sprite texture;
	
	/**
	 * Method returns a tile.
	 * 
	 * @param id - id of a different tile
	 * @return certain tile
	 */
	
	public static Tile getTile(int id) {
	if(id==1)return new Sand();
	if(id==2) return new Bush();
	else return new Water();
	}
	
	/**
	 * Method renders tile.
	 * 
	 * @param s - space, where image can appear
	 * @param x - x parameter where tile should appear 
	 * @param y - y parameter where tile should appear
	 */
	
	public void render(Screen s ,int x, int y) {
		s.renderSprite(x*16, y*16, texture);
		
	}
	
}
