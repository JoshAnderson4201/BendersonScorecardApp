package com.example.ja160637.bendersonscorecard;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by retre on 4/4/2018.
 */

public class Hole
{
    private String number;
    private String par;
    private String yards;


    public Hole(int holeNumber, Context context)
    {
        BufferedReader reader;
        try
        {
            final InputStream file = context.getAssets().open("cable.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            if(holeNumber < 10)
            {
                while(line != null && !Integer.toString(holeNumber).equals(line.substring(0,1)))
                {
                    line = reader.readLine();
                }
                number = line.substring(0,1);
                par =line.substring(2,3);
                yards = line.substring(4,7);
            }
            else
            {
                while(line != null && !Integer.toString(holeNumber).equals(line.substring(0,2)))
                {
                    line = reader.readLine();
                }
                number = line.substring(0,2);
                par =line.substring(3,4);
                yards = line.substring(5,8);
            }
        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }
    }

    public String getNumber()
    {
        return number;
    }

    public String getPar()
    {
        return par;
    }

    public String getYards()
    {
        return yards;
    }
}
