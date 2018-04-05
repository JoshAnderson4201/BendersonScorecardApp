package com.example.ja160637.bendersonscorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.util.Log;

public class IndividualHole extends AppCompatActivity
{
    TextView holeNumber, holePar, holeYardage;
    EditText scoreView;
    int currentHole = 1;
    String[] scoresArray = new String[18];
    String score;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_hole);
        loadHoleStats(currentHole);
    }

    //Loads hole stats for current hole
    public void loadHoleStats(int currentHole)
    {
        holeNumber = findViewById(R.id.holeNumber);
        holePar = findViewById(R.id.holePar);
        holeYardage = findViewById(R.id.holeYardage);

        Hole hole = new Hole(currentHole, this);

        holeNumber.setText(hole.getNumber());
        holePar.setText(hole.getPar());
        holeYardage.setText(hole.getYards());
        loadScore(currentHole);
    }

    // loads stats for the next hole
    public void nextHole(View v)
    {
        if(currentHole != 18)
        {
            saveScore(currentHole);
            currentHole++;
            loadHoleStats(currentHole);
        }
        else
        {
            saveScore(currentHole);
            currentHole = 1;
            loadHoleStats(currentHole);
        }
    }

    // loads stats for the previous hole
    public void prevHole(View v)
    {
        if(currentHole != 1)
        {
            saveScore(currentHole);
            currentHole--;
            loadHoleStats(currentHole);
        }
        else
        {
            saveScore(currentHole);
            currentHole = 18;
            loadHoleStats(currentHole);
        }
    }

    // saves the score the user enters for the current hole
    public void saveScore(int currentHole) {
        scoreView = findViewById(R.id.edit_score);
        score = scoreView.getText().toString();
        scoresArray[currentHole-1] = score;
        scoreView.setText("");
        String test = scoresArray[currentHole-1];
        Log.w("MainActivity", "" + test );
    }

    // displays a previously entered score for a hole already visited
    public void loadScore(int currentHole) {
        scoreView = findViewById(R.id.edit_score);
        String getScore = scoresArray[currentHole-1];
        scoreView.setText(getScore);
    }

    public void fullScorecard (View v) {
        Intent scorecardIntent = new Intent(this, FullScorecard.class);
        startActivity(scorecardIntent);
    }
}
