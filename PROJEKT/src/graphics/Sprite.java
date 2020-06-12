package graphics;

/**
 * 
 * This class defines specific part of a Spritesheet, 
 * which is later used to define a graphic representation of different objects.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 1.0.0
 *
 */

public class Sprite {
	protected int x,y,width,height;
	protected Spritesheet sp;
	
	/**
	 * 
	 * Constructor for a Sprite, which isn't square.
	 * 
	 * @param x - x parameter of Spritesheet 
	 * @param y - y parameter of Spritesheet 
	 * @param width - width of a Sprite
	 * @param height - height of a Sprite
	 * @param sp - downloaded Spritesheet
	 */
	
	public Sprite(int x, int y, int width, int height, Spritesheet sp) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height= height;
		this.sp=sp;
	}
	
	/**
	 * 
	 * Constructor for a square Sprite
	 * 
	 * @param x - x parameter of Spritesheet
	 * @param y - y parameter of Spritesheet
	 * @param size - width and height of a Sprite
	 * @param sp - downloaded Spritesheet
	 */
	
	public Sprite(int x, int y, int size, Spritesheet sp) {
		this.x = x;
		this.y = y;
		this.width = size;
		this.height= size;
		this.sp=sp;
	}
}
