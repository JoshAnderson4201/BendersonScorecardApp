package com.example.ja160637.bendersonscorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private DatabaseHandler dbHandle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        dbHandle = new DatabaseHandler(this);
        dbHandle.getWritableDatabase();
        setContentView(R.layout.activity_main);
    }

    public void newRound(View v)
    {
        Intent launchNewRound = new Intent(this, IndividualHole.class);
        startActivity(launchNewRound);
    }

    public void pastRound( View v ) {
        Intent launchPastRounds = new Intent (this, PastRounds.class);
        startActivity(launchPastRounds);
    }

}
