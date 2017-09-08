package com.example.joelbakken.myexercises;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ExercisesAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mExercises;
    private String[] mDate;
    private String[] mStartTime;
    private String[] mEndTime;
    private String[] mNotes;

    public ExercisesAdapter(Context context, String[] exercises, String[] date, String[] startTime, String[] endTime, String[] notes) {
        this.mContext = context;
        this.mExercises = exercises;
        this.mDate = date;
        this.mStartTime = startTime;
        this.mEndTime = endTime;
        this.mNotes = notes;
    }

    @Override
    public int getCount() {
        return mExercises.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) mContext
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View gridView;

        if (convertView == null) {
            // get layout from xml file
            listView = inflater.inflate(R.layout.exercise_list_item, null);


            // pull views
            TextView exerciseView = (TextView) listView
                    .findViewById(R.id.exercise_item_label);

            // set values into views
            exerciseView.setText(mExercises[position], mDate[position], mStartTime[position], mEndTime[position], mNotes[position]);// exercise details list
        } else {
            listView = (View) convertView;
        }
        return listView;
    }

    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}