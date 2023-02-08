package ie.tudublin;

import processing.core.PApplet;

public class Loops extends PApplet 
{
	public void settings() 
	{
		size(1000, 1000);
	}

	public void setup() 
	{
		colorMode(HSB);
	}

	public void draw() 
	{
		background(0);
		//drawRect();
		//loopsLines();
		loopsStepped();

	}

	public void drawRect()
	{
		int topleftX = 500;
		int topleftY = 0;
		int bottomrightX = 250;
		int bottomrightY = 1000;

		if(mouseX > 500)
		{
			bottomrightX = 300;
		}
		else if(mouseX < 500)
		{
			bottomrightX = -300;
		}
		if(mouseY > 500)
		{
			bottomrightY = 300;
		}
		else if(mouseY < 500)
		{
			bottomrightY = 800;
		}

		rect(topleftX, topleftY, bottomrightX, bottomrightY);
	}

	public void loopsLines()
	{
		int i = 0; // start at red
		for (i = 0; i < 255; i += 25)
		{
			fill(i, 255, 255);
			rect(i * 4, 0, 1000, 1000);
		}

	}

	public void loopsStepped()
	{
		int i = 0; // start at red
		int startpoint = 0;
		for (i = 0; i < 255; i += 25)
		{
			fill(i, 255, 255);
			rect(i * 4, startpoint, 100, 100);
			startpoint += 100;
		}
	}

	public void loopsSteppedX()
	{
		int i = 0; // start at red
		int startpoint = 0;
		for (i = 0; i < 255; i += 25)
		{
			fill(i, 255, 255);
			rect(i * 4, startpoint, 100, 100);
			startpoint += 100;
		}
	}




}
