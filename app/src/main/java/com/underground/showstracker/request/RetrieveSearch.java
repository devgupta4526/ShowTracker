package com.underground.showstracker.request;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.underground.showstracker.models.movieModels.MovieModel;
import com.underground.showstracker.response.MovieSearchResponse;
import com.underground.showstracker.utils.Credentials;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class RetrieveSearch {

    public MutableLiveData<Boolean> movieLoading;

    private String query;
    private int pageNumber;
    boolean cancelRequest;

    public RetrieveSearch(String query, int pageNumber) {
        movieLoading = new MutableLiveData<>();
        movieLoading.postValue(true);
        this.query = query;
        this.pageNumber = pageNumber;
        cancelRequest = false;
    }

    public List<MovieModel> search(int filter) {
        //filter is for differentiating movie search and TV show search 1->MovieSearch else->TVSearch
        //uses search method of api and returns list of movies api returns
        movieLoading.postValue(true);
        Response response = null;
        try {
            if(filter==1) response = searchMovie(query, pageNumber).execute();
            else response = searchTV(query, pageNumber).execute();

            if (cancelRequest) {
                return null;
            }
            if (response.code() == 200) {
                movieLoading.postValue(false);
                List<MovieModel> list = new ArrayList<>(((MovieSearchResponse) response.body()).getMovies());
                System.out.println(list);
                return list;
//                if (pageNumber == 1) {
//                    //sending to live data
//                    //post value is for background
//                    //set value is for background
//                    return  list;
//                } else {
//                    List<MovieModel> currentMovies = mSearchMovies.getValue();
//                    currentMovies.addAll(list);
//                    mSearchMovies.postValue(currentMovies);
//
//                }
            } else {
                movieLoading.postValue(false);
                String error = response.errorBody().string();
                Log.v("TAG", "Error " + error);
                return null;
            }

        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }

    }

    //Search Query
    private Call<MovieSearchResponse> searchMovie(String query, int pageNumber) {
        return Servicey.getMovieApi().searchMovie(
                Credentials.API_KEY,
                query,
                pageNumber);
    }

    //Search Query
    private Call<MovieSearchResponse> searchTV(String query, int pageNumber) {
        return Servicey.getMovieApi().searchTV(
                Credentials.API_KEY,
                query,
                pageNumber);
    }
}