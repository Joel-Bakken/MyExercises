package com.example.joelbakken.myexercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mLogButton;
    private Button mViewButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLogButton = (Button) findViewById(R.id.logButton);
            mLogButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, LogActivity.class);
                    startActivity(intent);
                }
            });

        mViewButton = (Button) findViewById(R.id.viewButton);
            mViewButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, ViewActivity.class);
                    startActivity(intent);
                }
            });

    }
}
