package com.example.testmyskills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ListView;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ActionBar actionBar =  getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        Intent intent = getIntent();
        String filmTitle = intent.getStringExtra("title");

        SQLiteManager sql = new SQLiteManager(this);

        ReviewsAdapter adapter = new ReviewsAdapter(this, sql.readSingleReview(filmTitle));
        ListView listView = (ListView) findViewById(R.id.reviewsList);
        listView.setAdapter(adapter);
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