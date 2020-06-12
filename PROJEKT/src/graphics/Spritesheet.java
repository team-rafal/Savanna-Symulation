package graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * This class is responsible for downloading Spritesheet, 
 * which will be used as a source for graphic representations of different objects.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 *
 * @version 1.0.0
 */

public class Spritesheet {
	
	// Definition of default Spritesheet, as we believe there will be only one.
	
	public static final Spritesheet def = new Spritesheet("/Spritesheet.png");
	
	public int WIDTH, HEIGHT;
	public int[] pixels; 
	
	/**
	 * 
	 * Constructor downloads Spritesheet from given path
	 * 
	 * @param path - place where Spritesheet file is located
	 */
	
	public Spritesheet(String path) {
		try {
			BufferedImage image = ImageIO.read(Spritesheet.class.getResource(path));
			WIDTH = image.getWidth();
			HEIGHT = image.getHeight();
			pixels = new int [WIDTH*HEIGHT];
			
			image.getRGB(0,0,WIDTH,HEIGHT,pixels,0,WIDTH);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
}
