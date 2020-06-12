package core;

import animals.*;
import graphics.*;
import java.util.*;
import world.Map;

/**
 * This class is used to create map and animals. It is also responsible for
 * updating and rendering them.
 * 
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec
 *
 * @version 1.0.0
 *
 */

public class Simulation {

	public Map map;
	Random r = new Random();
	private final int N = 60, X = 5;
	public boolean running = true;

	Animal[] animal = new Animal[N];
	private int lastX = -1, lastY = -1;
	public ArrayList<Animal> animalList;

	/**
	 * Constructor makes map and animals.
	 */

	public Simulation() {

		map = new Map(40, 22);

		animalList = new ArrayList<Animal>();
		ArrayList<Integer> xlist = new ArrayList<>(N);
		ArrayList<Integer> ylist = new ArrayList<>(N);
		for (int z = 0; z < N; z++) {
			int x = r.nextInt(608), y = r.nextInt(320);
			xlist.add(x);
			ylist.add(y);
			for (int p = 0; p < xlist.size(); p++) {
				if (xlist.get(p) == x && ylist.get(p) == y) {
					generate(x, y, xlist.get(p), ylist.get(p));
				}
			}
			if (z < X)
				animalList.add(animal[z] = new Antelope(x, y));
			else if (z >= X && z < 2 * X)
				animalList.add(animal[z] = new Elephant(x, y));
			else if (z >= 2 * X && z < 3 * X)
				animalList.add(animal[z] = new Giraffe(x, y));
			else if (z >= 3 * X && z < 6 * X)
				animalList.add(animal[z] = new Lion(x, y));
			else if (z >= 6 * X)
				animalList.add(animal[z] = new Zebra(x, y));
		}
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param lastX
	 * @param lastY
	 * Method generates another coordinates of x and y, if the coordinates matched
	 */

	private void generate(int x, int y, int lastX, int lastY) {
		x = 20 +  r.nextInt(588);
		y = 20 + r.nextInt(300);
		if (x == lastX && y == lastY) {
			generate(x, y, lastX, lastY);
		}

	}

	/**
	 * Method updates position of every animal on a map and updates their life time.
	 */

	public void update() {

		for (Animal i : animalList) {
			i.randMovment(map);
			i.updateLifeTime(map);
		}
		Animal.eat(animal);

	}

	/**
	 * Method used to render map and animals. After 'death' of an animal it isn't
	 * rendered anymore and its reference is zeroed. If all of the animals are dead
	 * simulation ends.
	 * 
	 * @param s - space where images can appear
	 */

	public void render(Screen s) {

		map.render(s);

		int a = 0;

		for (Animal i : animalList) {
			if (i.getLifeTime() > 0 && i.getHunger() > 0 && i.getThirst() > 0)
				i.render(s);
			else {
				i = null;
				++a;
			}
		}

		if (a == N)
			running = false;

	}
}
