package ie.tudublin;

import java.util.ArrayList;

import java.util.ArrayList;

import ddf.minim.AudioBuffer;
// import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import ddf.minim.analysis.FFT;
import processing.core.PApplet;

public class Audio3 extends PApplet{

    Minim m;
    AudioInput ai;
    AudioPlayer ap;
    AudioBuffer ab;

    FFT fft;
    ArrayList<Cube> cubes = new ArrayList<Cube>();

    public void keyPressed()
    {
        if (key == ' ')
        {
            if (ap.isPlaying())
            {
                ap.pause();
            }
            else
            {
                ap.play();
            }
        
        }
        if (key >= '0' && key <= '9')
        {
            createCubes(key - '0');
        }
    }

    public void settings()
    {
        fullScreen(P3D, SPAN);
        // size(1024, 1024, P3D);
    }

    public void setup()
    {
        colorMode(HSB);
        lights();
        m = new Minim(this);
        ap = m.loadFile("tomp3.cc - 08 PsychNerD and Marco G  More Cowbell.mp3", 1024);
        // ai = m.getLineIn(Minim.MONO, width, 44100, 16);
        ab = ap.mix;

        lerpedBuffer = new float[width];

        // fft = new FFT(width, 44100);

        createCubes(2);

    }

    public void createCubes(int numCubes)
    {
        cubes.clear();
        float theta = TWO_PI / (float) numCubes;
        for(int i = 0; i < numCubes ; i ++)
        {
            float x = (width / 2) + sin(i * theta) * 300;
            float y = (height / 2) - cos(i * theta) * 300;
            Cube c = new Cube();
            c.x = x;
            c.y = y;
            cubes.add(c);
        } 
    }

    public void createCubes(int numCubes)
    {
        cubes.clear();
        float theta = TWO_PI / (float)numCubes;
        for (int i = 0; i < numCubes; i++)
        {
            float x = (width / 2) + sin(i * theta) * 300;
            float y = (height / 2) - cos(i * theta) * 300;
            Cube c = new Cube();
            c.x = x;
            c.y = y;
            cubes.add(c);

        }
    }
    float rot = 0;
    float lerpedAverage = 0;
    float[] lerpedBuffer;

    float rot = 0;
    float lerpedAverage = 0;

    public void draw()
    {

        float total = 0;
        for (int i = 0 ; i < ab.size() ; i ++)
        {
            total += abs(ab.get(i));
        }
        float average = total / (float) ab.size();

        lerpedAverage = lerp(lerpedAverage, average, 0.1f);
        background(0);
        lights();
        colorMode(HSB);
        
        box(100);
    }

        //rot += 0.01f;

    }
}