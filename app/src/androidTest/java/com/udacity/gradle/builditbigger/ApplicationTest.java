package com.udacity.gradle.builditbigger;

import android.support.test.runner.AndroidJUnit4;

import com.udacity.gradle.builditbigger.asynctask.FetchJokeTask;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest {

    @Test
    public void testJokeNotEmpty() {
        String joke = null;

        FetchJokeTask fetchJokeTask = new FetchJokeTask();
        fetchJokeTask.execute();
        try {
            joke = fetchJokeTask.get();
        } catch(Exception e) {
            e.printStackTrace();
        }

        assertNotNull(joke);
        assertNotEquals("", joke);
    }
}