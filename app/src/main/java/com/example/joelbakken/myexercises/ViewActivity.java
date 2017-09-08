package com.example.joelbakken.myexercises;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class ViewActivity extends AppCompatActivity {
    ListView listView;
    String[] exercise = new String[] {
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

        listView = (ListView) findViewById(R.id.baseListView);

        listView.setAdapter(new ExercisesAdapter(this, exercise, date, startTime, endTime, notes));
    }
}
