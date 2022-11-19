package com.underground.showstracker.response;

import com.underground.showstracker.models.Movie;

//single movie
public class MovieResponse {

    //finding the movie object
    private Movie movie;

    public Movie getMovie() {
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
