package ie.tudublin;


import processing.data.TableRow;

public class Star {

    private boolean hab;
    private String displayName; 
    private float distance; 
    private float xG; 
    private float yG; 
    private float zG; 
    private float absMag;

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

    @Override
    public String toString() {
        return "Star [hab=" + hab + ", displayName=" + displayName + ", distance=" + distance + ", xG=" + xG + ", yG="
                + yG + ", zG=" + zG + ", absMag=" + absMag + "]";
    }

    public void setHab(boolean hab) {
        this.hab = hab;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setxG(float xG) {
        this.xG = xG;
    }

    public void setyG(float yG) {
        this.yG = yG;
    }

    public void setzG(float zG) {
        this.zG = zG;
    }

    public void setAbsMag(float absMag) {
        this.absMag = absMag;
    }

    public boolean isHab() {
        return hab;
    }

    public String getDisplayName() {
        return displayName;
    }

    public float getDistance() {
        return distance;
    }

    public float getxG() {
        return xG;
    }

    public float getyG() {
        return yG;
    }

    public float getzG() {
        return zG;
    }

    public float getAbsMag() {
        return absMag;
    }



    
    
}
