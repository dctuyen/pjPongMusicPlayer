package com.example.pjpongmusicplayer.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Playlist {

    @SerializedName("playlist_id")
    @Expose
    private String playlistId;
    @SerializedName("playlist_name")
    @Expose
    private String playlistName;
    @SerializedName("playlist_background")
    @Expose
    private String playlistBackground;
    @SerializedName("playlist_image")
    @Expose
    private String playlistImage;

    public String getPlaylistId() {
    return playlistId;
    }

    public void setPlaylistId(String playlistId) {
    this.playlistId = playlistId;
    }

    public String getPlaylistName() {
    return playlistName;
    }

    public void setPlaylistName(String playlistName) {
    this.playlistName = playlistName;
    }

    public String getPlaylistBackground() {
    return playlistBackground;
    }

    public void setPlaylistBackground(String playlistBackground) {
    this.playlistBackground = playlistBackground;
    }

    public String getPlaylistImage() {
    return playlistImage;
    }

    public void setPlaylistImage(String playlistImage) {
    this.playlistImage = playlistImage;
    }

}