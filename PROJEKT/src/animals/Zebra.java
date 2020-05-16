package animals;

import java.util.Random;

import graphics.*;
import world.Map;

public class Zebra extends Animal {

	public static final Sprite skin = new Sprite(48, 0, 16, Spritesheet.def);

	private int x, y, speed = 5, hunger, thirst, lifeTime = 100;

	public Zebra(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public void randMovment(Map m) {

		Random r = new Random();
		int moveWay, posX, posY;
		boolean isMovePosible;
		posX = x;
		posY = y;
		moveWay = r.nextInt(4);
		if (moveWay == 0) {
			isMovePosible = waterColision(posX, posY, m);
			if (isMovePosible == false) {
				y -= speed;
			}
		} else if (moveWay == 1) {
			isMovePosible = waterColision(posX, posY, m);
			if (isMovePosible == false) {
				y += speed;
			}
		} else if (moveWay == 2) {
			isMovePosible = waterColision(posX, posY, m);
			if (isMovePosible == false) {
				x -= speed;
			}
		} else if (moveWay == 3) {
			isMovePosible = waterColision(posX, posY, m);
			if (isMovePosible == false) {
				x += speed;
			}
		}

	}

	public int getLifeTime() {
		return this.lifeTime;
	}

	public void updateLifeTime() {
		int a;
		a = this.lifeTime;
		--a;
		this.lifeTime = a;
	}

	public void render(Screen s) {

		s.renderSprite((int) x, (int) y, this.skin);

	}
}
