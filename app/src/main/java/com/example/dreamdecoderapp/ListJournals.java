package com.example.dreamdecoderapp;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ListJournals extends AppCompatActivity {
    private ListView listView;
    private ArrayAdapter<Item> adapter;
    private final List<Item> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_list_journals); // Ensure this layout file exists
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ListView listView = findViewById(R.id.listView);
        adapter = new ArrayAdapter<Item>(this, android.R.layout.simple_list_item_1, itemList) {
            @NonNull
            @Override
            public View getView(int position, View convertView, @NonNull ViewGroup parent) {
                // Customize the view for each item
                if (convertView == null) {
                    convertView = getLayoutInflater().inflate(R.layout.list_item, parent, false);
                }

                Item currentItem = getItem(position);
                TextView itemDescription = convertView.findViewById(R.id.etDreamDescription);

                if (currentItem != null) {
                    itemDescription.setText(currentItem.getDescription());
                }

                return convertView;
            }
        };
        listView.setAdapter(adapter);
        // Fetch item data using RetrofitClient
        fetchItemData();
    }

    private void fetchItemData() {
        RetrofitClient.getInstance().getItemService().getItems().enqueue(new Callback<List<Item>>() {
            @Override
            public void onResponse(@NonNull Call<List<Item>> call, @NonNull Response<List<Item>> response) {
                if (response.isSuccessful()) {
                    List<Item> items = response.body();
                    itemList.clear();
                    assert items != null;
                    itemList.addAll(items);
                    adapter.notifyDataSetChanged();
                } else {
                    // Handle the case where the response is not successful
                    Toast.makeText(ListJournals.this, "Failed to retrieve items", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NonNull Call<List<Item>> call, @NonNull Throwable t) {
                // Handle failure
                Toast.makeText(ListJournals.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}


