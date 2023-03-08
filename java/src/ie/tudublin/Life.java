package ie.tudublin;

import processing.core.PApplet;

public class Life extends PApplet
{

	LifeBoard board;
	int state = 0;
	public void settings()
	{
		size(1920, 1200);
	}

	public void setup() {
		colorMode(RGB);
		background(0);
		board = new LifeBoard(250, this);
		board.randomise();
	}

	public void keyPressed()
	{
		switch(key)
		{
			case ' ':
				state += 1;
				state = state % 2;
				break;
			case '1':
				board.randomise();
				break;
			case '2':
				board.clear();
				break;
			case '3':
				
	}

	public void draw()
	{	
		background(0);
		board.render();
		if(state == 0)
		{
			board.applyRules();
		}
	}
}
