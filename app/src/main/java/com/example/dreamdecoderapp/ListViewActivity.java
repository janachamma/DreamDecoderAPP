package com.example.dreamdecoderapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ListViewActivity extends AppCompatActivity {
    private final String[] listItems = {"Dream Interpretation", "Journaling"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ListView listView = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, listItems);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = listItems[position];
                if (item.equals("Dream Interpretation")) {
                    // Navigate to Dream Interpretation Activity
                    Intent intent = new Intent(ListViewActivity.this, DreamInterpretationActivity.class);
                    startActivity(intent);
                } else if (item.equals("Journaling")) {
                    // Navigate to Journaling Activity
                    Intent intent = new Intent(ListViewActivity.this, JournalingActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ListViewActivity.this, "Clicked: " + item, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
