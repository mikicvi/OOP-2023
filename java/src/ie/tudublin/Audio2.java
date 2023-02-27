package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio2 extends PApplet {

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    public void settings()
    {
        size(1024, 1024, P3D); // p3D for hardware acceleration
    }

    public void setup()
    {
        m = new Minim(this);
        ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ai.mix;

    }

    public void draw()
    {
        background(0);
        stroke(255);
        float half = height / 2;
        for(int i = 0; i< ab.size(); i++)
        {
            line(i, half, i, half+ab.get(i)*half);
        }

        println(map(5,0,10, 1000, 2000));
        map1(5,0,10, 1000, 2000);
    }

    void map1(float a, float b, float c, float d, float e)
    {
        float f = (a -b) / (c - b); // 0.5
        float g = d + f * (e - d); // 1500
        println(g);
    }
    
}
