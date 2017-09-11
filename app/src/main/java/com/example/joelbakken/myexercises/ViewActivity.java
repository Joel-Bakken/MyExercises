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
import butterknife.Bind;
import butterknife.ButterKnife;

public class ViewActivity extends AppCompatActivity {
    @Bind(R.id.exerciseLog) TextView mExerciseLog;
    @Bind(R.id.listView) ListView mListView;
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
        ButterKnife.bind(this);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, exercise);
        mListView.setAdapter(adapter);

        mListView.setOnClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String exercise = ((TextView)view).getText().toString();
                Toast.makeText(ViewActivity.this, exercise,
                        Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String exercise = intent.getStringExtra("exercise");
        mExerciseLog.setText("On this date you did" + exercise + "for exercise.");
    }
}
