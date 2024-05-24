package com.pamo.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.pamo.bmi.ShoppingListAdapter;

import java.util.Arrays;
import java.util.List;

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

        // Inicjalizacja RecyclerView dla listy zakupów
        RecyclerView recyclerView = findViewById(R.id.shopping_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<String> shoppingItems = Arrays.asList("Mleko", "Jajka", "Mąka");
        ShoppingListAdapter adapter = new ShoppingListAdapter(shoppingItems);
        recyclerView.setAdapter(adapter);

        // Inicjalizacja wykresu BMI
        LineChart chart = findViewById(R.id.chart);
        BmiChartManager bmiChartManager = new BmiChartManager(chart);
        bmiChartManager.setupChart();
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
