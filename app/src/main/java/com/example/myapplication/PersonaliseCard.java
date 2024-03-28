package com.example.myapplication;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresExtension;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.google.android.material.navigation.NavigationView;

public class PersonaliseCard extends AppCompatActivity {
    ImageButton sidemenuButton, uploadImageButton;
    ImageView cardView, uploadImage;
    Button inviteCollaboratorButton, giftcardbutton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActivityResultLauncher resultLauncher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personalise_card);

        cardView = findViewById(R.id.imageView);
        uploadImage = findViewById(R.id.uploadedImage);
        uploadImageButton =findViewById(R.id.addImage);
        inviteCollaboratorButton = findViewById(R.id.btnInvite);

        sidemenuButton = findViewById(R.id.menu_icon);
        giftcardbutton = findViewById(R.id.giftcardButton);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        int cardImage = getIntent().getIntExtra("imageResourceId", 0);
        cardView.setImageResource(cardImage);

        registerResult();
        inviteCollaboratorButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.pagelayout, new CollaboratorFragment1())
                        .addToBackStack(null)
                        .commit();
            }
        });
        sidemenuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                //Switch statement will be used here to change activities.
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        uploadImageButton.setOnClickListener(new View.OnClickListener() {
            @RequiresExtension(extension = Build.VERSION_CODES.R, version = 2)
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_PICK_IMAGES);
                resultLauncher.launch(intent);
            }
        });

        // to implement:

        //giftcardbutton.setOnClickListener(new View.OnClickListener() {

        //});
    }
    private void registerResult(){
        resultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                            assert result.getData() != null;
                            Uri imageUri = result.getData().getData();
                            uploadImage.setImageURI(imageUri);
                    }
                }
        );
    }
}
