package com.example.fityard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    CardView BMICalculator, workout, nutritionGuide, dietPlans;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

       BMICalculator = (CardView) findViewById(R.id.BMICalculator);
       workout = (CardView) findViewById(R.id.workout);
       nutritionGuide = (CardView) findViewById(R.id.nutritionGuide);
       dietPlans = (CardView) findViewById(R.id.dietPlans);


       BMICalculator.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               Intent calculateBMI = new Intent(getApplicationContext(), calculateBMI.class);
                startActivity(calculateBMI);
           }
       });
    }
}