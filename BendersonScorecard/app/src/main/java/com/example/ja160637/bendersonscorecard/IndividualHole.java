package com.example.ja160637.bendersonscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class IndividualHole extends AppCompatActivity
{
    TextView holeNumber, holePar, holeYardage;
    int currentHole = 1;

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
    }

    public void nextHole(View v)
    {
        if(currentHole != 18)
        {
            currentHole++;
            loadHoleStats(currentHole);
        }
        else
        {
            currentHole = 1;
            loadHoleStats(currentHole);
        }

    }
}
