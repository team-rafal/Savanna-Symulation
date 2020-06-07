package animals;

import java.util.Random;

import graphics.*;
import world.Map;

public class Elephant extends Animal{
	

	
	public Elephant(int x, int y) {
		this.x=x;
		this.y=y;
		lifeTime = 150;
		hunger = 100;
		thirst=100;
		speed=5;
		meatEater = false;
		skin = new Sprite (16,0,16,Spritesheet.def);
	}
	
}
