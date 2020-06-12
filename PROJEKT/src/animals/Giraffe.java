package animals;

import java.util.Random;

import graphics.*;
import world.Map;

 /** 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */

public class Giraffe extends Animal{
	
	/**
	* Constructor defines animal's attributes and its graphic interpretation.
	*/
	
	public Giraffe(int x, int y) {
		this.x=x;
		this.y=y;
		speed=4;
		lifeTime = 150;
		hunger = 100;
		thirst=100;
		meatEater = false;
		skin = new Sprite (32,0,16,Spritesheet.def);
	}
	

}
