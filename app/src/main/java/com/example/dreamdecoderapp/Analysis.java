package com.example.dreamdecoderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Analysis extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_analysis);

        // Retrieve the dream text passed from DreamInterpretationActivity
        String dreamText = getIntent().getStringExtra("DREAM_TEXT");

        // Find the TextView where interpretation will be displayed
        TextView interpretationView = findViewById(R.id.interpretation_text_view);

        // Analyze the dream text
        assert dreamText != null;
        String interpretation = analyzeDream(dreamText);

        // Display the interpretation
        interpretationView.setText(interpretation);

        // Optional: Set up any other UI elements like buttons
        Button backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Navigate back to the previous activity
                finish();
            }
        });
    }

    private String analyzeDream(String dreamText) {
        // Example of a simple analysis with additional dream themes
        String interpretation;

        if (dreamText.contains("flying")) {
            interpretation = "Flying dreams often signify a desire for freedom or escape.";
        } else if (dreamText.contains("falling")) {
            interpretation = "Falling dreams might indicate a sense of insecurity or lack of control.";
        } else if (dreamText.contains("teeth")) {
            interpretation = "Dreams about teeth falling out can symbolize concerns about appearance or fear of aging.";
        } else if (dreamText.contains("chased")) {
            interpretation = "Being chased in a dream may represent a feeling of being pursued or pressured in waking life.";
        } else if (dreamText.contains("lost")) {
            interpretation = "Dreams of being lost can indicate a feeling of uncertainty or lack of direction.";
        } else if (dreamText.contains("water")) {
            interpretation = "Water in dreams often represents emotions or the subconscious mind.";
        } else if (dreamText.contains("death")) {
            interpretation = "Dreams about death might signify a transition or change in your life.";
        } else if (dreamText.contains("exam")) {
            interpretation = "Dreams about exams can reflect feelings of stress or self-evaluation.";
        } else if (dreamText.contains("pregnant")) {
            interpretation = "Dreams of pregnancy might symbolize new beginnings or something new developing in your life.";
        } else if (dreamText.contains("married")) {
            interpretation = "Dreams about marriage can signify commitment or a desire for union in some aspect of your life.";
        } else {
            interpretation = "Your dream is unique and might require more specific interpretation.";
        }

        return interpretation;
    }

}
