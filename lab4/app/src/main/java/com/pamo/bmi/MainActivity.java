package com.pamo.bmi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText height;
    EditText weight;
    TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        weight = findViewById(R.id.weight);
        height = findViewById(R.id.height);
        result = findViewById(R.id.result);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(view -> Snackbar.make(view, "Witaj w aplikacji BMI!", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show());
    }

    public void calculateBMI(View view) {
        String heightStr = height.getText().toString();
        String weightStr = weight.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float heightValue = Float.parseFloat(heightStr) / 100;
            float weightValue = Float.parseFloat(weightStr);
            float bmi = weightValue / (heightValue * heightValue);
            displayBMI(bmi);
        }
    }

    @SuppressLint("DefaultLocale")
    void displayBMI(float bmi) {
        String bmiLabel;

        if (bmi <= 18.5) {
            bmiLabel = "Niedowaga";
        } else if (bmi <= 24.9) {
            bmiLabel = "Waga prawidłowa";
        } else if (bmi <= 29.9) {
            bmiLabel = "Nadwaga";
        } else {
            bmiLabel = "Otyłość";
        }

        bmiLabel = "Twoje BMI: " + String.format("%.2f", bmi) + "\nStan: " + bmiLabel;
        result.setText(bmiLabel);
    }

    public void openCalorieCalculator(View view) {
        Intent intent = new Intent(this, CalorieCalculatorActivity.class);
        startActivity(intent);
    }
}