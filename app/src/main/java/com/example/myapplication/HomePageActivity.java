package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;

public class HomePageActivity extends AppCompatActivity {

    ImageButton basketButton, sidemenuButton;
    TextView logo;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ImageView profile;

    List<Cards> cards;

    RecyclerView cardRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        basketButton = findViewById(R.id.basket_icon);
        sidemenuButton = findViewById(R.id.menu_icon);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        cardRecyclerView = findViewById(R.id.cardrecyclerView);

        logo = findViewById(R.id.logo_icon);

        cards = new ArrayList<Cards>();
        cards.add(new Cards(R.drawable.anniversary));
        cards.add(new Cards(R.drawable.birthday1));
        cards.add(new Cards(R.drawable.birthday2));
        cards.add(new Cards(R.drawable.christmas1));
        cards.add(new Cards(R.drawable.christmas2));
        cards.add(new Cards(R.drawable.getwell1));
        cards.add(new Cards(R.drawable.getwell2));
        cards.add(new Cards(R.drawable.retirement));
        cards.add(new Cards(R.drawable.valentine1));
        cards.add(new Cards(R.drawable.valentine2));


        cardRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        cardRecyclerView.setAdapter(new MyAdapter(getApplicationContext(),cards));;
        basketButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageActivity.this, BasketActivity.class);
                startActivity(intent);
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


                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}