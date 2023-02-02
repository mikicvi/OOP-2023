package ie.tudublin;

import processing.core.PApplet;

public class BugZap extends PApplet
{

	float playerX, playerY, playerHeight, playerWidth;
	float bugX, bugY, bugWidth, bugHeight, bugInitX;
	float score = 0;
	int inGame = 0;

	public void settings()
	{
		size(500, 500);
	}

	public void setup() 
	{
		
		colorMode(HSB);
		background(0);
		playerX = width * 0.5f;
		playerY = 490;
		playerWidth = 50;

		bugX = random(30, 470);
		bugY = 20;
		bugWidth = 30;
	}

	public void draw()
	{	
		switch(inGame)
		{
			case 0:
				background(0);
				splashScreen();
				break;
			case 1:
				background(0);
				drawScore();
				drawPlayer(playerX, playerY, playerWidth);
				moveBug();
				drawBug(bugX, bugY , bugWidth);
				inGameChk();
				break;
			case 2:
				gameOver();
				if (key == ' ')
				{
					resetGame();
				}

				break;

		}
	}

	void drawPlayer (float x, float y, float w)
	{
		fill(250);
		fill(120, 100, 100);
		rect(x, y, w, w * 0.5f);
	}

	void drawBug(float x, float y, float w)
	{
		fill(220);
		//red color in HSL
		fill(0, 100, 100);
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
			// draw laser
			fill(250);
			stroke(250);
			line(playerX + 25, playerY - 10, playerX + 25, 0);

			// if bug is hit, add to score, and reset bug
			if (playerX + 25 > bugX - 15 && playerX + 25 < bugX + 15)
			{
				bugX = random(30, 470);
				bugY = 20;
				score ++;			
			}
		}
	}

	public void inGameChk()
	{
		if (bugY > 480)
		{
			inGame = 2;
		}
	}
	public void moveBug()
	{
		if((frameCount % 60) == 0)
		{
			bugX = random(bugX - 20, bugX + 25);
			bugY += 35;
		}
	}

	public void gameOver ()
	{

		// display game over text
		background(1);
		fill(255);
		textSize(20);
		text("Game Over", 200, 250);
		drawScore();
	}
	public void resetGame()
	{
		inGame = 1;
		score = 0;
		bugY = 20;
	}
	public void drawScore()
	{
		textSize(20);
		text("Score: " + score, 410, 20);
	}

	public void splashScreen()
	{
		fill(255);
		textSize(20);
		text("Press space to start", 150, 250);
		if (key == ' ')
		{
			inGame = 1;
		}
	}
}
