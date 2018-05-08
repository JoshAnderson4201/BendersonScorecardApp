package com.example.ja160637.bendersonscorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;

/**
 * Created by Daniel Benson on 4/22/2018.
 */

public class PastRounds extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    RadioGroup roundList;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_past_rounds);
        roundList = findViewById(R.id.roundList);

        DatabaseHandler dbh = new DatabaseHandler(this);
        ArrayList<Integer> IDarray = dbh.getIds();
        for (int i = 0; i < IDarray.size(); i++) {
            RadioButton round = new RadioButton(this);
            round.setText(Integer.toString(IDarray.get(i)));
            roundList.addView(round);
            Log.i("int value: ", Integer.toString(IDarray.get(i)));
        }
    }

    public void loadRound(View v)
    {
        int radioButtonId = roundList.getCheckedRadioButtonId();
        if(radioButtonId != -1)
        {
            View radioButton = roundList.findViewById(radioButtonId);
            int index = roundList.indexOfChild(radioButton);
            RadioButton r = (RadioButton) roundList.getChildAt(index);
            String roundID = r.getText().toString();
            db.getWritableDatabase();
            String[] scoreArray = db.getScoresById(Integer.parseInt(roundID));
            Intent launchOldRound = new Intent(this, IndividualHole.class);
            launchOldRound.putExtra("NewRound", false);
            launchOldRound.putExtra("RoundID", Integer.parseInt(roundID));
            launchOldRound.putExtra("ScoreArray", scoreArray);
            startActivity(launchOldRound);
        }
    }

    public void deleteRound(View v) {
        int radioButtonId = roundList.getCheckedRadioButtonId();
        if(radioButtonId != -1) {
            View radioButton = roundList.findViewById(radioButtonId);
            int index = roundList.indexOfChild(radioButton);
            RadioButton r = (RadioButton) roundList.getChildAt(index);
            String roundID = r.getText().toString();
            db.getWritableDatabase();
            db.deleteRoundByID(Integer.parseInt(roundID));
        }
    }



}
