package com.example.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.fragment.app.Fragment;

public class CollaboratorFragment1 extends Fragment {

    private EditText editTextEmailSender;
    private EditText editTextEmailSubject;
    private EditText editTextCollaboratorName;
    private EditText editTextCollaboratorEmail;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_collaborator1, container, false);

        // Initialise all views
        editTextEmailSender = view.findViewById(R.id.editTextEmailSender);
        editTextEmailSubject = view.findViewById(R.id.editTextEmailSubject);
        editTextCollaboratorName = view.findViewById(R.id.editTextCollaboratorName);
        editTextCollaboratorEmail = view.findViewById(R.id.editTextCollaboratorEmail);
        Button buttonInviteCollaborator = view.findViewById(R.id.buttonInviteCollaborator);

        // Set click listener for the invite button
        buttonInviteCollaborator.setOnClickListener(v -> inviteCollaborator());

        return view;
    }

    private void inviteCollaborator() {
        // Retrieve input values
        String emailSender = editTextEmailSender.getText().toString().trim();
        String emailSubject = editTextEmailSubject.getText().toString().trim();
        String collaboratorName = editTextCollaboratorName.getText().toString().trim();
        String collaboratorEmail = editTextCollaboratorEmail.getText().toString().trim();

        // Perform validation
        if (emailSender.isEmpty()) {
            editTextEmailSender.setError("Please enter sender's email");
            editTextEmailSender.requestFocus();
            return;
        }

        if (emailSubject.isEmpty()) {
            editTextEmailSubject.setError("Please enter email subject");
            editTextEmailSubject.requestFocus();
            return;
        }

        if (collaboratorName.isEmpty()) {
            editTextCollaboratorName.setError("Please enter collaborator's name");
            editTextCollaboratorName.requestFocus();
            return;
        }

        if (collaboratorEmail.isEmpty()) {
            editTextCollaboratorEmail.setError("Please enter collaborator's email");
            editTextCollaboratorEmail.requestFocus();
            return;
        }

        // Validate email format
        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailSender).matches()) {
            editTextEmailSender.setError("Please enter a valid email address");
            editTextEmailSender.requestFocus();
            return;
        }

        if (!android.util.Patterns.EMAIL_ADDRESS.matcher(collaboratorEmail).matches()) {
            editTextCollaboratorEmail.setError("Please enter a valid email address");
            editTextCollaboratorEmail.requestFocus();
            return;
        }

        // Invitation email
        String invitationMessage = "Hi " + collaboratorName + ",\n\nYou have been invited by " + emailSender + " to collaborate on a project.";
        // Implement the email sending logic later

        // Show a success message
        Toast.makeText(getContext(), "Invitation sent to " + collaboratorEmail, Toast.LENGTH_SHORT).show();

        // Clear input fields
        clearInputFields();
    }

    // Method to clear input fields
    private void clearInputFields() {
        editTextEmailSender.setText("");
        editTextEmailSubject.setText("");
        editTextCollaboratorName.setText("");
        editTextCollaboratorEmail.setText("");
    }
}
