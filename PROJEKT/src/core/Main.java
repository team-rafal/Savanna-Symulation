/*
 * 
 * Savanna Wildlife Simulation is a simulation made for object oriented programming course.
 * Our group works under supervision of Mr. Mgr in¿. Szymon Zacher. 
 * Course is organised by Wroc³aw University of Science and Technology.
 *
*/
package core;

import graphics.*;

import java.awt.*;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * This class is used to control the simulation, so to start, update, render and
 * stop it.
 *
 * @author Andrzej Olszewski, Bartosz Szymczak, Rafa³ Rodak, Mateusz Marciniec.
 * 
 * @version 0.2.3
 * 
 */

public class Main extends Canvas implements Runnable {

	public static int count = 0;
	public static final String TITLE = "Savanna Wildlife Simulation";
	public static final int WIDTH = 1366, HEIGHT = 768;

	private boolean RUNNING = false;
	private JFrame frame;
	private Simulation simulation;
	private Screen screen;

	/**
	 * Constructor makes the window that is used to show images.
	 */

	public Main() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		setMinimumSize(new Dimension(WIDTH, HEIGHT));
		setMaximumSize(new Dimension(WIDTH, HEIGHT));

		frame = new JFrame();
		frame.setTitle(TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.add(this, new BorderLayout().CENTER);

		frame.pack();

		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);

		int i = 40;

		screen = new Screen(16 * i, 9 * i);

		simulation = new Simulation();
	}

	/**
	 * Method makes sure the simulation is running and begins a Thread.
	 */

	private void start() {
		if (RUNNING)
			return;
		RUNNING = true;

		new Thread(this, "Game " + TITLE).start();
	}

	/**
	 * Method updates and renders simulation after specific time while it is
	 * running.
	 */

	public void run() {

		while (RUNNING && simulation.running) {
			try {
				update();
				render();
				Thread.sleep(500);
			} catch (InterruptedException e) {
			}
			count++;
		}

		stop();

	}

	private void update() {

		simulation.update();

	}

	/**
	 * Method renders images on a screen.
	 */

	private void render() {
		BufferStrategy bs = getBufferStrategy();
		if (bs == null) {
			createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();

		simulation.render(screen);

		g.drawImage(screen.getImage(), 0, 0, WIDTH, HEIGHT, null);

		g.dispose();
		bs.show();

	}

	/**
	 * Method stops simulation and closes window.
	 */

	private void stop() {
		if (!RUNNING)
			return;
		RUNNING = false;
		frame.dispose();
		System.exit(0);
		System.gc();
	}

	/**
	 * Main method starts the simulation.
	 * 
	 * @param args - standard main argument
	 */

	public static void main(String[] args) {
		new Main().start();
		;
	}
}
