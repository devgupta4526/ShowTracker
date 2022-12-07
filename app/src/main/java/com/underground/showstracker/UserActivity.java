package com.underground.showstracker;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.underground.showstracker.adapters.statsAdapters.FavoritesAdapter;
import com.underground.showstracker.adapters.statsAdapters.WatchListMovieAdapter;
import com.underground.showstracker.models.movieModels.MovieModel;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class UserActivity extends AppCompatActivity {


    RecyclerView watchlistCycle;
    RecyclerView favouritesCycle;
    ArrayList<MovieModel> watchListArrayList;
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

        FavoritesAdapter favAda = FavoritesAdapter.getFavListInstance();
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

    private void loadData() {
        // method to load arraylist from shared prefs
        // initializing our shared prefs with name as 
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for gson.
        Gson gson = new Gson();

        // below line is to get to string present from our 
        // shared prefs if not present setting it as null.
        String json = sharedPreferences.getString("courses", null);

        // below line is to get the type of our array list.
        Type type = new TypeToken<ArrayList<MovieModel>>() {}.getType();

        // in below line we are getting data from gson 
        // and saving it to our array list
        watchListArrayList = gson.fromJson(json, type);

        // checking below if the array list is empty or not
        if (watchListArrayList == null) {
            // if the array list is empty
            // creating a new array list.
            watchListArrayList = new ArrayList<MovieModel>();
        }
    }

    private void saveData() {
        // method for saving the data in array list.
        // creating a variable for storing data in
        // shared preferences.
        SharedPreferences sharedPreferences = getSharedPreferences("shared preferences", MODE_PRIVATE);

        // creating a variable for editor to
        // store data in shared preferences.
        SharedPreferences.Editor editor = sharedPreferences.edit();

        // creating a new variable for gson.
        Gson gson = new Gson();

        // getting data from gson and storing it in a string.
        String json = gson.toJson(watchListArrayList);

        // below line is to save data in shared
        // prefs in the form of string.
        editor.putString("courses", json);

        // below line is to apply changes
        // and save data in shared prefs.
        editor.apply();

        // after saving data we are displaying a toast message.
        Toast.makeText(this, "Saved Array List to Shared preferences. ", Toast.LENGTH_SHORT).show();
    }
}