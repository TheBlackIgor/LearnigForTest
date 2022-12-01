package com.example.testmyskills.classes;

public class Film {
    private String film;
    private double avg;
    private int women;
    private int men;

    public Film(String film, double avg,  int women, int men) {
        this.film = film;
        this.avg = avg;
        this.women = women;
        this.men = men;
    }

    @Override
    public String toString() {
        return "Film{" +
                "film='" + film + '\'' +
                ", avg=" + avg +
                ", women=" + women +
                ", men=" + men +
                '}';
    }

    public String getFilm() {
        return film;
    }

    public double getAvg() {
        return avg;
    }

    public int getWomen() {
        return women;
    }

    public int getMen() {
        return men;
    }
}
