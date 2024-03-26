package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class PersonaliseCard extends AppCompatActivity {
    ImageView cardView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise_card);

        cardView = findViewById(R.id.imageView);

        int imageResourceId = getIntent().getIntExtra("imageResourceId", 0);
        cardView.setImageResource(imageResourceId);
    }
}