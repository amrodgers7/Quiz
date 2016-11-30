package com.example.android.quiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import static android.widget.Toast.LENGTH_SHORT;

public class MainActivity extends AppCompatActivity {
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //** Method is called when Submit button is clicked

    public void submitScore(View view) {
        //Is Question 1 Correct?
        RadioButton Question1RadioButton = (RadioButton) findViewById(R.id.Question1_Correct);
        boolean Question1Correct = Question1RadioButton.isChecked();

        //**Is Question 2 correct?

        CheckBox bananaCheckbox = (CheckBox) findViewById(R.id.BananaCheckbox);
        boolean bananaCheckboxChecked = bananaCheckbox.isChecked();

        CheckBox parsleyCheckbox = (CheckBox) findViewById(R.id.ParsleyCheckbox);
        boolean parsleyCheckboxChecked = parsleyCheckbox.isChecked();

        CheckBox icebergCheckbox = (CheckBox) findViewById(R.id.IcebergLettuceCheckbox);
        boolean icebergCheckboxChecked = icebergCheckbox.isChecked();

        //**Is Question 3 correct?

        RadioButton Question3RadioButton = (RadioButton) findViewById(R.id.Question3_Correct);
        boolean Question3Correct = Question3RadioButton.isChecked();

        //**Is Question 4 correct?
        RadioButton Question4RadioButton = (RadioButton) findViewById(R.id.Question4_Correct);
        boolean Question4Correct = Question4RadioButton.isChecked();

        //**Is Question 5 correct?
        EditText Question5Text = (EditText) findViewById(R.id.favorite_text);
        String name = Question5Text.getText().toString();
        boolean Question5Correct =  (name.equals("cute"));

        int finalScore = calculateScore(Question1Correct, bananaCheckboxChecked, parsleyCheckboxChecked, icebergCheckboxChecked, Question3Correct, Question4Correct, Question5Correct);
        String scoreMessage = scoreOrder(Question1Correct, bananaCheckboxChecked, parsleyCheckboxChecked, icebergCheckboxChecked, Question3Correct, Question4Correct, Question5Correct);
        Toast.makeText(this, scoreMessage, LENGTH_SHORT).show();
    }


    //**Calculates Score
    private int calculateScore(boolean Question1Correct, boolean bananaCheckboxChecked, boolean parsleyCheckboxChecked, boolean icebergCheckboxChecked, boolean Question3Correct, boolean Question4Correct, boolean Question5Correct) {

        if (Question1Correct)
            score = score + 1;
            else score = score +0;
        if (icebergCheckboxChecked)
            score = score +0;
        if (bananaCheckboxChecked)
        if (parsleyCheckboxChecked)
            score = score +1;
        else score = score + 0;
        if (Question3Correct)
            score = score +1;
        else score = score +0;
        if (Question4Correct)
            score = score +1;
        else score= score +0;

        if (Question5Correct)
            score = score +1;
            else score = score +0;

        return score;
    }

    private String scoreOrder(boolean Question1Correct, boolean bananaCheckboxChecked, boolean parsleyCheckboxChecked, boolean icebergCheckboxChecked, boolean Question3Correct, boolean Question4Correct, boolean Question5Correct) {
        String scoreMessage = "You scored " + score + " out of 5!";
        return scoreMessage;
    }

    public void reset (View view) {
        findViewById(R.id.resetButton);
        score = 0;
        Toast.makeText(this, "Score is 0", LENGTH_SHORT).show();

    }




}

