package com.pamo.bmi;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;

public class RecipeRecommendationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_recommendation);

        ListView recipeListView = findViewById(R.id.recipeListView);
        String[] recipes = {
                getString(R.string.recipe1_title) + " - " + getString(R.string.recipe1_description),
                getString(R.string.recipe2_title) + " - " + getString(R.string.recipe2_description)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, recipes);
        recipeListView.setAdapter(adapter);
    }
}
