package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
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
    List<Cards> filteredCards;

    RecyclerView cardRecyclerView;
    MyAdapter myAdapter;

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
        //Setting cards and categories.
        cards.add(new Cards(R.drawable.anniversary, "Anniversary"));cards.add(new Cards(R.drawable.birthday1, "Birthday"));
        cards.add(new Cards(R.drawable.birthday2, "Birthday"));cards.add(new Cards(R.drawable.christmas1, "Christmas"));
        cards.add(new Cards(R.drawable.christmas2, "Christmas"));cards.add(new Cards(R.drawable.retirement, "Anniversary"));
        cards.add(new Cards(R.drawable.getwell1, "Get well"));cards.add(new Cards(R.drawable.getwell2, "Get well"));
        cards.add(new Cards(R.drawable.valentine1, "Valentine"));cards.add(new Cards(R.drawable.valentine2, "Valentine"));

        filteredCards = new ArrayList<>(cards);

        myAdapter = new MyAdapter(getApplicationContext(), filteredCards);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        cardRecyclerView.setLayoutManager(layoutManager);
        cardRecyclerView.setAdapter(myAdapter);
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

                //Switch statement will be used here to change activities.

                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    //This method is called when a filter button is pressed based on the specified category.
    private void filterCards(String category){
        filteredCards.clear();
        for (Cards card : cards){
            if(card.getCategory().equals(category)){
                filteredCards.add(card);
            }
        }
        myAdapter.filterList(filteredCards);
    }

    //Filters the cards based on which button is pressed and which category each card is assigned to.
    public void filterBirthdayTapped(View view) {
        filterCards("Birthday");
    }

    public void filterWellSoonTapped(View view) {
        filterCards("Get well");
    }

    public void filterChristmasTapped(View view) {
        filterCards("Christmas");
    }

    public void filterAnniversaryTapped(View view) {
        filterCards("Anniversary");
    }

    public void filterValentinesTapped(View view) {
        filterCards("Valentine");
    }
}