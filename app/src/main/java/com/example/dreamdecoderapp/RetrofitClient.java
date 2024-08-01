package com.example.dreamdecoderapp;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static RetrofitClient instance = null;
    private final UserService userService;
    private final ItemService itemService;

    private RetrofitClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(logging);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://projcet-fast-api.vercel.app/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(httpClient.build())
                .build();
        userService = retrofit.create(UserService.class);
        itemService = retrofit.create(ItemService.class);
    }


    // Public method to provide access to the single instance
//    public static RetrofitClient getInstance() {
//        if (instance == null) {
//            synchronized (RetrofitClient.class) {
//                if (instance == null) {
//                    instance = new RetrofitClient();
//                }
//            }
//        }
//        return instance;
//    }
    public static synchronized RetrofitClient getInstance() {
        if (instance == null) {
            instance = new RetrofitClient();
        }
        return instance;
    }
    public UserService getUserService() {
        return userService;
    }

    // Method to get ItemService instance
    public ItemService getItemService() {
        return itemService;
    }
}