package com.example.ja160637.bendersonscorecard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void loadHoleData()
    {

    }

    public void newRound(View v)
    {
        Intent launchNewRound = new Intent(this, IndividualHole.class);
        startActivity(launchNewRound);
    }
}
