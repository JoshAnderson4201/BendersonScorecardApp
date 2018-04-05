package com.example.ja160637.bendersonscorecard;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.GridLayout;
import android.graphics.Point;
import android.widget.Button;
import android.view.View;
import android.os.Bundle;

public class FullScorecard extends AppCompatActivity {
    public TextView[][] views;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Scorecard();
    }

    public void Scorecard() {
        // get the width of the screen
        Point size = new Point();
        getWindowManager().getDefaultDisplay().getSize(size);
        int width = size.x;
        int height = size.y;

        // create the layout manager as a grid layout
        GridLayout gridLayout = new GridLayout(this);
        gridLayout.setColumnCount(11);
        gridLayout.setRowCount(14);

        // create the TextViews and add them to the GridLayout
        views = new TextView[14][11];
        for (int row = 0; row < 14; row++) {
            for (int col = 0; col < 11; col++) {
                views[row][col] = new TextView(this);
                views[row][col].marg
                views[row][col].setTextSize((int)(width * .2));
                views[row][col].setBackgroundColor(Color.parseColor("#ff0000"));
                gridLayout.setPadding(50, 250, 50, 100);
                gridLayout.addView(views[row][col],width, height);
            }
        }

        // set gridlayout as the view of this activity
        setContentView(gridLayout);


    }
}
