package com.pamo.bmi;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CalorieCalculatorActivityTest {

    private CalorieCalculatorActivity activity;
    private EditText mockAgeInput;
    private EditText mockHeightInput;
    private EditText mockWeightInput;
    private Spinner mockGenderSpinner;
    private Spinner mockActivityLevelSpinner;
    private TextView mockResultText;

    @Before
    public void setUp() {
        // Initialize the activity and mock views
        activity = new CalorieCalculatorActivity();

        mockAgeInput = mock(EditText.class);
        mockHeightInput = mock(EditText.class);
        mockWeightInput = mock(EditText.class);
        mockGenderSpinner = mock(Spinner.class);
        mockActivityLevelSpinner = mock(Spinner.class);
        mockResultText = mock(TextView.class);
        Button mockCalculateButton = mock(Button.class);
        Button mockRecommendRecipesButton = mock(Button.class);

        activity.ageInput = mockAgeInput;
        activity.heightInput = mockHeightInput;
        activity.weightInput = mockWeightInput;
        activity.genderSpinner = mockGenderSpinner;
        activity.activityLevelSpinner = mockActivityLevelSpinner;
        activity.resultText = mockResultText;
        activity.calculateButton = mockCalculateButton;
        activity.recommendRecipesButton = mockRecommendRecipesButton;
    }

    @Test
    public void calculateAndDisplayCalories_CorrectValues_DisplaysCalories() {
        // Set up the mock data
        when(mockAgeInput.getText().toString()).thenReturn("25");
        when(mockHeightInput.getText().toString()).thenReturn("175");
        when(mockWeightInput.getText().toString()).thenReturn("70");
        when(mockGenderSpinner.getSelectedItem().toString()).thenReturn("Mężczyzna");
        when(mockActivityLevelSpinner.getSelectedItem().toString()).thenReturn("Średnia aktywność");

        // Call the method under test
        activity.calculateAndDisplayCalories();

        // Verify the expected behavior
        double expectedBMR = 88.362 + (13.397 * 70) + (4.799 * 175) - (5.677 * 25);
        double expectedCalories = expectedBMR * 1.55;
        String expectedText = "Twoje dzienne zapotrzebowanie kaloryczne: " + Math.round(expectedCalories) + " kcal";

        assertEquals(expectedText, mockResultText.getText().toString());
    }
}
