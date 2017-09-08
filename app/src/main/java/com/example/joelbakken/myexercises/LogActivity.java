package com.example.joelbakken.myexercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class LogActivity extends AppCompatActivity {
    private Button mSubmitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        mSubmitButton = (Button) findViewById(R.id.submitButton);
            mSubmitButton.setOnClickListener();
    }
}
