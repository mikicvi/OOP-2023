package ie.tudublin;

import processing.core.PApplet;

public class HealthPowerUp extends GameObject implements PowerUp
{

    float w;

    public HealthPowerUp(float x, float y, float r, int c, YASC p) 
    {
        super(x, y, r, c, p); // constructor chaining
    }

    @Override
    public void applyTo(Ship s) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyTo'");
    }

    @Override
    public void update() {
        rot += 0.01f;
        pos.add(forward);
    }

    @Override
    public void render() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'render'");
    }
    
}