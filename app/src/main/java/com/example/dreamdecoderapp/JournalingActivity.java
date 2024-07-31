package com.example.dreamdecoderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class JournalingActivity extends AppCompatActivity {

    private EditText etDreamDescription;
    private EditText etDreamDate;
    private EditText etDreamEmotions;
    private EditText etDreamSymbols;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journaling);

        TextView tvTitle = findViewById(R.id.tvTitle);
        TextView tvDreamJournal = findViewById(R.id.tvDreamJournal);
        etDreamDescription = findViewById(R.id.etDreamDescription);
        etDreamDate = findViewById(R.id.etDreamDate);
        etDreamEmotions = findViewById(R.id.etDreamEmotions);
        etDreamSymbols = findViewById(R.id.etDreamSymbols);
        Button saveButton = findViewById(R.id.saved);
        Button backButton = findViewById(R.id.Backbutton);

        // Set up button click listeners
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
        String dreamDate = etDreamDate.getText().toString();
        String dreamEmotions = etDreamEmotions.getText().toString();
        String dreamSymbols = etDreamSymbols.getText().toString();

        // Placeholder for saving the dream information
        // This could be saving to a database, shared preferences, or any other storage mechanism
        Toast.makeText(this, "Dream saved!", Toast.LENGTH_SHORT).show();

        // Clear the fields after saving
        etDreamDescription.setText("");
        etDreamDate.setText("");
        etDreamEmotions.setText("");
        etDreamSymbols.setText("");
    }
}
