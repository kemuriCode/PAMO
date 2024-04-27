package com.pamo.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class CalorieCalculatorActivity extends AppCompatActivity {

    public EditText ageInput;
    public EditText heightInput;
    public EditText weightInput;
    public Spinner genderSpinner;
    public Spinner activityLevelSpinner;
    public TextView resultText;
    public Button calculateButton;
    public Button recommendRecipesButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie_calculator);

        ageInput = findViewById(R.id.ageInput);
        heightInput = findViewById(R.id.heightInput);
        weightInput = findViewById(R.id.weightInput);
        genderSpinner = findViewById(R.id.genderSpinner);
        activityLevelSpinner = findViewById(R.id.activityLevelSpinner);
        resultText = findViewById(R.id.resultText);
        calculateButton = findViewById(R.id.calculateButton);
        recommendRecipesButton = findViewById(R.id.recommendRecipesButton);

        calculateButton.setOnClickListener(v -> calculateAndDisplayCalories());

        recommendRecipesButton.setOnClickListener(v -> {
            Intent intent = new Intent(CalorieCalculatorActivity.this, RecipeRecommendationActivity.class);
            startActivity(intent);
        });

        // Początkowo przycisk z propozycjami przepisów jest niewidoczny
        recommendRecipesButton.setVisibility(View.GONE);
    }

    public void calculateAndDisplayCalories() {
        int age = Integer.parseInt(ageInput.getText().toString());
        float height = Float.parseFloat(heightInput.getText().toString());
        float weight = Float.parseFloat(weightInput.getText().toString());
        String gender = genderSpinner.getSelectedItem().toString();
        String activityLevel = activityLevelSpinner.getSelectedItem().toString();

        double bmr = calculateBMR(gender, weight, height, age);
        double calories = calculateCalories(bmr, activityLevel);
        resultText.setText("Twoje dzienne zapotrzebowanie kaloryczne: " + Math.round(calories) + " kcal");

        // Uaktywnienie przycisku z propozycjami przepisów
        recommendRecipesButton.setVisibility(View.VISIBLE);
    }

    private double calculateBMR(String gender, float weight, float height, int age) {
        if (gender.equals("Mężczyzna")) {
            return 88.362 + (13.397 * weight) + (4.799 * height) - (5.677 * age);
        } else {
            return 447.593 + (9.247 * weight) + (3.098 * height) - (4.330 * age);
        }
    }

    private double calculateCalories(double bmr, String activityLevel) {
        switch (activityLevel) {
            case "Siedzący tryb życia":
                return bmr * 1.2;
            case "Lekka aktywność":
                return bmr * 1.375;
            case "Średnia aktywność":
                return bmr * 1.55;
            case "Duża aktywność":
                return bmr * 1.725;
            case "Bardzo duża aktywność":
                return bmr * 1.9;
            default:
                return bmr;
        }
    }
}
