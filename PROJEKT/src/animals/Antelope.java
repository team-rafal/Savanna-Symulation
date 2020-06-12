package animals;


import java.util.Random;

import graphics.*;
import world.Map;



public class Antelope extends Animal{
 
 	/**
	* Constructor defines animal's attributes and its graphic interpretation.
	*/
	
	
	public Antelope(int x, int y) {
		this.x=x;
		this.y=y;
		lifeTime = 150;
		hunger = 100;
		thirst=100;
		speed=5;
		meatEater = false;
		skin = new Sprite (64,0,16,Spritesheet.def);
	}
	
}
