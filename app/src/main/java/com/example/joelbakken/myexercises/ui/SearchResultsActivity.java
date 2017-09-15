package com.example.joelbakken.myexercises.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import se.akerfeldt.okhttp.signpost.OkHttpOAuthConsumer;
import se.akerfeldt.okhttp.signpost.SigningInterceptor;


import com.example.joelbakken.myexercises.adapters.FitnessLocationListAdapter;
import com.example.joelbakken.myexercises.models.FitnessLocation;
import com.example.joelbakken.myexercises.R;
import com.example.joelbakken.myexercises.services.YelpService;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class SearchResultsActivity extends AppCompatActivity {
    public static final  String TAG = SearchResultsActivity.class.getSimpleName();

    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    private FitnessLocationListAdapter mAdapter;

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

        yelpService.findFitness(fitnessLocation, new Callback(){


            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }


            public void onResponse(Call call, Response response) {
                mFitnessLocations = yelpService.processResults(response);

                SearchResultsActivity.this.runOnUiThread(new Runnable() {

                    @Override
                    public void run() {
                        mAdapter = new FitnessLocationListAdapter(getApplicationContext(), mFitnessLocations);
                        mRecyclerView.setAdapter(mAdapter);
                        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(SearchResultsActivity.this);
                        mRecyclerView.setLayoutManager(layoutManager);
                        mRecyclerView.setHasFixedSize(true);
                    }
                });
            }
        });
    }
}