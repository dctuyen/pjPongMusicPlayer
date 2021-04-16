package com.example.pjpongmusicplayer.Service;

import com.example.pjpongmusicplayer.Model.CateagoryTheme;
import com.example.pjpongmusicplayer.Model.Song;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {
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
        Call<List<com.example.pjpongmusicplayer.Model.Banner>> GetBanner();

        @GET("playlist.php")
        Call<List<com.example.pjpongmusicplayer.Model.Playlist>> GetPlaylist();

        @GET("themeandcategory.php")
        Call<CateagoryTheme> GetCategoryTheme();

        @GET("albumhot.php")
        Call<List<com.example.pjpongmusicplayer.Model.Album>> GetAlbumHot();
        @GET("songlikeslist.php")
        Call<List<Song>> GetHotSong();

}
