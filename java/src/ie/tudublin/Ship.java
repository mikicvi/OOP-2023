package ie.tudublin;

import processing.core.PApplet;
import processing.core.PConstants;
import processing.core.PVector;

public class Ship {
    private PVector pos;
    private PVector forward;
    private PApplet p;
    
    public Ship(float x, float y, int c, float size, PApplet p)
    {
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.size = size;
        this.c = c;
        this.p = p;
        halfSize = size / 2;
    }

    public PVector getPos() {
        return pos;
    }
    public void setPos(PVector pos) {
        this.pos = pos;
    }
    public float getRot() {
        return rot;
    }
    public void setRot(float rot) {
        this.rot = rot;
    }
    public int getC() {
        return c;
    }
    public void setC(int c) {
        this.c = c;
    }
    public float getSize() {
        return size;
    }
    public void setSize(float size) {
        this.size = size;
    }
    
    private float rot;
    private int c;
    private float size;
    private float halfSize;

    public void move()
    {
        forward.x = PApplet.sin(rot);
        forward.y = PApplet.cos(-rot);
        if(p.keyPressed)
        {
            if(p.keyCode == PConstants.UP)
            {
                pos.x -= forward.x;
                pos.y -= forward.y;
            }
            if(p.keyCode == PConstants.DOWN)
            {
                pos.x += forward.x;
                pos.y += forward.y;

            }
            if(p.keyCode == PConstants.LEFT)
            {
                rot -= 0.1f;
            }
            if(p.keyCode == PConstants.RIGHT)
            {
                rot += 0.1f;
            }
        }
    }


    public void render()
    {
        p.pushMatrix(); // store transfrom on top of stack

        p.translate(pos.x, pos.y);
        
        p.rotate(rot);
        p.stroke(c, 255, 255);
        p.noFill();

        // a ship
        p.line(- halfSize, 0 + halfSize, 0,- halfSize);
        p.line(0, - halfSize,  + halfSize,  + halfSize);
        p.line(0 + halfSize, 0 + halfSize, 0, 0);
        p.line(0, 0, 0 - halfSize, 0 + halfSize);
        
        p.popMatrix();
    }



    
}
