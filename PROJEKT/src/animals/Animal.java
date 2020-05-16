package animals;

import graphics.Screen;
import world.Map;
import world.Tile;

/**
 * This class and its subclasses are responsible for making and rendering
 * aninals as well as changing their position randomly and update their state.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public abstract class Animal {

	public Animal() {
	}

	/**
	 * Method used to render animals.
	 * 
	 * @param s - space where images can appear
	 */

	public void render(Screen s) {
	}
	
	/**
	* Method used to check if animals colide with water.
	* 
	* @param x - x parameter of animal's position
	* @param y - y parameter of animal's position
	* @param m - map, where animals can move
	*
	* @return true - if animal colides with water, false otherwise
	*/
	
	public static boolean waterColision(int x, int y, Map m) {

		int posX, posY, id;
		posX = x / 16;
		posY = y / 16;

		id = Tile.getId(m, posX, posY);

		if (id == 3) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Method used to move animals in random way.
	 * 
	 * @param m - map, where animals can move
	 */

	public void randMovment(Map m) {
	}

	/**
	 * Method returns actual lifeTime integer.
	 * 
	 * @return actual lifeTime integer
	 */

	public abstract int getLifeTime();

	/**
	 * Method decreases lifeTime after every update
	 */

	public abstract void updateLifeTime();
}
