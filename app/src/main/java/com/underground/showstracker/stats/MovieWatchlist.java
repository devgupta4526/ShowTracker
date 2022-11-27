package com.underground.showstracker.stats;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.underground.showstracker.adapters.ProductionCompaniesAdapter;
import com.underground.showstracker.adapters.SimilarMoviesAdapter;
import com.underground.showstracker.models.movieModels.Movie;
import com.underground.showstracker.models.movieModels.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class MovieWatchlist {
    private static List<MovieModel> mWatchlist = new ArrayList<>();

    private MovieWatchlist(){
    }

    public List<MovieModel> getmWatchlistInstance(){
        return mWatchlist;
    }

    public void addToWatchList(MovieModel m){
        mWatchlist.add(m);
    }

    public void removeFromWatchlist(MovieModel m){
        mWatchlist.remove(m);
    }
}
