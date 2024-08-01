package com.example.dreamdecoderapp;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ItemService {
    @GET("/items")
    Call<List<Item>> getItems();
    @POST("/users/{user_id}/items")
    Call<Item> createItemForUser(@Path("user_id") int userId, @Body Item
            item);

    Call<Item> createItem(Item newItem);
}