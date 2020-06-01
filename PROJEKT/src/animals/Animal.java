package animals;

import java.util.Random;

import graphics.Screen;
import graphics.Sprite;
import world.Map;

/** This class and its subclasses are responsible for making and rendering aninals
 *  as well as changing their position randomly and update their state.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 */

public abstract class Animal {
	
	protected int x,y,thrist,hunger,lifeTime,speed;
	
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
	
	public void randMovment(Map m) {
		Random r = new Random ();
		int moveWay, posX, posY;
		boolean isMovePosible;
		posX = x;
		posY = y;
			moveWay=r.nextInt(4);
			if(moveWay == 0 ) {
				isMovePosible = waterColision(posX,posY, m);
				if(isMovePosible == false) {
					x-=speed;
				}
			}
			else if(moveWay == 1) {
				isMovePosible = waterColision(posX,posY, m);
				if(isMovePosible == false) {
					y-=speed;
				}
			}
			else if(moveWay == 2 ) {
				isMovePosible = waterColision(posX+16,posY, m);
				if(isMovePosible == false) {
					x+=speed;
				}
			}
			else if(moveWay == 3) {
				isMovePosible = waterColision(posX,posY+16, m);
				if(isMovePosible == false) {
					y+=speed;
				}
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
		
//		do testów
//		System.out.println(x);
//		System.out.println(posX);
//		System.out.println(id);
		
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
	 * Method returns actual lifeTime integer.
	 * 
	 * @return actual lifeTime integer
	 */
	
	public int getLifeTime() {
//		if(this.lifeTime>=0) System.out.println(this.toString()+" hp: "+this.lifeTime);
		return this.lifeTime;
	}
	
	
	/**
	 * Method decreases lifeTime after every update
	 */
	
	public void updateLifeTime() {
		int a;
		a=this.lifeTime;
		--a;
		this.lifeTime=a;
	}
}
