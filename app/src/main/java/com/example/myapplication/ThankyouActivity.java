package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;

public class ThankyouActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    Button backtohome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);

        backtohome = findViewById(R.id.backtohome);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ThankyouActivity.this, HomePageActivity.class);
                startActivity(intent);
            }
        });
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_homepage:
                        Intent homeIntent = new Intent(ThankyouActivity.this, HomePageActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.navigation_basketPage:
                        Intent basketIntent = new Intent(ThankyouActivity.this, BasketActivity.class);
                        startActivity(basketIntent);
                        break;
                    case R.id.navigation_paymentPlanPage:
                        PaymentPlanFragment paymentPlanFragment = new PaymentPlanFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.homelayout, paymentPlanFragment).addToBackStack(null).commit() ;
                        break;
                    case R.id.navigation_accountPage:
                        Intent accountIntent = new Intent(ThankyouActivity.this, ProfileActivity.class);
                        startActivity(accountIntent);
                        break;
                    case R.id.navigation_settingsPage:
                        Intent settingsIntent = new Intent(ThankyouActivity.this, SettingsPageActivity.class);
                        startActivity(settingsIntent);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }
}