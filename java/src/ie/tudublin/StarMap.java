package ie.tudublin;


import processing.core.PApplet;
import processing.data.Table;
import processing.data.TableRow;
import java.util.ArrayList;


public class StarMap extends PApplet
{
	ArrayList<Star> stars = new ArrayList<Star>();
	Star firstclicked = null;
	Star secondclicked = null;
	public float border;

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
		border = width * 0.1f;
	
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
			s.render(this);
		}
	}


	public void mouseClicked()
	{
		for(Star s:stars)
		{
			float x = map(s.getxG(), -5, 5, 50, width - 50);
			float y = map(s.getyG(), -5, 5, 50, height - 50);
			
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
			float x = map(firstclicked.getxG(), -5, 5, 50, width - 50);
			float y = map(firstclicked.getyG(), -5, 5, 50, height - 50);
			if(secondclicked != null)
			{
				float x2 = map(secondclicked.getxG(), -5, 5, 50, width - 50);
				float y2 = map(secondclicked.getyG(), -5, 5, 50, height - 50);
				stroke(70, 255, 255);
				line(x, y, x2, y2);

				float dist = dist(firstclicked.getxG(), firstclicked.getyG(), firstclicked.getzG(), secondclicked.getxG(), secondclicked.getyG(), secondclicked.getzG());
				
				fill(255);
				textAlign(CENTER, CENTER);
				text("Distance between: " + firstclicked.getDisplayName() + " and " + secondclicked.getDisplayName() + " is " + dist + "parsecs", width/2, height - 50);
			}
			else
			{
				stroke(70, 255, 255);
				line(x, y, mouseX, mouseY);
			}
		}
		
	}
}
