package com.example.ja160637.bendersonscorecard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class IndividualHole extends AppCompatActivity
{
    HoleInfo holeInfo = new HoleInfo();
    TextView holeNumber, holePar, holeYardage;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_individual_hole);
        loadHoleStats(1);
    }

    //Loads hole stats for current hole
    public void loadHoleStats(int currentHole)
    {
        holeNumber = findViewById(R.id.holeNumber);
        holePar = findViewById(R.id.holePar);
        holeYardage = findViewById(R.id.holeYardage);

        holeNumber.setText(Integer.toString(holeInfo.getHoleNumber(currentHole)));
        holePar.setText(Integer.toString(holeInfo.getHolePar(currentHole)));
        holeYardage.setText(Integer.toString(holeInfo.getHoleYardage(currentHole)));
    }
}
