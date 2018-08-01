package com.github.sergemart.mobile.beatbox.activities;

import android.support.test.runner.AndroidJUnit4;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.anything;


@RunWith(AndroidJUnit4.class)
public class BeatBoxActivityTest {

    @Rule
    public ActivityTestRule<BeatBoxActivity> mActivityTestRule = new ActivityTestRule<>(BeatBoxActivity.class); // instantiate the activity before each test


    @Test
    public void shows_First_File_Name() {
        onView(withText("65_cjipie")).check(matches(anything()));
    }

}