package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{
	Ship ship;
	Ship ship1;

	public boolean[] keys = new boolean[1024];

	public void keyPressed()
	{
		keys[keyCode] = true;
	}

	public void keyReleased()
	{
		keys[keyCode] = false; 
	}


	// Generic 
	ArrayList<Bullet> bullets = new ArrayList<Bullet>(); // angle brackets - specifying type



	public void settings()
	{
		size(500, 500);
		
	}

	public void setup() {
		ship = new Ship(width / 2, height / 2, 50, 70, this);
		ship1 = new Ship(100, 50, 80, 6, this);
		colorMode(HSB);
	}

	public void draw()
	{	background(0);
		ship.render();
		ship.move();

		ship1.render();
		ship1.move();

		for(Bullet b: bullets)
		{
			b.render();
			b.move();
		}

		fill(255);
		text("Bullets: " +bullets.size(), 50,50);
	}
}
