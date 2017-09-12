package com.example.joelbakken.myexercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.Date;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewActivity extends AppCompatActivity {
    @Bind(R.id.exerciseLog) TextView mExerciseLog;
    @Bind(R.id.listView) ListView mListView;
    String[] exercises = new String[] {
            "Jogging", "Running", "Swimming"};
    String[] date = new String[] {
            "6/8/2017", "7/1/2017", "9/1/2017"};
    String[] startTime = new String[] {
            "13:00", "11:15", "12:00"};
    String[] endTime = new String[]{
            "14:10", "12:00", "13:00"};
    String[] notes = new String[] {
            "Blah Blah Blah", "I went far and fast", "The water was pretty wet"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        ButterKnife.bind(this);

        MyExercisesArrayAdapter adapter = new MyExercisesArrayAdapter(this, android.R.layout.simple_list_item_1, exercises, date, startTime, endTime, notes);
        mListView.setAdapter(adapter);

//        Intent intent = getIntent();
//        String exercise = intent.getStringExtra("exercise");
//        mExerciseLog.setText("On " + date  + " you did " + exercise + " for exercise from " + startTime + " to " + endTime + "." + "Notes: " + notes);
    }
}
