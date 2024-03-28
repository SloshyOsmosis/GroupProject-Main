package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.myapplication.databinding.ActivityBasketBinding;
import com.example.myapplication.databinding.ActivitySignupBinding;

public class BasketActivity extends AppCompatActivity {
    private ActivityBasketBinding binding;
    private double tax;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        calculatorCart();
    }

    private void calculatorCart() {
        double percentTax = 0.02;
        double delivery = 10;

    }
}