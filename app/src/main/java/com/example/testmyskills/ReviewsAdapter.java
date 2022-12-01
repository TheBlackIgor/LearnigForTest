package com.example.testmyskills;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.testmyskills.classes.Film;
import com.example.testmyskills.classes.SingleReview;

import java.util.ArrayList;

public class ReviewsAdapter extends ArrayAdapter<SingleReview> {

    public ReviewsAdapter(Context context, ArrayList<SingleReview> review) {
        super(context, 0, review);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        SingleReview review = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_reviews_adapter, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView score = (TextView) convertView.findViewById(R.id.score);
        TextView gender = (TextView) convertView.findViewById(R.id.gender);
        // Populate the data into the template view using the data object
        title.setText(review.getTitle());
       score.setText(String.valueOf(review.getReview()));
        gender.setText(review.getGender());
        // Return the completed view to render on screen
        return convertView;
    }
}