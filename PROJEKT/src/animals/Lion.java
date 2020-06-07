package animals;

import java.util.Random;
import core.*;
import world.*;
import graphics.*;
import core.Simulation;
import world.Map;


public class Lion extends Animal{
	
	public Lion(int x, int y) {
		this.x=x;
		this.y=y;
		speed=6;
		lifeTime = 150;
		hunger = 100;
		thirst=100;
		meatEater = true;
		skin = new Sprite (0,0,16,Spritesheet.def);
		
	}
	
}
