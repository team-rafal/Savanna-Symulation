package animals;

import java.util.Random;

import graphics.Screen;
import graphics.Sprite;
import world.Map;
import world.Tile;

/** This class and its subclasses are responsible for making and rendering aninals
 *  as well as changing their position randomly and update their state.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public abstract class Animal {
	
	protected int x,y,thirst,hunger,lifeTime,speed;
	
	protected Sprite skin;
	
	public Animal() {}
	
	/**
	 * Method used to render animals.
	 * 
	 * @param s - space where images can appear
	 */
	
	public void render(Screen s) {
		s.renderSprite((int)x, (int)y, this.skin);
	}
	
	/**
	 * Method used to move animals in random way.
	 * 
	 * @param m - map, where animals can move
	 */
	
	/*public void randMovment(Map m) {
		Random r = new Random ();
		int moveWay, posX, posY;
		boolean isMovePosible;
		posX = x;
		posY = y;
			moveWay=r.nextInt(4);
			if(moveWay == 0 ) {
				isMovePosible = waterColision(posX+speed,posY, m);
				if(isMovePosible == false) {
					x+=speed;
				}
			}
			else if(moveWay == 1) {
				isMovePosible = waterColision(posX,posY, m);
				if(isMovePosible == false) {
					y+=speed;
				}
			}
			else if(moveWay == 2 ) {
				isMovePosible = waterColision(posX,posY, m);
				if(isMovePosible == false) {
					x-=speed;
				}
			}
			else if(moveWay == 3) {
				isMovePosible = waterColision(posX,posY, m);
				if(isMovePosible == false) {
					x+=speed;
				}
			}

	}*/
	
	public void randMovment(Map m) {
		Random r = new Random();
		int moveWay, posX, posY;
		//boolean isMovePosible;
		posX = x;
		posY = y;
		if (waterColision(posX, posY, m) == true) {
			if (x >= 0 && x <= 16) {
				x += speed;				
			}
			else if (y >= 0 && y <= 16) {
				y += speed;				
			}
			else if (x >= 624 && x <= 640) {
				x -= speed;				
			}
			else if (y >= 336 && y <= 360) {
				y -= speed;				
			}
		}
		else {
			moveWay = r.nextInt(4);
			if (moveWay == 0)
				y -= speed;
			else if (moveWay == 1)
				y += speed;
			else if (moveWay == 2)
				x -= speed;
			else if (moveWay == 3)
				x += speed;
		}

	}
	/**
	 * 
	 * @param x
	 * @param y
	 * @param m
	 * @return
	 */
	
	
	public static boolean waterColision(int x, int y , Map m) {
		int posX, posY, id;
		posX = x/ 16;
		posY = y / 16;
		
		id = getId(m, posX, posY);
		
		if(id == 3 ) {
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * 
	 * 
	 * @param m
	 * @param x
	 * @param y
	 * @return
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
//		if(this.lifeTime>=0) System.out.println(this.toString()+" hp: "+this.lifeTime);
		return this.lifeTime;
	}
	
	
	/**
	 * Method decreases lifeTime and hunger of an animal when a specific term is met
	 */
	
	public void updateLifeTime(Map m) {
		int a, b;
		a = this.lifeTime;
		//b=1;
		int posX = getX();
		int posY = getY();
		if(bushColision(posX, posY,m)) {
			hunger++;
			//b = -1;
		}
		else if(waterColision(posX, posY, m)) {
			thirst++;
		}	
		else{
			--hunger;
			--thirst;
			--a;	
		}
		System.out.println("glod" + hunger);
		System.out.println("pragnienie" + thirst);
		System.out.println("lifetime" + a);
		
		this.lifeTime = a;
	}
	/**
	 * Method returns positon X of an animal
	 */
	public int getX () {
		return this.x;
	}
	/**
	 * Method returns positon Y of an animal
	 */
	public int getY () {
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
}
