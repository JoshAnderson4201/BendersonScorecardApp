package com.example.ja160637.bendersonscorecard;

import android.app.ActionBar;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
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
        //setContentView(R.layout.activity_full_scorecard);
        Scorecard();
    }

    public void Scorecard() {
        HorizontalScrollView.LayoutParams scrollParams = new HorizontalScrollView.LayoutParams(HorizontalScrollView.LayoutParams.MATCH_PARENT,
                HorizontalScrollView.LayoutParams.MATCH_PARENT);
        scrollParams.setMargins(20, 20, 20, 20);
        HorizontalScrollView scrollView = new HorizontalScrollView(this);
        scrollView.setBackgroundColor(Color.GRAY);
        scrollView.setFillViewport(true);
        LinearLayout.LayoutParams linearParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        linearParams.setMargins(0,20,0,20);
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setBackgroundColor(Color.BLUE);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setWeightSum(18);
        linearLayout.setLayoutParams(linearParams);

        for(int i = 0; i < 18; i++)
        {
            TextView tv = new TextView(this);
            tv.setBackgroundColor(Color.BLACK);
            LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            tvParams.setMargins(100,20,100,20);
            tv.setLayoutParams(tvParams);
            tv.setTextSize(20);
            tv.setText(Integer.toString(i+1));
            tv.setTextColor(Color.WHITE);
            linearLayout.addView(tv);
        }

        for(int i = 0; i < 18; i++)
        {
            TextView tv = new TextView(this);
            tv.setBackgroundColor(Color.BLACK);
            LinearLayout.LayoutParams tvParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                    LinearLayout.LayoutParams.WRAP_CONTENT);
            tvParams.setMargins(100,40,100,20);
            tv.setLayoutParams(tvParams);
            tv.setTextSize(20);
            tv.setText(Integer.toString(i+1));
            tv.setTextColor(Color.WHITE);
            linearLayout.addView(tv);
        }

        scrollView.addView(linearLayout);
        setContentView(scrollView);
    }
}
