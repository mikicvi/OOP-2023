package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;

	public void settings()
	{
		size(1024, 1024);
		board = new LifeBoard(100, this);
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
		delay(100);

	}
}
