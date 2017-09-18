package com.example.joelbakken.myexercises.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.joelbakken.myexercises.models.FitnessLocation;
import com.example.joelbakken.myexercises.ui.FitnessLocationFragment;

import java.util.ArrayList;

public class FitnessLocationPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<FitnessLocation> mFitnessLocations;

    public FitnessLocationPagerAdapter(FragmentManager fm, ArrayList<FitnessLocation> fitnessLocations) {
        super(fm);
        mFitnessLocations = fitnessLocations;
    }

    @Override
    public Fragment getItem(int position) {
        return FitnessLocationFragment.newInstance(mFitnessLocations.get(position));
    }

    @Override
    public int getCount() {
        return mFitnessLocations.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFitnessLocations.get(position).getName();
    }
}
