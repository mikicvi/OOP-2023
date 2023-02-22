package ie.tudublin;

import ddf.minim.AudioBuffer;
import ddf.minim.AudioInput;
import ddf.minim.AudioPlayer;
import ddf.minim.Minim;
import processing.core.PApplet;

public class Audio1 extends PApplet
{
    Minim minim;
    AudioPlayer ap;
    AudioInput ai;
    AudioBuffer ab;

    int mode = 0;

    float y = 0;
    float smoothedY = 0;
    float smoothedAmplitude = 0;

    public void keyPressed() {
		if (key >= '0' && key <= '9') {
			mode = key - '0';
		}
		if (keyCode == ' ') {
            if (ap.isPlaying()) {
                ap.pause();
            } else {
                ap.rewind();
                ap.play();
            }
        }
	}

    public void settings()
    {
        size(1024, 1000, P3D);
        //fullScreen(P3D, SPAN);
    }

    public void setup()
    {
        minim = new Minim(this);
        // Uncomment this to use the microphone
        // ai = minim.getLineIn(Minim.MONO, width, 44100, 16);
        // ab = ai.mix; 

        // And comment the next two lines out
        ap = minim.loadFile("heroplanet.mp3", 1024);
        ap.play();
        ab = ap.mix;
        colorMode(HSB);

        y = height / 2;
        smoothedY = y;

    }

    float off = 0;

    public void draw()
    {
        //background(0);
        float halfH = height / 2;
        float average = 0;
        float sum = 0;
        off += 1;
        // Calculate sum and average of the samples
        // Also lerp each element of buffer;
        for(int i = 0 ; i < ab.size() ; i ++)
        {
            sum += abs(ab.get(i));
        }
        average= sum / (float) ab.size();

        smoothedAmplitude = lerp(smoothedAmplitude, average, 0.1f);
        
        float cx = width / 2;
        float cy = height / 2;

        switch (mode) {
			case 0:
                // wavy lines visualisation
                background(0);
                for(int i = 0 ; i < ab.size() ; i ++)
                {
                    //float c = map(ab.get(i), -1, 1, 0, 255);
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, halfH - f, i);                    
                }
                break;
            case 1:
                // the waveform visualisation
                background(0);
                for(int i = 0; i < ab.size(); i++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    line(i, halfH + f, i, halfH - f);
                }            
                break;
            case 2:
            //The waveform drawn down the 4 sides of the screen
                background(0);
                for(int i = 0 ; i < ab.size(); i++)
                {
                    float c = map(i, 0, ab.size(), 0, 255);
                    stroke(c, 255, 255);
                    float f = ab.get(i) * halfH;
                    
                    //left side
                    line(0, i, f, i);
                    //top side
                    line(i, 0, i, f);
                    //right side
                    line(width, i, width - f, i);
                    //bottom side
                    line(i, height, i, height - f);
                }
                break;
            case 3:
                //The circle - Use the lerped amplitude to control the size of the circle
                background(0);
                noFill();
                for (int i = 0; i < ab.size(); i++)
                {   
                    float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
                    float c = map(smoothedAmplitude, 0, 1, 0, 255);
                    stroke(c, 255, 255);
                    strokeWeight(3);
                    circle(cx, cy, r);
                }
                break;
            case 4:
            // The square - Again use the lerped amplitude to control the size of the square. You can also use rectMode(CENTER) to make the x and y parameters of the rect function determine the center of the rect rather than the coordinates of the top left corner
            background(0);
            noFill();
            for (int i = 0; i < ab.size(); i++)
            {   
                float r = map(smoothedAmplitude, 0, 0.5f, 100, 2000);
                float c = map(smoothedAmplitude, 0, 1, 0, 255);
                stroke(c, 255, 255);
                strokeWeight(3);
                rectMode(CENTER);
                rect(cx, cy, r, r);
            }
            break;
            case 5:
            // The triangle of fixed size with an eye in middle and lines coming out of it
            float mid = 500;
            float height = 200;
            float left = 150;
            float right = 850;
            float botheight = 800;
            background(0);
            noFill();
            for (int i = 0; i < ab.size(); i++)
            {   
                float c = map(smoothedAmplitude, 0, 1, 0, 255);
                float c2 = map(i, 0, ab.size(), 0, 255);
                float f = ab.get(i) * halfH;
                stroke(c, 255, 255);
                strokeWeight(3);
                // triangle of fixed size
                triangle(150,800, 850,800, 500,200);
                //left side
                stroke(c2, 255, 255);
                strokeWeight(1);
                line(left+350,height,left+350-abs(f),height);
                left-=0.58;
                if(height<800)
                {
                    height++;
                }
                //right side
                line(right-350,height,right-350+abs(f),height);
                right+=0.58;
                //bottom side
                line(mid,botheight,mid+f,botheight);
                // line through middle (top to bottom)
                line(mid,200,mid - f,height+botheight);
            }
            break;



        }
        


        
        // Other examples we made in the class
        /*
        stroke(255);
        fill(100, 255, 255);        
        
        circle(width / 2, halfH, lerpedA * 100);

        circle(100, y, 50);
        y += random(-10, 10);
        smoothedY = lerp(smoothedY, y, 0.1f);        
        circle(200, smoothedY, 50);
        */

    }        
}
