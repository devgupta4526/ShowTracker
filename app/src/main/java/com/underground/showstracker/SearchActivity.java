package com.underground.showstracker;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayoutMediator;
import com.underground.showstracker.adapters.MovieRecyclerViewAdapter;
import com.underground.showstracker.adapters.NowPlayingAdapter;
import com.underground.showstracker.adapters.OnMovieListener;
import com.underground.showstracker.adapters.SearchViewAdapter;
import com.underground.showstracker.models.MovieModel;
import com.underground.showstracker.request.MovieApiClient;
import com.underground.showstracker.viewmodels.MovieListViewModel;

import java.util.ArrayList;
import java.util.List;

public class SearchActivity extends AppCompatActivity implements OnMovieListener {
    EditText editText;
    Button searchButton;
    String search;
    RecyclerView searchMovieView;
    RelativeLayout loadingLayout;
    private SearchViewAdapter adapter;
    private NowPlayingAdapter now_playing_adapter;
    List<MovieModel> searchList ;

    //View Model
    private MovieListViewModel movieListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        //Edittext Button findviewbyid
         editText = findViewById(R.id.searchMov);
         searchButton = findViewById(R.id.searchBtn);
         searchMovieView = findViewById(R.id.searchResultItem);
        loadingLayout  = findViewById(R.id.loading);
        searchList  = new ArrayList<>();
        //MovieIntent
        Intent MovieI = new Intent(SearchActivity.this, MovieListActivity.class );

        //UserIntent
        Intent UserI = new Intent(SearchActivity.this, UserActivity.class);

        //setup bottom navigation
        BottomNavigationView bottomNavigation;
        bottomNavigation = findViewById(R.id.btmNavView);
        bottomNavigation.setSelectedItemId(R.id.searchNav);
        bottomNavigation.setOnItemSelectedListener( item -> {
            switch (item.getItemId()){
                case R.id.homeNav:
                    startActivity(MovieI);
                    break;
                case R.id.userNav:
                    startActivity(UserI);
                    break;
            }
            return true;
        });

        //view-model
        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);

        //set up UI
        configureRecyclerView();


        //calling the observers
//        ObserveMovieTrendingChange();
//        ObserveMovieNowPlayingChange();


        search = editText.getText().toString();
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //calling the observers
                ObserveMovieTrendingChange(search);
                //api Calls
                searchMovieApi(search, 1);

            }
        });




    }


    //observing changes
    private void ObserveMovieTrendingChange(String s) {
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                // observe any data change
                if (movieModels != null) {

                    for (MovieModel movieModel : movieModels) {
                        //get the data in log
                        if(movieModel.getTitle().contains(s)) {
                            searchList.add(movieModel);
                            adapter.setmMovies(searchList);
                        }
                    }

//                    for (MovieModel movieModel : searchList) {
//                        //get the data in log
//                        adapter.setmMovies(searchList);
//                    }
                }
                else {
                    editText.setText("No Movies present");
                }
            }
        });
    }


    //calling the trending in main-activity
    private void searchMovieApi(String query, int pageNumber) {
        movieListViewModel.searchMovieApi(query, pageNumber);
    }



    private void configureRecyclerView() {
        adapter = new SearchViewAdapter(this);
        searchMovieView.setAdapter(adapter);
        searchMovieView.setLayoutManager(new LinearLayoutManager(this));

//        //Pagination support
//        searchMovieView.addOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                if (!searchMovieView.canScrollVertically(1)) {
//                    //here we need to get another page of data
//                    movieListViewModel.searchNextPage();
//                }
//            }
//        });

    }


    @Override
    public void onMovieClick(int position) {
        //sending data to detail intent
        Intent detailIntent = new Intent(SearchActivity.this,MovieDetailsActivity.class);
        detailIntent.putExtra("movie", adapter.getSelectedMovie(position));
        startActivity(detailIntent);

    }
    @Override
    public void onMovieClickNowPlaying(int position) {
        Intent detailIntent = new Intent(SearchActivity.this, MovieDetailsActivity.class);
        detailIntent.putExtra("movie", now_playing_adapter.getSelectedMovie(position));
        startActivity(detailIntent);
    }
    }
