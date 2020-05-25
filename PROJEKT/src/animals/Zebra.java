package animals;

import java.util.Random;

import graphics.*;
import world.Map;


public class Zebra extends Animal{
	
	
	public Zebra(int x, int y) {
		this.x=x;
		this.y=y;
		lifeTime = 150;
		hunger = 100;
		thirst=100;
		speed=5;
		skin = new Sprite (48,0,16,Spritesheet.def);
	}
	

}
