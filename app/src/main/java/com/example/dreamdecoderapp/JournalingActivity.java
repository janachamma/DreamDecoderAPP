package com.example.dreamdecoderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JournalingActivity extends AppCompatActivity {

    private EditText etDreamDescription;
    private EditText etDreamEmotions;
    private EditText etDreamSymbols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journaling);

        etDreamDescription = findViewById(R.id.etDreamDescription);
        etDreamEmotions = findViewById(R.id.etDreamEmotions);
        etDreamSymbols = findViewById(R.id.etDreamSymbols);
        Button saveButton = findViewById(R.id.saved);
        Button backButton = findViewById(R.id.Backbutton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveDream();
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void saveDream() {
        String dreamDescription = etDreamDescription.getText().toString();
        String dreamEmotions = etDreamEmotions.getText().toString();
        String dreamSymbols = etDreamSymbols.getText().toString();

        if (dreamDescription.isEmpty()) {
            Toast.makeText(this, "Please enter a dream description", Toast.LENGTH_SHORT).show();
            return;
        }

        // Create a new Item object with the dream details
        Item newItem = new Item();
        newItem.setDescription(dreamDescription);
        newItem.setDreamEmotions(dreamEmotions);
        newItem.setDreamSymbols(dreamSymbols);
        // Set other fields as needed

        // Assuming you have a method to get the userId from somewhere (e.g., SharedPreferences or passed through an Intent)
        int userId = getUserId(); // Replace with your actual user ID retrieval logic

        // Save the dream to the backend
        RetrofitClient.getInstance().getItemService().createItemForUser(userId, newItem).enqueue(new Callback<Item>() {
            @Override
            public void onResponse(@NonNull Call<Item> call, @NonNull Response<Item> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(JournalingActivity.this, "Dream saved!", Toast.LENGTH_SHORT).show();

                    // Navigate to ListJournalsActivity
                    Intent intent = new Intent(JournalingActivity.this, ListJournals.class);
                    startActivity(intent);
                    finish(); // Close this activity
                } else {
                    Toast.makeText(JournalingActivity.this, "Failed to save dream", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<Item> call, @NonNull Throwable t) {
                Toast.makeText(JournalingActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        // Clear the fields after saving
        etDreamDescription.setText("");
        etDreamEmotions.setText("");
        etDreamSymbols.setText("");
    }

    private int getUserId() {
        // Implement your logic to get the user ID
        return 1; // Placeholder
    }
}


