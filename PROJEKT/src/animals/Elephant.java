package animals;

import java.util.Random;

import graphics.*;
import world.Map;

public class Elephant extends Animal{
	
	 /**
	* Constructor defines animal's attributes and its graphic representation.
	*/
	
	public Elephant(int x, int y) {
		this.x=x;
		this.y=y;
		lifeTime = 90;
		speed=5;
		skin = new Sprite (16,0,16,Spritesheet.def);
	}
	
}
