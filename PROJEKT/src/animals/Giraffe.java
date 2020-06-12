package animals;

import java.util.Random;

import graphics.*;
import world.Map;

public class Giraffe extends Animal{
	
	 /**
	* Constructor defines animal's attributes and its graphic representation.
	*/
	
	public Giraffe(int x, int y) {
		this.x=x;
		this.y=y;
		speed=4;
		lifeTime = 100;
		skin = new Sprite (32,0,16,Spritesheet.def);
	}
	

}
