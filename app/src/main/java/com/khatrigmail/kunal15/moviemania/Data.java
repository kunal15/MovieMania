package com.khatrigmail.kunal15.moviemania;

/**
 * Created by Admin on 22-06-2016.
 */
public class Data {
        private String image;
        private String imageName;
        private int id;
        private String release_date;
        private String adult;
        private String overview;
        private String backdrop;
        private String original_language;
        private int vote_count;
        private double popularity;
        private double vote_average;
        private String trailer_key;

        public Data() {
        }

        public Data(String image, String title, int id, String release_date, String adult, String overview, String backdrop, String original_language, int vote_count, double popularity, double vote_average, String trailer_key) {
            this.image = image;
            this.imageName = title;
            this.id = id;
            this.release_date = release_date;
            this.adult = adult;
            this.overview = overview;
            this.backdrop = backdrop;
            this.original_language = original_language;
            this.vote_count = vote_count;
            this.popularity = popularity;
            this.vote_average = vote_average;
            this.trailer_key = trailer_key;
        }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public String getAdult() {
        return adult;
    }

    public void setAdult(String adult) {
        this.adult = adult;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getBackdrop() {
        return backdrop;
    }

    public void setBackdrop(String backdrop) {
        this.backdrop = backdrop;
    }

    public String getOriginal_language() {
        return original_language;
    }

    public void setOriginal_language(String original_language) {
        this.original_language = original_language;
    }

    public int getVote_count() {
        return vote_count;
    }

    public void setVote_count(int vote_count) {
        this.vote_count = vote_count;
    }

    public double getPopularity() {
        return popularity;
    }

    public void setPopularity(double popularity) {
        this.popularity = popularity;
    }

    public double getVote_average() {
        return vote_average;
    }

    public void setVote_average(double vote_average) {
        this.vote_average = vote_average;
    }

    public String getTrailer_key() {
        return trailer_key;
    }

    public void setTrailer_key(String trailer_key) {
        this.trailer_key = trailer_key;
    }
}
