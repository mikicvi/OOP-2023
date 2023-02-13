package ie.tudublin;

import processing.core.PApplet;

public class StarMap extends PApplet
{
	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
		background(0);

		smooth();
		
	}

		
	public void draw()
	{	
		strokeWeight(2);		
		drawGrid();
	}

	public void drawGrid()
	{
		stroke(100,255,255);
		float border = width * 0.05f;
		float w = width - (border * 2);
		float h = height - (border * 2);
		float gap = w / 10;

		for(float i = 0 ; i <= w ; i += gap)
		{
			line(border + i, border, border + i, border + h);
		}

		for(float i = 0 ; i <= h ; i += gap)
		{
			line(border, border + i, border + w, border + i);
		}

		// add numbering to the grid -5 to +5
		for(int i = 0 ; i <= 10 ; i++)
		{
			float x = border + (i * gap);
			float y = border + (i * gap);
			int z;
			fill(255);
			textSize(20);
			textAlign(CENTER, CENTER);
			text(i - 5, x, border - 30);
			text(i - 5, border - 30, y);
		}
		
	}
}
