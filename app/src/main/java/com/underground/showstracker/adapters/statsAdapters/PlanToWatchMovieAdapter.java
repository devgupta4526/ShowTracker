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

public class PlanToWatchMovieAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>  {

    public static List<MovieModel> planToWatch_list = new ArrayList<>();
    private static List<String> planToWatch_Titles = new ArrayList<>();

    private PlanToWatchMovieAdapter() {
    }

    private static final PlanToWatchMovieAdapter ptwAdapter = new PlanToWatchMovieAdapter();

    public static  PlanToWatchMovieAdapter getWatchlistInstance(){
        return ptwAdapter;
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
                .load("https://image.tmdb.org/t/p/w500/" + planToWatch_list.get(position).getPoster_path())
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
        if (planToWatch_list != null) {
            return planToWatch_list.size();
        }
        return 0;
    }

    @SuppressLint("NotifyDataSetChanged")
    public void setWatchlist(List<MovieModel> mMovies) {
        PlanToWatchMovieAdapter.clearList();
        for(MovieModel m: mMovies){
            PlanToWatchMovieAdapter.addtoList(m);
        }
        notifyDataSetChanged();
    }

    //Getting the id of the movie Clicked
    public MovieModel getSelectedMovie(int position) {
        if (planToWatch_list.size() > 0) {
            return planToWatch_list.get(position);
        }
        return null;
    }

    public static List<String> getTitles() {
        return planToWatch_Titles;
    }

    public static List<MovieModel> getList() {
        return planToWatch_list;
    }

    public static void addtoList(MovieModel m){
        planToWatch_list.add(m);
        planToWatch_Titles.add(m.getTitle());
    }

    public static void clearList(){
        planToWatch_list.clear();
    }

}
