package com.example.pjpongmusicplayer.Services;import com.example.pjpongmusicplayer.Models.User;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

import retrofit2.http.Query;

public interface DataService {
        @POST("getaccount.php/")
        @FormUrlEncoded
        Call<ResponseBody> checkUser(   @Field("account") String account,
                                        @Field("password") String password);

        @POST("createaccount.php/")
        @FormUrlEncoded
        Call<ResponseBody> createUser(@Field("name") String name,
                                      @Field("birthday") String birthday,
                                      @Field("phone") String phone,
                                      @Field("account") String account,
                                      @Field("password") String password);

        @GET("songbanner.php")
        Call<List<com.example.pjpongmusicplayer.Models.Banner>> GetBanner();

        @GET("playlist.php")
        Call<List<com.example.pjpongmusicplayer.Models.Playlist>> GetPlaylist();

        @GET("themeandcategory.php")
        Call<List<com.example.pjpongmusicplayer.Models.Categoryytheme>> GetCategoryTheme();

        @GET("albumhot.php")
        Call<List<com.example.pjpongmusicplayer.Models.Album>> GetAlbumHot();

}
