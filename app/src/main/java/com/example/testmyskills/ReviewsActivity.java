package com.example.testmyskills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Arrays;

public class ReviewsActivity extends AppCompatActivity {

    private ArrayList<Review> reviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SQLiteManager sql = new SQLiteManager(ReviewsActivity.this);
        reviews = sql.readReviews();

//       Log.d("DATAFROMDB", Arrays.toString(reviews.toArray()));

        reviews.add(new Review("XD", 2, "M"));
        reviews.add(new Review("XD", 2, "M"));
        AlertDialog.Builder alert = new AlertDialog.Builder(ReviewsActivity.this);
        alert.setTitle("Data");
        alert.setCancelable(false);//nie zamyka się po kliknięciu poza nim
        alert.setMessage(reviews.get(0).getTitle());
        alert.setNeutralButton("Close", null).show(); // null to pusty click
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            this.finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}