package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.regex.Pattern;

public class RecipientActivity extends AppCompatActivity {

    private EditText senderEmailEditText, emailSubjectEditText, recipientNameEditText, recipientEmailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipient);

        // Initialise EditText fields
        senderEmailEditText = findViewById(R.id.edit_sender_email);
        emailSubjectEditText = findViewById(R.id.edit_email_subject);
        recipientNameEditText = findViewById(R.id.edit_recipient_name);
        recipientEmailEditText = findViewById(R.id.edit_recipient_email);

        // Save button logic
        Button saveButton = findViewById(R.id.button_save_email_address);
        saveButton.setOnClickListener(v -> saveEmailAddress());
    }

    private void saveEmailAddress() {
        // Retrieve input values
        String senderEmail = senderEmailEditText.getText().toString().trim();
        String emailSubject = emailSubjectEditText.getText().toString().trim();
        String recipientName = recipientNameEditText.getText().toString().trim();
        String recipientEmail = recipientEmailEditText.getText().toString().trim();

        // Check for empty fields
        if (senderEmail.isEmpty() || emailSubject.isEmpty() || recipientName.isEmpty() || recipientEmail.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            return;
        }

        // Validate email formats
        if (!isValidEmail(senderEmail)) {
            Toast.makeText(this, "Invalid sender email address", Toast.LENGTH_SHORT).show();
            return;
        }

        if (!isValidEmail(recipientEmail)) {
            Toast.makeText(this, "Invalid recipient email address", Toast.LENGTH_SHORT).show();
            return;
        }

        // If all validations pass, show success message
        Toast.makeText(this, "Email Address saved successfully", Toast.LENGTH_SHORT).show();

        // Further actions like sending email or saving to database can be implemented here
        // I will look at this later
    }

    private boolean isValidEmail(String email) {
        //email validation using regex
        return Pattern.compile("[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.+[a-z]+").matcher(email).matches();
    }
}
