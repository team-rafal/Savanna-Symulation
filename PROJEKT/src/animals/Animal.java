package animals;

import java.util.Random;

import graphics.Screen;
import graphics.Sprite;
import world.Map;
import world.Tile;
import core.Simulation;

/**
 * This class and its subclasses are responsible for making and rendering
 * aninals as well as changing their position randomly and update their state.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */

public abstract class Animal {

	protected int x, y, thirst, hunger, lifeTime, speed;

	protected Sprite skin;
	
	protected boolean meatEater;

	public Animal() {
	}

	/**
	 * Method used to render animals.
	 * 
	 * @param s - space where images can appear
	 */

	public void render(Screen s) {
		s.renderSprite((int) x, (int) y, this.skin);
	}

	/**
	 * Method used to move animals in random way.
	 * 
	 * @param m - map, where animals can move
	 */

	public void randMovment(Map m) {
		Random r = new Random();
		int moveWay, posX, posY;
		boolean isMovePosible;
		posX = x;
		posY = y;
		moveWay = r.nextInt(4);
		if (moveWay == 0) {
			isMovePosible = waterColision(posX, posY, m);
			if (isMovePosible == false) {
				x -= speed;
			}
		} else if (moveWay == 1) {
			isMovePosible = waterColision(posX, posY, m);
			if (isMovePosible == false) {
				y -= speed;
			}
		} else if (moveWay == 2) {
			isMovePosible = waterColision(posX + 16, posY, m);
			if (isMovePosible == false) {
				x += speed;
			}
		} else if (moveWay == 3) {
			isMovePosible = waterColision(posX, posY + 16, m);
			if (isMovePosible == false) {
				y += speed;
			}
		}

	}

	/**
	 *
	 *  Method used to check if animals colide with bush.
	 * 
	 * @param x - position x of animal
	 * @param y - position y of animal
	 * @param m - map, where animals can move
	 * @return true - if animal colides with a water, otherwise fals
	 */

	public static boolean waterColision(int x, int y, Map m) {
		int posX, posY, id;
		posX = x / 16;
		posY = y / 16;

		id = getId(m, posX, posY);

		if (id == 3) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * Method used to get id value 
	 * 
	 * @param x - position x of animal
	 * @param y - position y of animal
	 * @param m - map, where animals can move
	 * @return id tile value in coordinates x y
	 */

	public static int getId(Map m, int x, int y) {
		return m.tiles[x][y].id;
	}

	/**
	 * Method used to check if animals colide with bush.
	 * 
	 * @param x - x parameter of animal's position
	 * @param y - y parameter of animal's position
	 * @param m - map, where animals can move
	 *
	 * @return true - if animal colides with a bush, otherwise false
	 */

	public static boolean bushColision(int x, int y, Map m) {

		int posX, posY, id;
		posX = x / 16;
		posY = y / 16;

		id = getId(m, posX, posY);

		if (id == 2) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Method returns actual lifeTime integer.
	 * 
	 * @return actual lifeTime integer
	 */

	public int getLifeTime() {
		return this.lifeTime;
	}

	/**
	 * Method decreases lifeTime and animal of an herbivore when a specific term is met
	 */

	public void updateLifeTime(Map m) {
		int a;
		Random c = new Random();
		a = this.lifeTime;
		int posX = getX();
		int posY = getY();
		if (bushColision(posX, posY, m)) {
			if(meatEater == false) {
				hunger += c.nextInt(10);
			}
		} else if (waterColision(posX, posY, m)) {
			thirst += c.nextInt(10);
		} else {
			--hunger;
			--thirst;
			--a;
		}
		this.lifeTime = a;
	}
	
	/**
	 * * @param tab - array containing all the animals
	 * 
	 *  The method checks whether the lion ate the herbivore and then increases its life time and hunger by random value.
	 */
	
	public static void eat(Animal tab[]) {
		int mx, my, hx, hy, lt, hunger;
		Random a = new Random();
		for (int i = 0; i < 60; i++) {
			if (tab[i].getMeatEater() == true) {
				mx = tab[i].getX();
				my = tab[i].getY();
				for (int j = 0; j < 60; j++) {
					if (tab[j].getMeatEater() == false) {
						hx = tab[j].getX();
						hy = tab[j].getY();
						
						if(((mx >= hx) && (mx <= hx + 16) &&  (my >= hy) && (my <= hy + 16)) 
								|| ((mx + 16 >= hx) && (mx + 16 <= hx + 16) &&  (my >= hy) && (my <= hy + 16) )
								|| ((mx >= hx) && (mx <= hx + 16) &&  (my + 16 >= hy) && (my + 16 <= hy + 16))
								|| ((mx + 16 >= hx) && (mx + 16 <= hx + 16) &&  (my + 16 >= hy) && (my + 16 <= hy + 16)))  {
							tab[j].setLifeTime(0);
							hunger = tab[i].getHunger() + a.nextInt(20);
							tab[i].setHunger(hunger);
						}

					}
				}
			}
		}
	}
	

	/**
	 * Method returns positon X of an animal
	 */
	public int getX() {
		return this.x;
	}

	/**
	 * Method returns positon Y of an animal
	 */
	public int getY() {
		return this.y;
	}

	/**
	 * Method returns hunger of an animal
	 */
	public int getHunger() {
		return this.hunger;
	}

	/**
	 * Method returns thirst of an animal
	 */
	public int getThirst() {
		return this.thirst;
	}
	
	/**
	 * Method returns type of an animal
	 */
	public boolean getMeatEater() {
		return this.meatEater;
	}
	
	/**
	 * @param x - value of new life time
	 * 
	 * Method for setting the animal's life time
	 */
	public void setLifeTime(int x) {
		this.lifeTime = x;
	}
	
	/**
	 * @param x - value of new hunger
	 * 
	 * Method for setting the animal's life time
	 */
	public void setHunger(int x) {
		this.hunger = x;
	}
}
