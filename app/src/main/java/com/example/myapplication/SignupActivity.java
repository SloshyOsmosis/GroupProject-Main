package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.databinding.ActivitySignupBinding;

public class SignupActivity extends AppCompatActivity {

    private ActivitySignupBinding binding;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySignupBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        databaseHelper = new DatabaseHelper(this);

        binding.signupBtn.setOnClickListener(v -> {
            String email = binding.txtEmail.getText().toString().trim();
            String password = binding.txtPassword.getText().toString();
            String confirmPassword = binding.txtRetypepassword.getText().toString();

            if (TextUtils.isEmpty(email) || TextUtils.isEmpty(password) || TextUtils.isEmpty(confirmPassword)) {
                showToast("Please fill in all fields.");
                return;
            }

            if (!isValidEmail(email)) {
                showToast("Please enter a valid email address.");
                return;
            }

            if (!isValidPassword(password)) {
                showToast("Please enter a valid password (at least 6 characters long).");
                return;
            }

            if (!password.equals(confirmPassword)) {
                showToast("Passwords do not match.");
                return;
            }

            if (databaseHelper.checkEmail(email)) {
                showToast("Email already exists. Please log in.");
                return;
            }

            if (databaseHelper.insertData(email, password)) {
                showToast("Signup successful");
                navigateToHomePage();
            } else {
                showToast("Signup failed. Please try again.");
            }
        });

        binding.txtAlreadylogin.setOnClickListener(v -> navigateToLoginPage());
    }

    private boolean isValidEmail(CharSequence target) {
        return (!TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches());
    }

    private boolean isValidPassword(String password) {
        return password.length() >= 6;
    }

    private void showToast(String message) {
        Toast.makeText(SignupActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    private void navigateToLoginPage() {
        Intent intent = new Intent(SignupActivity.this, LoginActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity so the user cannot go back to signup screen
    }

    private void navigateToHomePage() {
        Intent intent = new Intent(SignupActivity.this, HomePageActivity.class);
        startActivity(intent);
        finish(); // Finish the current activity so the user cannot go back to signup screen
    }
}
