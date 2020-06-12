package world;


import java.util.Random;

import graphics.Screen;


/**
 * This class is used to create and render a map.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 *
 * @version 1.0.0
 */

public class Map {
	
	
	private final int WIDTH,HEIGHT;
	
	public Tile[][] tiles;
	
	/**
	 * Constructor defines size of a map.
	 * 
	 * @param w - width of a map
	 * @param h - length of a map
	 */
	
	public Map(int w, int h) {
		WIDTH = w;
		HEIGHT = h;
		tiles = new Tile[w][h];
		
		fill();		
	}
		
	/**
	 * Method responsible for filling up the map with a random tile.
	 */
	
	
	public void fill() {

		for(int y = 0 ; y < HEIGHT ; ++y) {
			for(int x = 0; x < WIDTH ; ++x) {
				Random r = new Random ();
				if(y==0|| y==HEIGHT-1)tiles[x][y]=Tile.getTile(3);
				else if(x==0||x==WIDTH-1)tiles[x][y]=Tile.getTile(3);
				else if(r.nextInt(15)==3 &&(x>3&&x<WIDTH-3)&&(y>3&&y<HEIGHT-3))tiles[x][y] = Tile.getTile(2);
				else  tiles[x][y] = Tile.getTile(1);
			}
		}
	}
	
	/**
	 * Method responsible for rendering map.
	 * 
	 * @param s - space, where images can appear
	 */

	
	public void render(Screen s) {
		for(int y = 0 ; y < HEIGHT ; ++y) {
			for(int x = 0; x < WIDTH ; ++x) {
				tiles[x][y].render(s, x, y);
			}
		}
}	
}
