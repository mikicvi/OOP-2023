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

	}

	public void drawRect()
	{
		int topleftX = 100;
		int topleftY = 100;
		int bottomrightX = 200;
		int bottomrightY = 200;

		rect(topleftY, bottomrightY, bottomrightX, bottomrightY);

		
	}


}
