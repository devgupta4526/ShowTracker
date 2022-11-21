package com.underground.showstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

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
    }
}