package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SettingsPageActivity extends AppCompatActivity {

    private static final int PRIVACY_SPINNER_ID = R.id.privacySpinner;
    private static final int ACCOUNT_SPINNER_ID = R.id.accountSpinner;
    private static final int SECURITY_SPINNER_ID = R.id.securitySpinner;
    private static final int FEEDBACK_SPINNER_ID = R.id.feedbackSpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        Spinner privacySpinner = findViewById(PRIVACY_SPINNER_ID);
        Spinner accountSpinner = findViewById(ACCOUNT_SPINNER_ID);
        Spinner securitySpinner = findViewById(SECURITY_SPINNER_ID);
        Spinner feedbackSpinner = findViewById(FEEDBACK_SPINNER_ID);

        privacySpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
        accountSpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
        securitySpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
        feedbackSpinner.setOnItemSelectedListener(spinnerItemSelectedListener);
    }

    private AdapterView.OnItemSelectedListener spinnerItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            String selectedItem = parent.getItemAtPosition(position).toString();
            int spinnerId = parent.getId();

            if (spinnerId == PRIVACY_SPINNER_ID) {
                showToast("Privacy: " + selectedItem);
            } else if (spinnerId == ACCOUNT_SPINNER_ID) {
                showToast("Account: " + selectedItem);
            } else if (spinnerId == SECURITY_SPINNER_ID) {
                showToast("Security: " + selectedItem);
            } else if (spinnerId == FEEDBACK_SPINNER_ID) {
                showToast("Feedback: " + selectedItem);
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
