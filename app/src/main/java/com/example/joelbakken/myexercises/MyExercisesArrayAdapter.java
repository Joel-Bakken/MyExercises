package com.example.joelbakken.myexercises;


import android.content.Context;
import android.widget.ArrayAdapter;

import static android.R.attr.resource;

public class MyExercisesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mExercises;
    private String[] mDate;
    private String[] mStartTime;
    private String[] mEndTime;
    private String[] mNotes;

    public MyExercisesArrayAdapter(Context mContext, int resource, String[] mExercises, String[] mDate, String[] mStartTime, String[] mEndTime, String[] mNotes) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mExercises = mExercises;
        this.mDate = mDate;
        this.mStartTime = mStartTime;
        this.mEndTime = mEndTime;
        this.mNotes = mNotes;
    }

    @Override
    public Object getItem(int position) {
        String exercises = mExercises[position];
        String date = mDate[position];
        String startTime = mStartTime[position];
        String endTime = mEndTime[position];
        String notes = mNotes[position];
        return String.format("You %s on %s from %s to %s. Notes: %s ", exercises, date, startTime, endTime, notes);
    }

    @Override
    public int getCount() {
        return mExercises.length;
    }

}
