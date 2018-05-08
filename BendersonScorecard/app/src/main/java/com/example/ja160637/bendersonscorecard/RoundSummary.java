package com.example.ja160637.bendersonscorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class RoundSummary extends AppCompatActivity
{
    TextView birdies, pars, bogeys, total;
    //0: birdies, 1: pars, 2: bogeys, 3: total
    int[] stats = {0, 0, 0, 0};
    String[] scores = IndividualHole.scoresArray;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round_summary);
        loadStats(stats);
    }

    public void loadStats(int[] statArray)
    {
        buildStatArray(scores);
        birdies = findViewById(R.id.birdValue);
        birdies.setText(Integer.toString(statArray[0]));

        pars = findViewById(R.id.parValue);
        pars.setText(Integer.toString(statArray[1]));

        bogeys = findViewById(R.id.bogeyValue);
        bogeys.setText(Integer.toString(statArray[2]));

        total = findViewById(R.id.totalValue);
        total.setText(Integer.toString(statArray[3]));
    }

    public void buildStatArray(String[] scoresArray)
    {
        for(int i = 0; i < scoresArray.length; i++)
        {
            // Make the hole
            Hole hole = new Hole(i+1, this);

            if(scoresArray[i] != null && !scoresArray[i].equals(""))
            {
                // Check score vs hole par and add to stat array
                if (Integer.parseInt(scoresArray[i]) == Integer.parseInt(hole.getPar()) - 1)
                {
                    stats[0]++;
                } else if (Integer.parseInt(scoresArray[i]) == Integer.parseInt(hole.getPar()))
                {
                    stats[1]++;
                } else if (Integer.parseInt(scoresArray[i]) == Integer.parseInt(hole.getPar()) + 1)
                {
                    stats[2]++;
                }
                stats[3] += Integer.parseInt(scoresArray[i]);
            }
        }
    }

    public void mainMenu(View v)
    {
        Intent homeIntent = new Intent(this, MainActivity.class);
        startActivity(homeIntent);
    }
}