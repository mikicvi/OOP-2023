package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;


public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();
	Star firstclicked = null;
	Star secondclicked = null;

	public void settings()
	{
		size(1000, 1000);
	}

	public void setup() {
		colorMode(HSB);
		background(0);
		loadData();
		smooth();
		printStars();
		


	}

	void loadData()
	{
		Table table = loadTable("HabHYG15ly.csv", "header");
		for(TableRow row:table.rows())
		{
			Star s = new Star(row);
			stars.add(s);
		}
	}

	void printStars()
	{
		for(Star s:stars)
		{
			System.out.println(s);
		}
	}

	public void drawStars()
	{
		for(Star s:stars)
		{
			//remap the x and y values to fit the screen
			float x = map(s.xG, -5, 5, 50, width - 50);
			float y = map(s.yG, -5, 5, 50, height - 50);
			stroke(50,255,255);
			line(x-5, y, x+5, y);
			line(x, y-5, x, y+5);

			stroke(0,255,255);
			noFill();
			circle(x, y, s.distance*8);

			textAlign(LEFT, CENTER);
			text(s.displayName, x+20, y);

		}
	}


	public void mouseClicked()
	{
		for(Star s:stars)
		{
			float x = map(sy.xG, -5, 5, 50, width - 50);
			float y = map(s.yG, -5, 5, 50, height - 50);
			
			if(dist(mouseX, mouseY,x,y) < 20)
			{
				if(firstclicked == null)
				{
					firstclicked = s;
					break;
				}
				else if(secondclicked == null)
				{
					secondclicked = s;
					break;
				}
				else
				{
					firstclicked = s;
					secondclicked = null;
					break;
				}

			}
		}
	}



	public void drawGrid()
	{
		// purple color
		stroke(200, 255, 255);
		float border = 50.0f;

		int count = 10;
		float gap = (width - (border * 2.0f)) / (float) count;
		for(int i = -5 ; i <= 5 ; i ++)
		{
			float x = border + (gap * (i + 5));
			line(x, border, x, height - border);
			line(border, x, width - border, x);
			//labels on grid top and left
			fill(255);
			textAlign(CENTER, CENTER);
			text(i, border - 20, x);
			text(i, x, border - 20);
		}
		
	}


		
	public void draw()
	{	
		background(0);
		strokeWeight(2);		
		drawGrid();
		drawStars();

		if(firstclicked != null)
		{
			floa
		}
		
	}
}
