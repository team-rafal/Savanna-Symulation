package animals;

import java.util.Random;

import graphics.*;
import world.Map;

public class Giraffe extends Animal{
	

	
	public Giraffe(int x, int y) {
		this.x=x;
		this.y=y;
		speed=4;
		lifeTime = 150;
		hunger = 100;
		thirst=100;
		skin = new Sprite (32,0,16,Spritesheet.def);
	}
	

}
