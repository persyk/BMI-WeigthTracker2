package com.example.bmi_weigthtracker

import org.junit.Test

import org.junit.Assert.*
import java.util.regex.Pattern.matches

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        fun greeterSaysHello() {
            onView(withId(R.id.name_field)).perform(typeText("Steve"))
            onView(withId(R.id.greet_button)).perform(click())
            onView(withText("Hello Steve!")).check(matches(isDisplayed()))
        }
    }

}
