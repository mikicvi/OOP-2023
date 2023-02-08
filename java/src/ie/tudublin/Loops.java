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
		// change the game mode based on the number pressed by using mode = key - '0';
		// 1 = drawRect
		// 2 = loopsLines
		// 3 = loopsStepped
		// 4 = loopLipse
		
		switch (key - '0') {
			case 1:
				drawRect();
				break;
			case 2:
				loopsLines();
				break;
			case 3:
				loopsStepped();
				break;
			case 4:
				loopLipse();
				break;
			default:
				break;
		}
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
		int startpointX = 100;
		for (i = 0; i < 10; i ++)
		{
			fill(i*25, 255, 255);
			rect(i * 100, startpoint, 100, 100);
			rect(1000 - (i * 100), startpointX, -100, -100);
			startpoint += 100;
			startpointX += 100;
		}
	}

	public void loopLipse()
	{
		int initX = 500;
		int initY = 500;
		int color = 200;
		// draw increasing circles, starting at 0
		for (int i = 1000; i > 0; i -= 100)
		{
			//start at yellow in hsb
			fill(color, 255, 255);
			ellipse(initX, initY, i, i);
			color -= 15;
		}





	}




}
