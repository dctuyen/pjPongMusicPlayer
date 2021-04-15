package com.example.pjpongmusicplayer.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Baihat {

    @SerializedName("song_id")
    @Expose
    private String songId;
    @SerializedName("song_name")
    @Expose
    private String songName;
    @SerializedName("song_image")
    @Expose
    private String songImage;
    @SerializedName("song_artist")
    @Expose
    private String songArtist;
    @SerializedName("song_likes")
    @Expose
    private String songLikes;

    public String getSongId() {
    return songId;
    }

    public void setSongId(String songId) {
    this.songId = songId;
    }

    public String getSongName() {
    return songName;
    }

    public void setSongName(String songName) {
    this.songName = songName;
    }

    public String getSongImage() {
    return songImage;
    }

    public void setSongImage(String songImage) {
    this.songImage = songImage;
    }

    public String getSongArtist() {
    return songArtist;
    }

    public void setSongArtist(String songArtist) {
    this.songArtist = songArtist;
    }

    public String getSongLikes() {
    return songLikes;
    }

    public void setSongLikes(String songLikes) {
    this.songLikes = songLikes;
    }

}