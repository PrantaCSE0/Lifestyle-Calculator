package com.ttsoftbd.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button AgeCalculator,BMICalculator,BMRCalculator,PregnancyCalculator,IdealWeightCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AgeCalculator = findViewById(R.id.AgeCalculator);
        BMICalculator = findViewById(R.id.BMICalculator);
        BMRCalculator = findViewById(R.id.BMRCalculator);


        PregnancyCalculator = findViewById(R.id.PregnancyCalculator);
        IdealWeightCalculator = findViewById(R.id.IdealWeightCalculator);


        AgeCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,AgeCalculatorActivity.class);
                startActivity(intent);
            }
        });


        BMICalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,BMRCalculatorActivity.class);
                startActivity(intent);
            }
        });


        BMRCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,BMRCalculatorActivity.class);
                startActivity(intent);
            }
        });



        PregnancyCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,PregnancyCalculatorActivity.class);
                startActivity(intent);
            }
        });


        IdealWeightCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this,IdealWeightCalculatorActivity.class);
                startActivity(intent);
            }
        });

    }
}