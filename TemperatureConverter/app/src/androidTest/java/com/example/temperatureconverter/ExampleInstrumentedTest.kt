package com.example.temperatureconverter

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ConverterTest {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun convert_F_to_C_round() {
        onView(withId(R.id.fahrenheitOption)).perform(click())
        onView(withId(R.id.temperatureInput_editText))
            .perform(typeText("10.00"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.convertButton)).perform(click())
        onView(withId(R.id.result))
            .check(matches(withText(containsString("Result: -39,57 C°"))))
    }

    @Test
    fun convert_F_to_C_no_round() {
        onView(withId(R.id.fahrenheitOption)).perform(click())
        onView(withId(R.id.temperatureInput_editText))
            .perform(typeText("10.00"))
            .perform(closeSoftKeyboard())
        onView(withId(R.id.round_switch)).perform(click())
        onView(withId(R.id.convertButton)).perform(click())
        onView(withId(R.id.result))
            .check(matches(withText(containsString("Result: -39.568345323741006 C°"))))
    }
}