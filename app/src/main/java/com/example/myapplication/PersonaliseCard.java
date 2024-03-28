package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class PersonaliseCard extends AppCompatActivity {
    ImageView cardView;
    Button inviteCollaboratorButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise_card);

        // Initialize views
        cardView = findViewById(R.id.imageView);
        inviteCollaboratorButton = findViewById(R.id.buttonInviteCollaborator);

        // Check if views are properly initialized
        if (inviteCollaboratorButton != null) {
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
        } else {
            // Display a toast message if the button is not found
            Toast.makeText(this, "Button not found", Toast.LENGTH_SHORT).show();
        }

        // Check for intent data to set card image
        int cardImage = getIntent().getIntExtra("imageResourceId", 0);
        cardView.setImageResource(cardImage);
    }
}
