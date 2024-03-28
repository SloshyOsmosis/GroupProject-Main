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
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class PaymentInformationActivity extends AppCompatActivity {
    EditText etCardNumber, etName, etDate, etCVC;
    Button checkoutButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_information);

        etCardNumber = findViewById(R.id.txt_entercardnum);
        etName = findViewById(R.id.txt_entername);
        etDate = findViewById(R.id.txt_enterdate);
        etCVC = findViewById(R.id.txt_entercvc);

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        checkoutButton = findViewById(R.id.Checkout_btn);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id) {
                    case R.id.navigation_homepage:
                        Intent homeIntent = new Intent(PaymentInformationActivity.this, HomePageActivity.class);
                        startActivity(homeIntent);
                        break;
                    case R.id.navigation_basketPage:
                        Intent basketIntent = new Intent(PaymentInformationActivity.this, BasketActivity.class);
                        startActivity(basketIntent);
                        break;
                    case R.id.navigation_paymentPlanPage:
                        PaymentPlanFragment paymentPlanFragment = new PaymentPlanFragment();
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.homelayout, paymentPlanFragment).addToBackStack(null).commit() ;
                        break;
                    case R.id.navigation_accountPage:
                        Intent accountIntent = new Intent(PaymentInformationActivity.this, ProfileActivity.class);
                        startActivity(accountIntent);
                        break;
                    case R.id.navigation_settingsPage:
                        Intent settingsIntent = new Intent(PaymentInformationActivity.this, SettingsPageActivity.class);
                        startActivity(settingsIntent);
                        break;
                }
                drawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (CardNumber() && CardName() && CardDate() && CardCVC()){
                    Checkout();
                }
                else {
                    Toast.makeText(PaymentInformationActivity.this, "Please fill in all Card fields", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    //Card validation
    private boolean CardNumber(){
        String cardNumber = etCardNumber.getText().toString().trim();
        return cardNumber.length() == 16;
    }

    private boolean CardName(){
        String name = etName.getText().toString().trim();
        return !name.isEmpty();
    }

    private boolean CardDate(){
        String date = etDate.getText().toString().trim();
        return date.length() == 8;
    }

    private boolean CardCVC(){
        String cvc = etCVC.getText().toString().trim();
        return cvc.length() == 3;
    }

    private void Checkout(){
        Intent intent = new Intent(PaymentInformationActivity.this, ThankyouActivity.class);
        Toast.makeText(PaymentInformationActivity.this, "Card successfully sent!", Toast.LENGTH_SHORT).show();
        startActivity(intent);
        finish();
    }
}