package ie.tudublin;

public class PitchSpeller {

    float[] frequencies = {293.66f, 329.63f, 369.99f, 392.00f, 440.00f, 493.88f, 554.37f, 587.33f
        , 659.25f, 739.99f, 783.99f, 880.00f, 987.77f, 1108.73f, 1174.66f};
    String[] spellings = {"D,", "E,", "F,", "G,", "A,", "B,", "C", "D", "E", "F", "G", "A", "B","c", "d", "e", "f", "g", "a", "b", "c'", "d'", "e'", "f'", "g'", "a'", "b'", "c''", "d''"};

    public String spell(float frequency)
    {
        float difference =  Math.abs(frequency - frequencies[0]);
        int index = 0;
        for(int i = 1 ; i < frequencies.length ; i ++)
        {
            float d = Math.abs(frequency - frequencies[i]);
            if (d < difference)
            {
                difference = d;
                index = i;
            }
        }
        return spellings[index];
    }
    
}
