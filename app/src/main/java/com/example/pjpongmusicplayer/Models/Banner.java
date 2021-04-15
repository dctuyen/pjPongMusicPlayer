package com.example.pjpongmusicplayer.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class Banner {

@SerializedName("banner_id")
@Expose
private String bannerId;
@SerializedName("banner_image")
@Expose
private String bannerImage;
@SerializedName("banner_content")
@Expose
private String bannerContent;
@SerializedName("song_id")
@Expose
private String songId;
@SerializedName("song_name")
@Expose
private String songName;
@SerializedName("song_image")
@Expose
private String songImage;

public String getBannerId() {
return bannerId;
}

public void setBannerId(String bannerId) {
this.bannerId = bannerId;
}

public String getBannerImage() {
return bannerImage;
}

public void setBannerImage(String bannerImage) {
this.bannerImage = bannerImage;
}

public String getBannerContent() {
return bannerContent;
}

public void setBannerContent(String bannerContent) {
this.bannerContent = bannerContent;
}

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

}