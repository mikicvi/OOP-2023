package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;
	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(50, this);

		
		
	}

	
	
	public void draw()
	{	
		background(0);
		noFill();	
		stroke(255);
		board.render();
	}
}
