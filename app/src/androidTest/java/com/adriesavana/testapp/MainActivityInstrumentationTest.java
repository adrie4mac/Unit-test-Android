package com.adriesavana.testapp;

import android.support.test.espresso.Espresso;
import android.support.test.espresso.action.ViewActions;
import android.support.test.espresso.assertion.ViewAssertions;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by adri on 9/28/16.
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityInstrumentationTest {

    private static final String STRING_TO_BE_TYPED = "adrie";

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void sayHello() {
        Espresso.onView(ViewMatchers.withId(R.id.editText)).perform(ViewActions.typeText(STRING_TO_BE_TYPED), ViewActions.closeSoftKeyboard()); //line 1

        Espresso.onView(ViewMatchers.withText("Say hello!")).perform(ViewActions.click()); //line 2

        String expectedText = "Hello, " + STRING_TO_BE_TYPED + "!";
        Espresso.onView(ViewMatchers.withId(R.id.textView)).check(ViewAssertions.matches(ViewMatchers.withText(expectedText))); //line 3

    }
}
