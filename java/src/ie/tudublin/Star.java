package ie.tudublin;


import processing.data.TableRow;

public class Star {

    boolean hab;
    String displayName; 
    float distance; 
    float xG; 
    float yG; 
    float zG; 
    float absMag;


    public Star(TableRow tr)
    {
        this(
            tr.getInt("Hab?") == 1, 
            tr.getString("Display Name"), 
            tr.getFloat("Distance"),
            tr.getFloat("Xg"),
            tr.getFloat("Yg"),
            tr.getFloat("Zg"),
            tr.getFloat("AbsMag")
        );
    }

	public Star(boolean hab, String displayName, float distance, float xG, float yG, float zG, float absMag)
	{
		this.hab = hab;
		this.displayName = displayName;
		this.distance = distance;
		this.xG = xG;
		this.yG = yG;
		this.zG = zG;
		this.absMag = absMag;
	}

    public String toString()
    {
        return displayName + "\t" + distance + "\t" + xG + "\t" + yG + "\t" + zG + "\t" + absMag + "\t" + hab;
    }
    
}
