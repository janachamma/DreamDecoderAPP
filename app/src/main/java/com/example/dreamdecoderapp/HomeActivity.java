package com.example.dreamdecoderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {
    private ListView listView;
    private String[] options = {"Dream Interpretation", "Dream Journaling"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, ((Insets) systemBars).top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.list_options);

        // Set up the adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                options
        );

        listView.setAdapter(adapter);

        // Set up the item click listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    // Go to Dream Interpretation page
                    startActivity(new Intent(HomeActivity.this, DreamInterpretationActivity.class));
                } else if (position == 1) {
                    // Go to Dream Journaling page
                    startActivity(new Intent(HomeActivity.this, JournalingActivity.class));
                }
            }
        });
    }
}