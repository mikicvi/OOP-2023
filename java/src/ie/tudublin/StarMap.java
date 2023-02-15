package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;


public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();


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
		strokeWeight(2);		

		drawGrid();
	}
}
