package com.example.dreamdecoderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.dreamdecoderapp.R;

public class DreamInterpretationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dream_interpretation);

        TextView enterDreamLabel = findViewById(R.id.enter_dream_label);
        EditText dreamInput = findViewById(R.id.dream_input);
        Button analyzeButton = findViewById(R.id.analyze_button);
        Button backButton = findViewById(R.id.back_button);
        TextView dreamDecoderTitle = findViewById(R.id.DreamDecoder);

        // Set up button click listeners
        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String dreamText = dreamInput.getText().toString();
                Intent intent = new Intent(DreamInterpretationActivity.this, Analysis.class);
                intent.putExtra("DREAM_TEXT", dreamText);

                startActivity(intent);
                // Perform the interpretation on the dream text (placeholder)
                String interpretedText = interpretDream(dreamText);

                // Display the interpreted text
                enterDreamLabel.setText(interpretedText);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform back navigation or finish the activity
                finish();
            }
        });
    }

    private String interpretDream(String dreamText) {
        // Placeholder for dream interpretation logic
        return "Interpreted Dream: " + dreamText;
    }
}
