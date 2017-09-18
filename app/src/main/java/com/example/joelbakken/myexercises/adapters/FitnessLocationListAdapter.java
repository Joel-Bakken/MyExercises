package com.example.joelbakken.myexercises.adapters;

import android.content.Context;
import android.content.Intent;
import android.icu.util.ULocale;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.joelbakken.myexercises.R;
import com.example.joelbakken.myexercises.models.FitnessLocation;
import com.example.joelbakken.myexercises.ui.FitnessDetailActivity;
import com.example.joelbakken.myexercises.ui.SearchResultsActivity;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


public class FitnessLocationListAdapter extends RecyclerView.Adapter<FitnessLocationListAdapter.FitnessLocationViewHolder> {
    private ArrayList<FitnessLocation> mFitnessLocations = new ArrayList<>();
    private Context context;

    public FitnessLocationListAdapter(Context context, ArrayList<FitnessLocation> fitnessLocations) {
        Context mContext = context;
        mFitnessLocations = fitnessLocations;
    }

    @Override
    public  FitnessLocationListAdapter.FitnessLocationViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fitness_location_list_item, parent, false);
        FitnessLocationViewHolder viewHolder = new FitnessLocationViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(FitnessLocationListAdapter.FitnessLocationViewHolder holder, int position) {
        holder.bindFitnessLocation(mFitnessLocations.get(position));
    }

    @Override
    public  int getItemCount() {
        return mFitnessLocations.size();
    }

    public class FitnessLocationViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @Bind(R.id.fitnessLocationImageView) ImageView mFitnessLocationImageView;
        @Bind(R.id.fitnessLocationTextView) TextView mFitnessLocationTextView;
        @Bind(R.id.categoryTextView) TextView mCategoryTextView;
        @Bind(R.id.ratingTextView) TextView mRatingTextView;

        private Context mContext;

        public FitnessLocationViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void bindFitnessLocation(FitnessLocation fitnessLocation) {
            Picasso.with(mContext).load(fitnessLocation.getImageUrl()).into(mFitnessLocationImageView);
            mFitnessLocationTextView.setText(fitnessLocation.getName());
            mCategoryTextView.setText(fitnessLocation.getCategories().get(0));
            mRatingTextView.setText("Rating: " + fitnessLocation.getRating() + "/5");
        }

        public void onClick(View v) {
            int itemPosition = getLayoutPosition();
            Intent intent = new Intent(mContext, FitnessDetailActivity.class);
            intent.putExtra("position", itemPosition);
            intent.putExtra("fitnessLocations", Parcels.wrap(mFitnessLocations));
            mContext.startActivity(intent);
        }
    }
}
