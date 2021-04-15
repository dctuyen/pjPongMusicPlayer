package com.example.pjpongmusicplayer.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Album {

    @SerializedName("album_id")
    @Expose
    private String albumId;
    @SerializedName("album_name")
    @Expose
    private String albumName;
    @SerializedName("album_singer")
    @Expose
    private String albumSinger;
    @SerializedName("album_image")
    @Expose
    private String albumImage;

    public String getAlbumId() {
    return albumId;
    }

    public void setAlbumId(String albumId) {
    this.albumId = albumId;
    }

    public String getAlbumName() {
    return albumName;
    }

    public void setAlbumName(String albumName) {
    this.albumName = albumName;
    }

    public String getAlbumSinger() {
    return albumSinger;
    }

    public void setAlbumSinger(String albumSinger) {
    this.albumSinger = albumSinger;
    }

    public String getAlbumImage() {
    return albumImage;
    }

    public void setAlbumImage(String albumImage) {
    this.albumImage = albumImage;
    }

}