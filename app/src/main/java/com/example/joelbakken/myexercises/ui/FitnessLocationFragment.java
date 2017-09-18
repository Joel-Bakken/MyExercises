package com.example.joelbakken.myexercises.ui;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joelbakken.myexercises.R;
import com.example.joelbakken.myexercises.models.FitnessLocation;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class FitnessLocationFragment extends Fragment {
    @Bind(R.id.fitnessLocationImageView) ImageView mImageLabel;
    @Bind(R.id.fitnessLNameTextView) TextView mNameLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveFitnessButton) Button mSaveFitnessButton;

    private FitnessLocation mFitnessLocation;

    public static FitnessLocationFragment newInstance(FitnessLocation fitnessLocation) {
        FitnessLocationFragment fitnessLocationFragment = new FitnessLocationFragment();
        Bundle args = new Bundle();
        args.putParcelable("fitnessLocation", Parcels.wrap(fitnessLocation));
        fitnessLocationFragment.setArguments(args);
        return fitnessLocationFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFitnessLocation = Parcels.unwrap(getArguments().getParcelable("fitnessLocation"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fitness_location, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mFitnessLocation.getImageUrl()).into(mImageLabel);

        mNameLabel.setText(mFitnessLocation.getName());
        mRatingLabel.setText(Double.toString(mFitnessLocation.getRating()) + "/5");
        mPhoneLabel.setText(mFitnessLocation.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mFitnessLocation.getAddress()));

        return view;
    }
}

