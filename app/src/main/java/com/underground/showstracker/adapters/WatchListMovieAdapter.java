package com.underground.showstracker.adapters;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.underground.showstracker.R;
import com.underground.showstracker.models.movieModels.Movie;
import com.underground.showstracker.models.movieModels.MovieModel;

import java.util.ArrayList;
import java.util.List;

public class WatchListMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static List<MovieModel> watchlist = new ArrayList<>();

    private WatchListMovieAdapter() {
    }

    private static final WatchListMovieAdapter wm = new WatchListMovieAdapter();

    public static  WatchListMovieAdapter getWatchlistInstance(){
        return wm;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.similar_movie_item, parent, false);
        return new WatchListMovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load("https://image.tmdb.org/t/p/w500/" + watchlist.get(position).getPoster_path())
                .transform(new FitCenter(), new RoundedCorners(28))
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(((WatchListMovieViewHolder) holder).moviePoster);
    }

    /**
     * Returns the total number of items in the data set held by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        if (watchlist != null) {
            return watchlist.size();
        }
        return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setWatchlist(List<MovieModel> mMovies) {
        this.watchlist = mMovies;
        notifyDataSetChanged();
    }

    //Getting the id of the movie Clicked
    public MovieModel getSelectedMovie(int position) {
        if (watchlist.size() > 0) {
            return watchlist.get(position);
        }
        return null;
    }

    public static List<MovieModel> getWatchlist() {
        return watchlist;
    }

    public static void addWatchList(MovieModel m){
        watchlist.add(m);
    }

}
