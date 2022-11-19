package com.underground.showstracker.utils;

import com.underground.showstracker.models.Movie;
import com.underground.showstracker.response.CastResponse;
import com.underground.showstracker.response.MovieSearchResponse;
import com.underground.showstracker.response.ReviewResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    //search
    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    //trending

    @GET("/3/movie/popular")
    Call<MovieSearchResponse> getTrending(
            @Query("api_key") String key,
            @Query("page") int page

    );

    //now-playing
    @GET("/3/movie/now_playing")
    Call<MovieSearchResponse> getNowPlaying(
            @Query("api_key") String key,
            @Query("page") int page

    );

    //search by id
    @GET("3/movie/{movie_id}?")
    Call<Movie> getMovie(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    //get similar movie
    @GET("3/movie/{movie_id}/similar")
    Call<MovieSearchResponse> getSimilarMovies(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key,
            @Query("page") int page
    );

    @GET("3/movie/{movie_id}/credits")
    Call<CastResponse> getCasts(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key
    );

    @GET("3/movie/{movie_id}/reviews")
    Call<ReviewResponse> getReviews(
            @Path("movie_id") int movie_id,
            @Query("api_key") String api_key,
            @Query("page") int page
    );

}
