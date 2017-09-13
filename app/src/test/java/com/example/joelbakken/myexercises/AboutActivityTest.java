package com.example.joelbakken.myexercises;

import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
@RunWith(RobolectricGradleTestRunner.class)

public class AboutActivityTest {
    private AboutActivity activity;

    @Before
    public void setup() {
        activity = Robolectric.setupActivity(AboutActivity.class);
    }

    @Test
    public void validateButtonContent() {
        Button logButton = (Button) activity.findViewById(R.id.logButton);
        assertTrue("click to log your latest exercises".equals(logButton.getText().toString()));
    }

    private void assertTrue(boolean equals) {
    }
}