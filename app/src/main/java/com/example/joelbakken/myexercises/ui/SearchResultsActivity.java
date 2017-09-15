package com.example.joelbakken.myexercises.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;


import com.example.joelbakken.myexercises.models.FitnessLocation;
import com.example.joelbakken.myexercises.R;
import com.example.joelbakken.myexercises.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.callback.Callback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class SearchResultsActivity extends AppCompatActivity {
    public static final  String TAG = SearchResultsActivity.class.getSimpleName();

    @Bind(R.id.searchResultsListView) ListView mSearchResultsListView;
    @Bind(R.id.fitnessLocationTextView) TextView mFitnessLocationTextView;

    public ArrayList<FitnessLocation> mFitnessLocations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String fitnessLocation = intent.getStringExtra("fitnessLocation");

        mFitnessLocationTextView.setText("Here are all the fitness centers new: " + fitnessLocation);

        getFitnessLocations(fitnessLocation);
    }

    private void getFitnessLocations(String fitnessLocation) {
        final YelpService yelpService = new YelpService();

        yelpService.findFitnessLocations(fitnessLocation, new Callback(){

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) {
                mFitnessLocations = yelpService.processResults(response);

                SearchResultsActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        String[] fitnessLocationNames = new String [mFitnessLocations.size()];
                        for (int i = 0; i < fitnessLocationNames.length; i++) {
                            fitnessLocationNames[i] = mFitnessLocations.get(i).getName();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(SearchResultsActivity.this, android.R.layout.simple_list_item_1, fitnessLocationNames);
                        mSearchResultsListView.setAdapter(adapter);

                        for (FitnessLocation fitnessLocation : mFitnessLocations) {
                            Log.d(TAG, "Name: " + fitnessLocation.getName());
                            Log.d(TAG, "Phone: " + fitnessLocation.getPhone());
                            Log.d(TAG, "Website: " + fitnessLocation.getWebsite());
                            Log.d(TAG, "Image url: " + fitnessLocation.getImageUrl());
                            Log.d(TAG, "Rating: " + Double.toString(fitnessLocation.getRating()));
                            Log.d(TAG, "Address: " + android.text.TextUtils.join(", ", fitnessLocation.getAddress()));
                            Log.d(TAG, "Categories: " + fitnessLocation.getCategories().toString());
                        }
                    }
                });
            }
        });
    }
}