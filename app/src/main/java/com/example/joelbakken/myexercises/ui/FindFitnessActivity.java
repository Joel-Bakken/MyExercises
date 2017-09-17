package com.example.joelbakken.myexercises.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.joelbakken.myexercises.R;

import butterknife.Bind;

public class FindFitnessActivity extends AppCompatActivity {
    @Bind(R.id.findFitnessButton) Button mFindFitnessButton;
    @Bind(R.id.textViewFindFitness) TextView mTextViewFindFitness;
    @Bind(R.id.editTextZipCode) EditText mEditTextZipCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_fitness);
        mFindFitnessButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String editTextZipCode = mEditTextZipCode.getText().toString();
                Intent intent = new Intent(FindFitnessActivity.this, SearchResultsActivity.class);
                intent.putExtra("editTextZipCode", editTextZipCode);
                if (editTextZipCode.equals("")) {
                    Toast.makeText(FindFitnessActivity.this, "Please enter a zip code", Toast.LENGTH_LONG).show();
                } else {
                    startActivity(intent);
                }
            }
        });

    }
}
