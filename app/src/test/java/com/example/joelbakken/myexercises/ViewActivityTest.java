package com.example.joelbakken.myexercises;

import android.os.Build;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class ViewActivityTest {
    private ViewActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(ViewActivity.class);
    }

    @Test
    public void validateTextViewContent() {
        TextView exerciseLog = (TextView) activity.findViewById(R.id.exerciseLog);
        assertTrue("Exercise Log".equals(exerciseLog.getText().toString()));
    }

    private void assertTrue(boolean equals) {
    }
}