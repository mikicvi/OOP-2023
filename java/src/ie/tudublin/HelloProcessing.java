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
		background(0);

		
	}

	
	public void draw()
	{	
		line(10,10,100,100);// x1, y1, x2, y2
		stroke(255); // color
		fill(255,255,0); // yellow
		circle(300, 250, 70); // cx, cy, r
		fill(255,0,0);//red
		rect(10, 300, 40, 100); // tlx, tly, width, height
		stroke(127);
		noStroke();
		noFill();
		strokeWeight(1);// thickness
		fill(0,0,255); // blue
		triangle(40,90, 300, 20, 80, 70);
	}
}
