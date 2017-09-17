package com.example.joelbakken.myexercises.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.joelbakken.myexercises.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class LogActivity extends AppCompatActivity {

    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.aboutButton) Button mAboutButton;
    @Bind(R.id.exerciseName) EditText mExerciseName;  // for use with form validation
    @Bind(R.id.logDate) EditText mLogDate;  // for use with form validation
    @Bind(R.id.logStartTime) EditText mLogStartTime;  // for use with form validation
    @Bind(R.id.logEndTime) EditText mLogEndTime;  // for use with form validation
    @Bind(R.id.logExerciseNotes) EditText mLogExerciseNotes;  // for use with form validation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String exerciseName = mExerciseName.getText().toString();
                Intent intent = new Intent(LogActivity.this, ViewActivity.class);
                intent.putExtra("exerciseName", exerciseName);
                if (exerciseName.equals("")) {
                    Toast.makeText(LogActivity.this, "Please fill out all fields Elysia", Toast.LENGTH_LONG).show();
                } else {
                startActivity(intent);
                }
            }
        });

        mAboutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LogActivity.this, AboutActivity.class);
                startActivity(intent);
            }
        });
    }
}
