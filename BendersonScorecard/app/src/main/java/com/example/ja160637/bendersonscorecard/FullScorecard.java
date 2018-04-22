package com.example.ja160637.bendersonscorecard;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.view.View;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class FullScorecard extends AppCompatActivity {
    String[] scoresArray;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        setContentView(R.layout.activity_full_scorecard);
        if(extras != null)
        {
            scoresArray = getIntent().getStringArrayExtra("ScoreArray");
            loadScores(scoresArray);
        }
        Scorecard(this);
    }

    public void Scorecard(Context context)
    {
        BufferedReader reader;
        try
        {
            final InputStream file = context.getAssets().open("cable.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();
            int holeNumber = 1;
            String number;
            String par;
            String yards;
            while (holeNumber < 19)
            {
                String name = getPackageName();
                if (holeNumber < 10)
                {
                    while (line != null && !Integer.toString(holeNumber).equals(line.substring(0, 1)))
                    {
                        line = reader.readLine();
                    }
                    number = line.substring(0, 1);
                    par = line.substring(2, 3);
                    yards = line.substring(4, 7);
                    TextView hole = findViewById(getResources().getIdentifier("hole" + holeNumber, "id", name));
                    hole.setText(number + "\n\n" + par + "\n\n" + yards);
                }
                else
                {
                    while (line != null && !Integer.toString(holeNumber).equals(line.substring(0, 2)))
                    {
                        line = reader.readLine();
                    }
                    number = line.substring(0, 2);
                    par = line.substring(3, 4);
                    yards = line.substring(5, 8);
                    TextView hole = findViewById(getResources().getIdentifier("hole" + holeNumber, "id", name));
                    hole.setText(number + "\n\n" + par + "\n\n" + yards);
                }
                holeNumber++;
            }
        } catch (IOException ex)
        {
            ex.printStackTrace();
        }
    }

    private void loadScores(String[] array)
    {
        //Insert score from array into hole TV
        int holeNumber = 1;
        for(int i = 0; i < 18; i++)
        {
            String name = getPackageName();
            TextView scoreView = findViewById(getResources().getIdentifier("score" + holeNumber, "id", name));
            scoreView.setText(array[i]);
            holeNumber++;
        }
    }

    public void returnToIndividual(View v)
    {
        super.onBackPressed();
    }
}
