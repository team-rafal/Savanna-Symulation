package graphics;

import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

/**
 * This class is used to create space, where images can appear.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec
 *
 * @version 0.2.3
 */

public class Screen {

	public final int WIDTH;
	public final int HEIGHT;

	private BufferedImage image;
	private int[] pixels;

	/**
	 * Constructor defines parameters of a space, where images can appear.
	 * 
	 * @param w - width of a space
	 * @param h - height of a space
	 */

	public Screen(int w, int h) {
		WIDTH = w;
		HEIGHT = h;
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		pixels = ((DataBufferInt) image.getRaster().getDataBuffer()).getData();
	}

	public BufferedImage getImage() {
		return image;
	}

	/**
	 * 
	 * Method allows to render Sprite in a specific part of screen.
	 * 
	 * @param px - x parameter of position where Sprite is supposed to render.
	 * @param py - y parameter of position where Sprite is supposed to render.
	 * @param s  - space, where images can appear.
	 */

	public void renderSprite(int px, int py, Sprite s) {
		for (int y = 0; y < s.height; ++y)
			for (int x = 0; x < s.width; ++x) {
				pixel(px + x, py + y, s.sp.pixels[s.x + x + (s.y + y) * s.sp.WIDTH]);
			}
	}

	/**
	 * Method that makes sure that pixels are located within a window, ignores
	 * color pink and ruturns a color.
	 * 
	 * @param x     - x parameter of a Sprite
	 * @param y     - y parameter of a Sprite 
	 * @param color - value of a certain color 
	 */

	private void pixel(int x, int y, int color) {
		if (x < 0 || x >= WIDTH || y < 0 || y >= HEIGHT || color == 0xFFFF00FF)
			return;
		
		pixels[x + y * WIDTH] = color;
	}

}
