package com.example.joelbakken.myexercises.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.example.joelbakken.myexercises.R;
import com.example.joelbakken.myexercises.adapters.FitnessLocationPagerAdapter;
import com.example.joelbakken.myexercises.models.FitnessLocation;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FitnessLocationDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mViewPager;
    private FitnessLocationPagerAdapter adapterViewPager;
    ArrayList<FitnessLocation> mfitnessLocations = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_location_detail);
        ButterKnife.bind(this);

        mfitnessLocations = Parcels.unwrap(getIntent().getParcelableExtra("fitnessLocations"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new FitnessLocationPagerAdapter(getSupportFragmentManager(),mfitnessLocations);
        mViewPager.setAdapter(adapterViewPager);
        mViewPager.setCurrentItem(startingPosition);
    }
}
