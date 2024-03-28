package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.myapplication.databinding.ActivityBasketBinding;
import com.example.myapplication.databinding.ActivitySignupBinding;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {
    private ActivityBasketBinding binding;
    private Button buyButton, recipientButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        buyButton = findViewById(R.id.buyButton);
        recipientButton = findViewById(R.id.Recipientbutton);

        calculatorCart();

        recipientButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasketActivity.this, RecipientActivity.class);
                startActivity(intent);
            }
        });
        buyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BasketActivity.this, PaymentInformationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void calculatorCart() {
        double percentTax = 0.02;
        double delivery = 0.99;
        double discountPercentage = 0.20;

        double subtotal = 2.99;

        double taxPrice = subtotal * percentTax;
        double total = subtotal * (1+ percentTax) + delivery;
        double discountedPrice = total * discountPercentage;
        double totalAfterDisocount = total - discountedPrice;

        //"%.2f" converts floats to a 2 decimal number, rather than a very long sequence of numbers.
        binding.deliveryTxt.setText("£" + String.format("%.2f", delivery));
        binding.subtotalTxt.setText("£" + String.format("%.2f", subtotal));
        binding.discountpriceText.setText("£" + String.format("%.2f", discountedPrice));
        binding.totalTxt.setText("£"+String.format("%.2f", totalAfterDisocount));
        binding.totaltaxTxt.setText("£" + String.format("%.2f", taxPrice));

    }
}