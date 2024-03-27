package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Spinner privacySpinner = findViewById(R.id.privacySpinner);
        Spinner accountSpinner = findViewById(R.id.accountSpinner);
        Spinner securitySpinner = findViewById(R.id.securitySpinner);
        Spinner feedbackSpinner = findViewById(R.id.feedbackSpinner);

        privacySpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
        accountSpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
        securitySpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
        feedbackSpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
    }

    private AdapterView.OnItemSelectedListener spinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selectedItem = parent.getItemAtPosition(position).toString();
            switch (parent.getId()) {
                case R.id.privacySpinner:
                    // Handle privacy selection
                    showToast("Privacy: " + selectedItem);
                    break;
                case R.id.accountSpinner:
                    // Handle account selection
                    showToast("Account: " + selectedItem);
                    break;
                case R.id.securitySpinner:
                    // Handle security selection
                    showToast("Security: " + selectedItem);
                    break;
                case R.id.feedbackSpinner:
                    // Handle feedback selection
                    showToast("Feedback: " + selectedItem);
                    break;
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Do nothing
        }
    };

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
