package com.exercise.viewpager.model;

public class Movie {
    private String tittle;
    private String description;
    private String imageURL;

    public Movie(String tittle, String description, String imageURL) {
        this.tittle = tittle;
        this.description = description;
        this.imageURL = imageURL;
    }

    public String getTittle() {
        return tittle;
    }

    public void setTittle(String tittle) {
        this.tittle = tittle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
