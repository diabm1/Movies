package com.javaunit3.springmvc;

public class BatmanMovie implements com.javaunit3.springmvc.Movie {
    @Override
    public String getTitle() {
        return "Batman: The Dark Knight";
    }

    @Override
    public String getMaturityRating() {
        return "PG-13";
    }

    @Override
    public String getGenre(){
        return "Action";
    }
}
