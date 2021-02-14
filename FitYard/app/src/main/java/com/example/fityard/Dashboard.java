package com.example.fityard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.os.Bundle;
import android.widget.Button;

public class Dashboard extends AppCompatActivity {
    CardView pedoCard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        pedoCard = (CardView) findViewById(R.id.pedoProgressCard);

    }
}