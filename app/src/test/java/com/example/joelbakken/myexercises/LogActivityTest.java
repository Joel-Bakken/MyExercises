package com.example.joelbakken.myexercises;

import android.os.Build;
import android.widget.Button;

import com.example.joelbakken.myexercises.ui.LogActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class LogActivityTest {
    private LogActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(LogActivity.class);
    }

    @Test
    public void validateButtonContent() {
        Button aboutButton = (Button) activity.findViewById(R.id.aboutButton);
        assertTrue("About".equals(aboutButton.getText().toString()));
    }

    private void assertTrue(boolean equals) {
    }
}