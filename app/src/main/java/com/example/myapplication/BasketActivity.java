package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.example.myapplication.databinding.ActivityBasketBinding;
import com.example.myapplication.databinding.ActivitySignupBinding;

import java.util.ArrayList;

public class BasketActivity extends AppCompatActivity {
    private ActivityBasketBinding binding;
    private ImageView cardView;
    private double tax;
    private ArrayList<Cards> selectedCard = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        int cardImage = getIntent().getIntExtra("imageResourceId", 0);
        cardView.setImageResource(cardImage);

        calculatorCart();
    }

    private void calculatorCart() {
        double percentTax = 0.02;
        double delivery = 10;
        double discountPercentage = 0.20;

        double subtotal = 0.0;

        for (Cards card : selectedCard) {
            subtotal += card.getPrice();
        }

        double taxPrice = subtotal * percentTax;
        double total = subtotal * (1+ percentTax) + delivery;
        double discountedPrice = total * discountPercentage;
        double totalAfterDisocount = total - discountedPrice;

        //"%.2f" converts floats to a 2 decimal number, rather than a very long sequence of numbers.
        binding.subtotalTxt.setText("£" + String.format("%.2f", subtotal));
        binding.discountpriceText.setText("£" + String.format("%.2f", discountedPrice));
        binding.totalTxt.setText("£"+String.format("%.2f", totalAfterDisocount));
        binding.totaltaxTxt.setText("£" + String.format("%.2f", taxPrice));

    }
}