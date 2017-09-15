package com.example.joelbakken.myexercises;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.io.IOException;
import java.util.Date;

import javax.security.auth.callback.Callback;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Response;

public class SearchResultsActivity extends AppCompatActivity {
    public static final  String TAG = SearchResultsActivity.class.getSimpleName();

    @Bind(R.id.searchResultsListView) ListView mSearchResultsListView;
    @Bind(R.id.fitnessLocationTextView) TextView mFitnessLocationTextView;

    private String[] fitnessLocation = new String[] {"24hr Fitness", "L.A. Fitness", "Golds Gym", "ZUM Fitness", "TRIBE Fitness", "Anytime Fitness"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_results);
        ButterKnife.bind(this);

       ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, fitnessLocation);
       mSearchResultsListView.setAdapter(adapter);


       mSearchResultsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
           @Override
           public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
               String fitnessLocation = ((TextView) view).getText().toString();
               Toast.makeText(SearchResultsActivity.this, fitnessLocation, Toast.LENGTH_LONG).show();
           }
       });

        Intent intent = getIntent();
        String fitnessLocation = intent.getStringExtra("fitnessLocation");

        mFitnessLocationTextView.setText("Here are all the fitness centers near: " + fitnessLocation);

        getFitnessLocations(fitnessLocation);
    }

    private void getFitnessLocations(String fitnessLocation) {
        final YelpService yelpService = new YelpService();
        yelpService.findFitness(fitnessLocation, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    String jsonData = response.body().string();
                    Log.v(TAG, jsonData);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
