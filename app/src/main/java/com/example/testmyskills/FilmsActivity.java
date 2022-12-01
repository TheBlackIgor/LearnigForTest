package com.example.testmyskills;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.testmyskills.classes.Film;

import java.util.ArrayList;

public class FilmsActivity extends ArrayAdapter<Film> {

    public FilmsActivity(Context context, ArrayList<Film> films) {
        super(context, 0, films);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Film film = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.activity_films, parent, false);
        }
        // Lookup view for data population
        TextView title = (TextView) convertView.findViewById(R.id.title);
        TextView avg = (TextView) convertView.findViewById(R.id.avg);
        TextView kReviews = (TextView) convertView.findViewById(R.id.kReviews);
        TextView mReviews = (TextView) convertView.findViewById(R.id.mReviews);
        // Populate the data into the template view using the data object
        title.setText(film.getFilm());
        avg.setText(String.valueOf(round(film.getAvg())));
        kReviews.setText(String.valueOf(film.getWomen()));
        mReviews.setText(String.valueOf(film.getMen()));
        // Return the completed view to render on screen
        return convertView;
    }

    private double round(double a){
        return Math.round(a * 100.0) / 100.0;
    }
}