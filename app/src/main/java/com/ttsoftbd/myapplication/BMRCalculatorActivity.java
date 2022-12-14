package com.ttsoftbd.myapplication;

import static com.ttsoftbd.myapplication.BMICalcUtil.BMI_CATEGORY_HEALTHY;
import static com.ttsoftbd.myapplication.BMICalcUtil.BMI_CATEGORY_OBESE;
import static com.ttsoftbd.myapplication.BMICalcUtil.BMI_CATEGORY_OVERWEIGHT;
import static com.ttsoftbd.myapplication.BMICalcUtil.BMI_CATEGORY_UNDERWEIGHT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class BMRCalculatorActivity extends AppCompatActivity {

    private EditText weightKgEditText, heightCmEditText;
    private EditText weightLbsEditText, heightFtEditText, heightInEditText;
    private Button calculateButton;
    private TextView bmiTextView, categoryTextView;
    private ToggleButton toggleUnitsButton;
    private CardView bmrResultCardView;

    private boolean inMetricUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmrcalculator);


        weightKgEditText = findViewById(R.id.activity_main_weightkgs);
        heightCmEditText = findViewById(R.id.activity_main_heightcm);

        weightLbsEditText = findViewById(R.id.activity_main_weightlbs);
        heightFtEditText = findViewById(R.id.activity_main_heightfeet);
        heightInEditText = findViewById(R.id.activity_main_heightinches);

        calculateButton = findViewById(R.id.activity_main_calculate);
        toggleUnitsButton = findViewById(R.id.activity_main_toggleunits);

        bmiTextView = findViewById(R.id.activity_main_bmi);
        categoryTextView = findViewById(R.id.activity_main_category);
        bmrResultCardView = findViewById(R.id.activity_main_resultcard);

        inMetricUnits = true;
        updateInputsVisibility();
        bmrResultCardView.setVisibility(View.GONE);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inMetricUnits) {
                    if (weightKgEditText.length() == 0 || heightCmEditText.length() == 0) {
                        Toast.makeText(BMRCalculatorActivity.this, "Populate Weight and Height to Calculate BMI", Toast.LENGTH_SHORT).show();
                    } else {
                        double heightInCms = Double.parseDouble(heightCmEditText.getText().toString());
                        double weightInKgs = Double.parseDouble(weightKgEditText.getText().toString());
                        double bmi = BMICalcUtil.getInstance().calculateBMIMetric(heightInCms, weightInKgs);
                        displayBMI(bmi);
                    }
                } else {
                    if (weightLbsEditText.length() == 0 || heightFtEditText.length() == 0 || heightInEditText.length() == 0) {
                        Toast.makeText(BMRCalculatorActivity.this, "Populate Weight and Height to Calculate BMI", Toast.LENGTH_SHORT).show();
                    } else {
                        double heightFeet = Double.parseDouble(heightFtEditText.getText().toString());
                        double heightInches = Double.parseDouble(heightInEditText.getText().toString());
                        double weightLbs = Double.parseDouble(weightLbsEditText.getText().toString());
                        double bmi = BMICalcUtil.getInstance().calculateBMIImperial(heightFeet, heightInches, weightLbs);
                        displayBMI(bmi);
                    }
                }
            }
        });

        toggleUnitsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inMetricUnits = !inMetricUnits;
                updateInputsVisibility();
            }
        });
    }

    private void updateInputsVisibility() {
        if (inMetricUnits) {
            heightCmEditText.setVisibility(View.VISIBLE);
            weightKgEditText.setVisibility(View.VISIBLE);
            heightFtEditText.setVisibility(View.GONE);
            heightInEditText.setVisibility(View.GONE);
            weightLbsEditText.setVisibility(View.GONE);
        } else {
            heightCmEditText.setVisibility(View.GONE);
            weightKgEditText.setVisibility(View.GONE);
            heightFtEditText.setVisibility(View.VISIBLE);
            heightInEditText.setVisibility(View.VISIBLE);
            weightLbsEditText.setVisibility(View.VISIBLE);
        }
    }

    private void displayBMI(double bmi) {
        bmrResultCardView.setVisibility(View.VISIBLE);

        bmiTextView.setText(String.format("%.2f", bmi));

        String bmiCategory = BMICalcUtil.getInstance().classifyBMI(bmi);
        categoryTextView.setText(bmiCategory);

        switch (bmiCategory) {
            case BMI_CATEGORY_UNDERWEIGHT:
                bmrResultCardView.setCardBackgroundColor(Color.YELLOW);
                break;
            case BMI_CATEGORY_HEALTHY:
                bmrResultCardView.setCardBackgroundColor(Color.GREEN);
                break;
            case BMI_CATEGORY_OVERWEIGHT:
                bmrResultCardView.setCardBackgroundColor(Color.YELLOW);
                break;
            case BMI_CATEGORY_OBESE:
                bmrResultCardView.setCardBackgroundColor(Color.RED);
                break;
        }
    }


    }
