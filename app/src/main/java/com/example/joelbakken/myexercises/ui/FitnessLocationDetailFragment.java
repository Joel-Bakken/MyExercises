package com.example.joelbakken.myexercises.ui;

import android.content.Intent;
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

public class FitnessLocationDetailFragment extends Fragment implements View.OnClickListener {
    @Bind(R.id.fitnessLocationImageView) ImageView mImageLabel;
    @Bind(R.id.fitnessLocationTextView) TextView mNameLabel;
    @Bind(R.id.ratingTextView) TextView mRatingLabel;
    @Bind(R.id.websiteTextView) TextView mWebsiteLabel;
    @Bind(R.id.phoneTextView) TextView mPhoneLabel;
    @Bind(R.id.addressTextView) TextView mAddressLabel;
    @Bind(R.id.saveFitnessButton) Button mSaveFitnessButton;

    private FitnessLocation mFitnessLocation;

    public static FitnessLocationDetailFragment newInstance(FitnessLocation fitnessLocation) {
        FitnessLocationDetailFragment fitnessLocationDetailFragment = new FitnessLocationDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("fitnessLocation", Parcels.wrap(fitnessLocation));
        fitnessLocationDetailFragment.setArguments(args);
        return fitnessLocationDetailFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mFitnessLocation = Parcels.unwrap(getArguments().getParcelable("fitnessLocation"));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_fitness_location_detail, container, false);
        ButterKnife.bind(this, view);

        Picasso.with(view.getContext()).load(mFitnessLocation.getImageUrl()).into(mImageLabel);

        mNameLabel.setText(mFitnessLocation.getName());
        mWebsiteLabel.setOnClickListener(this);
        mRatingLabel.setText(Double.toString(mFitnessLocation.getRating()) + "/5");
        mPhoneLabel.setOnClickListener(this);
        mPhoneLabel.setText(mFitnessLocation.getPhone());
        mAddressLabel.setText(android.text.TextUtils.join(", ", mFitnessLocation.getAddress()));
        mAddressLabel.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        if (v == mWebsiteLabel) {
            Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(mFitnessLocation.getWebsite()));
            startActivity(webIntent);
        }
        if (v == mPhoneLabel) {
            Intent phoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + mFitnessLocation.getPhone()));
            startActivity(phoneIntent);
        }
        if (v == mAddressLabel) {
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:" + mFitnessLocation.getLatitude() + "," + mFitnessLocation.getLongitude() + "?q=(" + mFitnessLocation.getName() + ")"));
            startActivity(mapIntent);
        }
    }
}

