package animals;

import java.util.Random;
import core.*;
import world.*;
import graphics.*;
import core.Simulation;
import world.Map;

/**
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.4.0
 */

public class Lion extends Animal{
	
	/**
	* Constructor defines animal's attributes and its graphic representation.
	*/
	
	public Lion(int x, int y) {
		this.x=x;
		this.y=y;
		speed=6;
		lifeTime = 60;
			
		skin = new Sprite (0,0,16,Spritesheet.def);
		
	}
	
}
