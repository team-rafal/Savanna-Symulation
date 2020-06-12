package animals;


import java.util.Random;

import graphics.*;
import world.Map;

/**
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */


public class Antelope extends Animal{
 
 	/**
	* Constructor defines animal's attributes and its graphic representation.
	*/
	
	
	public Antelope(int x, int y) {
		this.x=x;
		this.y=y;
		lifeTime = 80;
		speed=5;
		skin = new Sprite (64,0,16,Spritesheet.def);
	}
	
	
}
