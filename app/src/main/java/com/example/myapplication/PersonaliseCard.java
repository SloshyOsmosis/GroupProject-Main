package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class PersonaliseCard extends AppCompatActivity {
    ImageView cardView;
    Button inviteCollaboratorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise_card);

        cardView = findViewById(R.id.imageView);

        inviteCollaboratorButton = findViewById(R.id.btnDeliveryDate);

        // Set click listener for the invite collaborator button
        inviteCollaboratorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Replace or add your fragment here
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_collaborator, new CollaboratorFragment1())
                        .addToBackStack(null)
                        .commit();
            }
        });

        int cardImage = getIntent().getIntExtra("imageResourceId", 0);
        cardView.setImageResource(cardImage);
    }
}