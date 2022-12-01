package com.example.testmyskills.classes;

public class SingleReview {

    private String gender;
    private int review;
    private String title;

    public SingleReview(String title, String gender, int review) {
        this.title = title;
        this.gender = gender;
        this.review = review;
    }

    public String getGender() {
        return gender;
    }

    public int getReview() {
        return review;
    }
    public String getTitle(){
        return title;
    }
}
