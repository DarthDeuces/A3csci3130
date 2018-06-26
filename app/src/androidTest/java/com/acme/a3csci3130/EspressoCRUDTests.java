package com.acme.a3csci3130;

import org.junit.Rule;
import org.junit.Test;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class EspressoCRUDTests {

    @Rule
    public ActivityTestRule mActivityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void createContact(){
        onView(withId(R.id.name)).perform(typeText("John"));
        onView(withId(R.id.pbusiness)).perform(typeText("super cool business"));
        onView(withId(R.id.addr)).perform(typeText("72 FireField Lane"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.submitButton)).perform(click());

    }
    @Test
    public void updateContact(){
        onData(withItemContent("item: 1")).perform(click());
        onView(withId(R.id.name)).perform(typeText("John"));
        onView(withId(R.id.pbusiness)).perform(typeText("super cool business"));
        onView(withId(R.id.addr)).perform(typeText("72 FireField Lane"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.updateButton)).perform(click());
    }
    @Test
    public void deleteContact(){
        onData(withItemContent("item: 1")).perform(click());
        onView(withId(R.id.name)).perform(typeText("John"));
        onView(withId(R.id.pbusiness)).perform(typeText("super cool business"));
        onView(withId(R.id.addr)).perform(typeText("72 FireField Lane"));
        onView(withId(R.id.province)).perform(typeText("NS"));
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
