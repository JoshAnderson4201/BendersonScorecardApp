package com.example.ja160637.bendersonscorecard;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Daniel Benson on 4/22/2018.
 */

public class PastRounds extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_rounds);

        DatabaseHandler dbh = new DatabaseHandler(this);
        ArrayList<Integer> IDarray = dbh.getIds();
        for (int i = 0; i < IDarray.size(); i++) {
            Log.i("int value: ", Integer.toString(IDarray.get(i)));
        }

        ArrayList<Integer> scoreArray = dbh.getScoresById(1);
        for (int i = 0; i < scoreArray.size(); i++) {
            Log.i("scores for id 5: ", Integer.toString(scoreArray.get(i)) );
        }
    }



}
