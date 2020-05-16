package animals;

import java.util.Random;
import core.*;
import world.*;
import graphics.*;
import core.Simulation;
import world.Map;

public class Lion extends Animal {

	private static final Sprite skin = new Sprite(0, 0, 16, Spritesheet.def);

	private int x, y, speed = 6, hunger, thirst, lifeTime = 60;

	public Lion(int x, int y) {
		this.x = x;
		this.y = y;

	}

	public void randMovment(Map m) {

		Random r = new Random();
		int moveWay, posX, posY;
		boolean isMovePosible;
		posX = x;
		posY = y;
		moveWay = r.nextInt(1);
		if (moveWay == 0) {
			isMovePosible = waterColision(posX + speed, posY, m);
			if (isMovePosible == false) {
				x += speed;
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
