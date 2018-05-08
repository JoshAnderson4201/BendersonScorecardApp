package com.example.ja160637.bendersonscorecard;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewStats extends AppCompatActivity {

    DatabaseHandler db = new DatabaseHandler(this);
    RoundSummary rs = new RoundSummary();
    TextView averageShots;
    String[] scoresArray;
    int i, x;
    int sum;
    int average;
    boolean complete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stats);
        averageShots = findViewById(R.id.total_shots_value);
        totalShots();
    }

    public void totalShots() {
        db.getWritableDatabase();
        ArrayList<Integer> IDarray = db.getIds();
        ArrayList<Integer> completeRounds = new ArrayList();

        // for all rounds
        for (i=1;i<IDarray.size()+1; i++) {
            scoresArray=db.getScoresById(i);
            for (x=0;x<scoresArray.length;x++) {
                complete = true;
                if (scoresArray[x] == null || scoresArray[x] == Integer.toString(0)) {
                    complete = false;
                }
            }
            // if complete is still true add the id to complete rounds
            if (complete ==  true) {
                completeRounds.add(i);
            }
        }

        // for every round
        for(i = 1; i < completeRounds.size()+1; i++) {
            scoresArray = db.getScoresById(i);
            // for every hole score in round[i]
            for (x = 1; x < scoresArray.length; x++) {
                // add the score to the total shots taken
                sum = (int)Math.ceil(sum + Integer.parseInt(scoresArray[x]));
            }
        }
        // average shots per round = all shots / number of rounds
        average = sum / completeRounds.size();
        TextView shotAverage = findViewById(R.id.total_shots_value);
        shotAverage.setText(Integer.toString(average));


    }

    public void ReturnMainMenu(View v)
    {
        Intent mainMenuIntent = new Intent(this, MainActivity.class);
        startActivity(mainMenuIntent);
    }

}
