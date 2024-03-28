package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Import Log class
import android.view.View;
import android.widget.Toast;
import com.example.myapplication.databinding.ActivityLoginBinding;
import com.example.myapplication.databinding.ActivitySignupBinding;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class LoginActivity extends AppCompatActivity {

    private static final String TAG = "LoginActivity";
    ActivityLoginBinding binding;
    DatabaseHelper databaseHelper;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate: Activity created");

        databaseHelper = new DatabaseHelper(this);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);

        // Check if Remember Me is enabled
        if (preferences.getBoolean("remember_me", false)) {
            String savedEmail = preferences.getString("email", "");
            String savedPassword = preferences.getString("password", "");
            binding.txtEmail.setText(savedEmail);
            binding.txtPassword.setText(savedPassword);
            binding.chkRememberMe.setChecked(true);
        }

        binding.loginbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Login button clicked");
                String email = binding.txtEmail.getText().toString();
                String password = binding.txtPassword.getText().toString();

                if (email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "All fields are mandatory", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "onClick: Empty email or password field");
                } else {
                    boolean checkCredential = databaseHelper.checkUser(email, password);
                    if (checkCredential) {
                        Log.d(TAG, "onClick: Login successful");
                        Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                        // Save credentials if Remember Me is checked
                        if (binding.chkRememberMe.isChecked()) {
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("email", email);
                            editor.putString("password", password);
                            editor.putBoolean("remember_me", true);
                            editor.apply();
                        }
                        Intent intent = new Intent(LoginActivity.this, HomePageActivity.class);
                        startActivity(intent);
                        finish(); // Finish LoginActivity to prevent back navigation
                    } else {
                        // Differentiate between "Invalid email" and "Incorrect password" messages
                        if (databaseHelper.checkEmailExists(email)) {
                            Toast.makeText(LoginActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(LoginActivity.this, "Invalid Email", Toast.LENGTH_SHORT).show();
                        }
                        Log.d(TAG, "onClick: Invalid credentials");
                    }
                }
            }
        });

        binding.txtAlready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "onClick: Already have an account text clicked");
                Intent intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });
    }
}

