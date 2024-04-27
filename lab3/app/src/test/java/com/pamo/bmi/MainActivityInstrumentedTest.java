package com.pamo.bmi;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.Espresso;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void ensureCalculateBMIBehavesCorrectly() {
        // Assume that the user enters '180' for height and '75' for weight.
        onView(withId(R.id.height)).perform(typeText("180"));
        onView(withId(R.id.weight)).perform(typeText("75"));

        // Close soft keyboard to click the button
        Espresso.closeSoftKeyboard();

        // Click on a button that should trigger the result.
        onView(withId(R.id.calculate_button)).perform(click());

        // Check if the result matches the expected value.
        String expectedBMIResult = "Twoje BMI: 23.15\nStan: Waga prawidłowa";
        onView(withId(R.id.result)).check(matches(withText(expectedBMIResult)));
    }
}