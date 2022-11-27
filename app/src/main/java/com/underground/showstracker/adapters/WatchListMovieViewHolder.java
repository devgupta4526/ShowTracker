package com.underground.showstracker.adapters;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.underground.showstracker.R;

public class WatchListMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView moviePoster;
    OnMovieListener onMovieListener;

    public WatchListMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        moviePoster = itemView.findViewById(R.id.similar_movie_item_poster);
    }

    @Override
    public void onClick(View view) {

    }
}
