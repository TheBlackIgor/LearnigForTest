package com.example.testmyskills;

public class Review {
    private static int id = 0;
    private String title;
    private int review;
    private String gender;

    public Review(String title, int review, String gender) {
        this.id = this.id+1;
        this.title = title;
        this.review = review;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getReview() {
        return review;
    }

    public String getGender() {
        return gender;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
