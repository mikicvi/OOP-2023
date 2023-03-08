package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;

	public void settings()
	{
		size(1920, 1200);
		board = new LifeBoard(500, this);
		board.randomise();

	}

	public void setup() {
		colorMode(RGB);
	}

	
	
	public void draw()
	{	
		noFill();	
		stroke(255);
		board.render();
		board.applyRules();

	}
}
