package com.star.numberguessinggame;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    private static final int MAX_NUMBER = 10;
    
    private Button mNumberButton1;
    private Button mNumberButton2;

    private TextView mScoreTextView;
    
    private int mNumber1;
    private int mNumber2;

    private int mTotalScore;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNumberButton1 = (Button) findViewById(R.id.number1);
        mNumberButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumbers(mNumber1, mNumber2);
            }
        });

        mNumberButton2 = (Button) findViewById(R.id.number2);
        mNumberButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkNumbers(mNumber2, mNumber1);
            }
        });

        mScoreTextView = (TextView) findViewById(R.id.score);

        initNumbers();
    }
    
    private void initNumbers() {
        Random random = new Random();
        mNumber1 = random.nextInt(MAX_NUMBER) + 1;
        mNumber2 = random.nextInt(MAX_NUMBER) + 1;
        while (mNumber2 == mNumber1) {
            mNumber2 = random.nextInt(MAX_NUMBER) + 1;
        }
        
        mNumberButton1.setText(mNumber1 + "");
        mNumberButton2.setText(mNumber2 + "");
    }

    private void checkNumbers(int number1, int number2) {
        if (number1 > number2) {
            getScore(1);
            Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
        } else {
            getScore(-1);
            Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
        }
        initNumbers();
    }

    private void getScore(int score) {
        mTotalScore += score;
        mScoreTextView.setText("Points: " + mTotalScore);
    }

}
