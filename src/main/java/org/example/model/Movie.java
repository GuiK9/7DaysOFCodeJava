package org.example.model;

import org.example.service.Content;
import org.json.JSONObject;

public class Movie implements Content {
    private String title;
    private String rank;
    private String ImgeURL;
    private String rating;
    private String year;

    public Movie(String title, String rank, String imgeURL, String rating, String year) {
        this.title = title;
        this.rank = rank;
        ImgeURL = imgeURL;
        this.rating = rating;
        this.year = year;
    }

    public Movie(Object JSONObject) {
        JSONObject jsonObject = new JSONObject(JSONObject.toString());
        String JSONtitle = jsonObject.getString("title");
        String JSONrank = jsonObject.getString("rank");
        String JSONimageURL = jsonObject.getString("image");
        String JSONYear = jsonObject.getString("year");
        String JSONRating = jsonObject.getString("imDbRating");
        this.title = JSONtitle;
        this.rank = JSONrank;
        ImgeURL = JSONimageURL;
        this.rating = JSONRating;
        this.year = JSONYear;
    }

    public String getTitle() {
        return title;
    }

    public String getRank() { return rank; }

    public String getRating() {
        return rating;
    }

    public String getYear() {
        return year;
    }

    public String getImgeURL() {
        return ImgeURL;
    }
    @Override
    public String toString() {
        return this.title + this.rank;
    }
}
