package com.example.pjpongmusicplayer.Service;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class APIRetrofitClient{
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String baseUrl) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(1000, TimeUnit.MILLISECONDS)
                .writeTimeout(1000, TimeUnit.MILLISECONDS)
                .connectTimeout(1000, TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Collections.singletonList(Protocol.HTTP_1_1))
                .build();
        Gson gson = new GsonBuilder().setLenient().create();
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
