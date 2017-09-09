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

    public MyExercisesArrayAdapter(Context context, String[] exercises, String[] date, String[] startTime, String[] endTime, String[] notes) {
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
        String exercise = mExercises[position];
        String date = mDate[position];
        String startTime = mStartTime[position];
        String endTime = mEndTime[position];
        String notes = mNotes[position];
        return String.format("%s\n", exercise, date, startTime, endTime, notes);
    }

    @Override
    public int getCount() {
        return mExercises.length + mDate.length + mStartTime.length + mEndTime.length + mNotes.length;
    }

}
