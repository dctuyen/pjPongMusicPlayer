package com.example.pjpongmusicplayer.Services;

import com.example.pjpongmusicplayer.Models.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface DataService {
        @POST("getaccount.php")
        Call<User> createUser(@Body User login);

}
