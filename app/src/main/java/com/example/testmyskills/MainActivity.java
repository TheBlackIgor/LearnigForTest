package com.example.testmyskills;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.testmyskills.classes.Review;

public class MainActivity extends AppCompatActivity {

    private String filmForReview = null;
    private int review = -1;
    private String gender = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("spr grupa b");
        setClickListeners();

    }

    public void setClickListeners(){
        Button saveButton = findViewById(R.id.save);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(filmForReview == null || review == -1 || gender == null){
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Błąd");
                    alert.setCancelable(false);//nie zamyka się po kliknięciu poza nim
                    alert.setMessage("Wprowadź dobre dane debilu");
                    alert.setNeutralButton("Close", null).show(); // null to pusty click
                }else{
                    AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                    alert.setTitle("Saved");
                    alert.setCancelable(false);//nie zamyka się po kliknięciu poza nim
                    alert.setMessage("Zapisano do bazy danych");
                    alert.setNeutralButton("OK", null).show(); // null to pusty click
                     RadioGroup radio1 = findViewById(R.id.radio1);
                     radio1.clearCheck();
                    RadioGroup radio2 = findViewById(R.id.radio2);
                    radio2.clearCheck();
                    RadioGroup radio3 = findViewById(R.id.radio3);
                    radio3.clearCheck();
                    Review newReview = new Review(filmForReview, review, gender);
                    SQLiteManager sql = new SQLiteManager(MainActivity.this);
                    sql.addReviewToDatabase(newReview);
                    filmForReview = null;
                    gender = null;
                    review = -1;
                }
            }
        });
        Button button2 = findViewById(R.id.goToTheNextView);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReviewsActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onRadioButtonClicked1(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.film1:
                if (checked)
                    filmForReview = "Film 1";
                    break;
            case R.id.film2:
                if (checked)
                    filmForReview = "Film 2";
                    break;
            case R.id.film3:
                if (checked)
                    filmForReview = "Film 3";
                    break;
        }
    }

    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.review0:
                if (checked)
                    review = 0;
                break;
            case R.id.review1:
                if (checked)
                    review = 1;
                break;
            case R.id.review2:
                if (checked)
                    review = 2;
                break;
            case R.id.review3:
                if (checked)
                    review = 3;
                break;
            case R.id.review4:
                if (checked)
                    review = 4;
                break;
            case R.id.review5:
                if (checked)
                    review = 5;
                break;

        }
    }
    public void onRadioButtonClicked3(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        // Check which radio button was clicked
        switch(view.getId()) {
            case R.id.M:
                if (checked)
                    gender = "M";
                break;
            case R.id.K:
                if (checked)
                    gender = "K";
                break;
        }
    }
}