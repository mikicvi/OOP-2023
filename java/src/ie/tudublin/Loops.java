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
	}

	public void draw() 
	{
		background(0);
		drawRect();

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




}
