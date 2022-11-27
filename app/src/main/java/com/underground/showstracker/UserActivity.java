package com.underground.showstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.underground.showstracker.adapters.statsAdapters.FavoritesAdapter;
import com.underground.showstracker.adapters.statsAdapters.WatchListMovieAdapter;

public class UserActivity extends AppCompatActivity {


    RecyclerView watchlistCycle;
    RecyclerView favouritesCycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);


        //MovieIntent
        Intent MovieI = new Intent(UserActivity.this, MovieListActivity.class );

        //SearchIntent
        Intent SearchI = new Intent(UserActivity.this, SearchActivity.class);

        //setup bottom navigation
        BottomNavigationView bottomNavigation;
        bottomNavigation = findViewById(R.id.btmNavView);
        bottomNavigation.setSelectedItemId(R.id.userNav);
        bottomNavigation.setOnItemSelectedListener( item -> {
            switch (item.getItemId()){
                case R.id.homeNav:
                    startActivity(MovieI);
                    break;
                case R.id.searchNav:
                    startActivity(SearchI);
                    break;
            }
            return true;
        });

        watchlistCycle = findViewById(R.id.watched_movies_recycler_view);
        favouritesCycle = findViewById(R.id.favorites_recycler_view);
        setUpRecyclerView();


    }

    private void setUpRecyclerView() {

        WatchListMovieAdapter watchlistAdapter = WatchListMovieAdapter.getWatchlistInstance();
        watchlistCycle.setAdapter(watchlistAdapter);

        FavoritesAdapter favAda = FavoritesAdapter.getWatchlistInstance();
        favouritesCycle.setAdapter(favAda);

//        //Pagination support
//        watchlistCycle.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (!watchlistCycle.canScrollHorizontally(1)) {
//                    //here we need to get another page of data
////                    movieListViewModel.searchNextPageSimilar();
//                }
//            }
//        });

    }
}