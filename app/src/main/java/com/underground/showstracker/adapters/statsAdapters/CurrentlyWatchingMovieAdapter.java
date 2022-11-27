package com.underground.showstracker.adapters.statsAdapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.underground.showstracker.R;
import com.underground.showstracker.models.movieModels.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class CurrentlyWatchingMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static List<MovieModel> cwMovies = new ArrayList<>();

    private CurrentlyWatchingMovieAdapter() {
    }

    private static final CurrentlyWatchingMovieAdapter cwAdapter = new CurrentlyWatchingMovieAdapter();

    public static  CurrentlyWatchingMovieAdapter getWatchlistInstance(){
        return cwAdapter;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.similar_movie_item, parent, false);
        return new StatListMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500/" + cwMovies.get(position).getPoster_path())
                .transform(new FitCenter(), new RoundedCorners(28))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(((StatListMovieViewHolder) holder).moviePoster);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if (cwMovies != null) {
            return cwMovies.size();
        }
        return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setWatchlist(List<MovieModel> mMovies) {
        CurrentlyWatchingMovieAdapter.clearList();
        for(MovieModel m: mMovies){
            CurrentlyWatchingMovieAdapter.addCurrentWatchMovie(m);
        }
        notifyDataSetChanged();
    }

    //Getting the id of the movie Clicked
    public MovieModel getSelectedMovie(int position) {
        if (cwMovies.size() > 0) {
            return cwMovies.get(position);
        }
        return null;
    }

    public static List<MovieModel> getCurrentWatchlist() {
        return cwMovies;
    }

    public static void addCurrentWatchMovie(MovieModel m){
        cwMovies.add(m);
    }

    public static void clearList(){
        cwMovies.clear();
    }

}
