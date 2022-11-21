package com.underground.showstracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class UserActivity extends AppCompatActivity {

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

    }
}