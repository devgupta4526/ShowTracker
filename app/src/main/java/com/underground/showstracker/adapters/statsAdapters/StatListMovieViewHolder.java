package com.underground.showstracker.adapters.statsAdapters;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.underground.showstracker.R;
import com.underground.showstracker.adapters.OnMovieListener;

public class StatListMovieViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    ImageView moviePoster;
    OnMovieListener onMovieListener;

    public StatListMovieViewHolder(@NonNull View itemView) {
        super(itemView);
        moviePoster = itemView.findViewById(R.id.similar_movie_item_poster);
    }

    @Override
    public void onClick(View view) {

    }
}
