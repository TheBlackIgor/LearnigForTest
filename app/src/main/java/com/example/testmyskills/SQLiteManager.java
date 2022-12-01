package com.example.testmyskills;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.testmyskills.classes.Film;
import com.example.testmyskills.classes.Review;
import com.example.testmyskills.classes.SingleReview;

import java.util.ArrayList;


public class SQLiteManager extends SQLiteOpenHelper
{
    private static SQLiteManager sqLiteManager;

    private static final String DATABASE_NAME = "REVIEWS";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "Note";
    private static final String COUNTER = "Counter";

    private static final String ID_FIELD = "id";
    private static final String TITLE_FIELD = "title";
    private static final String REVIEW_FIELD = "review";
    private static final String GENDER_FIELD = "gender";

    public SQLiteManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static SQLiteManager instanceOfDatabase(Context context)
    {
        if(sqLiteManager == null)
            sqLiteManager = new SQLiteManager(context);

        return sqLiteManager;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase)
    {
        StringBuilder sql;
        sql = new StringBuilder()
                .append("CREATE TABLE ")
                .append(TABLE_NAME)
                .append("(")
                .append(COUNTER)
                .append(" INTEGER PRIMARY KEY AUTOINCREMENT, ")
                .append(ID_FIELD)
                .append(" INT, ")
                .append(TITLE_FIELD)
                .append(" TEXT, ")
                .append(REVIEW_FIELD)
                .append(" INT, ")
                .append(GENDER_FIELD)
                .append(" TEXT)");

        sqLiteDatabase.execSQL(sql.toString());
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion){}

    public void addReviewToDatabase(Review review)
    {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        ContentValues contentValues = new ContentValues();
        contentValues.put(ID_FIELD, review.getId());
        contentValues.put(TITLE_FIELD, review.getTitle());
        contentValues.put(REVIEW_FIELD, review.getReview());
        contentValues.put(GENDER_FIELD, review.getGender());

        sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
    }

    public ArrayList<Review> readReviews()
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<Review> reviews = new ArrayList<>();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME, null))
        {
            if(result.getCount() != 0)
            {
                while (result.moveToNext())
                {
                    int id = result.getInt(1);
                    String title = result.getString(2);
                    int review = Integer.parseInt(result.getString(3));
                    String gender = result.getString(4);
                    Review resReview = new Review(title,review,gender);
                    reviews.add(resReview);
                }
            }
        }
        return reviews;
    }

    public Film filmsRead(String title)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        double reviewAvg = 0.0;
        double count = 0;
        int m = 0;
        int k = 0;
        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE title='" + title + "'", null))
        {
            if(result.getCount() != 0)
            {
                while (result.moveToNext())
                {
                    count++;
                    int id = result.getInt(1);
                    reviewAvg += Integer.parseInt(result.getString(3));
                    String gender = result.getString(4);
                    if(gender == "M") m++;
                    else k++;

                }
            }
        }
        if(count > 0)
            return new Film(title, (reviewAvg / count), m, k);
        else
            return new Film(title, 0.00, 0,0);
    }

    public ArrayList<SingleReview> readSingleReview(String title)
    {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        ArrayList<SingleReview> reviews = new ArrayList<>();

        try (Cursor result = sqLiteDatabase.rawQuery("SELECT * FROM " + TABLE_NAME + " WHERE title='" + title + "'", null))
        {
            if(result.getCount() != 0)
            {
                while (result.moveToNext())
                {
                    String gender = result.getString(4);
                    int review = Integer.parseInt(result.getString(3));
                    reviews.add(new SingleReview(title, gender, review));
                }
            }
        }
        return reviews;
    }



}

