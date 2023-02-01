package ie.tudublin;

import processing.core.PApplet;

public class HelloProcessing extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		//colorMode(HSB);
		background(255, 0, 0); // red background

		
	}

	int x = 0;

	
	public void draw()
	{	// the allseeing eye
		background(255, 0, 0); //redraw the background
		noStroke();
		//yellow circle
		fill(255, 255, 0);
		ellipse(250, 250, 460,460);
		//sky blue triangle over circle
		fill(0, 255, 255);
		triangle(250, 0, 50, 450, 450, 450);
		//eclipe eye shaped
		fill(255, 255, 255);
		ellipse(250, 250, 200, 120);
		//eye black part
		fill(0,0,0);
		ellipse(250, 250, 75, 75);
		// if mouse click -> close eye
		if (mousePressed) {
			fill(255, 255, 255);
			ellipse(250, 250, 75, 75);
		}

		//background(0);


	}
}
