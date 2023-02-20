package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;
// can also do fully qyualified class name instead of import statements
// ie. ddf.minim.AudioInput
public class Audio1 extends PApplet
{

    Minim minim; // instance of the minim library
    AudioInput ai; // instance of the AudioInput class
    AudioPlayer ap;
    AudioBuffer ab;

	public void settings()
	{
		size(1024, 500);
	}

    int frameSize = 1024; // number of samples in a frame
	public void setup() 
    {
        colorMode(HSB);
        background(0);
        minim = new Minim(this); // instanciating, creating new object, reffering to this class(current applet)(just like self in python)

        ai = minim.getLineIn(Minim.MONO, frameSize, 44100, 16); // 16 bit audio
        ab = ai.mix; // ab object encapsulates the audio buffer


        smooth();
	}

	public void draw()
	{	
        background(0);
        stroke(255);
        
        float half = height / 2;
        float cgap = 255 / (float)ab.size(); // colour gap between each line

        float total = 0;
        
        for(int i = 0; i < ab.size(); i++)
        {
            total += ab.get(i);
            stroke(i * cgap, 255, 255);
            line(i,half,i, half + ab.get(i) * half); // get(i) returns the value of the sample at index i, * half to scale it down to the height of the window
            
            // circle that increases in size based on the amplitude of the audio
            circle(300,300, ab.get(i) * 1000);
        }
        float average = total / (float)ab.size();

        float r = average * 200;
        lerpedR = lerp(lerpedR, r, 0.1f); // lerping the radius of the circle means that the circle will grow and shrink smoothly

        circle(100, 200, lerpedR);

        
    }
    float lerpedR = 0;
}
