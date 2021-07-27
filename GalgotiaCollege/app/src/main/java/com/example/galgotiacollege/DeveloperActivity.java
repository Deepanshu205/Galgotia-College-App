package com.example.galgotiacollege;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DeveloperActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_developer);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Developers");

    }
}