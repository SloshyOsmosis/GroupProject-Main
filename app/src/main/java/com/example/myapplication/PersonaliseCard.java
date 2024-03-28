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
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;
import com.google.gson.Gson;

public class PersonaliseCard extends AppCompatActivity {
    ImageButton sidemenuButton, uploadImageButton;
    ImageView cardView, uploadImage;
    Button inviteCollaboratorButton, giftcardbutton, deliverybutton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActivityResultLauncher resultLauncher;
    private CustomCard customCard;

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
        deliverybutton = findViewById(R.id.btnDeliveryDate);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        int cardImage = getIntent().getIntExtra("imageResourceId", 0);
        cardView.setImageResource(cardImage);

        registerResult();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_homepage:
                        Intent homeIntent = new Intent(PersonaliseCard.this, HomePageActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.navigation_basketPage:
                        Intent basketIntent = new Intent(PersonaliseCard.this, BasketActivity.class);
                        startActivity(basketIntent);
                        break;
                    case R.id.navigation_paymentPlanPage:
                        PaymentPlanFragment paymentPlanFragment = new PaymentPlanFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.homelayout, paymentPlanFragment).addToBackStack(null).commit() ;
                        break;
                    case R.id.navigation_accountPage:
                        Intent accountIntent = new Intent(PersonaliseCard.this, ProfileActivity.class);
                        startActivity(accountIntent);
                        break;
                    case R.id.navigation_settingsPage:
                        Intent settingsIntent = new Intent(PersonaliseCard.this, SettingsPageActivity.class);
                        startActivity(settingsIntent);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
        deliverybutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveCard(customCard);
                Intent intent = new Intent(PersonaliseCard.this, CalendarActivity.class);
                startActivity(intent);
                finish();
            }});
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

    private void saveCard(CustomCard customCard){
        SharedPreferences.Editor editor = getSharedPreferences("MyPreferences", MODE_PRIVATE).edit();
        Gson gson = new Gson();
        String json = gson.toJson(customCard);
        editor.putString("currentCard", json);
        editor.apply();

        Toast.makeText(this, "Card saved to json file", Toast.LENGTH_SHORT).show();
    }
}
