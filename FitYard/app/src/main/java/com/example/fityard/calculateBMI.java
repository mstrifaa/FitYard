package com.example.fityard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class calculateBMI extends AppCompatActivity {

    RadioButton weight_lb, height_cm, height_inch, weight_kg;
    EditText uWeight, uHeight;
    TextView message;
    Button calcBMI;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate_b_m_i);

        weight_lb = (RadioButton) findViewById(R.id.lb);
        weight_kg = (RadioButton) findViewById(R.id.kg);
        height_cm = (RadioButton) findViewById(R.id.cm);
        height_inch = (RadioButton) findViewById(R.id.inch);
        calcBMI = (Button) findViewById(R.id.calculateBMI);

        uHeight = (EditText) findViewById(R.id.height);
        uWeight = (EditText) findViewById(R.id.weight);

        message = (TextView) findViewById(R.id.bmiMessage);

        calcBMI.setOnClickListener(new View.OnClickListener() {
            double weight, height, bmi;

            @Override
            public void onClick(View v) {
                if(weight_kg.isChecked()){
                    weight = Double.parseDouble(uWeight.toString());
                }
                else if(weight_lb.isChecked()){
                    weight = Double.parseDouble(uWeight.toString()) * 0.453592;
                }

                if(height_inch.isChecked()){
                    height = Double.parseDouble(uHeight.toString()) * 0.0254;
                }
                else if(height_cm.isChecked()){
                    height = Double.parseDouble(uHeight.toString())/100;
                }

                bmi = weight/(height*height);

                String msg;
                if(bmi>25){
                    msg ="Your BMI is " + bmi + ".\n\n Overweight!";
                }
                else if(bmi<21){
                    msg ="Your BMI is " + bmi + ".\n\n Underweight!";
                }
                else
                    msg ="Your BMI is " + bmi + ".\n\n";


                message.setText(msg);

            }

        });

    }

}

