package com.example.testmyskills;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.testmyskills.classes.Film;

import java.util.ArrayList;

public class ReviewsActivity extends AppCompatActivity {

    ArrayList<Film> films = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);



        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);

        SQLiteManager sql = new SQLiteManager(this);

        films.add(sql.filmsRead("Film 1"));
        films.add(sql.filmsRead("Film 2"));
        films.add(sql.filmsRead("Film 3"));

        FilmsActivity adapter = new FilmsActivity(this, films);
        ListView listView = (ListView) findViewById(R.id.filmsList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ReviewsActivity.this, DetailsActivity.class);
                intent.putExtra("title", films.get(i).getFilm());
                startActivity(intent);
            }
        });
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