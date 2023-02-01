package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	public void settings()
	{
		size(500, 500);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		playerX = 250;
		playerY = 490;
		playerWidth = 50;


		bugX = random(30, 470);
		bugY = 0;
		bugWidth = 30;
	}

	float playerX, playerY, playerHeight, playerWidth;
	float bugX, bugY, bugWidth, bugHeight, bugInitX;


	
	public void draw()
	{	
		background(0);
		drawPlayer(playerX, playerY, playerWidth);

		if((frameCount % 60) == 0)
		{
			bugX = random(bugX - 20, bugX + 25);
			bugY += 15;
		}
		drawBug(bugX, bugY , bugWidth);
	}

	void drawPlayer (float x, float y, float w)
	{
		// create space invaders rocket
		// body
		fill(220);

		rect(x, y, w, w * 0.5f);
	}

	void drawBug(float x, float y, float w)
	{
		// create space invaders bug
		// body
		fill(220);
		ellipse(x, y, bugWidth, bugWidth-10);

	}

	public void keyPressed()
	{
		if (keyCode == LEFT)
		{
			// add player bounds
			if(playerX > 0)
			{
				playerX -= 5;
			}
		}
		if (keyCode == RIGHT)
		{
			if(playerX < 500 - playerWidth)
			{
				playerX += 5;
			}
		}
		if (key == ' ')
		{
			// fire bullet
			fill(250);
			stroke(250);
			line(playerX + 25, playerY - 10, playerX + 25, 0);
		}
	}
}
