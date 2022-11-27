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

public class FavoritesAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static List<MovieModel> favList = new ArrayList<>();

    private FavoritesAdapter() {
    }

    private static final FavoritesAdapter favAdapter = new FavoritesAdapter();

    public static  FavoritesAdapter getFavListInstance(){
        return favAdapter;
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
                .load("https://image.tmdb.org/t/p/w500/" + favList.get(position).getPoster_path())
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
        if (favList != null) {
            return favList.size();
        }
        return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setWatchlist(List<MovieModel> mMovies) {
        FavoritesAdapter.clearList();
        for(MovieModel m: mMovies){
            FavoritesAdapter.addFavoriteList(m);
        }
        notifyDataSetChanged();
    }

    //Getting the id of the movie Clicked
    public MovieModel getSelectedMovie(int position) {
        if (favList.size() > 0) {
            return favList.get(position);
        }
        return null;
    }

    public static List<MovieModel> getFavList() {
        return favList;
    }

    public static void addFavoriteList(MovieModel m){
        favList.add(m);
    }

    public static void clearList(){
        favList.clear();
    }

}
